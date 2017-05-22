package com.itour.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class TestImgMatch {

	   private String replaceImgSrc(String content,String replaceHttp){
           String result ="";
//	       String patternStr="^.*<img\\s*.*\\s*src=\\\"(.*)\\\"\\s*.*>.*$";
//	       String patternStr=".*?<img\\s*.*?\\s*src=\\\"(.*)\\\"\\s*.*?>.*";
//	       String patternStr="^.*<img\\s*.*\\s*src=\\\"(.*?)\\\"\\s*.*>.*$";
//	       String patternStr="<img(?:.*)src=(\"{1}|\'{1})([^\\[^>]+[gif|jpg|jpeg|bmp|bmp]*)(\"{1}|\'{1})(?:.*)>";
//	       String patternStr="<img.*src=(.*?)[^>]*?>src=\"?(.*?)(\"|>|\\s+)";
//	       String patternStr="(?i)<img[^>]*?src=\"([])\"";
//	       String patternStr = "<img\\s+[^>]*?src="((\\w+?:\\/\\/|/)[^"]*?)"[^>]*?>";
 //        String patternStr = "<img\\s+[^>]*?src=\"((\\w+?:?//|\\/|\\w*)[^\"]*?)\"[^>]*?>";
	         String patternStr = "<img\\s+[^>]*?src=[\"|\']((\\w+?:?//|\\/|\\w*)[^\"]*?)[\"|\'][^>]*?>";
	         Pattern pattern=Pattern.compile(patternStr);
	         Matcher matcher = pattern.matcher(content);
	          //如果匹配到了img
	         System.out.println("matcher.matches() == "+matcher.matches());
	         if(matcher.matches()){
	           result=content.replaceAll(matcher.group(1),(replaceHttp+matcher.group(1)));
	           System.out.println(" result == "+result);
	         }else{
	             result =content;
	         }
	         return result;
	    }
	   public static void main(String[] args) {
		   TestImgMatch ss = new TestImgMatch();
	       String content = "<p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"3\"</p><p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"33\" /></p><p>&nbsp;</p><p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"3\"</p><p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"33\" /></p><p>&nbsp;</p>";
//	     String content = "<p><img title=\"33\" alt=\"33\" align=\"left\" src=\"/WorkStation/attached/20110802/20110802173151_741.gif\" width=\"33\" height=\"33\" /></p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;<img title=\"32\" alt=\"32\" src=\"/WorkStation/attached/20110802/20110802173215_520.gif\" width=\"33\" height=\"33\" /></p>" ;
	       ss.replaceImgSrc(content, "http://10.10.0.126:8088");
	       
	       String content1 = "<p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"3\"</p>";
//	     String content = "<p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"3\"</p><p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"33\" /></p><p>&nbsp;</p><p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"3\"</p><p><img style=\"width:356px;height:163px;\" title=\"33\" alt=\"33\" src=\"/WorkStation/attached/20110802/20110802131500_758.gif\" width=\"33\" height=\"33\" /></p><p>&nbsp;</p>";
//	     content = content.replaceAll("(.*)src=\"(.*)", "$1src=\"http://127.0.0.1:8088$2");
	       content1 = content1.replaceAll("(.*?)src=\"(.*?)", "$1src=\"http://127.0.0.1:8088$2");
//	     String contents = content.replaceAll("(.*?)src=\"(.*?)", "$1src=\""+path+"$2");
	 
	       System.out.println(content1);
	      
//	     String str = "<img src=\"/WorkStation/attached/20110729/2011072917.jpg\" width=\"333\" height=\"333\" /><img src=\"/WorkStation/attached/20110729/2011072916.jpg\" width=\"333\" height=\"333\" /><img src=\"/WorkStation/attached/20110729/2011072917.jpg\" width=\"333\" height=\"333\" />";
	    }
}
