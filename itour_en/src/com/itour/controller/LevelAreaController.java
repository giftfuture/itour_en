package com.itour.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.LevelAreaKit;
import com.itour.entity.Areas;
import com.itour.entity.LevelArea;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.RouteTemplate;
import com.itour.entity.SysUser;
import com.itour.entity.TravelItem;
import com.itour.service.LevelAreaService;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.RouteTemplateService;
import com.itour.service.TravelItemService;
import com.itour.util.Constants;
import com.itour.vo.LevelAreaVo;
import com.itour.vo.TravelItemVo;
@Controller
@RequestMapping("/levelarea") 
public class LevelAreaController extends BaseController {
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired(required=false)
    private CacheService cacheService;
	@Autowired
	private LevelAreaService levelAreaService ;
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;
	@Autowired  
	private RouteTemplateService<RouteTemplate> routeTemplateService; 
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	@Autowired
	private LogOperationService logOperationService;
	@Autowired 
	private TravelItemService<TravelItem> travelItemService; 
	
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/allAreas", method = RequestMethod.GET)
	public List<LevelArea> allAreas(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//Map<String,Object> root = getRootMap();allLevelAreas
		List<LevelArea> allAreas = Lists.newArrayList();
		allAreas.add(new LevelArea("","--请选择--"));
		List<LevelArea> areas = Constants.allLevelAreas;
		if(areas.size() ==0){
			Constants.allLevelAreas.addAll(levelAreaService.allAreas());
			areas = Constants.allLevelAreas;
		}
		//root.put("allAreas", allAreas);
		//String result = JsonUtils.encode(root);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行LevelAreaController的allAreas方法");
		return allAreas;
	}

	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/list") 
	public ModelAndView  list(LevelAreaVo page,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的list方法");
		return forward("server/sys/levelArea"); 
	}
	
	
	/**
	 * @param url
	 * @param classifyId
	 * @return 
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/dataList.json", method = RequestMethod.POST) 
	public EasyUIGrid datalist(LevelAreaVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<OrderDetail> dataList = orderDetailService.queryByList(page);
		BasePage<Map<String, String>> page = levelAreaService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的dataList方法");
		return dataGridAdapter.wrap(page);
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(LevelAreaVo entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String odId="";
		SysUser sessionuser = SessionUtils.getUser(request);
		LevelArea od = null;
		if(StringUtils.isNotEmpty(entity.getNewlevel1Area())){
			entity.setLevel1Area(entity.getNewlevel1Area());
		}
		if(StringUtils.isNotEmpty(entity.getRouteTemplate())){
			RouteTemplate ti = routeTemplateService.selectByRouteCode(entity.getRouteTemplate());
			entity.setRouteTemplate(ti==null?"":ti.getId());
		}
		if(StringUtils.isNotEmpty(entity.getNewlevel2Area())){
			entity.setLevel2Area(entity.getNewlevel2Area());
		}		
		if(StringUtils.isNotEmpty(entity.getItem())){
			TravelItemVo ti = travelItemService.getByAlias(entity.getItem());
			entity.setTravelItem(ti==null?"":ti.getId());
		}
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId())){
			entity.setAliasCode(IDGenerator.code(19));
			entity.setCreateBy(sessionuser.getId());
			entity.setUpdateBy(sessionuser.getId());
			odId = levelAreaService.add(LevelAreaKit.toEntity(entity));
		}else{
				od = levelAreaService.queryById(entity.getId());
			if(od == null){
				entity.setAliasCode(IDGenerator.code(19));
				entity.setCreateBy(sessionuser.getId());
				entity.setUpdateBy(sessionuser.getId());
				odId = levelAreaService.add(LevelAreaKit.toEntity(entity));
			}else{
				entity.setUpdateBy(sessionuser.getId());
				levelAreaService.update(LevelAreaKit.toEntity(entity));
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的save方法");
		if(StringUtils.isNotEmpty(odId)){
			String logId = logSettingService.add(new LogSetting("level_area","路线区域管理","levelarea/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logId,"新增",odId,JsonUtils.encode(entity),"","levelarea/save",sessionuser.getId()));
		}else{			
			String logId = logSettingService.add(new LogSetting("level_area","路线区域管理","levelarea/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logId,"更新",odId,JsonUtils.encode(od),JsonUtils.encode(entity),"levelarea/save(update)",sessionuser.getId()));
		}
		return sendSuccessResult(response, "保存成功~");
	}
	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/getId", method = RequestMethod.POST)
	public String getId(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		LevelAreaVo entity  = levelAreaService.selectById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的getId方法");
		String logId = logSettingService.add(new LogSetting("level_area","查看","levelarea/getId",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logId,"查看",id,JsonUtils.encode(entity),"","levelarea/getId",sessionuser.getId()));
		return JsonUtils.encode(context);
	}
	
	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		levelAreaService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的delete方法");
		String logId = logSettingService.add(new LogSetting("level_area","订单明细","levelarea/delete",sessionuser.getId(),"delete from level-area where id in("+JsonUtils.encode(id)+")",""));
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"levelarea/delete",sessionuser.getId()));
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/logicdelete", method = RequestMethod.POST)
	public String logicdelete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		levelAreaService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("level_area","订单明细","levelarea/logicdelete",sessionuser.getId(),"update level_area set valid=0 where id in("+JsonUtils.encode(id)+")",""));
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"levelarea/logicdelete",sessionuser.getId()));
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryLevel1", method = RequestMethod.GET)
	public String queryLevel1(HttpServletRequest request,HttpServletResponse response){
		List<LevelArea> allAreas = Constants.level1Areas;
		if(allAreas.size()<=1){
			List<LevelArea> areas = Lists.newArrayList();
			areas.add(new LevelArea("","请选择"));
			areas.addAll(levelAreaService.queryLevel1());
			Constants.level1Areas.clear();
			Constants.level1Areas.addAll(areas);
			allAreas = areas;
		}
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行LevelAreaController的queryLevel1方法");
		return JsonUtils.encode(allAreas);
	}
	
	/**
	 * 
	 * @param level1Area
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryLevel2ByLevel1", method = RequestMethod.GET)
	public String queryLevel2ByLevel1(String level1Area,HttpServletRequest request,HttpServletResponse response){
		List<LevelArea> allAreas = Lists.newArrayList();
		try {
				if(StringUtils.isNotEmpty(level1Area)){
					level1Area = new String(level1Area.getBytes("ISO8859-1"), "UTF-8");
					allAreas.addAll(levelAreaService.queryLevel2ByLevel1(level1Area));
					SysUser user = SessionUtils.getUser(request);
					logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行LevelAreaController的queryLevel2ByLevel1方法");
				}
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JsonUtils.encode(allAreas);
	};
}
