package com.itour.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.page.Pager;
import com.itour.base.util.FilePros;
import com.itour.base.web.BaseController;
import com.itour.entity.Areas;
import com.itour.entity.RouteTemplate;
import com.itour.service.AreasService;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.RouteTemplateService;
import com.itour.service.TravelItemService;
import com.itour.util.Constants;
import com.itour.vo.RouteTemplateVO;
import com.itour.vo.TravelItemVO;

import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
@Controller
@RequestMapping("/destination") 
public class DestinationController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	@Autowired  
	private RouteTemplateService<RouteTemplate> routeTemplateService; 
	@Autowired
	private TravelItemService travelItemService;
	@Autowired
	private AreasService areasService;
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;
	
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	
	@Autowired
	private LogOperationService logOperationService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/main") 
	public ModelAndView main(TravelItemVO vo,HttpServletRequest request) throws Exception{
		long beginTime = System.currentTimeMillis();
	 	Map<String,Object> context = getRootMap();
	 	List<Areas> allScopes = areasService.allAreas();
	 	Map<String,List<TravelItemVO>> sortedItems = Maps.newHashMap();
	 	Map<String,String> scopes = Maps.newHashMap();
	 	List<TravelItemVO> list = Lists.newArrayList();
	 	List<TravelItemVO> sublist = Lists.newArrayList();
	 	List<TravelItemVO> fulllist = null;
	 	Map<String,Integer> tiSizes = Maps.newHashMap();
	 	String ptopath = FilePros.httpitemCoverpath();
	 	for(Areas scope:allScopes){
	 		fulllist = Lists.newArrayList();
			list = travelItemService.queryByScope(scope.getId());
			if(list != null && list.size() > Constants.maxDestinations){
				sublist=list.subList(0, Constants.maxDestinations);
				fulllist.addAll(sublist);
			}else{
				sublist=list;
				if(list.size()>0){
					fulllist.addAll(list);
					for ( int i=0;i < Constants.maxDestinations-list.size();i++){
						fulllist.add(new TravelItemVO());
					}
				}
			}
			for(TravelItemVO ti:sublist){
				if(StringUtils.isNotEmpty(ti.getCover())){	 							
					String realCover = ptopath+"/" +StringUtils.trim(ti.getItemCode())+"_"+ti.getAlias()+"/"+ ti.getCover();
					ti.setCover(realCover);
				}
			}
			System.out.println("########sublist="+sublist.size());
			System.out.println("########fulllist="+fulllist.size());
 			if(StringUtils.isNoneEmpty(scope.getId(),scope.getAreaname()) && list != null && list.size() >0){	
 				sortedItems.put(scope.getPinyin()+"_"+scope.getShortname(), fulllist);
 				tiSizes.put(scope.getPinyin()+"_"+scope.getShortname(), list.size());		
 				scopes.put(scope.getId(), scope.getAreaname());
 			}
	 	}
	 	List<TravelItemVO> items = travelItemService.searchTravelItem(new HashMap());		
		//设置页面数据
		context.put("scopes", scopes); 
		context.put("items", items);
		context.put("sortedItems",sortedItems);
		context.put("tiSizes",tiSizes);
		context.put("maxd", Constants.maxDestinations);
		System.out.println("用时："+(System.currentTimeMillis()-beginTime));
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //Browser browser = userAgent.getBrowser();  
        OperatingSystem os = userAgent.getOperatingSystem();
        if(os.isMobileDevice()){
        	logger.debug("###########DestinationController main当前是移动浏览器#####");
        	return forward("mfront/destination/destinations",context);
        }
		return forward("front/destination/destinations",context); 
	}
	/**
	 * 
	 * @param scopeAlias
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/detail/{alias}", method = RequestMethod.GET) 
	public ModelAndView detail(@PathVariable("alias")String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
	 	Map<String,Object> context = getRootMap();
	 	List<Areas> allScopes = areasService.allAreas();
	 	List<TravelItemVO> list = Lists.newArrayList();
	 	List<TravelItemVO> sublist = Lists.newArrayList();
	 	Map<String,String> scopes = Maps.newHashMap();
	 	String ptopath = FilePros.httpitemCoverpath();
	 	for(Areas scope:allScopes){
			list = travelItemService.queryByScope(scope.getId());
			if(list != null && list.size() > Constants.maxDestinations){
				sublist = list.subList(0, Constants.maxDestinations);
			}else{
				sublist = list;
			}
			for(TravelItemVO ti:sublist){
				if(StringUtils.isNotEmpty(ti.getCover())){	 							
					String realCover = ptopath+"/" +StringUtils.trim(ti.getItemCode())+"_"+ti.getAlias()+"/"+ ti.getCover();
					ti.setCover(realCover);
				}
			}
 			if(StringUtils.isNoneEmpty(scope.getId(),scope.getAreaname()) && sublist != null && sublist.size() >0){	 				
 				scopes.put(scope.getId(), scope.getAreaname());
 			}
	 	}
	 	List<TravelItemVO> items = travelItemService.searchTravelItem(new HashMap());		
		context.put("items", items);
	 	TravelItemVO itemvo = travelItemService.getByAlias(alias);	
	 	String [] photos = itemvo.getPhotos().split("\\|");
	 	List<String> photoList = Lists.newArrayList();
	 	String photoPath = FilePros.httptravelitemPhotoPath();
	 	String itemCoverPath = FilePros.httpitemCoverpath();
	 	itemvo.setCover(StringUtils.trim(itemCoverPath+"/"+itemvo.getItemCode()+"_"+itemvo.getAlias()+"/"+itemvo.getCover()));
	 	if(photos!=null && photos.length>0){
	 		for(String photo:photos){
	 			if(StringUtils.isNotEmpty(photo)&&!photo.equals(",")&&!photo.equals("|")&&photo.indexOf('.')>0){
	 				photoList.add(photoPath+"/"+StringUtils.trim(itemvo.getItemCode())+"_"+itemvo.getAlias()+"/"+ photo);
	 			}
	 		}
	 	}
	 	if(StringUtils.isNotEmpty(itemvo.getTicketsBlock())){
			 	StringBuffer ticketsBlock=new StringBuffer("<table border=0>");
			 	if(itemvo.getFullyearTicket()==1){//区分淡旺季
			 			String[] busytb = itemvo.getTicketsBlock().substring(itemvo.getTicketsBlock().indexOf("slack season")<0?0:itemvo.getTicketsBlock().indexOf("slack season")+3,itemvo.getTicketsBlock().indexOf("busy season")<0?itemvo.getTicketsBlock().length():itemvo.getTicketsBlock().indexOf("busy season")).split("、");
			 			String[] freetb = itemvo.getTicketsBlock().substring(itemvo.getTicketsBlock().indexOf("busy season")<0?0:itemvo.getTicketsBlock().indexOf("busy season")+3).split("、");
			 			if(busytb.length>0){
				 			ticketsBlock.append("<tr><td rowspan="+busytb.length+" style='padding-right:5px'><strong>slack season</strong></td><td style='text-align:left'>"+busytb[0]+"</td></tr>");
				 			for(int i=0;i<busytb.length;i++){
				 				if(i!=0){
				 					ticketsBlock.append("<tr><td style='text-align:left'>"+busytb[i]+"</td></tr>");
				 				}
				 			}
			 			}
			 			if(freetb.length>0){
			 				ticketsBlock.append("<tr><td colspan=2 style='text-align:center'>-------------------------------------</td></tr>");
				 			ticketsBlock.append("<tr><td rowspan="+freetb.length+" style='padding-right:5px'><strong>busy season</strong></td><td style='text-align:left'>"+freetb[0]+"</td></tr>");
				 			for(int i=0;i<freetb.length;i++){
				 				if(i!=0){
				 					ticketsBlock.append("<tr><td style='text-align:left'>"+freetb[i]+"</td></tr>");
				 				}
				 			}
			 			}
			 		 
			 	}else{
			 		String [] tb = itemvo.getTicketsBlock().split("、");
			 		ticketsBlock.append("<tr><td rowspan="+tb.length+" style='padding-right:5px'>Full Year Ticket Information</td><td style='text-align:left'>"+tb[0]+"</td></tr>");
			 		for(int i=0;i<tb.length;i++){
		 				if(i!=0){
		 					ticketsBlock.append("<tr><td style='text-align:left'>"+tb[i]+"</td></tr>");
		 				}
		 			}
			 	}
			 	ticketsBlock.append("</table>");
			 	itemvo.setTicketsBlock(ticketsBlock.toString());
	 	}
		List<RouteTemplateVO> rts = routeTemplateService.queryByItems(itemvo.getId());
		context.put("scopes", scopes); 
		context.put("itemvo", itemvo);
		context.put("photos", photoList);
		context.put("rts", rts);
		context.put("showMore", rts.size()>Constants.maxMoreDestinations);
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //Browser browser = userAgent.getBrowser();  
        OperatingSystem os = userAgent.getOperatingSystem();
        if(os.isMobileDevice()){
        	logger.debug("###########DestinationController detail{alias}当前是移动浏览器#####");
        	return forward("mfront/destination/destdetail",context);
        }
		return forward("front/destination/destdetail",context); 
	}
	/**
	 * 
	 * @param scopeAlias
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/moredests/{scope}", method = RequestMethod.GET) 
	public ModelAndView moredests(@PathVariable("scope")String scope,HttpServletRequest request,HttpServletResponse response) throws Exception{
	 	Map<String,Object> context = getRootMap();
	 	context.put("scope",scope);
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //Browser browser = userAgent.getBrowser();  
        OperatingSystem os = userAgent.getOperatingSystem();
        if(os.isMobileDevice()){
        	logger.debug("###########DestinationController moredests当前是移动浏览器#####");
        	return forward("mfront/destination/moredests",context);
        }
		return forward("front/destination/moredests",context);   
	}
	/**
	 * 
	 * @param alias
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/moredestPage", method = RequestMethod.POST) 
	public String moredestPage(String pageNo,String scope,HttpServletRequest request,HttpServletResponse response) throws Exception{
	 	Map<String,Object> context = getRootMap();
	 	Areas areas = areasService.queryByPinyin(scope);
	 	TravelItemVO vo = new TravelItemVO();
	 	vo.setScope(areas !=null?areas.getId():"");
	 	//TravelItemVO ttvo = travelItemService.getByAlias(alias);
		vo.setPage(Long.parseLong(pageNo));
		vo.setRows(Constants.moredestsPerPage);
		vo.setLimit(Constants.moredestsPerPage);
		BasePage<TravelItemVO> page = travelItemService.pageQueryByScope(vo);
		page.setPage(Long.parseLong(pageNo));
		Pager pager = page.getPager();
		pager.setPageId(Long.parseLong(pageNo));
		pager.setPageSize(Constants.moredestsPerPage);
		pager.setRowCount(page.getTotal());
		page.setPager(pager);
		context.put("result", page);
		context.put("dests",areas!=null?areas.getAreaname():""); 	
		//context.put("context", map);
		//vo.setPage(Long.parseLong(pageNo));
		//vo.setRows(Constants.happyperPage);
		//vo.setLimit(Constants.happyperPage);
		return JsonUtils.encode(context);
	}
	/**
	 * 
	 * @param pageNo
	 * @param alias
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/related/{alias}", method = RequestMethod.GET) 
	public ModelAndView searchRts(@PathVariable("alias")String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		context.put("pageNo", 1);
		context.put("alias", alias);
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //Browser browser = userAgent.getBrowser();  
        OperatingSystem os = userAgent.getOperatingSystem();
        if(os.isMobileDevice()){
        	logger.debug("###########DestinationController searchRt当前是移动浏览器#####");
        	return forward("mfront/destination/searchRt",context);
        }
		return forward("front/destination/searchRt",context); 
	}
	/**
	 * 
	 * @param alias
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/related/searchRtResults", method = RequestMethod.POST) 
	public String searchRtResults(String pageNo,String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
	 	Map<String,Object> context = getRootMap();
	 	TravelItemVO ttvo = travelItemService.getByAlias(alias);
	 	RouteTemplateVO vo = new RouteTemplateVO();
		vo.setPage(Long.parseLong(pageNo));
		vo.setRows(Constants.destsPerPage);
		vo.setLimit(Constants.destsPerPage);
		vo.setTravelItems(ttvo.getId());
		BasePage<RouteTemplateVO> page = routeTemplateService.pageQueryByItems(vo);
		page.setPage(Long.parseLong(pageNo));
		Pager pager = page.getPager();
		pager.setPageId(Long.parseLong(pageNo));
		pager.setPageSize(Constants.destsPerPage);
		pager.setRowCount(page.getTotal());
		page.setPager(pager);
		context.put("result", page);
		//context.put("context", map);
		//vo.setPage(Long.parseLong(pageNo));
		//vo.setRows(Constants.happyperPage);
		//vo.setLimit(Constants.happyperPage);
		return JsonUtils.encode(context);
	}

}