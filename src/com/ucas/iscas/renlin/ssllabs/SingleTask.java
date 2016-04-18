package com.ucas.iscas.renlin.ssllabs;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.ucas.iscas.renlin.data.AssessmentResults;

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
		try {
			AssessmentResults.saveAssessmentResults(hostInformation);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
