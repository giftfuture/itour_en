package com.itour.base.util;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.itour.base.util.RoleConstant.SuperAdmin;
import com.itour.entity.SysUser;

/**
 * 
 * Cookie 工具类
 *
 */
public final class SessionUtils {
	
	protected static final Logger logger = Logger.getLogger(SessionUtils.class);
	
	private static final String SESSION_USER = "session_user";

	private static final String SESSION_VALIDATECODE = "session_validatecode";//验证码
	
	private static final String HAPPY_VALIDATECODE = "happy_validatecode";//晒回忆幸福验证码
	
	private static final String SESSION_ACCESS_URLS = "session_access_urls"; //系统能够访问的URL
	
	
	private static final String SESSION_MENUBTN_MAP = "session_menubtn_map"; //系统菜单按钮

	
	
	/**
	  * 设置session的值
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static void setAttr(HttpServletRequest request,String key,Object value){
		 HttpSession session = request.getSession(true);
		 session.setMaxInactiveInterval(60*60);//一小时
		 session.setAttribute(key, value);
	 }
	 
	 
	 /**
	  * 获取session的值
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static Object getAttr(HttpServletRequest request,String key){
		 HttpSession session = request.getSession(false);
			if(session!=null)
				return session.getAttribute(key);
			return null;
	 }
	 
	 /**
	  * 删除Session值
	  * @param request
	  * @param key
	  */
	 public static void removeAttr(HttpServletRequest request,String key){
		 HttpSession session = request.getSession(false);
			if(session!=null)
			 session.removeAttribute(key);
	 }
	 
	 /**
	  * 设置用户信息 到session
	  * @param request
	  * @param user
	  */
	 public static void setUser(HttpServletRequest request,SysUser user){
		 HttpSession session = request.getSession(true);
		 session.setMaxInactiveInterval(60*60);//一小时
		 session.setAttribute(SESSION_USER, user);
	 }
	 
	 
	 /**
	  * 从session中获取用户信息
	  * @param request
	  * @return SysUser
	  */
	 public static SysUser getUser(HttpServletRequest request){
		 HttpSession session = request.getSession(false);
			if(session!=null)
			return (SysUser)session.getAttribute(SESSION_USER);
			return null;
	 }
	 
	 /**
	  * 从session中获取用户信息
	  * @param request
	  * @return SysUser
	  */
	 public static String getUserId(HttpServletRequest request){
		 SysUser user = getUser(request);
		 if(user != null){
			 return user.getId();
		 }
		return null; 
	 }
	 
	 
	 /**
	  * 从session中删除用户信息
	  * @param request
	  * @return SysUser
	  */
	 public static void removeUser(HttpServletRequest request){
		removeAttr(request, SESSION_USER);
	 }
	 
	 /**
	  * 设置验证码 到session
	  * @param request
	  * @param user
	  */
	 public static void setHappyValidateCode(HttpServletRequest request,String validateCode){
		 HttpSession session = request.getSession(true);
		 session.setMaxInactiveInterval(60*60);//一小时
		 session.setAttribute(HAPPY_VALIDATECODE, validateCode);
	 }
	 
	 
	 /**
	  * 从session中获取验证码
	  * @param request
	  * @return SysUser
	  */
	 public static String getHappyValidateCode(HttpServletRequest request){
		 HttpSession session = request.getSession(false);
		 if(session!=null)
			return(String)session.getAttribute(HAPPY_VALIDATECODE);
			return null;
	 }
	 
	 /**
	  * 从session中获删除验证码
	  * @param request
	  * @return SysUser
	  */
	 public static void removeHappyValidateCode(HttpServletRequest request){
		removeAttr(request, HAPPY_VALIDATECODE);
	 }
	 
	 /**
	  * 设置验证码 到session
	  * @param request
	  * @param user
	  */
	 public static void setValidateCode(HttpServletRequest request,String validateCode){
		 HttpSession session = request.getSession(true);
		 session.setMaxInactiveInterval(60*60);//一小时
		 session.setAttribute(SESSION_VALIDATECODE, validateCode);
	 }
	 
	 
	 /**
	  * 从session中获取验证码
	  * @param request
	  * @return SysUser
	  */
	 public static String getValidateCode(HttpServletRequest request){
		 HttpSession session = request.getSession(false);
		 if(session!=null)
			return (String)session.getAttribute(SESSION_VALIDATECODE);
			return null;
	 }
	 
	 
	 /**
	  * 从session中获删除验证码
	  * @param request
	  * @return SysUser
	  */
	 public static void removeValidateCode(HttpServletRequest request){
		removeAttr(request, SESSION_VALIDATECODE);
	 }
	 
	 /**
	  * 判断当前登录用户是否超级管理员
	  * @param request
	  * @return
	  */
	 public static boolean isAdmin(HttpServletRequest request){ //判断登录用户是否超级管理员
		 SysUser user =  getUser(request);
		 if(user == null  || user.getSuperAdmin() != SuperAdmin.YES.key){
			 return false;
		 }
		 return true;
	 }
	 
	 
	 
	 /**
	  * 设置当前登录用户的访问菜单的权限
	  * @param request
	  * @return
	  */
	 public static void setAccessUrl(HttpServletRequest request,List<String> accessUrls){ //判断登录用户是否超级管理员
		 setAttr(request, SESSION_ACCESS_URLS, accessUrls);
	 }
	 
	 
	 
	 /**
	  * 判断URL是否可访问
	  * @param request
	  * @return
	  */
	 @SuppressWarnings("unchecked")
	public static boolean isAccessUrl(HttpServletRequest request,String url){ 
		 List<String> accessUrls = (List<String>)getAttr(request, SESSION_ACCESS_URLS);
		 if(accessUrls == null ||accessUrls.isEmpty() || !accessUrls.contains(url)){
			 return false;
		 }
		 return true;
	 }
	 
	 
	 /**
	  * 设置菜单按钮
	  * @param request
	  * @param btnMap
	  */
	 public static void setMemuBtnMap(HttpServletRequest request,Map<String,List<String>> btnMap){ //判断登录用户是否超级管理员
		 setAttr(request, SESSION_MENUBTN_MAP, btnMap);
	 }
	 
	 /**
	  * 获取菜单按钮
	  * @param request
	  * @param btnMap
	  */
	 public static List<String> getMemuBtnListVal(HttpServletRequest request,String menuUri){ //判断登录用户是否超级管理员
		 Map btnMap  = (Map)getAttr(request, SESSION_MENUBTN_MAP);
		 if(btnMap == null || btnMap.isEmpty()){
			 return null;
		 }
		 return (List<String>)btnMap.get(menuUri);
	 }
	 
//		private static final String SESSION_ACCESS_URLS = "session_access_urls"; //系统能够访问的URL
//		
//		
//		private static final String SESSION_MENUBTN_MAP = "session_menubtn_map"; //系统菜单按钮
	
}