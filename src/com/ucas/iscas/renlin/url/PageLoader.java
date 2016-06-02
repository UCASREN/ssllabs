package com.ucas.iscas.renlin.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class PageLoader {
	/*
	 * // 使用静态内部类实现单例模式 private static class PageLoaderHolder{ private static
	 * final PageLoader INSTANCE = new PageLoader(); }
	 * 
	 * // 私有构造函数 private PageLoader(){}
	 * 
	 * public static PageLoader getInstance(){ return PageLoaderHolder.INSTANCE;
	 * }
	 */

	@Test
	/**
	 * 
	 * @throws Exception
	 */
	public void parseSite() throws Exception {

		String siteAddr = "google.com.hk";
		List<URL> urlList = new ArrayList<URL>(); // 储存域内相关地址列表
		Set<String> urlSet = new HashSet<String>(); // 储存最后获得的关键子域名

		Map<URL, URLRecord> dataMap = new HashMap<URL, URLRecord>();// 用于储存地址对应的数据
		urlList.add(new URL(siteAddr));
		urlSet.add(siteAddr);

		while (!urlList.isEmpty()) {
			URL u = urlList.remove(0);
			System.out.println("-------");
			System.out.println("PARSE URL " + u);
			URLRecord data = parseURL(u);
			System.out.println("FINISHED PARSE URL " + data.finUrl);
			analysisData(data, urlList, siteAddr, urlSet);
			dataMap.put(u, data);
		}
		System.out.println(urlList.size());
		System.out.println(urlSet.size());
		for (String url : urlSet)
			System.out.println(url);
	}

	/**
	 * 主要功能有2点： 1.分析网页内容，将重点子域名存入urlSet； 2.增加其它子链接到urlList，供下一步分析。
	 * 
	 */
	public void analysisData(URLRecord pageRec, List urlList, String siteAddr,
			Set<String> urlSet) {

		List<HtmlAnchor> anchors = null;
		try {
			// 获取页面上的所有链接
			anchors = pageRec.pageData.getAnchors();
			// TODO 增加通过字符串获取链接地址ַ
		} catch (Exception e) {

		}
		if (anchors != null) {
			for (int i = 0; i < anchors.size(); i++) {
				String href = anchors.get(i).getHrefAttribute();
				href = URLUtil.parseRelHref(pageRec.finUrl.toString(), href);
				URL link = null;
				if (href.toLowerCase().startsWith("http")) {
					try {
						link = new URL(href);

					} catch (Exception e) {

					}
				}
				if (link != null
						&& link.getHost().toString().endsWith(siteAddr)) {
					// 获取链接所属子域名
					boolean rootAdded = false;
					String subDomain = link.getProtocol() + "://"
							+ link.getHost();
					URL rootUrl = null;
					try {
						rootUrl = new URL(subDomain);
					} catch (Exception e) {
					}
					// 若同子域名下已存在待处理页面，则不再进行添加
					if (urlSet.contains(subDomain)) {
						rootAdded = true;
						// System.out.println("ALREADY ADDED "+subDomain);
					}

					if (!rootAdded
							&& pageRec.finUrl.getProtocol().equalsIgnoreCase(
									"http")
							&& link.getProtocol().equalsIgnoreCase("https")) {// 从页面中获取所有敏感链接地址
						if (rootUrl != null && !urlSet.contains(subDomain)) {
							urlList.add(rootUrl);
							urlSet.add(subDomain); // ？？？为什么同时将超链接和子域名同时加入urlSet？？
							System.out.println("LINKS ADDED " + subDomain);
						}
						if (!urlSet.contains(href)) {
							urlSet.add(href);
							urlList.add(link);
							System.out.println("LINKS ADDED " + href);
						}
					} else if (!rootAdded
							&& (href.contains("login")
									|| href.contains("passport")
									|| href.contains("secure")
									|| href.contains("mail") || href
										.contains("account"))) {
						if (rootUrl != null && !urlSet.contains(subDomain)) {
							urlList.add(rootUrl);
							urlSet.add(subDomain);
							System.out.println("LINKS ADDED " + subDomain);
						}
						if (!urlSet.contains(href)) {
							urlSet.add(href);
							urlList.add(link);
							System.out.println("LINKS ADDED " + href);
						}
					}
				}

				// System.out.println(page.asXml());

			}
		}

		try {// TODO 更精确的passowrd框判断方法
			HtmlElement pwd = pageRec.pageData.getElementByName("password");
			pageRec.isSen = true;
		} catch (Exception e) {
		}
		System.out.println("IS SENSITIVE " + pageRec.isSen);
	}

	/**
	 * 主要功能如下： 1.分析给定的URL，处理重定向跳转问题，并记录最后的跳转地址，生成一条URLRecord记录 2.
	 * 
	 */
	public URLRecord parseURL(URL accUrl) throws Exception {
		WebClient client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setJavaScriptEnabled(true); // 默认执行js，如果不执行js，则可能会登录失败，因为用户名密码框需要js来绘制。
		client.getOptions().setCssEnabled(false);
		client.setJavaScriptTimeout(0);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.waitForBackgroundJavaScript(10000);

		URLRecord rec = new URLRecord();
		rec.setAccUrl(accUrl);
		URL finUrl = getFinUrl(accUrl, rec, client);
		rec.setFinUrl(finUrl);
		return rec;
	}

	private URL getFinUrl(URL accUrl, URLRecord rec, WebClient client) {
		// TODO Auto-generated method stub
		String protocol = accUrl.getProtocol().toLowerCase();
		switch (protocol) {
		case "http":
			int a = 0;
			break;
		case "https":
			int b = 1;
			break;
		default:
			break;
		}
		return null;
	}
}
