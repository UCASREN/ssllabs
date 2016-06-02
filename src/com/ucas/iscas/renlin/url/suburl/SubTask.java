package com.ucas.iscas.renlin.url.suburl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import test.com.ucas.iscas.renlin.hibernate.HibernateUtil;

import com.google.gson.Gson;
import com.ucas.iscas.renlin.pojo.Endpoint;
import com.ucas.iscas.renlin.pojo.Endpointdetails;
import com.ucas.iscas.renlin.pojo.Host;
import com.ucas.iscas.renlin.ssllabs.Api;

public class SubTask implements Runnable{
	private String url;
	private Api api;
	private Set<String> urlSet;

	public SubTask(String url) {
		super();
		this.url = url;
		this.api = new Api();
		this.urlSet = new HashSet<String>();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 评估请求
	 * 
	 * @param host
	 *            ：域名
	 * @param startNew
	 *            ：是否发起新的评估
	 * @param all
	 *            ：all=done时，表示评估完成才返回完整信息。
	 * @return
	 */
	public JSONObject AssessmentRequest(String host, boolean startNew,
			String all) {
		JSONObject hostInformation = api.fetchHostInformation(host, false,
				startNew, false, null, all, true);
		return hostInformation;
	}

	public void sleep(int time) {
		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Set<String> getUrlSet() {
		return urlSet;
	}
	
	public void setUrlSet(Set<String> urlSet) {
		this.urlSet = urlSet;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JSONObject hostInformation = null;
		// 0. 解析子域名获取更多好的子域名
		
		
		// 1. 发起新的请求
		AssessmentRequest(url, true, "done");
		sleep(5000);

		// 2. 查询请求状态
		boolean finish = false;
		while (!finish) {
			hostInformation = AssessmentRequest(url, false, "done");
			try {
				while (!hostInformation.has("status")) {
				    sleep(5000);
				    hostInformation = AssessmentRequest(url, true, "done");
			    }
				String status = hostInformation.getString("status");
				switch (status) {
				case "DNS":
					break;
				case "IN_PROGRESS":
					sleep(10000);
					break;
				case "READY":
					//System.out.println(url + ":READY!");
					finish = true;
					break;
				case "ERROR":
					// 处理错误的地方，直接结束本次请求，可能原因url非法，不可达。
					return;
				default:
					break;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// 3. 存储评估结果
	    saveAssessmentResults(hostInformation);
	}

	private void saveAssessmentResults(JSONObject hostInformation) {
		// TODO Auto-generated method stub
		Session session = null;
    	Transaction tx = null;
    	try{
    		session = HibernateUtil.getSession();
    		tx = session.beginTransaction();
    		Api api = new Api();
    		Host host = new Gson().fromJson(hostInformation.toString(), Host.class);
    		Set<Endpoint> endpoints = host.endpoints;
    		Iterator<Endpoint> iterator = endpoints.iterator();
    		while (iterator.hasNext()){
    			Endpoint next = iterator.next();
    			next.setHost(host);
    			Endpointdetails details = next.details;
    			details.hostname = host;
    			details.endpoint = next;
    			session.save(next);
    			session.save(details);
    		}	
            session.save(host);
    		tx.commit();
    	}catch(HibernateException e){
    		if (tx != null)
    			tx.rollback();
    		e.printStackTrace();
    		throw e;
    	}finally{
    		HibernateUtil.closeSession();
    	}
    }
}
