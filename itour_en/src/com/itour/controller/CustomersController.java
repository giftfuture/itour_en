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
import com.itour.base.util.FilePros;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.SessionUtils;
import com.itour.base.web.BaseController;
import com.itour.entity.Customers;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.SysUser;
import com.itour.service.CustomersService;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.vo.CustomerVo;
import com.itour.vo.RouteTemplateVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>CustomersController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */ 
@Controller
@RequestMapping("/customers") 
public class CustomersController extends BaseController{
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	// Servrice start
	@Autowired //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CustomersService customersService; 
	@Autowired
	private DataGridAdapter dataGridAdapter;
    @Autowired(required=false)
    private CacheService cacheService;
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
	@RequestMapping(value = "/list") 
	public ModelAndView list(CustomerVo vo,HttpServletRequest request) throws Exception{
		request.isUserInRole("");
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行CustomersController的list方法");
		return forward("server/sys/customers"); 
	}
	
	
	/**
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value = "/dataList.json", method = RequestMethod.POST) 
	@ResponseBody
	public EasyUIGrid datalist(CustomerVo vo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//BasePage page = dataGridAdapter.getPagination();
		BasePage<Map<String, Object>> pagination = customersService.pagedQuery(vo);
		//List<Customers> dataList = customersService.queryByList(page);
		//设置页面数据
		//Map<String,Object> jsonMap = new HashMap<String,Object>();
		//jsonMap.put("total",page.getPager().getRowCount());
		//jsonMap.put("rows", dataList);
	//	Customers cust = dataList.get(0);
		//System.out.println("####"+JSON.toJSONString(cust));
		//System.out.println("####"+JSON.toJSONString(dataList));
	 //   JSONObject jsonObj = JSONObject.parseObject(cust.toString());
	 //   System.out.println(jsonObj);
	 //	HtmlUtil.writerJSON(response,jsonMap);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行CustomersController的dataList方法");
		return dataGridAdapter.wrap(pagination);
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
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(Customers entity,HttpServletRequest request,HttpServletResponse response) throws Exception{
		entity.setCustomerId(IDGenerator.getUUID());
		String customerId = "";
		Customers cust = null;
		SysUser user = SessionUtils.getUser(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId())){
			//entity.setId(IDGenerator.getLongId());
			customerId = customersService.add(entity);
		}else{
				cust = customersService.queryById(entity.getId());
			if(cust == null){
				customerId = customersService.add(entity);
			}else{
				customersService.update(entity);
			}
		}
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行CustomersController的save方法");
		if(StringUtils.isNotEmpty(customerId)){
			String logId = logSettingService.add(new LogSetting("customers","客户管理","customers/save",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
			logOperationService.add(new LogOperation(logId,"新增",customerId,"",JsonUtils.encode(entity),"customers/save",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		}else{			
			String logId = logSettingService.add(new LogSetting("customers","客户管理","customers/save(update)",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
			logOperationService.add(new LogOperation(logId,"更新",cust!=null?cust.getId():"",JsonUtils.encode(cust),JsonUtils.encode(entity),"customers/save(update)",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		}
		return sendSuccessResult(response, "保存成功~");
	}
	
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value = "/getId", method = RequestMethod.POST)
	@ResponseBody
	public String getId(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = getRootMap();
		Customers entity  = customersService.queryById(id);
		if(entity  == null){
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行CustomersController的getId方法");
		String logId = logSettingService.add(new LogSetting("customers","客户管理","customers/getId",user.getId(),"",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"查看",entity.getId(),JsonUtils.encode(entity),"","customers/getId",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return JsonUtils.encode(context);
	}
	
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		customersService.delete(id);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行CustomersController的delete方法");
		String logId = logSettingService.add(new LogSetting("customers","客户管理","customers/delete",user.getId(),"delete from customers where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"物理删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"customers/delete",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value = "/logicdelete", method = RequestMethod.POST)
	@ResponseBody
	public String logicdelete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		customersService.logicdelete(id);
		SysUser user = SessionUtils.getUser(request);
		logger.info("#####"+(user!= null?("id:"+user.getId()+"email:"+user.getEmail()+",nickName:"+user.getNickName()):"")+"调用执行CustomersController的logicdelete方法");
		String logId = logSettingService.add(new LogSetting("customers","客户管理","customers/logicdelete",user.getId(),"update customers set is_valid=0 where id in("+JsonUtils.encode(id)+")",""));//String tableName,String function,String urlTeimplate,String creater,String deletescriptTemplate,String updatescriptTemplate
		logOperationService.add(new LogOperation(logId,"逻辑删除",JsonUtils.encode(id),JsonUtils.encode(id),JsonUtils.encode(id),"customers/logicdelete",user.getId()));//String logCode,String operationType,String primaryKeyvalue,String content,String url,String creater
		return removeSuccessMessage(response);
	}
	/**线路和报价单
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin=true,verifyURL=true)
	@ResponseBody
	@RequestMapping(value="/showOrders",method = RequestMethod.GET)
	public ModelAndView showOrders(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> context = getRootMap();
		String orderhtmls = FilePros.httporderhtmls();
		List<CustomerVo> vos  = customersService.queryOrdersByCid(id);
		CustomerVo customers = customersService.selectById(id);
		context.put("customers", customers);
		if(vos == null||vos.size()==0){		
			//sendFailureResult(response, "没有找到对应的记录!");
			context.put(SUCCESS, false);
			context.put(MSG,  "没有找到对应的记录!");
		}else{
			for(CustomerVo vo:vos){
				vo.setOrderUrl(orderhtmls+"/"+vo.getOrderNo()+".html");
			}
			context.put(SUCCESS, true);
			context.put("vos", vos);
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行CustomersController的showOrders方法");
		String logId = logSettingService.add(new LogSetting("showOrders","订单","customers/showOrders",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logId,"查看",id,JsonUtils.encode(vos),"","customers/showOrders",sessionuser.getId()));
		return forward("server/sys/showOrders",context);
	}
	
	
}
