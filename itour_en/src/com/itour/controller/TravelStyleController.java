package com.itour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.FilePros;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.PinYinUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.RouteTemplateKit;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.RouteTemplate;
import com.itour.entity.SysUser;
import com.itour.entity.SysVariables;
import com.itour.entity.TravelStyle;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.TravelStyleService;
import com.itour.util.Constants;
import com.itour.vo.RouteTemplateVo;
import com.itour.vo.TravelStyleVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>TravelStyleController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/travelStyle") 
public class TravelStyleController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired(required=false)
    private CacheService cacheService;
	// Servrice start
	@Autowired //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
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
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/list") 
	public ModelAndView list(TravelStyleVo page,HttpServletRequest request) throws Exception{
		 Map<String,Object>  context = getRootMap();
		//context.put("dataList", dataList);//设置页面数据
			SysUser sessionuser = SessionUtils.getUser(request);
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的list方法");
		 return forward("server/sys/travelStyle",context); 
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
	public EasyUIGrid datalist(TravelStyleVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		BasePage<TravelStyleVo> pagination = travelStyleService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的dataList方法");
		return dataGridAdapter.wrap(pagination); 
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
	public @ResponseBody String uploadPhotos(@RequestParam(value="id")String id,@RequestParam(value="fileselect",required=false) MultipartFile fileselect,
		HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> context = getRootMap();
		String tsCoverPath = FilePros.tsCoverPath();
		try {
			SysUser sessionuser = SessionUtils.getUser(request);
			TravelStyle ts = travelStyleService.queryById(id);
			if(ts !=null){
				//String fileName = vo.getCoverImg() != null ? vo.getCoverImg().getName():"";
				//vo.setCover(fileName);
				String path = tsCoverPath+File.separatorChar+PinYinUtil.getPinYin(ts.getType())+"_"+ts.getAlias();
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
				            uploadpic = new File(path+File.separatorChar+picName );
				            System.out.println("旅行方式ID="+id+""+ts.getType()+"上传封面图片是" + picName);  
				            out = new FileOutputStream(uploadpic);  
				            out.write(f.getBytes());  
				            out.close();  
				        }  
						ts.setCover(picName);
						picName = null;
						directory = null;
						uploadpic = null;
						ts.setUpdateBy(sessionuser.getId());
						travelStyleService.updateCover(ts);
						if(out != null){
							try {
								out.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						context.put(SUCCESS, true);
						context.put("msg", "旅行方式封面图片上传成功！");
				}else{
					System.out.println("##########不是上传文件对象#############");
					context.put(SUCCESS, false);
					context.put("msg", "旅行方式上传封面文件类型非法!");
				}
			}
			logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的uploadCover方法");
			try {
				String logid = logSettingService.add(new LogSetting("travel_style","路线模板","travelStyle/uploadCover",sessionuser.getId(),"",""));
				logOperationService.add(new LogOperation(logid,"上传封面",ts!= null?ts.getId():"","",JsonUtils.encode(ts),"travelStyle/uploadCover",sessionuser.getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			context.put(SUCCESS, false);
			context.put("msg", "旅行方式上传封面文件出现IO异常!");
			e.printStackTrace();
		}catch(Exception e){
			context.put(SUCCESS, false);
			context.put("msg", "旅行方式上传封面文件出错!");
			e.printStackTrace();
		}
		String result = JsonUtils.encode(context);
		return result;
	}
	/**
	 * 
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/allData", method = RequestMethod.POST) 
	public void allData(HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<TravelStyle> dataList = travelStyleService.queryByList(null);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("rows", dataList);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的allData方法");
		HtmlUtil.writerJson(response, jsonMap);
	}
	/**
	 * -所有-
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/loadStyles", method = RequestMethod.GET) 
	public List<Map<String,Object>> loadStyles(HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<Map<String,Object>> list = Constants.allStyles;
		if(list.size()==0){
			List<Map<String,Object>> newlist = new ArrayList(){{add(new HashMap(){{put("alias","");put("type","-所有-");}});}};
			newlist.addAll(travelStyleService.loadStyles());
			Constants.allStyles.clear();
			Constants.allStyles.addAll(newlist);
			list = newlist;
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的loadStyles方法");
		return list;
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
	public String save(TravelStyle entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
	//	Map<String,Object>  context = new HashMap<String,Object>();
		entity.setValid(true);
		SysUser sessionuser = SessionUtils.getUser(request);
		String id = "";
		TravelStyle ts = null;
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId())){
			entity.setCreateBy(sessionuser.getId());
			entity.setUpdateBy(sessionuser.getId());
			id = travelStyleService.add(entity);
		}else{
				ts = travelStyleService.queryById(entity.getId());
			if(ts == null){
				entity.setCreateBy(sessionuser.getId());
				entity.setUpdateBy(sessionuser.getId());
				id = travelStyleService.add(entity);
			}else{
				entity.setUpdateBy(sessionuser.getId());
				travelStyleService.update(entity);
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的save方法");
		if(StringUtils.isNotEmpty(id)){			
			String logid = logSettingService.add(new LogSetting("travel_style","旅行方式管理","travelStyle/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",id,JsonUtils.encode(entity),"","travelStyle/save",sessionuser.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("travel_style","旅行方式管理","travelStyle/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",ts!= null?ts.getId():"",JsonUtils.encode(ts),JsonUtils.encode(entity),"travelStyle/save(update)",sessionuser.getId()));
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
	@RequestMapping(value="/getId")
	public String getId(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		TravelStyle entity  = travelStyleService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的getId方法");
		String logId = logSettingService.add(new LogSetting("travel_style","旅行方式管理","travelStyle/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","travelStyle/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
	@RequestMapping(value="/delete")
	public String delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		travelStyleService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的delete方法");
		String logId = logSettingService.add(new LogSetting("travel_style","旅行方式管理","travelStyle/delete",sessionuser.getId(),"delete from travel_style where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"travelStyle/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
	@RequestMapping(value="/logicdelete")
	public String logicdelete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		travelStyleService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelStyleController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("travel_style","旅行方式管理","travelStyle/logicdelete",sessionuser.getId(),"update travel_style set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"travelStyle/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
}
