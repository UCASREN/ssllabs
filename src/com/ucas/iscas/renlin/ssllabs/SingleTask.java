package com.ucas.iscas.renlin.ssllabs;

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


	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 1. 发起新的请求
		
		
		// 2. 查询请求状态
		
		// 3. 存储评估结果

	}

}
