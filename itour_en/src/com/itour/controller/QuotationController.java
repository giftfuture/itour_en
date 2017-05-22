package com.itour.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.HtmlUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.Quotation;
import com.itour.entity.SysUser;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.QuotationService;
import com.itour.vo.FeedbackVo;
import com.itour.vo.QuotationVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>QuotationController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/quotation") 
public class QuotationController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired(required=false)
    private CacheService cacheService;
	// Servrice start
	@Autowired //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private QuotationService<Quotation> quotationService; 
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
	public ModelAndView list(QuotationVo page,HttpServletRequest request) throws Exception{
	/*	Map<String,Object>  context = getRootMap();
		List<Quotation> dataList = quotationService.queryByList(page);
		//设置页面数据
		context.put("dataList", dataList);*/
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuotationController的getId方法");
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
	public EasyUIGrid  datalist(QuotationVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<Quotation> dataList = quotationService.queryByList(vo);
		BasePage<QuotationVo> page = quotationService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuotationController的datalist方法");
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
	public String save(Quotation entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String quId = "";
		Quotation qo = null;
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			quId = quotationService.add(entity);
		}else{
				qo = quotationService.queryById(entity.getId());
			if(qo == null){
				quId = quotationService.add(entity);
			}else{
				quotationService.update(entity);
			}
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuotationController的save方法");
		if(StringUtils.isNotEmpty(quId)){			
			String logid = logSettingService.add(new LogSetting("quotation","报价单","quotation/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"新增",quId,JsonUtils.encode(entity),"","quotation/save",sessionuser.getId()));
		}else{
			String logid = logSettingService.add(new LogSetting("quotation","报价单","quotation/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logid,"更新",qo!= null?qo.getId():"",JsonUtils.encode(qo),JsonUtils.encode(entity),"quotation/save(update)",sessionuser.getId()));
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
		Quotation entity  = quotationService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		//String data = JsonUtils.encode(entity);
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuotationController的getId方法");
		String logId = logSettingService.add(new LogSetting("quotation","报价单","quotation/getId",sessionuser.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","quotation/getId",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		quotationService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuotationController的delete方法");
		String logId = logSettingService.add(new LogSetting("quotation","报价单","quotation/delete",sessionuser.getId(),"delete from quotation where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"quotation/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		quotationService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行QuotationController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("quotation","报价单","quotation/logicdelete",sessionuser.getId(),"update quotation set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"quotation/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
}
