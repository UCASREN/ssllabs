package com.ucas.iscas.renlin.url;

import java.net.URL;
import java.security.cert.X509Certificate;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class URLRecord {
	private URL accUrl;//访问的源地址
	private URL finUrl;//重定向后的最终地址
	private boolean isSuc;//访问是否成功
	private boolean isMadTLS;//被访问地址存在强制HTTPS跳转
	private boolean isNoneTLS;//被访问地址无有效HTTPS
	private boolean isHSTS;//被访问网址有HSTS
	private HtmlPage pageData;//获取到的HTTP信息
	private X509Certificate cert;
	private boolean isSen;//被访问网址是否包含敏感信息
	private String senInfor;//敏感信息内容
	

	public URLRecord() {
		// TODO Auto-generated constructor stub
		accUrl = null;
		finUrl = null;
		isSuc = false;
		isMadTLS = false;
		isNoneTLS = true;
		isHSTS = false;
		pageData = null;
		cert = null;
		isSen = false;
		senInfor = "";
	}

	

	public URLRecord(URL accUrl, URL finUrl, boolean isSuc, boolean isMadTLS,
			boolean isNoneTLS, boolean isHSTS, HtmlPage pageData,
			X509Certificate cert, boolean isSen, String senInfor) {
		super();
		this.accUrl = accUrl;
		this.finUrl = finUrl;
		this.isSuc = isSuc;
		this.isMadTLS = isMadTLS;
		this.isNoneTLS = isNoneTLS;
		this.isHSTS = isHSTS;
		this.pageData = pageData;
		this.cert = cert;
		this.isSen = isSen;
		this.senInfor = senInfor;
	}



	public URL getAccUrl() {
		return accUrl;
	}


	public void setAccUrl(URL accUrl) {
		this.accUrl = accUrl;
	}


	public URL getFinUrl() {
		return finUrl;
	}


	public void setFinUrl(URL finUrl) {
		this.finUrl = finUrl;
	}


	public boolean isSuc() {
		return isSuc;
	}


	public void setSuc(boolean isSuc) {
		this.isSuc = isSuc;
	}


	public boolean isMadTLS() {
		return isMadTLS;
	}


	public void setMadTLS(boolean isMadTLS) {
		this.isMadTLS = isMadTLS;
	}


	public boolean isNoneTLS() {
		return isNoneTLS;
	}


	public void setNoneTLS(boolean isNoneTLS) {
		this.isNoneTLS = isNoneTLS;
	}


	public boolean isHSTS() {
		return isHSTS;
	}


	public void setHSTS(boolean isHSTS) {
		this.isHSTS = isHSTS;
	}


	public HtmlPage getPageData() {
		return pageData;
	}


	public void setPageData(HtmlPage pageData) {
		this.pageData = pageData;
	}


	public X509Certificate getCert() {
		return cert;
	}


	public void setCert(X509Certificate cert) {
		this.cert = cert;
	}


	public boolean isSen() {
		return isSen;
	}


	public void setSen(boolean isSen) {
		this.isSen = isSen;
	}


	public String getSenInfor() {
		return senInfor;
	}


	public void setSenInfor(String senInfor) {
		this.senInfor = senInfor;
	}
}
