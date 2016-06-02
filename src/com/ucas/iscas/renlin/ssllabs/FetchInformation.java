package com.ucas.iscas.renlin.ssllabs;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.stream.events.EndDocument;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

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
		int start = Integer.valueOf(args[1]), end = Integer.valueOf(args[2]);
		for (int i = start; i < end; i ++){
			int index = urls[i].indexOf("http");
			if (index == -1) continue;
			SingleTask task = new SingleTask(urls[i].substring(index));
			
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
	
	@Test
	public void c(){
		Set<String> test = new HashSet<String>();
		test.add("adad");
		test.add("aaaa");
		System.out.println(test.toString());
	}

}
