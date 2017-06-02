package com.itour.controller.front;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.itour.base.annotation.Auth;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.page.Pager;
import com.itour.base.util.FilePros;
import com.itour.base.web.BaseController;
import com.itour.entity.QuoteForm;
import com.itour.entity.TravelItem;
import com.itour.entity.TravelStyle;
import com.itour.service.QuoteFormService;
import com.itour.service.RouteTemplateService;
import com.itour.service.TravelItemService;
import com.itour.service.TravelStyleService;
import com.itour.util.Constants;
import com.itour.vo.CalculateQuoteVO;
import com.itour.vo.CustomerVO;
import com.itour.vo.QuoteFormVO;
import com.itour.vo.RouteTemplateVO;
import com.itour.vo.TravelItemVO;

@Controller
@RequestMapping("/light") 
public class LightController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	// Servrice start
	@Autowired 
	private TravelItemService<TravelItem> travelItemService; 
	@Autowired 
	private RouteTemplateService routeTemplateService;
	@Autowired 
	private TravelStyleService travelStyleService;
	@Autowired
	private QuoteFormService quoteFormService;
	
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/main", method = RequestMethod.GET) 
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		return forward("front/light/main",context); 
	}
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@SuppressWarnings({"unchecked" })
	@RequestMapping(value="/lightpagination", method = RequestMethod.POST) 
	public String lightpagination(String pageNo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		//page.setDeleted(DELETED.NO.key);
		if(StringUtils.isNotEmpty(Constants.travelStyles.get(Constants.LIGHT))){			
			RouteTemplateVO vo = new RouteTemplateVO();
			vo.setTravelStyle(Constants.LIGHT);
			vo.setPage(Long.parseLong(pageNo));
			vo.setRows(Constants.rtPerPage);
			vo.setLimit(Constants.rtPerPage);
			BasePage<RouteTemplateVO> page = routeTemplateService.pageQueryByStyle(vo);
			page.setPage(Long.parseLong(pageNo));
			Pager pager = page.getPager();
			pager.setPageId(Long.parseLong(pageNo));
			pager.setPageSize(Constants.rtPerPage);
			pager.setRowCount(page.getTotal());
			page.setPager(pager);
			context.put("result", page);
		}
		return JsonUtils.encode(context);
	}
	/**
	 * 
	 * @param alias
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/light/{alias}", method = RequestMethod.GET) 
	public ModelAndView hiking(@PathVariable("alias")String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
		RouteTemplateVO rt = routeTemplateService.queryByAlias(alias);
		TravelStyle style = (TravelStyle)travelStyleService.queryById(rt.getTravelStyle());
		rt.setTravelStyle(style.getType());
		String mappath = FilePros.httprouteMapPath();
		String coverpath = FilePros.httpRouteCoverpath();
		if(rt != null && StringUtils.isNotEmpty(rt.getRouteMap())){
			rt.setRouteMap(StringUtils.trim(mappath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getRouteMap()));
		}
		if(rt != null && StringUtils.isNotEmpty(rt.getCover())){
			rt.setCover(StringUtils.trim(coverpath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getCover()));
		}
		if(rt != null && StringUtils.isNotEmpty(rt.getRelated())){
			String [] ids =  rt.getRelated().split(",");
			List<RouteTemplateVO> relates = routeTemplateService.queryByRelated(Arrays.asList(ids));
			for(RouteTemplateVO rtp:relates){
				TravelStyle ts = (TravelStyle)travelStyleService.queryById(rtp.getTravelStyle());
				if(ts != null){
					rtp.setTravelStyleAlias(ts.getAlias());
				}
			}
			 rt.setRelates(relates);
		}
		QuoteFormVO qf = quoteFormService.queryByRtId(rt.getId());
	/*	String beriefTrip = qf.getBeriefTrip().replaceAll("\"", "'");//ExecuteScript.exeScript("beriefTrip",qf.getBeriefTrip().replaceAll("\"", "'"),request);
		rt.setBeriefTrip(beriefTrip);
		String ftlName = "";
		Boolean flag =(Boolean)FreeMarkerUtil.htmlFileHasExist(request, Constants.FREEMARKER_PATH, ftlName).get("exist");
        if(!flag){//如何静态文件不存在，重新生成
            Map<String,Object> map = getRootMap();
            map.put("beriefTrip", beriefTrip);//这里包含业务逻辑请求等
          //  mv.addAllAttributes(map);
            FreeMarkerUtil.createHtml(freeMarkerConfig, "beriefTrip.ftl", request, map, Constants.FREEMARKER_PATH, ftlName);//根据模板生成静态页面
        }*/
		String itemIds = StringUtils.isNotEmpty(rt.getTravelItems())?rt.getTravelItems():"";
		List<String> itids = Arrays.asList(itemIds.split(","));
		List<TravelItemVO> items = travelItemService.queryByIds(itids);
		//String ptopath = FilePros.itemCoverpath();
		List<String> photoList = Lists.newArrayList();
		String rtPhotoPath = FilePros.httpRoutePhotos();
		String [] photos = StringUtils.isNotEmpty(rt.getViewphotos())?rt.getViewphotos().split("\\|"):new String[]{};
		for(String photo:photos){
			photoList.add(StringUtils.trim(rtPhotoPath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+photo));
		}
		StringBuffer routeLine = new StringBuffer(rt.getDeparture());
		for(TravelItemVO ti:items){
		/*	String cover = ti.getCover();
			if(StringUtils.isNotEmpty(cover)){
				String realCover = ptopath+"/" +ti.getItemCode()+"_"+ti.getAlias()+"/"+ ti.getCover();//Constants.basePhoto
				ti.setCover(realCover);
			}
			String photos = ti.getPhotos();
			if(StringUtils.isNotEmpty(photos)){
				List<String> array = Arrays.asList(photos.split("\\|"));
				for(String name:array){
					String realname = ptopath+"/" +ti.getItemCode()+"_"+ti.getAlias()+"/"+ name;//Constants.basePhoto
					photoList.add(realname);
				}
			}*/
			routeLine.append("-"+ti.getItem());
		}
		routeLine.append("-"+rt.getArrive());
		rt.setRouteLine(routeLine.toString());
		rt.setPhotoList(photoList);
		float adultquote = Float.parseFloat(qf.getShowTicket().split("\\|")[0])+Float.parseFloat(qf.getShowTourguide().split("\\|")[0])+
				Float.parseFloat(qf.getShowHotel().split("\\|")[0])+Float.parseFloat(qf.getShowRentcar().split("\\|")[0])+Float.parseFloat(qf.getShowDinner().split("\\|")[0])+
				Float.parseFloat(qf.getShowInsurance().split("\\|")[0])+Float.parseFloat(qf.getShowComphcost().split("\\|")[0])+Float.parseFloat(qf.getShowRecreation().split("\\|")[0]);
		float childquote = Float.parseFloat(qf.getShowTicket().split("\\|")[0])+Float.parseFloat(qf.getShowTourguide().split("\\|")[0])+
				Float.parseFloat(qf.getShowHotel().split("\\|")[0])+Float.parseFloat(qf.getShowRentcar().split("\\|")[0])+Float.parseFloat(qf.getShowDinner().split("\\|")[0])+
				Float.parseFloat(qf.getShowInsurance().split("\\|")[0])+Float.parseFloat(qf.getShowComphcost().split("\\|")[0])+Float.parseFloat(qf.getShowRecreation().split("\\|")[0]);
		qf.setAdultsQuote(adultquote);
		qf.setChildquote(childquote);
		Map<String,Object> map = getRootMap();
		map.put("items", items);
		map.put("rt", rt);
		map.put("qf", qf);
		map.put("alias", alias);
		return forward("front/light/detail",map); 
	}
	/**
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return${alias:.*}  {key:[a-zA-Z0-9\\.]+} 
	 * @RequestParam("alias") String alias,
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/detail/{alias}", method = RequestMethod.GET) 
	public ModelAndView detail(@PathVariable("alias") String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
		RouteTemplateVO rt = routeTemplateService.queryByAlias(alias);
		String mappath = FilePros.httprouteMapPath();
		String coverpath = FilePros.httpRouteCoverpath();
		if(rt != null && StringUtils.isNotEmpty(rt.getRouteMap())){
			rt.setRouteMap(mappath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getRouteMap());
		}
		if(rt != null && StringUtils.isNotEmpty(rt.getCover())){
			rt.setCover(coverpath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getCover());
		}
		if(rt != null && StringUtils.isNotEmpty(rt.getRelated())){
			String [] ids =  rt.getRelated().split(",");
			List<RouteTemplateVO> relates = routeTemplateService.queryByRelated(Arrays.asList(ids));
			for(RouteTemplateVO rtp:relates){
				TravelStyle ts = (TravelStyle)travelStyleService.queryById(rtp.getTravelStyle());
				if(ts != null){
					rtp.setTravelStyleAlias(ts.getAlias());
				}
			}
			 rt.setRelates(relates);
		}
		String itemIds = StringUtils.isNotEmpty(rt.getTravelItems())?rt.getTravelItems():"";
		List<String> itids = Arrays.asList(itemIds.split(","));
		List<TravelItemVO> items = travelItemService.queryByIds(itids);
		String ptopath = FilePros.itemCoverpath();
		for(TravelItemVO ti:items){
			String photo = ti.getCover();
			if(StringUtils.isNotEmpty(photo)){
				String cover = ptopath+"/" +ti.getItemCode()+"_"+ti.getAlias()+"/"+ ti.getCover();//Constants.basePhoto
				ti.setCover(cover);
			}
		}
		Map<String,Object> map =getRootMap();
		map.put("items", items);
		map.put("rt", rt);
		return forward("front/light/detail",map); 
	}
	/**
	 * 
	 * @param alias
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selfbooking/{alias}",method = RequestMethod.GET) 
	@ResponseBody
	public ModelAndView selfbooking(@PathVariable("alias") String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> map = getRootMap();
		RouteTemplateVO rt = routeTemplateService.queryByAlias(alias);
		String mappath = FilePros.httprouteMapPath();
		String coverpath = FilePros.httpRouteCoverpath();
		if(rt != null && StringUtils.isNotEmpty(rt.getRouteMap())){
			rt.setRouteMap(mappath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getRouteMap());
		}
		if(rt != null && StringUtils.isNotEmpty(rt.getCover())){
			rt.setCover(coverpath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getCover());
		}
		if(rt != null && StringUtils.isNotEmpty(rt.getRelated())){
			String [] ids =  rt.getRelated().split(",");
			List<RouteTemplateVO> relates = routeTemplateService.queryByRelated(Arrays.asList(ids));
			for(RouteTemplateVO rtp:relates){
				TravelStyle ts = (TravelStyle)travelStyleService.queryById(rtp.getTravelStyle());
				if(ts != null){
					rtp.setTravelStyleAlias(ts.getAlias());
				}
			}
			 rt.setRelates(relates);
		}
		String itemIds = StringUtils.isNotEmpty(rt.getTravelItems())?rt.getTravelItems():"";
		List<String> itids = Arrays.asList(itemIds.split(","));
		List<TravelItemVO> items = travelItemService.queryByIds(itids);
		String ptopath = FilePros.itemCoverpath();
		for(TravelItemVO ti:items){
			String photo = ti.getCover();
			if(StringUtils.isNotEmpty(photo)){
				String cover = ptopath+"/" +ti.getItemCode()+"_"+ti.getAlias()+"/"+ ti.getCover();//Constants.basePhoto
				ti.setCover(cover);
			}
		}
		map.put("items", items);
		map.put("rt", rt);
		return forward("front/light/selfbooking",map); 
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toQuote1",method = RequestMethod.GET) 
	@ResponseBody
	public ModelAndView toQuote1(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		//context.put("items", items);
		//context.put("rt", rt);
		return forward("front/light/quote_step1",context); 
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toQuote2/{alias}",method = RequestMethod.GET) 
	@ResponseBody
	public ModelAndView toQuote2(@PathVariable("alias") String alias,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		RouteTemplateVO bean = routeTemplateService.queryByAlias(alias);
		//RouteTemplateVO bean  = routeTemplateService.selectById(id);
		if(bean == null){
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
			return forward(request.getHeader("Referer"),context);
		}
		QuoteFormVO qf = quoteFormService.queryByRtId(bean.getId());
		context.put(SUCCESS, true);
		context.put("bean", bean);
		context.put("qf", qf);
		return forward("front/light/quote_step2",context); 
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/calculateSum", method = RequestMethod.POST)
	public String calculateSum(@RequestBody CalculateQuoteVO vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Float adultsumcost =0f;
		Float childrensumcost =0f;
		if(vo !=null && StringUtils.isNotEmpty(vo.getId())){//&& adults !=null && children !=null
			int adults = vo.getAdults();
			int children = vo.getChildren();
			QuoteForm qf = quoteFormService.queryById(vo.getId());
			if(qf.getAsAdult()==1){
				adultsumcost+=qf.getAdults()*adults;
				childrensumcost+=qf.getAdults()*children;
			}else{
				adultsumcost+=qf.getAdults()*adults;
				childrensumcost+=qf.getChildren()*children;
			}
			adultsumcost+=Float.parseFloat(qf.getShowTicket().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowTraveldoc().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowTourguide().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowHotel().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowRentcar().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowBigtraffic().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowDinner().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowInsurance().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowComphcost().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowRecreation().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowItemguide().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowBathorse().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowRidehorse().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowClimbregister().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowClimbnexus().split("\\|")[0])*adults;
			adultsumcost+=Float.parseFloat(qf.getShowElsecost().split("\\|")[0])*adults;
			
			childrensumcost+=Float.parseFloat(qf.getShowTicket().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowTraveldoc().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowTourguide().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowHotel().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowRentcar().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowBigtraffic().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowDinner().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowInsurance().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowComphcost().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowRecreation().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowItemguide().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowBathorse().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowRidehorse().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowClimbregister().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowClimbnexus().split("\\|")[0])*children;
			childrensumcost+=Float.parseFloat(qf.getShowElsecost().split("\\|")[0])*children;
		}
		Map<String,String> map = getHashMap();
		map.put("adultsumcost", adultsumcost+"");
		map.put("childrensumcost", childrensumcost+"");
		return JsonUtils.encode(map);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toQuote3",method = RequestMethod.GET) 
	@ResponseBody
	public ModelAndView toQuote3(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		//context.put("items", items);
		//context.put("rt", rt);
		return forward("front/light/quote_step3",context); 
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toQuote4",method = RequestMethod.GET) 
	@ResponseBody
	public ModelAndView toQuote4(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		//context.put("items", items);
		//context.put("rt", rt);
		return forward("front/light/quote_step4",context); 
	}
	
}
