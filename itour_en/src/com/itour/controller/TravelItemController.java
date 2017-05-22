package com.itour.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.DateUtil;
import com.itour.base.util.FilePros;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.util.StringUtil;
import com.itour.base.web.BaseController;
import com.itour.convert.RouteTemplateKit;
import com.itour.convert.TravelItemKit;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.RouteTemplate;
import com.itour.entity.SysUser;
import com.itour.entity.TravelItem;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.TravelItemService;
import com.itour.util.Constants;
import com.itour.vo.OrderDetailVo;
import com.itour.vo.RouteTemplateVo;
//import com.alibaba.fastjson.JSONObject;
import com.itour.vo.TravelItemVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>TravelItemController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/travelItem") 
public class TravelItemController extends BaseController{
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired(required=false)
    private CacheService cacheService;
	// Servrice start
	@Autowired  
	private TravelItemService<TravelItem> travelItemService; 
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
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/list") 
	public ModelAndView list(TravelItemVo page,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的list方法");
		return forward("server/sys/travelItem"); 
	}
	
	/**
	 * 更改封面
	 * @param cover
	 * @param page
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/uploadCover", method = RequestMethod.POST) 
	public String uploadCover(@RequestParam(value="id")String id,@RequestParam(value="fileselect",required=false) MultipartFile fileselect,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		//ti.setCover(cover);
	//	fb.setCover(coverpath+"/"+fb.getItemCode()+"_"+fb.getAlias()+"/"+fb.getCover());
		//travelItemService.update(ti);	
		//SysUser sessionuser = SessionUtils.getUser(request);
		//logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的updateCover方法");
		//String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/updateCover",sessionuser.getId(),"",""));
		//logOperationService.add(new LogOperation(logid,"更新封面",vo!= null?vo.getId():"",JsonUtils.encode(vo),JsonUtils.encode(ti),"travelItem/updateCover",sessionuser.getId()));
		//return forward("server/sys/travelItem"); 
		Map<String,Object> context = getRootMap();
		String coverpath = FilePros.itemCoverpath();
		try {
			SysUser sessionuser = SessionUtils.getUser(request);
			TravelItem ti =travelItemService.queryById(id);
			TravelItemVo vo = TravelItemKit.toRecord(ti);
			if(vo !=null){
				//String fileName = vo.getCoverImg() != null ? vo.getCoverImg().getName():"";
				//vo.setCover(fileName);
				String path = coverpath+"\\"+StringUtils.trim(vo.getItemCode())+"_"+vo.getAlias();
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
				            System.out.println("景点ID="+id+"上传封面图片是" + picName);  
				            out = new FileOutputStream(uploadpic);  
				            out.write(f.getBytes());  
				            out.close();  
				        }  
						ti.setCover(picName);
						picName = null;
						directory = null;
						uploadpic = null;
						ti.setUpdateBy(sessionuser.getId());;
						travelItemService.uploadCover(ti);
						if(out != null){
							try {
								out.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						context.put(SUCCESS, true);
						context.put("msg", "景点封面图片上传成功！");
				}else{
					System.out.println("##########不是上传文件对象#############");
					context.put(SUCCESS, false);
					context.put("msg", "景点上传封面文件类型非法!");
				}
			}
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的updateCover方法");
			try {
				String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/updateCover",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"上传封面",ti!= null?ti.getId():"","",JsonUtils.encode(ti),"travelItem/updateCover",sessionuser.getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			context.put(SUCCESS, false);
			context.put("msg", "景点上传封面文件出现IO异常!");
			e.printStackTrace();
		}catch(Exception e){
			context.put(SUCCESS, false);
			context.put("msg", "景点上传封面文件出错!");
			e.printStackTrace();
		}
		String result = JsonUtils.encode(context);
		return result;
	
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
	public EasyUIGrid datalist(TravelItemVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<TravelItem> dataList = travelItemService.queryByList(page);
		BasePage<TravelItemVo> page = travelItemService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的dataList方法");
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
	public String save(TravelItemVo entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = "";
		TravelItem ti = null;
		SysUser sessionuser = SessionUtils.getUser(request);
	    String busyseason = entity.getBusybeginMonth()+"月"+entity.getBusybeginDate()+"日~"+entity.getBusyendMonth()+"月"+entity.getBusyendDate()+"日";
	    String freeseason = entity.getFreebeginMonth()+"月"+entity.getFreebeginDate()+"日~"+entity.getFreeendMonth()+"月"+entity.getFreeendDate()+"日";
	    entity.setBusyseason(busyseason);
	    entity.setFreeseason(freeseason);
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId())){
	  		entity.setCreateBy(sessionuser.getId());
			entity.setUpdateBy(sessionuser.getId());
			id = travelItemService.add(TravelItemKit.toBean(entity));
		}else{
				ti = travelItemService.queryById(entity.getId());
			if(ti == null){
				entity.setCreateBy(sessionuser.getId());
				entity.setUpdateBy(sessionuser.getId());
				id = travelItemService.add(TravelItemKit.toBean(entity));
			}else{
				entity.setUpdateBy(sessionuser.getId());
				travelItemService.update(TravelItemKit.toBean(entity));
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的save方法");
		if(StringUtils.isNotEmpty(id)){			
			String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",id,JsonUtils.encode(entity),"","travelItem/save",sessionuser.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",ti!= null?ti.getId():"",JsonUtils.encode(ti),JsonUtils.encode(entity),"travelItem/save(update)",sessionuser.getId()));
		}
		return sendSuccessResult(response, "保存成功~");
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
	@RequestMapping(value="/uploadPhoto",method = RequestMethod.POST)//,method = RequestMethod.POST  , produces = "application/json"
	public @ResponseBody String uploadPhotos(String id,@RequestParam(value="fileselect",required=false) MultipartFile fileselect,
			HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object>  context = getRootMap();
		TravelItem ti = new TravelItem();
		try {
			if(request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;// resolver.resolveMultipart(request);
			//MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;            
		 //String filename =	multipartRequest.getHeader("X_FILENAME");
		// String filetype =	multipartRequest.getHeader("X-File-Type");
		// String fifi = multipartRequest.getHeader("fileselect");
		// CommonsMultipartFile cm = (CommonsMultipartFile) multipartRequest.getFile("file");
			// 获得文件：   
			//Map<String,MultipartFile> file = (Map<String,MultipartFile>) multipartRequest.getFileMap(); 
			//MultiValueMap<String,MultipartFile> its = multipartRequest.getMultiFileMap();
			//List<MultipartFile> lll = multipartRequest.getFiles("fileselect");
			String travelitemPhotoPath = FilePros.travelitemPhotoPath();// FilePros.uploadPtopath(multipartRequest);//FilePros.uploadPath();
			TravelItem t = travelItemService.queryById(id);
			StringBuffer photos = new StringBuffer();
			if (t != null){
				photos.append(t.getPhotos() == null ? "":t.getPhotos());
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
	            parpath = travelitemPhotoPath+"\\"+StringUtils.trim(t.getItemCode())+"_"+StringUtils.trim(t.getAlias());
	            directory = new File(parpath);
	            if(!directory.exists()||!directory.isDirectory()){
	            	directory.mkdirs();
	            }
	            uploadpic = new File(parpath+"\\"+picName );
	            photos.append(StringUtils.isNotEmpty(photos.toString())?"|"+picName :picName );
	            System.out.println("景点ID="+(t!= null?t.getId():"")+"上传图片文件名是：" + picName);  
	            out = new FileOutputStream(uploadpic);  
	            out.write(f.getBytes());  
	            out.close();  
			}
			picName = null;
			directory = null;
			uploadpic = null;
			parpath = null;
			ti.setId(id);
			ti.setPhotos(photos.toString());
			travelItemService.update(ti);
			if(out != null){
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			context.put(SUCCESS, true);
			context.put("msg", "景点图片上传成功！");
			}else{
				System.out.println("##########上传景点文件不是图片对象#############");
				context.put(SUCCESS, false);
				context.put("msg", "上传景点图片文件类型非法!");
			}
		} catch (IOException e) {
			context.put(SUCCESS, false);
			context.put("msg", "上传景点文件出现IO异常!");
			e.printStackTrace();
		}catch(Exception e){
			context.put(SUCCESS, false);
			context.put("msg", "上传景点文件出错!");
			e.printStackTrace();
		}
		String result = JsonUtils.encode(context);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的uploadPhoto方法");
		try {
			String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/uploadPhoto",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"上传图片",ti!= null?ti.getId():"","",JsonUtils.encode(ti),"travelItem/uploadPhoto",sessionuser.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		//HtmlUtil.writerJson(response, result);
		//return forward("server/sys/travelItem",context); 
	}
	/**
	 * 获取待编辑,预览,删除的图片
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/editPhoto",method = RequestMethod.POST)
	public Map<String,Object> getPhotos(@RequestParam(value="id")String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		TravelItem ti = travelItemService.queryById(id);
		try {
			String photos =  ti.getPhotos();
			String [] filenames = photos.split("\\|");
			String httptravelitemPhotoPath = FilePros.httptravelitemPhotoPath();//磁盘路径
			String travelitemPhotoPath = FilePros.travelitemPhotoPath();//网络访问路径
			String directory = StringUtils.trim(ti.getItemCode())+"_"+StringUtils.trim(ti.getAlias());
			String parpath = travelitemPhotoPath+"\\"+directory;
			String httpPath =httptravelitemPhotoPath +"/"+directory;
			List<String> uris = new ArrayList<String>();
			File newfile = null;
			//FileInputStream is = null;
			//BufferedInputStream imageStream = null;
			//OutputStream toClient = null;
			for(String name:filenames){
				if(StringUtils.isNotEmpty(name)&& !name.equals(",")){	
					newfile = new File(parpath+"\\"+name);
					if(newfile.exists() && newfile.getName().equals(name)){
						/*is = new FileInputStream(newfile);
					    imageStream = new BufferedInputStream(is);
				        int i = imageStream.available(); // 得到文件大小
				        byte data[] = new byte[i];
				        is.read(data);// 读数据
	*/			      //  response.setContentType("image/*"); // 设置返回的文件类型
				      //  response.setContentType("application/octet-stream;charset=UTF-8");  
				       // toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
				      //  toClient.write(data); // 输出数据
				      //  toClient.flush();
						uris.add(httpPath+"/"+directory+"/"+newfile.getName());//newfile.getAbsolutePath()
					}
				}
			}
			newfile = null;
			//imageStream = null;
			//toClient = null;
			context.put(SUCCESS, true);
			context.put("uris", uris);
			//HtmlUtil.writerJSON(response, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的editPhoto方法");
		try {
			String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/editPhoto",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"编辑图片",ti!= null?ti.getId():"","",JsonUtils.encode(ti),"travelItem/editPhoto",sessionuser.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return context;
	}
	
	/**
	 * 保存编辑,删除后的图片
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/saveeditedPhoto",method = RequestMethod.POST)
	public Map<String,Object> saveeditedPhoto(@RequestParam(value="id")String id,@RequestParam(value="fileNames")String fileNames,HttpServletRequest request,HttpServletResponse response)throws Exception{
		Map<String,Object> context = getRootMap();
		String realPath = FilePros.itemCoverpath();
		TravelItem ti = travelItemService.queryById(id);
		String [] photos = StringUtils.isNotEmpty(ti.getPhotos()) ? ti.getPhotos().split("\\|"):null;
		String [] names = fileNames.split(",");
		List<String> list =	Arrays.asList(photos);
		for(String name:names){
			String parpath = ti != null?ti.getItemCode().replaceAll(" ", "")+"_"+ti.getAlias() :"";
			if(StringUtils.isNotEmpty(name) &&StringUtils.isNotEmpty(parpath)){
				String filePath = realPath+"\\"+parpath+"\\"+name;
				File file = new File(filePath);
				if (file.exists() && file.getName().equals(name)) {
					file.delete();
					for(String photo:photos){
						if(photo.equals(name)){
							list.remove(photo);
						}
					}
				}
			}
		}
		list.spliterator();
		ti = new TravelItem();
		ti.setId(id);
		StringBuffer pnames = new StringBuffer();
		for(String name:list){
			pnames.append("|"+name);
		}
		ti.setPhotos(pnames.toString());
		travelItemService.update(ti);
		context.put(SUCCESS, true);
		context.put("msg", "图片保存成功！");
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的saveeditedPhoto方法");
		String logid = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/saveeditedPhoto",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logid,"保存编辑图片",ti!= null?ti.getId():"","",JsonUtils.encode(ti),"travelItem/saveeditedPhoto",sessionuser.getId()));
		return context;
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
		Map<String,Object>  context = getRootMap();
		TravelItemVo entity  = travelItemService.selectById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		if(StringUtils.isNotEmpty(entity.getFreeseason())){
			String[] temp = entity.getFreeseason().split("~");
			entity.setFreebeginMonth(temp[0].substring(0, temp[0].indexOf("月")));
			entity.setFreebeginDate(temp[0].substring(temp[0].indexOf("月")+1,temp[0].indexOf("日")));
			entity.setFreeendMonth(temp[1].substring(0, temp[1].indexOf("月")));
			entity.setFreeendDate(temp[1].substring(temp[1].indexOf("月")+1,temp[1].indexOf("日")));
		}
		if(StringUtils.isNotEmpty(entity.getBusyseason())){
			String[] temp = entity.getBusyseason().split("~");
			entity.setBusybeginMonth(temp[0].substring(0, temp[0].indexOf("月")));
			entity.setBusybeginDate(temp[0].substring(temp[0].indexOf("月")+1,temp[0].indexOf("日")));
			entity.setBusyendMonth(temp[1].substring(0, temp[1].indexOf("月")));
			entity.setBusyendDate(temp[1].substring(temp[1].indexOf("月")+1,temp[1].indexOf("日")));
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的getId方法");
		String logId = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","travelItem/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return JsonUtils.encode(context);
	}
	/**
	 * IllegalAccessException
	 * @param travelStyle
	 * @param fileNames
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@SuppressWarnings({})
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public void searchTravelItem(@RequestParam(value="travelStyle")String travelStyle,@RequestParam(value="rcdDays")String rcdDays,@RequestParam(value="scope")String scope,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> map = getRootMap();
		if(StringUtils.isNotEmpty(travelStyle)){			
			map.put("travelStyle", travelStyle);
		}
		if(StringUtils.isNotEmpty(scope)){			
			map.put("scope", scope);
		}
		if(rcdDays.indexOf('-')>0){
			map.put("rcdDays1", rcdDays.split("-")[0]);
			map.put("rcdDays2", rcdDays.split("-")[1]);
		}else{
			map.put("rcdDays", rcdDays);
		}
		travelItemService.searchTravelItem(map);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的search方法");
	}
	
 
/*	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/queryByScope", method = RequestMethod.GET)
	public List<TravelItem> queryByScope(@RequestParam(value="scopeAlias")String scopeAlias,HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<TravelItem> travelItems = Lists.newArrayList();
		if(StringUtils.isNotEmpty(scopeAlias) && !scopeAlias.equalsIgnoreCase("undefined")){			
			travelItems = travelItemService.queryByScopeAlias(scopeAlias);
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的queryByScope方法");
		return travelItems ;
	}*/
	/**
	 * 查询该区域的景点
	 * @param travelStyle
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/queryByStyle", method = RequestMethod.GET)
	public List<TravelItemVo> queryByStyle(@RequestParam(value="travelStyle")String travelStyle,HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<TravelItemVo> travelItems = travelItemService.queryByStyle(travelStyle);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的queryByStyle方法");
		return travelItems ;
	}
	/**
	 * 
	 * @param alias
	 * @param request
	 * @param response
	 * @return
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/queryByAlias", method = RequestMethod.POST)
	public String queryByAlias(@RequestParam(value="alias")String alias,HttpServletRequest request,HttpServletResponse response){
		if(StringUtils.isNotEmpty(alias)){
			String[] aliass = alias.split(",");
			List<TravelItemVo> travelItems = travelItemService.queryByAlias(Arrays.asList(aliass));
			String travelitemPhotoPath = FilePros.httptravelitemPhotoPath();//
			String parpath = "";
		//	Map<String,String> maps = Maps.newHashMap();
			for(TravelItemVo vo:travelItems){
				 if(StringUtils.isNotEmpty(vo.getPhotos())){
					 List<Integer> tempAr = new ArrayList<Integer>();
					 StringBuffer ptos = new StringBuffer();
					 String[] photos = vo.getPhotos().split("\\|");
					 for(int i=0;i<Constants.ITEMPHOTOCOUNT;i++){
						 Random rd = new Random();
						 int num = rd.nextInt(photos.length);
						 if(!tempAr.contains(num)){
							 parpath = StringUtils.trim(travelitemPhotoPath+"/"+vo.getItemCode()+"_"+vo.getAlias()+"/"+photos[num]);
							 ptos.append(parpath+",");
							 tempAr.add(num);
						 }
					 }
					 vo.setPhotos(ptos.toString());
				 }
			}
			SysUser sessionuser = SessionUtils.getUser(request);
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的queryByStyle方法");
			return JsonUtils.encode(travelItems) ;
		}
		return JsonUtils.encode("{}");
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
		travelItemService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的delete方法");
		String logId = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/delete",sessionuser.getId(),"delete from travel_item where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"travelItem/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		travelItemService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("travel_item","景点管理","travelItem/logicdelete",sessionuser.getId(),"update travel_item set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"travelItem/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param response
	 * @return全部區域
	 * @throws Exception
	 */
	/*@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/allScopes", method = RequestMethod.GET)
	public List<Map<String,String>> allScopes(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<HashMap<String,String>> maps = travelItemService.allScopes();
		List<Map<String,String>> newlist = Lists.newArrayList();
		newlist.add(new HashMap(){{put("scopeAlias","");put("scope","全部區域");}});
		newlist.addAll(maps);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的allScopes方法");
		return newlist;
	}*/
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/queryByScope", method = RequestMethod.GET)
	public List<TravelItemVo> queryByScope(String scope,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<TravelItemVo> vos = travelItemService.queryMapByScope(scope);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的allScopes方法");
		return vos;
	}
	/**
	 * 
	 * @param response
	 * @return全部區域
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/allItems", method = RequestMethod.GET)
	public List<HashMap<String,String>> allItems(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<HashMap<String,String>> maplist = travelItemService.allItems();
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelItemController的allItems方法");
		return maplist;
	}
	
	/**
	 * 
	 * @param exception
	 * @return
	 */
	 @ExceptionHandler(IOException.class)  
	 public ModelAndView handleIOException(IOException exception) {  
		 ModelAndView modelAndView = new ModelAndView("profile/uploadPage");  
		 modelAndView.addObject("error", exception.getMessage());  
		 return modelAndView;  
	 }  
	 
	
	/**
	* 返回项目在磁盘上的绝对路径
	* 
	* @param request
	* @param path
	* @return
	*/
	private static String getAppPath(HttpServletRequest request, String path) {
	if (StringUtil.isEmpty(path))
		return "";
	return request.getSession().getServletContext().getRealPath(path);
	}
	
	
}
