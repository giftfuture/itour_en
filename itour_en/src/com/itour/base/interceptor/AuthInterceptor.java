package com.itour.base.interceptor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.ui.ModelMap;  
import org.springframework.web.context.request.WebRequest;  
import org.springframework.web.context.request.WebRequestInterceptor;

import com.itour.base.Filter.FileCaptureResponseWrapper;
import com.itour.base.annotation.Auth;
import com.itour.base.util.FilePros;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.entity.SysUser;


/**
 * 权限拦截器
 * @author fred
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	private final static Logger log = Logger.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
	//	boolean handlerOk = super.preHandle(request, response, handler);
		//AuthInterceptor auths = (handler).getMethodAnnotation(AuthInterceptor.class);
		/*if(handler instanceof ResourceHttpRequestHandler){
			ResourceHttpRequestHandler hh = (ResourceHttpRequestHandler)handler;
			//if(hh.)
		}*/
		String requesturi= request.getRequestURI();
		String menuUrl = StringUtils.remove(requesturi,request.getContextPath()+"/");
		if(menuUrl.startsWith("images/")||menuUrl.startsWith("js/")||menuUrl.startsWith("css/")||menuUrl.startsWith("resources/")||menuUrl.startsWith("main/logIn")||menuUrl.startsWith("main/index.js.map")){
			return super.preHandle(request, response, handler);
		}
		if (handler instanceof HandlerMethod){
				HandlerMethod method = (HandlerMethod)handler;
				Auth auth = method.getMethodAnnotation(Auth.class);
		//		Auth auth = method.getMethod().getAnnotation(Auth.class);
				////验证登陆超时问题  auth = null，默认验证 
				if(auth !=null && auth.verifyLogin()){
					//String path = request.getServletPath();
					SysUser user =SessionUtils.getUser(request);
					if(user == null){
						String baseUri = request.getContextPath();
						String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+baseUri+"/";    
						response.setStatus(response.SC_GATEWAY_TIMEOUT);
						//request.getRequestDispatcher("window.location.href="+basePath+"main/login").forward(request,response);
						//response.sendRedirect("window.location.href="+basePath+"main/login");
						response.sendRedirect(basePath+"main/login");
						//forword("window.location.href="+basePath+"main/login",null);
					/*	Map<String, Object> result = new HashMap<String, Object>();
						result.put(BaseController.SUCCESS, false);
						result.put(BaseController.LOGOUT_FLAG, true);//登录标记 true 退出
						result.put(BaseController.MSG, "请登录.");
						HtmlUtil.writerJson(response, result);*/
						return false;
					}
					return super.preHandle(request, response, handler);
				}
				//验证URL权限
				if(auth !=null && auth.verifyURL()){		
					//判断是否超级管理员
					if(!SessionUtils.isAdmin(request)){
						if(!SessionUtils.isAccessUrl(request, StringUtils.trim(menuUrl))){					
							//日志记录
							String userMail = SessionUtils.getUser(request).getEmail();
							String msg ="URL权限验证不通过:[url="+menuUrl+"][email ="+ userMail+"]" ;
							log.error(msg);
							response.setStatus(response.SC_FORBIDDEN);
							Map<String, Object> result = new HashMap<String, Object>();
							result.put(BaseController.SUCCESS, false);
							result.put(BaseController.MSG, "没有权限访问,请联系超级管理员.");
							HtmlUtil.writerJson(response, result);
							return false;
						}
					}
				}else{}
		}
		return super.preHandle(request, response, handler);
	}
	/**
	 * 
	 * @param viewName
	 * @param context
	 * @return
	 */
	private ModelAndView forword(String viewName,Map context){
		return new ModelAndView(viewName,context); 
	}
	
}
