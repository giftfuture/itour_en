package com.itour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.convert.ImageFilter;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.page.Pager;
import com.itour.base.util.ClassReflectUtil;
import com.itour.base.util.DateUtil;
import com.itour.base.util.FilePros;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.ShowHappyKit;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.ShowHappy;
import com.itour.entity.SysUser;
import com.itour.entity.TravelItem;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.ShowHappyService;
import com.itour.util.Constants;
import com.itour.vo.ShowHappyVo;

/**
 * 
 * <br>
 * <b>功能：</b>ShowHappyController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/showhappy") 
public class ShowHappyController extends BaseController{
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	// Servrice start
    @Autowired(required=false)
    private CacheService cacheService;
	@Autowired  
	private ShowHappyService showHappyService; 
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
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/main") 
	public ModelAndView main(@RequestParam(value="pageNo",defaultValue="1")int pageNo,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的main方法");
		return forward("front/happy/happiness"); 
	}
	/**
	 * 
	 * @param pageNo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/pagination") 
	public String pagination(@RequestParam(value="pageNo",defaultValue="1")int pageNo,HttpServletRequest request) throws Exception{
		Map<String,Object> context = getRootMap();
		ShowHappyVo vo = new ShowHappyVo();
		vo.setPage(pageNo);
		vo.setLimit(Constants.happyperPage);
		vo.getPager().setPageSize(Constants.happyperPage);
		vo.getPager().setPageId(pageNo);
		BasePage<ShowHappyVo> page = showHappyService.showPageQuery(vo);
		//List<Map<String, Object>> records = page.getRecords();
		//context.put("records", page.getRecords());
		//context.put("pageNo",pageNo);
		page.setPage(pageNo);
		Pager pager = page.getPager();
		pager.setPageId(pageNo);
		pager.setPageSize(Constants.happyperPage);
		pager.setRowCount(page.getTotal());
		page.setPager(pager);
		context.put("result", page);
		//context.put("total",page.getTotal());
		//context.put("rows",page.getRows());
		//System.out.println(JsonUtils.encode(page));
		return JsonUtils.encode(context);
	}
	
	/**
	 * 
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sharehappy") 
	public ModelAndView sharehappy(ShowHappyVo vo,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的shareHappy方法");
		return forward("front/happy/sharehappy"); 
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
	public ModelAndView  list(ShowHappyVo vo,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的list方法");
		return forward("server/sys/showhappy"); 
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
	public EasyUIGrid datalist(ShowHappyVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(vo.getCreateTime() != null){
			//String createTime = DateUtil.getDateYmdHs(vo.getCreateTime());
			//Timestamp createTime =  new Timestamp(vo.getCreateTime().getTime());//DateUtil.fromStringToDate("YYYY-MM-dd",DateUtil.getDateLong(page.getCreateTime()));
			vo.setCreateTime(vo.getCreateTime());
		}
		BasePage<ShowHappyVo> page = showHappyService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的datalist方法");
		return dataGridAdapter.wrap(page);
	}
	/**
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return${alias:.*}  {key:[a-zA-Z0-9\\.]+}   @RequestParam("title") String alias,
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/detail/{shCode}", method = RequestMethod.GET) 
	public ModelAndView detail(@PathVariable("shCode") String shCode,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		ShowHappyVo sh = showHappyService.queryByCode(shCode);
		String content = sh.getContent();
		String shareHappyPath = FilePros.httpshareHappyPath();
		//String shCoverPath = FilePros.httpshCoverPath();
		if(StringUtils.isNotEmpty(content)){
			List<String> imgs = ImageFilter.getsrcList(content);
			if(imgs.size()>0){
				for(String fileName:imgs){ 
					String path = shareHappyPath+"/"+(sh.getShCode()+"_"+sh.getRoute())+"/"+fileName;
	    			//if(ff.exists()&&!ff.isDirectory()){//文件根目录不存在时创建  
	    			   //String bytesrc =	ImageFilter.GetImageStr(path,ImageFilter.base64ImgExt.get(fileName.substring(fileName.indexOf("."))));
	    				//content = content.replace(fileName, bytesrc);  
					content = content.replace(fileName, path);  
	    			//}
				}
			}
				sh.setContent(content);
			}
		//Map<String,Object> record = ShowHappyKit.toRecord(sh);
		context.put("sh", sh);
		return forward("front/happy/happydetail",context); 
	}
	/**
	 * 
	 * @param entity
	 * @param typeIds
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)//@RequestBody
	public String add(@RequestBody ShowHappyVo showhappy,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//Map<String,Object> context = getRootMap();
		String vcode = SessionUtils.getHappyValidateCode(request);
		SessionUtils.removeHappyValidateCode(request); //清除验证码，确保验证码只能用一次
	 	if(StringUtils.isEmpty(showhappy.getVerifyCode())){
	 		//failureMessage(response, "验证码不能为空.");
			return sendFailureResult(response, "验证码不能为空~");
		}
	 	if(!showhappy.getVerifyCode().toLowerCase().equals(vcode)){//判断验证码是否正确   
	 		//failureMessage(response, "验证码输入错误.");
			return sendFailureResult(response, "验证码输入错误~");
		} 
	 	String shareHappyCoverPath = FilePros.shareHappyCoverPath();
	 	showhappy.setShCode(IDGenerator.code(19)); 
	 	//String fileName = showhappy.getSurface().getName();
	 	if(StringUtils.isNotEmpty(showhappy.getCover())){
		 	String cover = ImageFilter.writeBase64ImageString(showhappy.getCover(),showhappy.getSurface(),shareHappyCoverPath,showhappy.getShCode()+"_"+showhappy.getRoute());
		 	showhappy.setCover(cover);
	 	}
		String shareHappyPath = FilePros.shareHappyPath();
		String uuid = IDGenerator.getUUID();
		ClassReflectUtil.setIdKeyValue(showhappy,"id",uuid);
		ImageFilter.writeSHBase64Image(showhappy,shareHappyPath);		
		showHappyService.addShowHappy(ShowHappyKit.toEntity(showhappy));
		//String result = JsonUtils.encode(context);
		return sendSuccessResult(response, "保存成功~");
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
	public String save(ShowHappyVo showhappy,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String shId = "";
		ShowHappy sh = null;
		SysUser sessionuser = SessionUtils.getUser(request);
		if(showhappy.getId()==null||StringUtils.isEmpty(showhappy.getId())){
			shId = showHappyService.add(ShowHappyKit.toEntity(showhappy));
		}else{
				sh = showHappyService.queryById(showhappy.getId());
			if(sh == null){
				shId = showHappyService.add(ShowHappyKit.toEntity(showhappy));
			}else{
				showHappyService.update(ShowHappyKit.toEntity(showhappy));
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的save方法");
		if(StringUtils.isNotEmpty(shId)){			
			String logid = logSettingService.add(new LogSetting("show_happy","回忆幸福","showhappy/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",shId,JsonUtils.encode(showhappy),"","showhappy/save",sessionuser.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("show_happy","回忆幸福","showhappy/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",sh!= null?sh.getId():"",JsonUtils.encode(sh),JsonUtils.encode(showhappy),"showhappy/save(update)",sessionuser.getId()));
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
		ShowHappy entity  = showHappyService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		String logId = logSettingService.add(new LogSetting("show_happy","回忆幸福","showhappy/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","showhappy/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的getId方法");
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
		showHappyService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的delete方法");
		String logId = logSettingService.add(new LogSetting("show_happy","回忆幸福","showhappy/delete",sessionuser.getId(),"delete from show_happy where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"showhappy/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		showHappyService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行ShowHappyController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("show_happy","回忆幸福","showhappy/logicdelete",sessionuser.getId(),"update show_happy set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"showhappy/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}

}
