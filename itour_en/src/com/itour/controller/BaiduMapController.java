package com.itour.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
/*import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.vehicle.entity.mobile.GsMeitrackObdEntity;
import org.jeecgframework.web.vehicle.entity.mobile.GsPersonnelRouteEntity;
import org.jeecgframework.web.vehicle.entity.vehicle.GsCarinfoEntity;
import org.jeecgframework.web.vehicle.service.mobile.GsMeitrackObdServiceI;
import org.jeecgframework.web.vehicle.service.mobile.GsPersonnelRouteServiceI;
import org.jeecgframework.web.vehicle.service.route.GsCarRouteServiceI;
import org.jeecgframework.web.vehicle.service.vehicle.GsCarinfoServiceI;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itour.base.util.DateUtil;
import com.itour.base.web.BaseController;


/**
 * @author pc
 * 
 */
@Controller
@RequestMapping("/baiduMapController")
public class BaiduMapController extends BaseController
{
/*	@Autowired
	private GsCarRouteServiceI gsCarRouteServiceI;
	@Autowired
	private GsMeitrackObdServiceI gsMeitrackObdServiceI;
	@Autowired
	private GsPersonnelRouteServiceI gsPersonnelRouteServiceI;
	@Autowired
	private GsCarinfoServiceI gsCarinfoService;
	@Autowired
	private SystemService systemService;*/
	private String message;
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	/**
	 * 通用列表页面跳转
	 */
	@RequestMapping(params = "mapTest")
	public String mapTest(HttpServletRequest request)
	{
		// 跳转的目标页面
		return "map/jsdemo01";
	}
	
	/**
	 * 通用列表页面跳转
	 */
	@RequestMapping(params = "mapTest1")
	public String mapTest1(String id, HttpServletRequest request)
	{
		// 跳转的目标页面
		request.setAttribute("id", id);
		String today = DateUtil.dateToString(new Date(), "yyyy-MM-dd");
		String yesterday = DateUtil.dateToString(DateUtil.getDateFromString(DateUtil.getYesterday()), "yyyy-MM-dd");
		String todayfirstTime = today + " 00:00:00";
		String todaylastTime = today + " 23:59:59";
		String yesterdayfirstTime = yesterday + " 00:00:00";
		String yesterdaylastTime = yesterday + " 23:59:59";
		request.setAttribute("todayfirstTime", todayfirstTime);
		request.setAttribute("todaylastTime", todaylastTime);
		request.setAttribute("yesterdayfirstTime", yesterdayfirstTime);
		request.setAttribute("yesterdaylastTime", yesterdaylastTime);
		return "map/jsdemo";
	}
	
	/**
	 * 通用列表页面跳转
	 */
	@RequestMapping(params = "personMap")
	public String personMap(/*GsPersonnelRouteEntity gsCarinfo,*/ HttpServletRequest request)
	{
		// 跳转的目标页面
		//request.setAttribute("id", gsCarinfo.getId());
		String today = DateUtil.dateToString(new Date(), "yyyy-MM-dd");
		String yesterday = DateUtil.dateToString(DateUtil.getDateFromString(DateUtil.getYesterday()), "yyyy-MM-dd");
		String todayfirstTime = today + " 00:00:00";
		String todaylastTime = today + " 23:59:59";
		String yesterdayfirstTime = yesterday + " 00:00:00";
		String yesterdaylastTime = yesterday + " 23:59:59";
		request.setAttribute("todayfirstTime", todayfirstTime);
		request.setAttribute("todaylastTime", todaylastTime);
		request.setAttribute("yesterdayfirstTime", yesterdayfirstTime);
		request.setAttribute("yesterdaylastTime", yesterdaylastTime);
		return "map/personMap";
	}
	
	/**
	 * 通用列表页面跳转
	 */
	@RequestMapping(params = "mapData")
	public void mapData(HttpServletRequest request, HttpServletResponse response)
	{
		String sql = "SELECT * FROM agent_point";
		//DataDo dd = new DataDo();
		String outstr = "";
		try
		{
		//	outstr = dd.resultSetToJson(dd.dataDo(sql));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try
		{
			response.getWriter().write(outstr);
			response.getWriter().flush();
			response.getWriter().close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	@RequestMapping(params = "mapDataByParam")
	@ResponseBody
	public List<GsMeitrackObdEntity> getRouteListByUserId(GsCarinfoEntity gsCarinfo, HttpServletRequest request,
	        HttpServletResponse response)
	{
		//
		String id = request.getParameter("id");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String hql = "select t1 from GsMeitrackObdEntity t1,GsCarinfoEntity t where t1.imei=t.obdnumber and  t.id='"
		        + id + "' ";
		if (!StringUtils.isNoneEmpty(starttime))
		{
			hql = hql + " and t1.datetime >= '" + starttime + "' ";
		}
		if (!StringUtils.isNoneEmpty(endtime))
		{
			hql = hql + " and t1.datetime <= '" + endtime + "' ";
		}
		hql = hql + " order by t1.datetime asc";
		List<GsMeitrackObdEntity> list = gsMeitrackObdServiceI.findByQueryString(hql);
		return list;
	}*/
	
/*	@RequestMapping(params = "personmapDataByParam")
	@ResponseBody
	public List<GsPersonnelRouteEntity> personmapDataByParam(String id, String starttime, String endtime)
	{
		String hsql = "select t1 from GsPersonnelRouteEntity t1 ,GsCarinfoEntity t where t1.personnelid=t.personnelid and  t.id='"
		        + id + "' ";
		if (!StringUtils.isNullOrEmpty(starttime))
		{
			hsql = hsql + " and t1.createtime >= '" + starttime + "' ";
		}
		if (!StringUtils.isNullOrEmpty(endtime))
		{
			hsql = hsql + " and t1.createtime <= '" + endtime + "' ";
		}
		hsql = hsql + " order by t1.createtime asc";
		List<GsPersonnelRouteEntity> list = gsPersonnelRouteServiceI.findByQueryString(hsql);
		return list;
	}*/
}
