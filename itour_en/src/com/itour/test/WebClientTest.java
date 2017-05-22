package com.itour.test;

import java.net.URL;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
//import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class WebClientTest {

	public static void main(String[] args) {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		try {
		URL url=new URL("https://www.baidu.com");
        WebRequest request= new WebRequest(url);
        WebResponse response=new WebResponse(null, request, 6000);
       // webClient.setJavaScriptEnabled(true);
       // webClient.setThrowExceptionOnScriptError(false);
       //webClient.setCssEnabled(false);
       // webClient.setRedirectEnabled(true);
        JavaScriptEngine engine = new JavaScriptEngine(webClient);
        webClient.setJavaScriptEngine(engine);
        HtmlPage firstPage = null;
        ScriptResult result = null;
      //  JavaScriptPage jsp=new JavaScriptPage(response, null);
        //JavaScriptPage jsp=new JavaScriptPage(response, null);
          firstPage = webClient.getPage(request);
          String JavaScriptCode = "1+1";
           result = firstPage.executeJavaScript(JavaScriptCode);
           Object javaScriptResult = result.getJavaScriptResult();
           System.out.println(javaScriptResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
