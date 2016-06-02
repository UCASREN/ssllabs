package com.ucas.iscas.renlin.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class URLUtil {

	
	public static String parseRelHref(String curPage, String relUrl){

		if(relUrl.startsWith("http://") || relUrl.startsWith("https://")){
			return relUrl;
		}else if(relUrl.startsWith("/")){
			return curPage.substring(0,curPage.lastIndexOf("/"))+relUrl;
		}else{
			return curPage+"/"+relUrl;
		}
	}
	
	public static void fun(){
		while (!isFin && i <= 10) {
			// 访问直至重定向次数超过阈值或无跳转
			URLConnection connection = reqURL.openConnection();
			// System.out.println(reqURL.toString());
			connection.setRequestProperty("accept", "*/*"); // 告诉WEB服务器自己接受什么介质类型，*/*
															// 表示任何类型
			connection.setRequestProperty("connection", "Keep-Alive"); // 使一次TCP连接为同一用户的多次请求服务，提高响应速度。
			connection.setRequestProperty("user-agent", "Chrome"); // 浏览器身份标识字符串
			connection.setReadTimeout(3000); // 设置读取的超时时间为3000ms
			try {
				connection.connect();
				Map<String, List<String>> map = connection
						.getHeaderFields();
				// 遍历所有的响应头字段
				for (String key : map.keySet()) {
					System.out.println(key);
					System.out.println(key + "--->" + map.get(key));
					if (key == null) {
						if (map.get(key).toString().contains("200 OK")) { // 请求已成功，请求所希望的响应头或数据体将随此响应返回。
							isFin = true;
							rec.isSuc = true;
						} else if (map.get(key).toString()
								.contains("302 Moved Temporarily")) { // 被请求的资源暂时移动到新位置

						} else {
							isFin = true;
							rec.isSuc = false;
						}
					} else if (key.equalsIgnoreCase("location")) { // 用来 进行
																	// 重定向
																	// ，或者在创建了某个新资源时使用。
						String newURL = map.get(key).toString();
						// System.out.println(newURL);
						newURL = newURL.substring(1, newURL.length() - 1); // ??没有找到location示例，不知道为什么这么写
						// System.out.println(newURL);
						reqURL = new URL(newURL);
					} else if (key.equalsIgnoreCase("set-cookie")) { // HTTP
																		// cookie
						// String cookieVal =
						// map.get(key).toString().substring(1,
						// newURL.length()-1);
						// cookieVal = cookieVal.substring(0,
						// cookieVal.indexOf(";"));
						// sessionId=sessionId+cookieVal+";";
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				isFin = true;
			}
			i++;
		}
	}
}
