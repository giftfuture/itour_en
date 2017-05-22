package com.itour.controller;

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

import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.convert.OrderDetailKit;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.OrderDetail;
import com.itour.entity.SysUser;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.OrderDetailService;
import com.itour.vo.OrderDetailVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>OrderDetailController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/orderDetail") 
public class OrderDetailController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired(required=false)
    private CacheService cacheService;
	// Servrice start
	@Autowired  
	private OrderDetailService<OrderDetail> orderDetailService; 
	
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
	public ModelAndView  list(OrderDetailVo page,HttpServletRequest request) throws Exception{
		//Map<String,Object>  context = getRootMap();
		//List<OrderDetail> dataList = orderDetailService.queryByList(page);
		//设置页面数据
	//	context.put("dataList", dataList);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行OrderDetailController的list方法");
		return forward("server/sys/orderDetail"); 
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
	public EasyUIGrid  datalist(OrderDetailVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//List<OrderDetail> dataList = orderDetailService.queryByList(page);
		BasePage<OrderDetailVo> page = orderDetailService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行OrderDetailController的dataList方法");
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
	public String save(OrderDetailVo entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String odId="";
		OrderDetail od = null;
		SysUser sessionuser = SessionUtils.getUser(request);
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId())){
			odId = orderDetailService.add(OrderDetailKit.toEntity(entity));
		}else{
				od = orderDetailService.queryById(entity.getId());
			if(od == null){
				odId = orderDetailService.add(OrderDetailKit.toEntity(entity));
			}else{
				orderDetailService.update(OrderDetailKit.toEntity(entity));
			}
		}
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行OrderDetailController的save方法");
		if(StringUtils.isNotEmpty(odId)){
			String logId = logSettingService.add(new LogSetting("order_detail","订单明细","orderdetail/save",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logId,"新增",odId,JsonUtils.encode(entity),"","orderdetail/save",sessionuser.getId()));
		}else{			
			String logId = logSettingService.add(new LogSetting("order_detail","订单明细","orderdetail/save(update)",sessionuser.getId(),"",""));
			logOperationService.add(new LogOperation(logId,"更新",odId,JsonUtils.encode(od),JsonUtils.encode(entity),"orderdetail/save(update)",sessionuser.getId()));
		}
		return sendSuccessResult(response, "保存成功~");
	}
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
/*	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=false,verifyURL=false)
	@ResponseBody
	@RequestMapping(value="/booking", method = RequestMethod.POST)
	public String booking(@RequestBody OrderDetailVo entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String vcode = SessionUtils.getHappyValidateCode(request);
		SessionUtils.removeHappyValidateCode(request);//清除验证码，确保验证码只能用一次
	 	if(StringUtils.isEmpty(entity.getVerifyCode())){
	 		return sendFailureResult(response, "验证码不能为空.");
		}
		//判断验证码是否正确
	 	if(!entity.getVerifyCode().toLowerCase().equals(vcode)){   
	 		return sendFailureResult(response, "验证码输入错误.");
		} 
		String odId="";
		OrderDetail od = null;
		if(entity.getId()==null||StringUtils.isEmpty(entity.getId().toString())){
			entity.setStatus(1);
			odId = orderDetailService.add(OrderDetailKit.toEntity(entity));
		}else{
			   od = orderDetailService.queryById(entity.getId());
			if(od == null){
				entity.setStatus(1);
				odId = orderDetailService.add(OrderDetailKit.toEntity(entity));
			}else{
				orderDetailService.update(OrderDetailKit.toEntity(entity));
			}
		}
		String result = sendSuccessResult(response, "下单预订成功！");
		return result;
	}*/
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
		OrderDetail entity  = orderDetailService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行OrderDetailController的getId方法");
		String logId = logSettingService.add(new LogSetting("order_detail","订单明细","orderdetail/getId",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logId,"查看",id,JsonUtils.encode(entity),"","orderdetail/getId",sessionuser.getId()));
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
		orderDetailService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行OrderDetailController的delete方法");
		String logId = logSettingService.add(new LogSetting("order_detail","订单明细","orderdetail/delete",sessionuser.getId(),"delete from order_detail where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"orderdetail/delete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
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
		orderDetailService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行OrderDetailController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("order_detail","订单明细","orderdetail/logicdelete",sessionuser.getId(),"update order_detail set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"orderdetail/logicdelete",sessionuser.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}

}
