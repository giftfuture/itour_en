package com.itour.base.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.itour.base.collect.Mapx;
import com.itour.base.collect.Mapxs;
import com.itour.base.json.JsonUtils;
import com.itour.base.log.Logger;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.edit.MyEditor;
@Controller
@Scope("prototype")
public class BaseController {
	//===================================Fields==============================================
		/** 记录日志的对象. */
	private static Logger logger = Logger.getLogger(BaseController.class);
	
	public final static String SUCCESS ="success";  
	
	public final static String MSG ="msg";  
	
	public final static String PROP ="prop";  
	
	public final static String DATA ="data";  
	
	public final static String LOGOUT_FLAG = "logoutFlag";  
	
	
   @InitBinder  
   protected void initBinder(WebDataBinder binder) {  
		 binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));  
		 binder.registerCustomEditor(int.class,new MyEditor()); 
   }  
	 
	 /**
	  * 获取IP地址
	  * @param request
	  * @return
	  */
	 public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	 
	 /**
	  * 所有ActionMap 统一从这里获取
	  * @return
	  */
	public Map<String,Object> getRootMap(){
		Map<String,Object> rootMap = Maps.newHashMap();
		//result.put(SUCCESS, false);
		//result.put(MSG, message);
		//添加url到 Map中
		//rootMap.putAll(URLUtils.getUrlMap());
		return rootMap;
	}
	public Map<String,String> getHashMap(){
		Map<String,String> map = Maps.newHashMap();
		//result.put(SUCCESS, false);
		//result.put(MSG, message);
		//添加url到 Map中
		//rootMap.putAll(URLUtils.getUrlMap());
		return map;
	}
	public ModelAndView forward(String viewName,Map context){
		return new ModelAndView(viewName,context); 
	}
	public ModelAndView forward(String viewName){
		return new ModelAndView(viewName); 
	}
	public ModelAndView error(String errMsg){
		return new ModelAndView("error"); 
	}
	/**
	 *
	 * 提示成功信息
	 *
	 * @param message
	 *
	 */
	public void successMessage(HttpServletResponse response,  String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SUCCESS, true);
		map.put(MSG, message);
		//String result = JsonUtils.encode(map);
		HtmlUtil.writerJson2(response,map);
	}
	/**
	 * 
	 * @param response
	 * @param message
	 */
	public void failureMessage(HttpServletResponse response,  String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SUCCESS, false);
		map.put(MSG, message);
		HtmlUtil.writerJson2(response,map);
	}
	/**
	 *
	 * 提示成功信息
	 *
	 * @param message
	 *
	 */
	public void sendSuccessMessage(HttpServletResponse response,  String message) {
		Map<String, Object> result = getRootMap();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		HtmlUtil.writerJson(response, result);
	}
	
	public String removeSuccessMessage(HttpServletResponse response) {
		Map<String, Object> result = getRootMap();
		result.put(SUCCESS, true);
		result.put(MSG, "删除成功！");
		return JsonUtils.encode(result);
	}
	/**
	 *
	 * 提示失败信息
	 *
	 * @param message
	 *
	 */
	public void sendFailureMessage(HttpServletResponse response,String message) {
		Map<String, Object> result = getRootMap();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		HtmlUtil.writerJson(response, result);
	}
	public String sendFailureResult(HttpServletResponse response,String message) {
		Map<String, Object> result = getRootMap();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		return JsonUtils.encode(result);
	}
	public String sendSuccessResult(HttpServletResponse response,String message) {
		Map<String, Object> result = getRootMap();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		return JsonUtils.encode(result);
	}
	public String sendFailureResult(HttpServletResponse response,String message,String result) {
		Map<String, Object> context = getRootMap();
		context.put(SUCCESS, false);
		context.put(MSG, message);
		context.put(DATA,result);
		return JsonUtils.encode(context);
	}
	public String sendSuccessResult(HttpServletResponse response,String message,String result) {
		Map<String, Object> context = getRootMap();
		context.put(SUCCESS, true);
		context.put(MSG, message);
		context.put(DATA,result);
		return JsonUtils.encode(context);
	}
	/**
	 *
	 * 提示失败信息
	 *
	 * @param message
	 *
	 */
	public void sendFailureMessage(HttpServletResponse response,String property,String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		result.put(PROP, property);
		HtmlUtil.writerJson(response, result);
	}
	/**
	 * 从request读取数据,并将数据封装成MAP格式
	 * @param request HTTP请求
	 * @return 请求的参数
	 */
	public static Mapx read(HttpServletRequest request) {
		Mapx params = Mapxs.newMapx();
		for (Enumeration<String> en = request.getParameterNames(); en.hasMoreElements();) {
			String name = en.nextElement();
			String value = request.getParameter(name);
			params.put(name, value);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("params:" + params);
		}
		return params;
	}

	/**
	 * 从request body读取数据
	 * @param request HTTP请求
	 * @return request_body 数据
	 */
	public static String readText(HttpServletRequest request) {
		InputStream input = null;
		String text = null;
		try {
			text = IOUtils.toString(input = request.getInputStream(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(input);
		}
		return text;
	}

	/**
	 * 返回数据
	 * @param src 返回的数据
	 * @param response HTTP响应
	 */
	public static void write(Object src, HttpServletResponse response) {
		try {
			if (src instanceof Throwable) {
				src = wrapException((Throwable) src);
			}
			String json = JsonUtils.encode(src);
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			//response.setContentType("text/html; charset=UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Access-Control-Allow-Origin", "*");
			if (logger.isDebugEnabled()) {
				logger.debug("json:" + json);
			}
			PrintWriter writer = response.getWriter();
			writer.print(json);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	/**
	 * 返回JSONP数据
	 * 
	 * @param src 返回的数据
	 * @param request HTTP请求
	 * @param response HTTP响应
	 */
	public static void writeJsonp(Object src, HttpServletRequest request, HttpServletResponse response) {
		String callback = StringUtils.EMPTY;
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			callback = StringUtils.defaultString(request.getParameter("callback"));// JSONP
		}
		try {
			if (src instanceof Throwable) {
				src = wrapException((Throwable) src);
			}
			String json = JsonUtils.encode(src);
			if (logger.isDebugEnabled()) {
				logger.debug("callback:" + callback + " json:" + json);
			}
			response.setHeader("Pragma", "no-cache"); // HTTP/1.0
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/javascript;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append(callback);
			writer.append("(");
			writer.append(json);
			writer.append(")");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	
	/**
	 * 包装异常
	 * @param e 异常信息
	 * @return 包装后的结果
	 */
	protected static Mapx wrapException(Throwable e) {
		Mapx error = Mapxs.newMapx();
		String message = e.getMessage();
		if (message == null) {
			message = e.toString();
		}
		error.put("@failure", Boolean.TRUE);//failure|success
		return error;
	}


}
