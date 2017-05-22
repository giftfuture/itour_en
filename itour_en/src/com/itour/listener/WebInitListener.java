package com.itour.listener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.itour.base.util.SessionUtils;
import com.itour.base.util.SystemVariable;
import com.itour.util.Constants;

public class WebInitListener extends JdbcDaoSupport implements ServletContextListener {
	
	private static final Logger log = Logger.getLogger(WebInitListener.class);
	
	/*@Autowired(required=false)
	private JdbcTemplate jdbcTemplate;
	
	@Autowired(required=false)
	private DruidDataSource dataSource;*/
//	public static HashMap<String, String> ConfigMap=new HashMap<String, String>();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	@Override
	public void contextInitialized(ServletContextEvent event) {
	   ServletContext servlet=event.getServletContext();
	   SystemVariable.init();
	   Constants.init();
	}
	

	
	/* 启动不同任务类型的线程 */
	public void initThreadRunner() {
		String pTaskType = "";
		try {
			//pTaskType = PropertiesUtils.getProperties(ContextUtils.taskTypeFileName).getProperty("taskType");
		} catch (Exception e) {
			// logger.error("读取属性文件错误！");
		}
	}
	

}
