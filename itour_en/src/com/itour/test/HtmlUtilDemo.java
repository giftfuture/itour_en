package com.itour.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.HtmlPage;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class HtmlUtilDemo {
	public void parseHtml(){
		//创建一个可执行js,css,ajax的多功能WebClient  
        WebClient multiWebClient = new WebClient(BrowserVersion.CHROME);  
       // multiWebClient.setJavaScriptEnabled(true);//执行JavaScript  
       // multiWebClient.setCssEnabled(true);//执行css  
        multiWebClient.setAjaxController(new NicelyResynchronizingAjaxController());//设置ajax代理  
          
        //创建一个普通的WebClient  
        WebClient commmonWebClient = new WebClient(BrowserVersion.CHROME);  
       // commmonWebClient.setJavaScriptEnabled(false);  
       // commmonWebClient.setCssEnabled(false);  
       //   
        //用多功能Client获取动态页面的html并执行完js后的页面  
        try {
			URL dynamicUrl = new URL("http://localhost:30010/WebSite");  
			HtmlPage dynamicPage = (HtmlPage) multiWebClient.getPage(dynamicUrl);  
			//根据项目需要,使用普通Client加载首页模板(避免执行模板里面的js,这些js都是真正要浏览器查看的时候才会执行)  
			URL constantUrl = new URL("http://localhost:30010/WebSite/wwwroot/indexTemple.html");  
			HtmlPage htmlpage = commmonWebClient.getPage(constantUrl);  
			NodeList body = htmlpage.getBody();   
			/** 
			 * 未详细测试的结论:getElementById一个元素只能取一次,取了之后再取就是空元素,其子也无法用getElementById取到 
			 * 开始处理header 
			 */  
    /*   appendChildren(body.getElementById("_static_nav"), dynamicPage.getElementById("_static_nav"));  
			  
			//开始处理_static_leftbox  
			//处理图片滚动KSS_content  
			appendChildren(body.getElementById("KinSlideshow"), dynamicPage.getElementById("KSS_content"));  
			//处理最新电子书  
			appendChildren(body.getElementById("e_bookDiv"), dynamicPage.getElementById("e_bookDiv"));  
			  
			//取出content  
			HtmlElement content = body.getElementById("content");  
			  
			//开始处理_static_rightbox  
			content.appendChild(dynamicPage.getElementById("_static_rightbox"));  
			//添加div换行  
			DomElement clearDiv = htmlpage.createElement("div");  
			clearDiv.setAttribute("class", "clear");  
			//一个DomElement貌似只能使用一次  
			content.appendChild(clearDiv.cloneNode(true));  
			  
			//开始处理_static_bookshow  
			content.appendChild(dynamicPage.getElementById("_static_bookshow"));  
			content.appendChild(clearDiv.cloneNode(true));  
			  
			//开始处理_static_assistBox,secrecyRelevancediv,_static_optionBox  
			content.appendChild(dynamicPage.getElementById("_static_assistBox"));  
			content.appendChild(dynamicPage.getElementById("secrecyRelevancediv"));  
			content.appendChild(dynamicPage.getElementById("_static_optionBox"));  
			content.appendChild(clearDiv.cloneNode(true));  
			  
			//开始处理_static_bookShowA  
			content.appendChild(dynamicPage.getElementById("_static_bookShowA"));  
			content.appendChild(clearDiv.cloneNode(true));  
			//开始处理_static_serve  
			content.appendChild(dynamicPage.getElementById("_static_serve"));  
			  
			//开始处理footer  
			body.appendChild(clearDiv.cloneNode(true));  
			body.appendChild(dynamicPage.getElementById("_static_footer"));  
			  
			  
			//处理错误  
			String finalHtml =htmlpage.asXml().replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");   
      finalHtml = finalHtml.replaceAll("<a class=\"prev browse left\"/>", "<a class=\"prev browse left\" ></a>");  
			finalHtml = finalHtml.replaceAll("<a class=\"next browse right\"/>", "<a class=\"next browse right\" ></a>");  
			finalHtml = finalHtml.replaceAll("<b/>", "<b></b>");  
			finalHtml = finalHtml.replaceAll("scrollable_2", "scrollable");  
			stringToFile(finalHtml,"E:\\WayOfGlory\\WebSite\\WebContent\\wwwroot\\indexHome.html");   */
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
    public DomElement appendChildren(DomElement target,DomElement source){  
	Iterator it = source.getChildElements().iterator();  
	while(it.hasNext()){  
	    DomElement ele = (DomElement) it.next();  
	    target.appendChild(ele);  
	}  
        return target;  
    }  
      
      
  
    public void stringToFile(String content,String path){  
        try {  
		    FileWriterWithEncoding fileWriter = new FileWriterWithEncoding(path,"utf-8");  
		    fileWriter.write(content);  
		    fileWriter.flush();  
		    fileWriter.close();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}  
		    }  
}
