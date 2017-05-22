package com.itour.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.QuoteForm;
import com.itour.entity.SysUser;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.QuoteFormService;
import com.itour.vo.QuoteFormVo;

@Controller
@RequestMapping("/quoteForm") 
public class QuoteFormController extends BaseController {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	// Servrice start
	@Autowired 
	private QuoteFormService  quoteFormService; 
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
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value="/list") 
	public ModelAndView list(QuoteFormVo page,HttpServletRequest request) throws Exception{
	/*	Map<String,Object>  context = getRootMap();
		List<Quotation> dataList = quotationService.queryByList(page);
		//设置页面数据
		context.put("dataList", dataList);*/
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuoteFormController的list方法");
		return forward("server/sys/quotation"); 
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
	public EasyUIGrid  datalist(QuoteFormVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<Quotation> dataList = quotationService.queryByList(vo);
		BasePage<QuoteFormVo> page = quoteFormService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuoteFormController的datalist方法");
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
	public String save(QuoteForm entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//Map<String,Object> context =getRootMap();
		QuoteForm qo = null;
		String qoId = "";
		SysUser sessionuser = SessionUtils.getUser(request);
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId())){
			entity.setCreateBy(sessionuser.getId());
			entity.setUpdateBy(sessionuser.getId());
			qoId = quoteFormService.add(entity);
		}else{
			qo = quoteFormService.queryById(entity.getId());
			if(qo == null){
				entity.setCreateBy(sessionuser.getId());
				entity.setUpdateBy(sessionuser.getId());
				qoId = quoteFormService.add(entity);
			}else{
				entity.setUpdateBy(sessionuser.getId());
				quoteFormService.update(entity);
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuoteFormController的save方法");
		if(StringUtils.isNotEmpty(qoId)){			
			String logid = logSettingService.add(new LogSetting("quote_form","详细价目表","quoteForm/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",qoId,JsonUtils.encode(entity),"","quoteForm/save",sessionuser.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("quote_form","详细价目表","quoteForm/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",qo!= null?qo.getId():"",JsonUtils.encode(qo),JsonUtils.encode(entity),"quoteForm/save(update)",sessionuser.getId()));
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
		Map<String,Object>  context = getRootMap();
		QuoteForm entity  = quoteFormService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		//String data = JsonUtils.encode(entity);
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuoteFormController的getId方法");
		String logId = logSettingService.add(new LogSetting("quote_form","详细价目表","quoteForm/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","quoteForm/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		quoteFormService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuoteFormController的delete方法");
		String logId = logSettingService.add(new LogSetting("quote_form","详细价目表","quoteForm/delete",sessionuser.getId(),"delete from quote_form where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"quoteForm/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		quoteFormService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuoteFormController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("quote_form","详细价目表","quoteForm/logicdelete",sessionuser.getId(),"update quote_form set valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"quoteForm/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}

}

