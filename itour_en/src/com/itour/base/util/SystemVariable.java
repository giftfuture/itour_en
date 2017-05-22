package com.itour.base.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.itour.base.jdbc.JdbcDaoHelper;
import com.itour.base.jdbc.JdbcTemplatex;
import com.itour.base.util.email.EmailService;
import com.itour.dao.CustomersDao;

public class SystemVariable{
	/**
	 * 任务处理状态标志,
	 * 等0表示等待接受任务。
	 * 非0表示正在处理任务。
	 */
	public static int TaskCount = 0;
	//public static Map<String, String> map = new HashMap<String, String>();
	
	public static String taskSerialNum = "";				//任务序列号
	public static Exception exception = null;					//系统异常
	public static String hostName = "";						//本机计算机名
	public static String hostIp = "";						//本机IP地址
	public static String remoteAddr = "";					//远程调用IP
	
	public static Map<String, String> exceptionBrand = new HashMap<String, String>();//标签字段
	public static List<Exception> exceptionList = new ArrayList<Exception>();//异常列表
	public static StringBuffer brandString = new StringBuffer();//异常标签
	
	public static String tasker = "";						//调用者
	
	public static boolean localCacheRunning = false;		//本地文件写入运行状态
	public static int localCacheTaskCount = 0;				//本地文件写入线程数
	public static Exception localCacheException = null;;	//本地文件写入异常
	
	public static int errorSyncDataCount = 0;				//同步失败数据数量
	
	public static final Map<String,String> cache = new HashMap<String,String>();
	
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	static{
		try {
		   hostName = InetAddress.getLocalHost().getHostName();
		   hostIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void init(){
		String sql = "select var_name,var_value from sys_variables where var_project='itour' and var_hostname='"+SystemVariable.hostName+"' and var_hostip='"+SystemVariable.hostIp+"'";  
		List<Map<String, Object>> list = null;
		System.out.println("WebInitListener.contextInitialized.sql="+sql);
		//WebApplicationContext apli=WebApplicationContextUtils.getWebApplicationContext(servlet);
		//SysVariablesService sysParamService=(SysVariablesService) apli.getBean("SysParamService");
		try{
			//JdbcTemplate tpl =  this.getJdbcTemplate();
			//tpl = new JdbcTemplate(dataSource);
			//list =JdbcTemplatex.queryForList(sql);  
			//list =JdbcDaoHelper.(sql);  
			list = jdbcTemplate.queryForList(sql);
			for (Map<String,Object> map : list){
				SystemVariable.cache.put(map.get("var_name").toString(),map.get("var_value").toString());
				//System.out.println(map.get("var_name")+"         "+map.get("var_value"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	//	sendEmail();
	}
	
	private static void sendEmail(){

		//String receive_email = PropUtil.getValue("receive_email","zzz@163.com");
		//System.out.println(receive_email);
		 //trustAllHttpsCertificates();  
		 //HttpsURLConnection.setDefaultHostnameVerifier(hv);  
		// SslUtils.ignoreSsl();
		// EmailService.sendEmail("zpc@sina.com", "mai test", "testmail","zpc@sina.com","123456","mail.sina.com","25");
		//	emailTemplateService.sendEmail(userMap, acctMap, eventType);
		try {
			 String title="Holy Bible《神学讲座 ——普遍启示与特殊启示》第一讲";
			 String content = "我不知道你为什麽来参加这个聚会？这个聚会里面不讲故事的，不是做见证的，不是讲作梦经验或是古哩古怪的事情，我们要讲神学的问题。如果对神学有兴趣，而结果又找到正统的神学，那就是信仰的根基被建立起来的一个很重要的秘诀了。如果教会对神学没有兴趣，或者对正统的神学没有兴趣，那麽这个教会的信仰就没有根基了。所以我盼望这个神学要从「神学院的垄断」拯救出来，因为许多人以为神学只是「神学院里面的人」搞的事情。而「神学」这个字在希腊文就是用两个字配合起来的，第一个字就是Theos、第二个字就是 Logos，所以 Theology就是「神的道」，或者是「对神的真理的认识」，「有关於神的知识」这个叫做「神学」";
			 String receivers = SystemVariable.cache.get("receive_email");
			 String sender = SystemVariable.cache.get("sender_email");
			 String pwd = SystemVariable.cache.get("sender_pwd");
			 String host = SystemVariable.cache.get("sender_host");
			 String port = SystemVariable.cache.get("sender_port");
			 String auth = SystemVariable.cache.get("sender_auth");
			 String ssl = SystemVariable.cache.get("sender_ssl");
			 String protocol = SystemVariable.cache.get("sender_protocol");
			// String [] emails = receivers.split(";");
			// for(String email:emails){						 
				 EmailService.sendEmail(receivers, title, content,sender,pwd,host,port,auth,ssl,protocol,"");
			// }
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	
	}
	
	public static synchronized void addErrorSyncDataCount(){
		errorSyncDataCount++;
	}
	
	public static synchronized void addLocalCacheThreadCount(){
		localCacheTaskCount++;
	}
	
	public static synchronized void reduceLocalCacheThreadCount(){
		localCacheTaskCount--;
	}
	
	public static synchronized void addThreadCount(){
		TaskCount++;
	}
	
	public static synchronized void reduceThreadCount(){
		TaskCount--;
	}
	
	public static synchronized void addException(Exception exception){
		exceptionList.add(exception);
	}
	
	public static synchronized void addBrandString(String brand){
		brandString.append(brand);
	}
	
	public static synchronized void clearBrandString(){
		brandString.delete(0, brandString.length());
	}


	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		SystemVariable.jdbcTemplate = jdbcTemplate;
	}
	
}
