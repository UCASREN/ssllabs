package com.ucas.iscas.renlin.ssllabs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ucas.iscas.renlin.utils.FileFind;

public class FetchInformation{
	
	public static void main(String[] args){
		// 选取固定线程池的大小为25
		ExecutorService executor = Executors.newFixedThreadPool(25);
		
		// 读取URL
		String pathName = "E:\\桌面\\certs\\Alexa_10W.txt";
		String[] urls = FileFind.getRealSiteNames(pathName);
		
		// 执行任务
		for (int i = 0; i < urls.length; i ++){
			SingleTask task = new SingleTask(urls[0]);
			executor.execute(task);	
			try {
				// 每个新请求的发起的时间间隔为1s
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

}
