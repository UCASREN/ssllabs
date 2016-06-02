package com.ucas.iscas.renlin.url.suburl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONException;
import org.json.JSONObject;

import com.ucas.iscas.renlin.ssllabs.Api;
import com.ucas.iscas.renlin.ssllabs.SingleTask;
import com.ucas.iscas.renlin.utils.FileFind;

public class ParseSubDomain {

	public static void main(String[] args) throws JSONException {
		// 选取固定线程池的大小为25
		ExecutorService executor = Executors.newFixedThreadPool(25);

		// 读取URL
		String pathName = args[0];
		String[] urls = FileFind.getRealSiteNames(pathName);

		// 执行任务
		Api api = new Api();
		int start =Integer.valueOf(args[1]), end = Integer.valueOf(args[2]);
		for (int i = start; i < end; i++) {
			SingleTask task = new SingleTask(urls[i]);
			executor.execute(task);
			JSONObject apiInformation = api.fetchApiInfo();
			System.out.println("目前活跃线程数：" + Thread.activeCount());
			System.out.println("currentAssessments: "
					+ apiInformation.getInt("currentAssessments"));
		}
		executor.shutdown();

	}

}
