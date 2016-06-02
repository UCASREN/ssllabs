package com.ucas.iscas.renlin.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HTTPLoader {

	public HTTPLoader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.getOptions().setJavaScriptEnabled(true);    //默认执行js，如果不执行js，则可能会登录失败，因为用户名密码框需要js来绘制。
        client.getOptions().setCssEnabled(false);
        //client.setJavaScriptTimeout(1000);
        client.setAjaxController(new NicelyResynchronizingAjaxController());
        client.getOptions().setThrowExceptionOnScriptError(false);        

        HtmlPage page = client.getPage("http://www.samsung.com/cn/home/");

        
        
        
        List<HtmlAnchor> anchors = page.getAnchors();
        for(int i = 0; i<anchors.size();i++){
        	//System.out.println(anchors.get(i).asXml());
        	System.out.println(anchors.get(i).getHrefAttribute());
            //System.out.println(page.asXml());
        	try{
        		//URL u = new URL();
        	}catch(Exception e){
        		
        	}
        }
        System.out.println(page.asXml());
        //HtmlElement pwd = page.getElementByName("password");
        //System.out.println(pwd.asXml());    	

        //System.out.println(page.asXml());
        //登录
        //HtmlInput ln = page.getHtmlElementById("username");
        //HtmlInput pwd = page.getHtmlElementById("password");
        
        client.close();
    }
	
}
