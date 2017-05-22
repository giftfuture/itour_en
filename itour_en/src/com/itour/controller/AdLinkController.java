
package com.itour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import com.itour.base.util.PinYinUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.AdLinkKit;
import com.itour.entity.AdLink;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.SysUser;
import com.itour.service.AdLinkService;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.util.Constants;
import com.itour.vo.AdLinkVo;
@Controller
@RequestMapping("/adLink") 
public class AdLinkController extends BaseController {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdLinkService adLinkService ;
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;
    @Autowired(required=false)
    private CacheService cacheService;
	@Autowired
	private LogSettingDetailService logSettingDetailService;
	
	@Autowired
	private LogOperationService logOperationService;
	
	@ResponseBody
	@RequestMapping(value="/allAdLink", method = RequestMethod.POST)
	public String allAdLink(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//Map<String,Object> root = getRootMap();
		//List<AdLink> allAreas = Lists.newArrayList();
		String adlinpath = FilePros.httpadLinkPath();
		List<AdLink> links = Constants.alladLinks;
		if(links.size()==0||links.get(0).getAdvertise().startsWith("adlink/")){
			Constants.alladLinks.clear();
			List<AdLink> templinks =adLinkService.allAdLink();
			for(AdLink al:templinks){
				al.setAdvertise(adlinpath+"/"+al.getAdvertise());
				//allAreas.add(al);
			}
			Constants.alladLinks.addAll(templinks);
			links = Constants.alladLinks;
		}
		//root.put("allAreas", allAreas);
		//String result = JsonUtils.encode(root);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行AdLinkController的allAdLink方法");
		return JsonUtils.encode(links);
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
	public ModelAndView  list(AdLinkVo page,HttpServletRequest request) throws Exception{
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行AdLinkController的list方法");
		return forward("server/sys/adLink"); 
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
	public EasyUIGrid datalist(AdLinkVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<OrderDetail> dataList = orderDetailService.queryByList(page);
		BasePage<Map<String, String>> page = adLinkService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行AdLinkController的dataList方法");
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
	public String save(AdLinkVo entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String odId="";
		AdLink od = null;
		SysUser sessionuser = SessionUtils.getUser(request);
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId())){
			entity.setCreateBy(sessionuser.getId());
			entity.setUpdateBy(sessionuser.getId());
			odId = adLinkService.add(AdLinkKit.toEntity(entity));
		}else{
				od = adLinkService.queryById(entity.getId());
			if(od == null){
				entity.setCreateBy(sessionuser.getId());
				entity.setUpdateBy(sessionuser.getId());
				odId = adLinkService.add(AdLinkKit.toEntity(entity));
			}else{
				entity.setUpdateBy(sessionuser.getId());
				adLinkService.update(AdLinkKit.toEntity(entity));
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行AdLinkController的save方法");
		if(StringUtils.isNotEmpty(odId)){
			String logId = logSettingService.add(new LogSetting("ad_link","首页广告链接管理","adlink/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logId,"新增",odId,JsonUtils.encode(entity),"","ad_link/save",sessionuser.getId()));
		}else{			
			String logId = logSettingService.add(new LogSetting("ad_link","首页广告链接管理","adlink/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logId,"更新",odId,JsonUtils.encode(od),JsonUtils.encode(entity),"adlink/save(update)",sessionuser.getId()));
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
		AdLink entity  = adLinkService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行AdLinkController的getId方法");
		String logId = logSettingService.add(new LogSetting("ad_link","查看","adlink/getId",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logId,"查看",id,JsonUtils.encode(entity),"","adlink/getId",sessionuser.getId()));
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
		adLinkService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行AdLinkController的delete方法");
		String logId = logSettingService.add(new LogSetting("ad_link","订单明细","adlink/delete",sessionuser.getId(),"delete from ad_link where id in("+JsonUtils.encode(id)+")",""));
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"adlink/delete",sessionuser.getId()));
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
		adLinkService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行LevelAreaController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("ad_link","首页广告链接管理","adlink/logicdelete",sessionuser.getId(),"update ad_link set valid=0 where id in("+JsonUtils.encode(id)+")",""));
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"adlink/logicdelete",sessionuser.getId()));
		return removeSuccessMessage(response);
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
	@RequestMapping(value="/uploadPhoto",method = RequestMethod.POST)
	public @ResponseBody String uploadPhotos(@RequestParam(value="id")String id,@RequestParam(value="fileselect",required=false) MultipartFile fileselect,
		HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> context = getRootMap();
		String adLinkPath = FilePros.adLinkPath();
		try {
			SysUser sessionuser = SessionUtils.getUser(request);
			AdLink rt = adLinkService.queryById(id);
			AdLinkVo vo = AdLinkKit.toVo(rt);
			if(vo !=null){
				//String fileName = vo.getCoverImg() != null ? vo.getCoverImg().getName():"";
				//vo.setCover(fileName);
				//String path = adLinkPath+File.separatorChar+PinYinUtil.getPinYin(rt.getTitle());
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
				            directory = new File(StringUtils.trim(adLinkPath));
				            if(!directory.exists()||!directory.isDirectory()){
				            	directory.mkdirs();
				            }
				            //newpicName = Calendar.getInstance(Locale.CHINA).getTimeInMillis()+picName.substring(picName.indexOf("."));
				            uploadpic = new File(adLinkPath+File.separatorChar+picName );
				            System.out.println("上传首页图片是" + picName);  
				            out = new FileOutputStream(uploadpic);  
				            out.write(f.getBytes());  
				            out.close();  
				        }  
						rt.setAdvertise(picName);
						picName = null;
						directory = null;
						uploadpic = null;
						rt.setUpdateBy(sessionuser.getId());
						adLinkService.update(rt);
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
}
