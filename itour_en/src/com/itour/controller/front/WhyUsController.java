package com.itour.controller.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.web.BaseController;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;

import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

@Controller 
//@RequestMapping("/whyus")
public class WhyUsController extends BaseController {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;
	
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	
	@Autowired
	private LogOperationService logOperationService;
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/whyus-why")
	public ModelAndView why(HttpServletRequest request,HttpServletResponse response){
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //Browser browser = userAgent.getBrowser();  
        OperatingSystem os = userAgent.getOperatingSystem();
        if(os.isMobileDevice()){
        	logger.debug("###########WhyUsController why当前是移动浏览器#####");
        	return forward("mfront/whyus/why");
        }
		return forward("front/whyus/why");
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/whyus-aboutus")
	public ModelAndView aboutus(HttpServletRequest request,HttpServletResponse response){
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //Browser browser = userAgent.getBrowser();  
        OperatingSystem os = userAgent.getOperatingSystem();
        if(os.isMobileDevice()){
        	logger.debug("###########WhyUsController aboutus当前是移动浏览器#####");
        	return forward("mfront/whyus/aboutus");
        }
		return forward("front/whyus/aboutus");
	}
}
