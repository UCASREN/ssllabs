package com.ucas.iscas.renlin.ssllabs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONException;
import org.json.JSONObject;

import com.ucas.iscas.renlin.utils.FileFind;

public class FetchInformation{
	
	public static void main(String[] args) throws JSONException{
		// 选取固定线程池的大小为25
		ExecutorService executor = Executors.newFixedThreadPool(25);
		
		// 读取URL
		String pathName = args[0];
		String[] urls = FileFind.getRealSiteNames(pathName);
		
		// 执行任务
		Api api = new Api();
		for (int i = Integer.valueOf(args[1]); i < Integer.valueOf(args[2]); i ++){
			SingleTask task = new SingleTask(urls[i]);
			executor.execute(task);	
			try {
				// 每个新请求的发起的时间间隔为1s
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject apiInformation = api.fetchApiInfo();
			System.out.println("目前活跃线程数：" + Thread.activeCount());
			System.out.println("currentAssessments: " + apiInformation.getInt("currentAssessments"));
		}
		executor.shutdown();
	}

}
