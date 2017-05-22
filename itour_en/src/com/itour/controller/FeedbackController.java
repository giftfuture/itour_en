package com.itour.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.page.Pager;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.FeedbackKit;
import com.itour.entity.Feedback;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.SysUser;
import com.itour.service.FeedbackService;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.util.Constants;
import com.itour.vo.CustomerVo;
import com.itour.vo.FeedbackVo;

/**
 * 
 * <br>
 * <b>功能：</b>FeedbackController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/feedback") 
public class FeedbackController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	// Servrice start
	@Autowired //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private FeedbackService feedbackService; 
    @Autowired(required=false)
    private CacheService cacheService;
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
	public ModelAndView  list(CustomerVo vo,HttpServletRequest request) throws Exception{
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的list方法");
		return forward("server/sys/feedback"); 
	}
	/**
	 * 
	 * @param vo
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/pagination", method = RequestMethod.POST) 
	public 	String pagination(@RequestParam(value="pageNo",defaultValue="1")int pageNo,String route,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		FeedbackVo fv = new FeedbackVo();
		int count = 0;
		fv.setPublicShow(true);
		fv.setRoute(route);
		fv.setPage(pageNo);
		fv.setRows(Constants.fbperPage);
		//fv.setLimit(Constants.fbperPage);
		fv.getPager().setPageId(pageNo);
		fv.getPager().setPageSize(Constants.fbperPage);
		fv.getPager().setOrderField("create_time");
		fv.getPager().setOrderDirection(false);
		List<FeedbackVo> list = Lists.newArrayList();
		/*if(Constants.feedbackpage.size() >= Constants.fbperPage){
			list = Constants.feedbackpage.subList((int)fv.getPager().getPageOffset(), Constants.fbperPage);
			count = Constants.feedbackpage.size();
		}else{*/
			List<Feedback> fbs = feedbackService.queryByList(fv);
			for(Feedback fb:fbs) {
				list.add(FeedbackKit.toRecord(fb));
			}
			count = feedbackService.queryByCount(fv);
		//}
	//	List<FeedbackVo> records = Lists.newArrayList();
		BasePage<FeedbackVo> page = new BasePage<FeedbackVo>(fv.getStart(), fv.getLimit(), list, count);
		//Pager pager = new Pager();
		page.setPage(pageNo);
		Pager pager = page.getPager();
		pager.setPageId(pageNo);
		pager.setPageSize(Constants.fbperPage);
		pager.setRowCount(page.getTotal());
		//page.getPager()
		//page.setTotalPage(page.getPager().getPageCount());
		//page.getPager().getPageCount();
		page.setPager(pager);
		context.put(SUCCESS, true);
		context.put("result", page);
		String result = JsonUtils.encode(context);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的pagination方法");
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
	public EasyUIGrid  datalist(FeedbackVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(vo.getCreateTime() != null){
			vo.setCreateTime(vo.getCreateTime());
		}
		BasePage<FeedbackVo> page = feedbackService.pagedQuery(vo);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的dataList方法");
		return dataGridAdapter.wrap(page);
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
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FeedbackVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Feedback bean = FeedbackKit.toEntity(vo);
		String fbId = "";
		Feedback fb = null;
		//response.setContentType("text/html;charset=UTF-8"); 
		String vcode = SessionUtils.getValidateCode(request);
		SessionUtils.removeValidateCode(request);//清除验证码，确保验证码只能用一次
	 	if(StringUtils.isBlank(vo.getVerifyCode())){
			return sendFailureResult(response, "验证码不能为空~");
		}
		//判断验证码是否正确
	 	if(!vo.getVerifyCode().toLowerCase().equals(vcode)){   
		   return sendFailureResult(response, "验证码输入错误~");
		} 
		if(vo.getId()==null||StringUtils.isBlank(vo.getId().toString())){
			fbId = feedbackService.add(bean);
		}else{
				fb = feedbackService.queryById(vo.getId());
			if(fb == null)
				fbId = feedbackService.add(bean);
			else
				feedbackService.update(bean);
		}
		
	/*	SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的add方法");
		if(StringUtils.isNotEmpty(fbId)){
			String logId =logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/add",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
			logOperationService.add(new LogOperation(logId,"新增",fbId,"",JsonUtils.encode(bean),"feedback/add",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		}else{
			String logId =logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/add(update)",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
			logOperationService.add(new LogOperation(logId,"更新",fb!=null ?fb.getId():"",JsonUtils.encode(fb),JsonUtils.encode(bean),"feedback/add(update)",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		}*/
		return sendSuccessResult(response, "保存成功~");
		//sendSuccessMessage(response, "保存成功~");
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
	public String save(Feedback entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String fbId = "";
		Feedback feedback = null;
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			fbId = feedbackService.add(entity);
		}else{
			feedback = feedbackService.queryById(entity.getId());
			if(feedback == null)
				fbId = feedbackService.add(entity);
			else
				feedbackService.update(entity);
		}
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的save方法");
		if(StringUtils.isNotEmpty(fbId)){
			String logId =logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/save",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
			logOperationService.add(new LogOperation(logId,"新增",fbId,"",JsonUtils.encode(entity),"feedback/save",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		}else{
			String logId =logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/save(update)",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
			logOperationService.add(new LogOperation(logId,"更新",feedback!=null ?feedback.getId():"",JsonUtils.encode(feedback),JsonUtils.encode(entity),"feedback/save(update)",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		Map<String,Object>  context = getRootMap();
		Feedback entity  = feedbackService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		String result = JsonUtils.encode(context);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的getId方法");
		String logId = logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/getId",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),"",JsonUtils.encode(entity),"feedback/getId",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return result;
	}
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		feedbackService.delete(id);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的delete方法");
		String logId = logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/delete",user.getId(),"delete from customers where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"feedback/delete",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/logicdelete", method = RequestMethod.POST)
	public String logicdelete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		feedbackService.logicdelete(id);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行FeedbackController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("feed_back","反馈咨询","feedback/logicdelete",user.getId(),"update feed_back set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"feedback/logicdelete",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}

}
