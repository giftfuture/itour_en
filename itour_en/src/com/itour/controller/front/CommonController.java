package com.itour.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.util.HtmlUtil;
import com.itour.controller.TravelStyleController;
import com.itour.entity.TravelStyle;
import com.itour.vo.TravelStyleVO;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.TravelStyleService;

@Controller
//@Scope("prototype")
@RequestMapping("/common") 
public class CommonController {

	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	// Servrice start
	@Autowired
	private TravelStyleService<TravelStyle> travelStyleService; 
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
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/styles") 
	public void allData(HttpServletResponse response,TravelStyleVO page)throws Exception{
		List<TravelStyle> dataList = travelStyleService.queryValid();
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
}
