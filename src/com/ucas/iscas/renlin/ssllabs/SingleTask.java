package com.ucas.iscas.renlin.ssllabs;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import test.com.ucas.iscas.renlin.hibernate.HibernateUtil;

import com.google.gson.Gson;
import com.ucas.iscas.renlin.data.AssessmentResults;
import com.ucas.iscas.renlin.pojo.Endpoint;
import com.ucas.iscas.renlin.pojo.Endpointdetails;
import com.ucas.iscas.renlin.pojo.Host;

public class SingleTask implements Runnable {
	private String url;
	private Api api;

	public SingleTask(String url) {
		super();
		this.url = url;
		this.api = new Api();
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		JSONObject hostInformation = null;
		// 1. 发起新的请求
		AssessmentRequest(url, true, "done");
		sleep(10000);

		// 2. 查询请求状态
		boolean finish = false;
		while (!finish) {
			hostInformation = AssessmentRequest(url, false, "done");
			try {
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
					// 处理错误的地方
					break;
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
