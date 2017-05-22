package com.itour.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.junit.Test;

import com.itour.base.json.JsonUtils;
import info.monitorenter.util.StringUtil;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;

/**
 * <br>
 * <b>功能：</b>详细的功能描述<br>
 * <b>日期：</b> Jun 14, 2016 <br>
 * <b>更新者：</b><br>
 * <b>日期：</b> <br>
 * <b>更新内容：</b><br>
 */
public class HtmlUtil {
	
	private final static String regxpForHtml = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签   
	
	private final static String regxpForImgTag = "<\\s*img\\s+([^>]*)\\s*>"; // 找出IMG标签   
	
	private final static String regxpForImaTagSrcAttrib = "src=\"([^\"]+)\""; // 找出IMG标签的SRC属性   
	
	/**
	 * 
	 * <br>
	 * <b>功能：</b>输出json格式<br>
	 * <b>作者：</b>fred<br>
	 * <b>日期：</b> Jun 14, 2016 <br>
	 * @param response
	 * @param jsonStr
	 * @throws Exception
	 */
	public static void writerJson(HttpServletResponse response,String jsonStr) {
			writer(response,jsonStr);
	}
	/**
	 * fastjson write
	 * @param response
	 * @param object
	 */
	public static void writerJson2(HttpServletResponse response,Object object){
		response.setContentType("application/json");
		String result = JsonUtils.encode(object);
		// result = result == null ||result == "{\"msg\":\"1\",\"success\":true}" || result =="{\"total\":1,\"rows\":[{}]}"|| result.equals("{success=true, allType=true}") || result.equals("{}") ||result.length()<3 ? net.sf.json.JSONObject.fromObject(object).toString() :result ;
		writer(response,result);
	}
	/**
	 * fastjson write
	 * @param response
	 * @param object
	 */
	public static void writerJson(HttpServletResponse response,Object object){
		//response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		String result = JsonUtils.encode(object);
		// result = result == null ||result == "{\"msg\":\"1\",\"success\":true}" || result =="{\"total\":1,\"rows\":[{}]}"|| result.equals("{success=true, allType=true}") || result.equals("{}") ||result.length()<3 ? net.sf.json.JSONObject.fromObject(object).toString() :result ;
		writer(response,result);
	}
	/**
	 * 
	 * <br>
	 * <b>功能：</b>输出HTML代码<br>
	 * <b>日期：</b> Jun 14, 2016 <br>
	 * @param response
	 * @param htmlStr
	 * @throws Exception
	 */
	public static void writerHtml(HttpServletResponse response,String htmlStr) {
		writer(response,htmlStr);
	}
	/**
	 * 
	 * @param response
	 * @param str
	 */
	private static void writer(HttpServletResponse response,String str){
		try {
			//StringBuffer result = new StringBuffer();
			//设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= null;
			out = response.getWriter();
			//System.out.println(str);
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
  
    /**  
     *   
     * 基本功能：替换标记以正常显示  
     * <p>  
     *   
     * @param input  
     * @return String  
     */  
    public String replaceTag(String input) {   
        if (!hasSpecialChars(input)) {   
            return input;   
        }   
        StringBuffer filtered = new StringBuffer(input.length());   
        char c;   
        for (int i = 0; i <= input.length() - 1; i++) {   
            c = input.charAt(i);   
            switch (c) {   
            case '<':   
                filtered.append("&lt;");   
                break;   
            case '>':   
                filtered.append("&gt;");   
                break;   
            case '"':   
                filtered.append("&quot;");   
                break;   
            case '&':   
                filtered.append("&amp;");   
                break;   
            default:   
                filtered.append(c);   
            }   
  
        }   
        return (filtered.toString());   
    }   
  
    /**  
     *   
     * 基本功能：判断标记是否存在  
     * <p>  
     *   
     * @param input  
     * @return boolean  
     */  
    public boolean hasSpecialChars(String input) {   
        boolean flag = false;   
        if ((input != null) && (input.length() > 0)) {   
            char c;   
            for (int i = 0; i <= input.length() - 1; i++) {   
                c = input.charAt(i);   
                switch (c) {   
                case '>':   
                    flag = true;   
                    break;   
                case '<':   
                    flag = true;   
                    break;   
                case '"':   
                    flag = true;   
                    break;   
                case '&':   
                    flag = true;   
                    break;   
                }   
            }   
        }   
        return flag;   
    }   
  
    /**  
     *   
     * 基本功能：过滤所有以"<"开头以">"结尾的标签  
     * <p>  
     *   
     * @param str  
     * @return String  
     */  
    public static String filterHtml(String str) {   
        Pattern pattern = Pattern.compile(regxpForHtml);   
        Matcher matcher = pattern.matcher(str);   
        StringBuffer sb = new StringBuffer();   
        boolean result1 = matcher.find();   
        while (result1) {   
            matcher.appendReplacement(sb, "");   
            result1 = matcher.find();   
        }   
        matcher.appendTail(sb);   
        return sb.toString();   
    }   
  
    /**  
     *   
     * 基本功能：过滤指定标签  
     * <p>  
     *   
     * @param str  
     * @param tag  
     *            指定标签  
     * @return String  
     */  
    public static String fiterHtmlTag(String str, String tag){   
        String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";   
        Pattern pattern = Pattern.compile(regxp);   
        Matcher matcher = pattern.matcher(str);   
        StringBuffer sb = new StringBuffer();   
        boolean result1 = matcher.find();   
        while (result1) {   
            matcher.appendReplacement(sb, "");   
            result1 = matcher.find();   
        }   
        matcher.appendTail(sb);   
        return sb.toString();   
    }   
    /** 
     * 获取指定HTML标签的指定属性的值 
     * @param source 要匹配的源文本 
     * @param element 标签名称 
     * @param attr 标签的属性名称 
     * @return 属性值列表 
     */  
    public static List<String> inputValue(String source, String element, String attr) {  
        List<String> result = new ArrayList<String>();  
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";  
        Matcher m = Pattern.compile(reg).matcher(source);  
        while (m.find()) {  
            String r = m.group(1);  
            result.add(r);  
        }  
        return result;  
    } 
    /**
     * 
     * @param source
     * @param element
     * @param attr
     * @return
     */
    public static List<String> selectValue(String source, String element, String attr) {  
       List<String> result = new ArrayList<String>();  
       String reg = "<select(?:\\s+id=['\">]([^\\s'\"]+)['\">]|\\s+value=['\">]([^\\s'\"]+)['\">])*[^>]*?>";  
     //  String reg="<param\\p{Space}+name\\p{Space}*=\\p{Space}*\"LoadDataURL\"\\p{Space}+value\\p{Space}*=\\p{Space}*\"(.* )\"";
       Matcher matcher = Pattern.compile(reg).matcher(source); 
       while(matcher.find()){
    	   System.out.println(matcher.group(1)); 
       }
        return result;  
    } 
    /**  
     *   
     * 基本功能：替换指定的标签    
     * <p>  
     *   
     * @param str  
     * @param beforeTag  
     *            要替换的标签  
     * @param tagAttrib  
     *            要替换的标签属性值  
     * @param startTag  
     *            新标签开始标记  
     * @param endTag  
     *            新标签结束标记   
     * @return String  
     * @如：替换img标签的src属性值为[img]属性值[/img]  
     */  
    public static String replaceHtmlTag(String str, String beforeTag,String tagAttrib, String startTag, String endTag) {   
        String regxpForTag = "<\\s*" + beforeTag + "\\s+([^>]*)\\s*>";   
        String regxpForTagAttrib = tagAttrib + "=\"([^\"]+)\"";   
        Pattern patternForTag = Pattern.compile(regxpForTag);   
        Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib);   
        Matcher matcherForTag = patternForTag.matcher(str);   
        StringBuffer sb = new StringBuffer();   
        boolean result = matcherForTag.find(); 
        sb.append("fsfsf");
        while (result){   
            StringBuffer sbreplace = new StringBuffer("dfff");   
            String group =matcherForTag.group(1);
            Matcher matcherForAttrib = patternForAttrib.matcher(group);   
            if (matcherForAttrib.find()) {   
                matcherForAttrib.appendReplacement(sbreplace, startTag + matcherForAttrib.group(1) + endTag);   
            }   
            matcherForTag.appendReplacement(sb, sbreplace.toString());   
            result = matcherForTag.find();   
        }   
        matcherForTag.appendTail(sb);   
        return sb.toString();   
    }   
    /**
     * 
     * @param str
     * @param beforeTag
     * @param startTag
     * @param endTag
     * @return
     */
    public static String replaceHtmlTag(String str, String beforeTag,String startTag, String endTag) {   
        String regxpForTag = "<\\s*" + beforeTag + "\\s+([^>]*)\\s*>";   
        Pattern patternForTag = Pattern.compile(regxpForTag);   
        Matcher matcherForTag = patternForTag.matcher(str);   
        StringBuffer sb = new StringBuffer(); 
        String result = "";   
        while(matcherForTag.find()){   
          //  StringBuffer sbreplace = new StringBuffer();   
          /*  if (matcherForAttrib.find()) {   
                matcherForAttrib.appendReplacement(sbreplace, startTag   
                        + matcherForAttrib.group(1) + endTag);   
            }   */		
            matcherForTag.appendReplacement(sb,startTag + matcherForTag.group(1) + endTag);   
            result = matcherForTag.group();   
        }   
       sb = matcherForTag.appendTail(sb);   
        return result;   
    } 
    /**
     * 去掉文本中的html标签
     *
     * @param inputString
     * @return
     */
    public static String html2Text(String inputString) {
        if (StringUtils.isEmpty(inputString)) {
            return null;
        }
        String htmlStr = inputString;
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        java.util.regex.Pattern p_html1;
        java.util.regex.Matcher m_html1;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String regEx_html1 = "<[^>]+";
            p_script = Pattern.compile(regEx_script,
                    Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern
                    .compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_html1 = Pattern
                    .compile(regEx_html1, Pattern.CASE_INSENSITIVE);
            m_html1 = p_html1.matcher(htmlStr);
            htmlStr = m_html1.replaceAll(""); // 过滤html标签

            textStr = htmlStr;

            // 替换&amp;nbsp;
            textStr = textStr.replaceAll("&amp;", "").replaceAll("nbsp;", "");

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;// 返回文本字符串
    }
	public static String repDomain(String source, String domain, String element, String attr) { 
		String img = ""; 
		Pattern p_image; 
		Matcher m_image; 
		String regEx_img = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE); 
		m_image = p_image.matcher(source); 
		while (m_image.find()) {
			img = m_image.group();
			Matcher m = Pattern.compile("href\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img); 
			while (m.find()) { 
				String srcVal = m.group(1); 
				if(srcVal.indexOf("/@tenant")>=0){
					int idx = srcVal.indexOf("/@tenant"); 
					StringBuffer temp = new StringBuffer(); 
					String dstVal = temp.append(domain).append(srcVal.substring(idx+1)).toString(); 
					source = source.replace(srcVal, dstVal); 
					} 
				} 
			} 
		return source; 
		}
	public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
                                                                                                        // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
                                                                                                    // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
 
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
 
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
 
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
 
            textStr = htmlStr;
 
        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr;// 返回文本字符串
    }
	/**
	 * 利用url获取html内容
	 * @param urlstr
	 * @return
	 */
	public static String getHtmlContent(String urlstr){  
        /*思路： 1.读出原网页：url--》openstream--》inputStreamRead---》bufferReader---》。read 
         * 2.解决自动识别字符编码 利用cpdetecter：http://sourceforge.jp/projects/sfnet_cpdetector/ 
        */  
        String result="";  
        if(StringUtils.isEmpty(urlstr)) return null;  
        try {  
            String charset = getCode(urlstr);  
            //System.out.println(charset);  
            URL url = new URL(urlstr);  
            InputStream is = url.openStream();  
            InputStreamReader isr = new InputStreamReader(is, charset);  
            BufferedReader br = new BufferedReader(isr);  
            String temp =null;  
            while(true){  
                temp = br.readLine();  
                /*if(StringUtil.isNotEmpty(temp)){*/  // 这个工具不能滥用，因为temp可能是“”但是正文没结束;     
                if(temp !=null){  
                    result += temp+"\n";  
                }else{  
                    break;  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
          
        return result;  
          
    }  
	/**
	 * CodepageDetectorProxy 是一个代理类，是个单例模式；开发api中有
 	 *说明这个代理类需要一个容器，于是我们找到ICodepageDetector有：
 	 *引入cpdector包（），利用CodepageDetectorProxy代理装入JChardetfacade容器,然后detectCodePage出东东 
	 * @param url
	 * @return
	 */
	public static String getCode(String url){  
        String result="";  
        if(StringUtils.isEmpty(url))return null;  
        try {  
        	CodepageDetectorProxy cdp =CodepageDetectorProxy.getInstance();  
        	cdp.add(JChardetFacade.getInstance());  
            result = cdp.detectCodepage(new URL(url)).toString();  
        } catch(Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
        }
        /**
	 * 
	 * @param regexString
	 * @param content
	 * @param index
	 * @return
	 */
	public static String getContentUseRegex(String regexString ,String content,int index){  
        String result="";  
        if(StringUtils.isEmpty(regexString)|| StringUtils.isEmpty(content)) return result;  
         
        Pattern pattern = Pattern.compile(regexString);  
        Matcher matcher =pattern.matcher(content);  
        if(matcher.find()){  
            //System.out.println("find");  
            result = matcher.group(index);  
        }  
        return result;  
}  
	/**
	 * 
	 * @param urlstr
	 * @param encoding
	 * @param tag
	 * @param attrName
	 * @param attrVal
	 * @return
	 */
	public static String getContentUseParse(String urlstr,String encoding,String tag,String attrName,String attrVal){  
        /* 思路：引用htmlParse包--》Parse。parse（AndFileter） 
         *其中NodeFileter是一个接口，AndFilterTagNameFilter HasAttributeFilter都是其实现类 
         *AndFilter 是一个可以层层封装的过滤类；用AndFilter andFilter= new AndFilter(new TagNameFilter("h1"),new HasAttributeFilter("itemprop","headline")); 
         *解析后得到NodeList ，于是就可以了 
         */      
        String result ="";  
        AndFilter andFilter=null;  
        if(StringUtils.isEmpty(urlstr))return result;  
        if(StringUtils.isEmpty(encoding))encoding="utf-8";  
        try {  
            Parser parser = new Parser(urlstr);  
            parser.setEncoding(encoding);  
            if(StringUtils.isNotEmpty(attrName)&& StringUtils.isNotEmpty(attrVal)){  
                 andFilter = new AndFilter(new TagNameFilter(tag),new HasAttributeFilter(attrName, attrVal));  
            }else if(StringUtils.isNotEmpty(attrName)&& StringUtils.isEmpty(attrVal)){  
                 andFilter = new AndFilter(new TagNameFilter(tag),new HasAttributeFilter(attrName));  
            }else{  
                NodeFilter[]  nodeFilters = new NodeFilter[1];  
                nodeFilters[0] = new TagNameFilter(tag);  
                 andFilter = new AndFilter(nodeFilters);  
            }  
            NodeList nodeLists =parser.parse(andFilter);  
            parser.reset();  
            Node node = nodeLists.elementAt(0);  
            result = node.toPlainTextString();  
        } catch(Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
   }  
	@Test  
    public void getHtmlContentUseParseTest(){  
        //<div class=\"time\" id=\"pubtime_baidu\" itemprop=\"datePublished\" content=\"2015-12-06T08:35:00+08:00\">2015-12-06 08:35:00</div>  
        //<h1 itemprop="headline">习近平在中非合作论坛约翰内斯堡峰会上总结讲话</h1>  
        String encoding = HtmlUtil.getCode("http://news.sohu.com/20151206/n429917146.shtml");  
        String str = HtmlUtil.getContentUseParse("http://news.sohu.com/20151206/n429917146.shtml", encoding,"h1","itemprop","headline");  
      
        System.out.println(str);  
    }  
	@Test  
     public void getContentUseRegexTest(){  
        //<h1 itemprop="headline">习近平在中非合作论坛约翰内斯堡峰会上总结讲话</h1>  
        String source = "<h1itemprop=\"headline\">习近平在中非合作论坛约翰内斯堡峰会上总结讲话</h1>";  
        String regex ="<h1(.*)itemprop=\\\"headline(.*)\\\">(.*)</h1>";  
        String str = getContentUseRegex(regex,source,3);  
        System.out.println(str);  
        //<divclass="time" id="pubtime_baidu" itemprop="datePublished"content="2015-12-06T08:35:00+08:00">2015-12-06 08:35:00</div>  
        source = "<divclass=\"time\" id=\"pubtime_baidu\"itemprop=\"datePublished\"content=\"2015-12-06T08:35:00+08:00\">2015-12-0608:35:00</div>";  
        regex = "<div(.*)itemprop=\\\"datePublished\\\"(.*)>(.*)</div>";  
        str = getContentUseRegex(regex,source, 3);  
        System.out.println(str);  
	}
	public static void main(String[] args) {
		String html="<select><option value='bbdb' selected='selected'>bbbb</option><option value='aaa'>aaa</option></select><input name='mileage' min='0' value='aaaa' onkeyup='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)' onblur='this.v()' type='number'>";
		//String result = replaceHtmlTag(html,"input","value","<span>","</span>");
		//System.out.println(fiterHtmlTag(html, "input"));
		//System.out.println(result);
		// List<String> list =inputValue(html,"input", "value"); 
		List<String> list = selectValue(html,"select","value");
		 for(String s:list){
			 System.out.println(s);
		 }
		 
	}
}
