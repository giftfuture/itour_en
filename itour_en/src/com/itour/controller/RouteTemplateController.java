package com.itour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.convert.ImageFilter;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.ClassReflectUtil;							
import com.itour.base.util.FilePros;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.RouteTemplateKit;
import com.itour.convert.ShowHappyKit;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.QuoteForm;
import com.itour.entity.RouteTemplate;
import com.itour.entity.SysUser;
import com.itour.entity.TravelItem;
import com.itour.entity.TravelStyle;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.QuoteFormService;
import com.itour.service.RouteTemplateService;
import com.itour.service.TravelItemService;
import com.itour.service.TravelStyleService;
import com.itour.vo.QuoteFormVo;
import com.itour.vo.RouteTemplateVo;
import com.itour.vo.ShowHappyVo;
import com.itour.vo.TravelItemVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/routeTemplate") 
public class RouteTemplateController extends BaseController{
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	// Servrice start
	@Autowired  
	private RouteTemplateService<RouteTemplate> routeTemplateService; 
    @Autowired(required=false)
    private CacheService cacheService;
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private QuoteFormService quoteFormService;
	@Autowired
	private LogSettingService logSettingService;
	@Autowired
	private TravelItemService travelItemService;
	@Autowired
	private TravelStyleService travelStyleService; 
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	
	@Autowired
	private LogOperationService logOperationService;
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/list") 
	public ModelAndView list(RouteTemplateVo page,HttpServletRequest request) throws Exception{
	/*	Map<String,Object>  context = getRootMap();
		List<RouteTemplate> dataList = routeTemplateService.queryByList(page);
		//设置页面数据
		context.put("dataList", dataList);*/
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的list方法");
		return forward("server/sys/routeTemplate"); 
	}
	/**
	 * 
	 * @param page
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/rtschedule") 
	public ModelAndView rtschedule(String id,HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		RouteTemplateVo bean  = routeTemplateService.selectById(id);
		if(bean == null){
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
			return forward(request.getHeader("Referer"),context);
		}
		QuoteFormVo qf = quoteFormService.queryByRtId(id);
		//String quotoForm = entity.getQuotoForm();
		context.put(SUCCESS, true);
		//context.put("quotoForm", quotoForm);
		context.put("bean", bean);
		context.put("qf", qf);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的quoteEdit方法");
		String logId = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/quoteEdit",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",bean.getId(),JsonUtils.encode(bean),"","routeTemplate/quoteEdit",sessionuser.getId()));
		return forward("server/sys/rtschedule",context); 
	}
	/**
	 * 
	 * @param entity
	 * @param typeIds
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/savertschedule", method = RequestMethod.POST)
	public String savertschedule(@RequestBody RouteTemplateVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//Map<String,Object> context = getRootMap();
		String vcode = SessionUtils.getHappyValidateCode(request);
		SessionUtils.removeHappyValidateCode(request); //清除验证码，确保验证码只能用一次
	 	if(StringUtils.isEmpty(vo.getVerifyCode())){
	 		//failureMessage(response, "验证码不能为空.");
			return sendFailureResult(response, "验证码不能为空~");
		}
	 	if(!vo.getVerifyCode().toLowerCase().equals(vcode)){//判断验证码是否正确   
	 		//failureMessage(response, "验证码输入错误.");
			return sendFailureResult(response, "验证码输入错误~");
		} 						 			
		String rtschedulePath = FilePros.rtschedulePath();
		//String fileName = vo.getSurface().getName();
		//vo.setCover(fileName);
		String subpath = vo.getId();
		String quotoForm = ImageFilter.writeBase64Image(vo.getQuotoForm(),rtschedulePath,subpath);
		vo.setQuotoForm(quotoForm);
		vo.setValid(true);
		routeTemplateService.updateQuotoForm(RouteTemplateKit.toEntity(vo));
		//vo.addShowHappy(ShowHappyKit.toEntity(vo));
		//String result = JsonUtils.encode(context);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的savertschedule方法");
		String logid = logSettingService.add(new LogSetting("route_template","路线模板更新quotoForm","routeTemplate/savertschedule",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logid,"路线模板更新quotoForm",vo.getId(),JsonUtils.encode(vo),"","routeTemplate/savertschedule",sessionuser.getId()));
		return sendSuccessResult(response, "详细日程更新成功~",quotoForm);
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
	public EasyUIGrid datalist(RouteTemplateVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<RouteTemplate> dataList = routeTemplateService.queryByList(page);
		BasePage<RouteTemplateVo> page = routeTemplateService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的datalist方法");
		return dataGridAdapter.wrap(page);
	}
	/**
	 * 
	 * @param id
	 * @param fileselect
	 * @param request
	 * @param responset 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/uploadPhotos",method = RequestMethod.POST)//,method = RequestMethod.POST  , produces = "application/json"
	public @ResponseBody String uploadPhotos(String id,@RequestParam(value="fileselect",required=false) MultipartFile fileselect,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object>  context = getRootMap();
		RouteTemplate rt =new RouteTemplate();
		try {
			RouteTemplate t = routeTemplateService.queryById(id);
			if(request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			String routePhotos = FilePros.routePhotos();
			StringBuffer photos = new StringBuffer();
			if (t != null){
				photos.append(t.getViewphotos() == null ? "":t.getViewphotos());
			}
			// MultipartFile imgFile = null;
			 OutputStream out = null;
			// Iterator<String> it = multipartRequest.getFileNames();
			List<MultipartFile> multifiles = multipartRequest.getFiles("fileselect");
			 String picName = "";
			 File directory = null;
			 File uploadpic = null;
			 String parpath = "";
			for(MultipartFile f:multifiles){
		    	picName = StringUtils.isNotEmpty(f.getOriginalFilename())?f.getOriginalFilename() : Calendar.getInstance(Locale.CHINA).getTimeInMillis()+".jpg";   
	            parpath = routePhotos+"\\"+StringUtils.trim(t.getRouteCode())+"_"+StringUtils.trim(t.getAlias());
	            directory = new File(parpath);
	            if(!directory.exists()||!directory.isDirectory()){
	            	directory.mkdirs();
	            }
	            uploadpic = new File(parpath+"\\"+picName);
	            photos.append(StringUtils.isNotEmpty(photos.toString())?"|"+picName :picName);
	            System.out.println("路线ID="+(t!= null?t.getId():"")+"上传图片文件名是：" + picName);  
	            out = new FileOutputStream(uploadpic);  
	            out.write(f.getBytes());  
	            out.close();  
			}
			picName = null;
			directory = null;
			uploadpic = null;
			parpath = null;
			rt.setId(id);
			rt.setViewphotos(photos.toString());
			routeTemplateService.update(rt);
			if(out != null){
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			context.put(SUCCESS, true);
			context.put("msg", "路线图片上传成功！");
			}else{
				System.out.println("##########不是上传图片文件对象#############");
				context.put(SUCCESS, false);
				context.put("msg", "上传路线图片文件类型非法!");
			}
		} catch (IOException e) {
			context.put(SUCCESS, false);
			context.put("msg", "上传路线图片出现IO异常!");
			e.printStackTrace();
		}catch(Exception e){
			context.put(SUCCESS, false);
			context.put("msg", "上传路线图片出错!");
			e.printStackTrace();
		}
		String result = JsonUtils.encode(context);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的uploadPhotos方法");
		try {
			String logid = logSettingService.add(new LogSetting("route_template","路线模板管理","routeTemplate/uploadPhotos",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"上传路线图片",rt!= null?rt.getId():"","",JsonUtils.encode(rt),"routeTemplate/uploadPhotos",sessionuser.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param id
	 * @param fileselect
	 * @param request
	 * @param responset 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/uploadCover",method = RequestMethod.POST)
	public @ResponseBody String uploadCover(@RequestParam(value="id")String id,@RequestParam(value="fileselect",required=false) MultipartFile fileselect,
		HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> context = getRootMap();
		String rtCoverPath = FilePros.routeCoverpath();
		try {
			SysUser sessionuser = SessionUtils.getUser(request);
			RouteTemplate rt = routeTemplateService.queryById(id);
			RouteTemplateVo vo = RouteTemplateKit.toRecord(rt);
			if(vo !=null){
				//String fileName = vo.getCoverImg() != null ? vo.getCoverImg().getName():"";
				//vo.setCover(fileName);
				String path = rtCoverPath+"\\"+vo.getRouteCode()+"_"+vo.getAlias();
				//ImageFilter.writeBase64Image(vo.getCoverImg(),path);
				if(request instanceof MultipartHttpServletRequest){
						MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
						OutputStream out = null;
						List<MultipartFile> multifiles = multipartRequest.getFiles("fileselect");
						 String picName = "";
						// String newpicName = "";
						 File directory = null;
						 File uploadpic = null;
						 MultipartFile f = multifiles.get(0);
					     if(f.getOriginalFilename().length() > 0) {    
					    	picName = f.getOriginalFilename();   
				            directory = new File(StringUtils.trim(path));
				            if(!directory.exists()||!directory.isDirectory()){
				            	directory.mkdirs();
				            }
				            //newpicName = Calendar.getInstance(Locale.CHINA).getTimeInMillis()+picName.substring(picName.indexOf("."));
				            uploadpic = new File(path+"\\"+picName );
				            System.out.println("路线ID="+id+"上传封面图片是" + picName);  
				            out = new FileOutputStream(uploadpic);  
				            out.write(f.getBytes());  
				            out.close();  
				        }  
						rt.setCover(picName);
						picName = null;
						directory = null;
						uploadpic = null;
						rt.setUpdateBy(sessionuser.getId());;
						routeTemplateService.uploadCover(rt);
						if(out != null){
							try {
								out.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						context.put(SUCCESS, true);
						context.put("msg", "封面图片上传成功！");
				}else{
					System.out.println("##########不是上传文件对象#############");
					context.put(SUCCESS, false);
					context.put("msg", "上传封面文件类型非法!");
				}
			}
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的uploadPhoto方法");
			try {
				String logid = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/uploadPhoto",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"上传封面",rt!= null?rt.getId():"","",JsonUtils.encode(rt),"routeTemplate/uploadPhoto",sessionuser.getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			context.put(SUCCESS, false);
			context.put("msg", "上传封面文件出现IO异常!");
			e.printStackTrace();
		}catch(Exception e){
			context.put(SUCCESS, false);
			context.put("msg", "上传封面文件出错!");
			e.printStackTrace();
		}
		String result = JsonUtils.encode(context);
		return result;
	}
	/**
	 * 
	 * @param id
	 * @param fileselect
	 * @param request
	 * @param responset 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/uploadMap",method = RequestMethod.POST)
	public @ResponseBody String uploadMap(@RequestParam(value="id")String id,@RequestParam(value="mapfile") MultipartFile mapfile,
		HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> context = getRootMap();
		String routeMapPath = FilePros.routeMapPath();
		try {
			SysUser sessionuser = SessionUtils.getUser(request);
			RouteTemplate rt = routeTemplateService.queryById(id);
			RouteTemplateVo vo = RouteTemplateKit.toRecord(rt);
			if(vo !=null){
				//String fileName = vo.getCoverImg() != null ? vo.getCoverImg().getName():"";
				//vo.setCover(fileName);
				String path = routeMapPath+File.separatorChar+vo.getRouteCode()+"_"+vo.getAlias();
				//ImageFilter.writeBase64Image(vo.getCoverImg(),path);
				if(request instanceof MultipartHttpServletRequest){
						MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
						OutputStream out = null;
						List<MultipartFile> multifiles = multipartRequest.getFiles("mapfile");
						 String picName = "";
						// String newpicName = "";
						 File directory = null;
						 File uploadpic = null;
						 MultipartFile mf = multifiles.get(0);
					     if(mf.getOriginalFilename().length() > 0) {    
					    	picName = mf.getOriginalFilename();   
				            directory = new File(StringUtils.trim(path));
				            if(!directory.exists()||!directory.isDirectory()){
				            	directory.mkdirs();
				            }
				            //newpicName = Calendar.getInstance(Locale.CHINA).getTimeInMillis()+picName.substring(picName.indexOf("."));
				            uploadpic = new File(path+File.separatorChar+picName );
				            System.out.println("路线ID="+id+"上传地图图片是" + picName);  
				            out = new FileOutputStream(uploadpic);  
				            out.write(mf.getBytes());  
				            out.close();  
				        }  
						rt.setRouteMap(picName);
						rt.setUpdateBy(sessionuser.getId());;
						routeTemplateService.uploadMap(rt);
					/*	File[] files = directory.listFiles();
						if(files !=null && files.length>0){
							for(File f:files){
								if(!f.getName().equals(picName)){
									f.delete();
								}
							}
						}*/
						picName = null;
						directory = null;
						uploadpic = null;
						if(out != null){
							try {
								out.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						context.put(SUCCESS, true);
						context.put("msg", "地图图片上传成功！");
				}else{
					System.out.println("##########不是上传文件对象#############");
					context.put(SUCCESS, false);
					context.put("msg", "上传地图文件类型非法!");
				}
			}
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的uploadMap方法");
			try {
				String logid = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/uploadMap",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"上传路线地图",rt!= null?rt.getId():"","",JsonUtils.encode(rt),"routeTemplate/uploadMap",sessionuser.getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			context.put(SUCCESS, false);
			context.put("msg", "上传地图文件出现IO异常!");
			e.printStackTrace();
		}catch(Exception e){
			context.put(SUCCESS, false);
			context.put("msg", "上传地图文件出错!");
			e.printStackTrace();
		}
		String result = JsonUtils.encode(context);
		return result;
	}
	/**
	 * 添加或修改数据
	 * @param url
	 * @param 56423498738365
	 * @return  @RequestBody
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/save", method = RequestMethod.POST//,
//	headers={"content-type=application/json;"},//multipart/form-data
	//produces=MediaType.APPLICATION_JSON_VALUE//.MULTIPART_FORM_DATA_VALUE
	)
	public @ResponseBody String save(RouteTemplate vo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		//Map<String,Object>  context = new HashMap<String,Object>();
		try {
			RouteTemplate rt = null;
			String rtId = "";
			//RouteTemplate bean =null;
			//String uuid = IDGenerator.getUUID();
			//ClassReflectUtil.setIdKeyValue(vo,"id",uuid);
			//vo.setRouteCode(IDGenerator.code(19));
			//bean = RouteTemplateKit.toEntity(vo);
			SysUser sessionuser = SessionUtils.getUser(request);
			if(StringUtils.isNotEmpty(vo.getTravelItems())){
				List<String> tis = Lists.newArrayList();
				List<String> alias = Arrays.asList(vo.getTravelItems().split(","));
				for(String a:alias){					
					TravelItemVo ti = travelItemService.getByAlias(a);
					tis.add(ti!=null?ti.getId():"");
				}
				vo.setTravelItems(Joiner.on(",").join(tis));
			}
			if(StringUtils.isNotEmpty(vo.getRelated())){
				List<String> relates = Lists.newArrayList();
				List<String> rels = Arrays.asList(vo.getRelated().split(","));
				for(String rel:rels){
					RouteTemplate t = routeTemplateService.selectByRouteCode(rel);
					relates.add(t!=null?t.getId():"");
				}
				vo.setRelated(Joiner.on(",").join(relates));
			}
			if(StringUtils.isNotEmpty(vo.getTravelStyle())){
				TravelStyle ts = travelStyleService.queryByAlias(vo.getTravelStyle());
				vo.setTravelStyle(ts!=null?ts.getId():"");
			}
			if(vo.getId()==null||StringUtils.isEmpty(vo.getId())){
				vo.setRouteCode(IDGenerator.code(16));
				vo.setCreateBy(sessionuser.getId());
				vo.setUpdateBy(sessionuser.getId());
				rtId = routeTemplateService.add(vo);
			}else{
				rt = routeTemplateService.queryById(vo.getId());
				if(rt == null){
					vo.setRouteCode(IDGenerator.code(16));
					vo.setCreateBy(sessionuser.getId());
					vo.setUpdateBy(sessionuser.getId());
					rtId = routeTemplateService.add(vo);
				}else{
					vo.setValid(true);
					vo.setUpdateBy(sessionuser.getId());
					routeTemplateService.update(vo);
				}
			} 
			
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的save方法");
			if(StringUtils.isNotEmpty(rtId)){			
				String logid = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/save",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"新增",rtId,JsonUtils.encode(vo),"","routeTemplate/save",sessionuser.getId()));
			}else{
				String logid = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/save(update)",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"更新",rt!= null?rt.getId():"",JsonUtils.encode(rt),JsonUtils.encode(vo),"routeTemplate/save(update)",sessionuser.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			sendSuccessMessage(response, "保存出错~");
		}
		return sendSuccessResult(response, "保存成功~");
	}
	
	/**
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
		RouteTemplateVo entity  = routeTemplateService.selectById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的getId方法");
		String logId = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","routeTemplate/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return JsonUtils.encode(context);
	}
	/**
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/quoteEdit",method = RequestMethod.GET)
	public ModelAndView quoteEdit(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		RouteTemplateVo bean  = routeTemplateService.selectById(id);
		if(bean == null){
			//return sendFailureMessage(response, "没有找到对应的记录!");
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
		//	return forward("server/sys/quoteEdit",context);
			return forward(request.getHeader("Referer"),context);
		}
		QuoteFormVo qf = quoteFormService.queryByRtId(id);
		//String quotoForm = entity.getQuotoForm();
		context.put(SUCCESS, true);
		//context.put("quotoForm", quotoForm);
		context.put("bean", bean);
		context.put("qf", qf);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的quoteEdit方法");
		String logId = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/quoteEdit",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",bean.getId(),JsonUtils.encode(bean),"","routeTemplate/quoteEdit",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return forward("server/sys/quoteEdit",context);
	}
	/**
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/updateQuoteForm", method = RequestMethod.POST)
	public void updateQuoteForm(@RequestBody QuoteForm quoteForm,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
		/*	List<TravelItem> list = travelItemService.queryByAlias(Arrays.asList(quoteForm.getTravelItems().split(",")));
			List<String> alias = Lists.newArrayList();
			for(TravelItem ti:list){
				alias.add(ti.getItem());
			}
			quoteForm.setShowTrip(quoteForm.getShowTrip().replace(quoteForm.getTravelItems(), StringUtils.join(alias.toArray(), ",")));*/
			QuoteFormVo qf = quoteFormService.queryByRtId(quoteForm.getRouteTemplate());
			String qfId = "";
			SysUser user = SessionUtils.getUser(request);
			if(user != null){
				quoteForm.setUpdateBy(user.getId());
			}
			if(qf == null){		
				quoteForm.setCreateBy(user.getId());
				qfId = quoteFormService.add(quoteForm);
			}else{
				quoteForm.setId(qf.getId());
				quoteForm.setValid(true);
				quoteFormService.update(quoteForm);				
			}
			SysUser sessionuser = SessionUtils.getUser(request);
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的updateQuoteForm方法");
			if(StringUtils.isNotEmpty(qfId)){			
				String logid = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/updateQuoteForm",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"新增",qfId,JsonUtils.encode(quoteForm),"","routeTemplate/updateQuoteForm",sessionuser.getId()));
				sendSuccessMessage(response, "详细价目表内容添加成功!");
			}else{
				String logid = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/updateQuoteForm(update)",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"更新",qf!= null?qf.getId():"",JsonUtils.encode(qf),JsonUtils.encode(quoteForm),"routeTemplate/updateQuoteForm(update)",sessionuser.getId()));
				sendSuccessMessage(response, "详细价目表内容更新成功!");
			}
		} catch (Exception e) {
			sendFailureMessage(response, "详细价目表内容更新出错!");
			e.printStackTrace();
		}
	}
	/**
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		routeTemplateService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的delete方法");
		String logId = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/delete",sessionuser.getId(),"delete from route_template where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"routeTemplate/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/logicdelete", method = RequestMethod.POST)
	public String logicdelete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		routeTemplateService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行RouteTemplateController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("route_template","路线模板","routeTemplate/logicdelete",sessionuser.getId(),"update route_template set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"routeTemplate/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/loadRoutes", method = RequestMethod.POST)
	public void loadRoutes(HttpServletResponse response) throws Exception{
		RouteTemplateVo vo = new RouteTemplateVo();
		List<RouteTemplate> list = routeTemplateService.queryByList(vo);
		HtmlUtil.writerJson(response, list);
	}
	/**
	 * 
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/allRelatedRts", method = RequestMethod.GET)
	public List<RouteTemplateVo> allRelatedRts(String rtId,HttpServletRequest request,HttpServletResponse response)throws Exception{
		RouteTemplate rt = routeTemplateService.queryById(rtId);
		List<String> related = Lists.newArrayList();
		if(rt !=null){
			related.addAll(Arrays.asList(rt.getRelated().split(",")));
		}
		List<RouteTemplateVo> list = routeTemplateService.queryByRelated(related);
		return list;
	}
	/**
	 * 
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/queryAll", method = RequestMethod.GET)
	public List<RouteTemplateVo> queryAll(HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<RouteTemplateVo> list = routeTemplateService.queryAll();
		return list;
	}
}
