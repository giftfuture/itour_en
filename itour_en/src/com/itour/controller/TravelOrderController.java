package com.itour.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableList;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.google.common.collect.Lists;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itour.base.annotation.Auth;
import com.itour.base.cache.CacheService;
import com.itour.base.convert.ImageFilter;
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.DateUtil;
import com.itour.base.util.FilePros;
import com.itour.base.util.HtmlToPdf;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.PinYinUtil;
import com.itour.base.util.SessionUtils;
import com.itour.base.util.StringUtil;
import com.itour.base.util.WaterMarkUtilPDF;
import com.itour.base.util.email.EmailService;
import com.itour.base.web.BaseController;
import com.itour.convert.OrderDetailKit;
import com.itour.convert.RouteTemplateKit;
import com.itour.convert.TravelOrderKit;
import com.itour.entity.Customers;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.entity.OrderDetail;
import com.itour.entity.RouteTemplate;
import com.itour.entity.SysUser;
import com.itour.entity.TravelItem;
import com.itour.entity.TravelOrder;
import com.itour.entity.TravelStyle;
import com.itour.service.CustomersService;
import com.itour.service.LogOperationService;
import com.itour.service.LogSettingDetailService;
import com.itour.service.LogSettingService;
import com.itour.service.OrderDetailService;
import com.itour.service.QuoteFormService;
import com.itour.service.RouteTemplateService;
import com.itour.service.TravelItemService;
import com.itour.service.TravelOrderService;
import com.itour.service.TravelStyleService;
import com.itour.util.Constants;
import com.itour.vo.CalculateQuoteVO;
import com.itour.vo.OrderDetailVO;
import com.itour.vo.QuoteFormVO;
import com.itour.vo.RouteTemplateVO;
import com.itour.vo.TravelItemVO;
import com.itour.vo.TravelOrderVO;
/*import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;*/

/**
 * 
 * <br>
 * <b>功能：</b>TravelOrderController<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Controller
@RequestMapping("/travelOrder")
public class TravelOrderController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired(required = false)
	private CacheService cacheService;
	// Servrice start
	@Autowired // 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private TravelOrderService<TravelOrder> travelOrderService;
	@Autowired  
	private CustomersService customersService; 
	@Autowired
	private DataGridAdapter dataGridAdapter;
	@Autowired
	private LogSettingService logSettingService;

	@Autowired
	private LogSettingDetailService logSettingDetailService;

	@Autowired
	private LogOperationService logOperationService;
	@Autowired
	private OrderDetailService<OrderDetail> orderDetailService;
	@Autowired
	private RouteTemplateService<RouteTemplate> routeTemplateService;
	@Autowired
	private QuoteFormService quoteFormService;
	@Autowired
	private TravelStyleService<TravelStyle> travelStyleService;
	@Autowired
	private TravelItemService<TravelItem> travelItemService;

	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = true, verifyURL = true)
	@RequestMapping(value = "/list")
	public ModelAndView list(TravelOrderVO page, HttpServletRequest request) throws Exception {
		/*
		 * Map<String,Object> context = getRootMap(); List<TravelOrder> dataList
		 * = travelOrderService.queryByList(page); context.put("dataList",
		 * dataList);//设置页面数据
		 */
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####" + (sessionuser != null ? ("id:" + sessionuser.getId() + "email:" + sessionuser.getEmail()
				+ ",nickName:" + sessionuser.getNickName()) : "") + "调用执行TravelOrderController的list方法");
		return forward("server/sys/travelOrder");
	}

	/**
	 * @param url
	 * @param classifyId
	 * @return
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = true, verifyURL = true)
	@ResponseBody
	@RequestMapping(value = "/dataList.json", method = RequestMethod.POST)
	public EasyUIGrid datalist(TravelOrderVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// List<TravelOrder> dataList = travelOrderService.queryByList(page);
		BasePage<TravelOrderVO> pagination = travelOrderService.pagedQuery(vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####" + (sessionuser != null ? ("id:" + sessionuser.getId() + "email:" + sessionuser.getEmail()
				+ ",nickName:" + sessionuser.getNickName()) : "") + "调用执行TravelOrderController的dataList方法");
		return dataGridAdapter.wrap(pagination);
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin = true, verifyURL = true)
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(TravelOrderVO entity, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = "";
		TravelOrder to = null;
		TravelOrder record = null;
		if (StringUtils.isNotEmpty(entity.getId())) {
			entity.setOrderNo(IDGenerator.getUUID());
			entity.setOrderStatus(1);
			entity.setCustomerId(IDGenerator.getUUID());
			entity.setOrderName(entity.getOrderNo() + "_" + entity.getOrderName() + "_"
					+ (StringUtils.isNotEmpty(entity.getCustomerId()) ? entity.getCustomerId() : IDGenerator.code(16))
					+ "_" + DateUtil.dateToString(DateUtil.fromStringToDate(DateUtil.y_m_d, entity.getExpectedDepart()),
							DateUtil.longTimePlusMill)
					+ IDGenerator.number(4));
			record = TravelOrderKit.toRecord(entity);
			id = travelOrderService.add(record);
		} else {
			to = travelOrderService.queryById(entity.getId());
			if (to == null) {
				entity.setOrderNo(IDGenerator.getUUID());
				entity.setOrderStatus(1);
				entity.setCustomerId(IDGenerator.code(16));
				entity.setOrderName(entity.getOrderNo() + "_" + entity.getOrderName() + "_"
						+ (StringUtils.isNotEmpty(entity.getCustomerId()) ? entity.getCustomerId()
								: IDGenerator.code(16))
						+ "_"
						+ DateUtil.dateToString(DateUtil.fromStringToDate(DateUtil.y_m_d, entity.getExpectedDepart()),
								DateUtil.longTimePlusMill)
						+ IDGenerator.number(4));
				record = TravelOrderKit.toRecord(entity);
				id = travelOrderService.add(record);
			} else {
				travelOrderService.update(record);
			}
		}
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####" + (sessionuser != null ? ("id:" + sessionuser.getId() + "email:" + sessionuser.getEmail()
				+ ",nickName:" + sessionuser.getNickName()) : "") + "调用执行TravelOrderController的save方法");
		if (StringUtils.isNotEmpty(id)) {
			String logid = logSettingService
					.add(new LogSetting("travel_order", "订单管理", "travelOrder/save", sessionuser.getId(), "", ""));
			logOperationService.add(new LogOperation(logid, "新增", id, JsonUtils.encode(entity), "", "travelOrder/save",
					sessionuser.getId()));
		} else {
			String logid = logSettingService.add(
					new LogSetting("travel_order", "订单管理", "travelOrder/save(update)", sessionuser.getId(), "", ""));
			logOperationService.add(new LogOperation(logid, "更新", to != null ? to.getId() : "", JsonUtils.encode(to),
					JsonUtils.encode(entity), "travelOrder/save(update)", sessionuser.getId()));
		}
		return sendSuccessResult(response, "保存成功~");
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@ResponseBody
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String booking(@RequestBody OrderDetailVO entity, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String vcode = SessionUtils.getHappyValidateCode(request);
		SessionUtils.removeHappyValidateCode(request);// 清除验证码，确保验证码只能用一次
		String receiveremail = entity.getReceiveremail();
		if (StringUtils.isEmpty(entity.getVerifyCode())) {
			return sendFailureResult(response, "验证码不能为空.");
		}
		// 判断验证码是否正确
		if (!entity.getVerifyCode().toLowerCase().equals(vcode)) {
			return sendFailureResult(response, "验证码输入错误.");
		}
		Customers customers = new Customers();
		customers.setEmail(entity.getReceiveremail());
		customers.setAddress(entity.getComefrom());
		customers.setMobile(entity.getReceiverMobile());
		customers.setTelephone(entity.getReceiverMobile());
		customers.setCity(entity.getComefrom());
		customers.setCustomerName(entity.getReceiver());
		customers.setDistrict(entity.getReceiverMobile());
		customers.setScope(entity.getComefrom());
		customers.setValid(1);
		customers.setIntroduction("");
		customers.setStatus(1);
		customers.setNickName(entity.getReceiver());
		String customerId = customersService.add(customers);
		TravelOrderVO to = new TravelOrderVO();
		to.setBudget(entity.getBudget());
		if (StringUtils.isNotEmpty(entity.getExpectedBack())) {
			to.setExpectedBack(entity.getExpectedBack());
		}
		if (StringUtils.isNotEmpty(entity.getExpectedDepart())) {
			to.setExpectedDepart(entity.getExpectedDepart());
		}																
		to.setCustomerId(customerId);
		to.setOrderNo(IDGenerator.getUUID());
		to.setRoutename(entity.getRoutename());
		to.setReceiver(entity.getReceiver());
		to.setReceiveremail(entity.getReceiveremail());
		to.setReceiverMobile(entity.getReceiverMobile());
		to.setGender(entity.getGender());
		to.setOrderStatus(1);
		to.setTotalStaff(entity.getAdults() + entity.getChildren());
		to.setOrderName(IDGenerator.getUUID() + "_" + entity.getRoutename() + "_" + IDGenerator.code(16) + "_"
				+ DateUtil.dateToString(DateUtil.fromStringToDate(DateUtil.y_m_d, entity.getExpectedDepart()),
						DateUtil.longTimePlusMill)
				+ IDGenerator.number(4));
		String travelOrderId = travelOrderService.add(TravelOrderKit.toRecord(to));
		// String odId="";
		// OrderDetail od = null;
		/*
		 * if(entity.getId()==null||StringUtils.isEmpty(entity.getId().toString(
		 * ))){ entity.setStatus(1);
		 * entity.setTravelOrder(StringUtils.isNotEmpty(travelOrderId)?
		 * travelOrderId:""); odId =
		 * orderDetailService.add(OrderDetailKit.toEntity(entity)); }else{ od =
		 * orderDetailService.queryById(entity.getId()); if(od == null){
		 * entity.setStatus(1);
		 * entity.setTravelOrder(StringUtils.isNotEmpty(travelOrderId)?
		 * travelOrderId:""); odId =
		 * orderDetailService.add(OrderDetailKit.toEntity(entity)); }else{
		 * orderDetailService.update(OrderDetailKit.toEntity(entity)); } }
		 */
		entity.setStatus(1);
		entity.setTravelOrder(StringUtils.isNotEmpty(travelOrderId) ? travelOrderId : "");
		entity.setGroupDate(entity.getExpectedDepart());
		//entity.setCount(entity.getAdults()+entity.getChildren());
		String groupCode = "Itour"+entity.getGroupDate();
		String gCode = orderDetailService.queryGroupCode(groupCode);
		entity.setGroupCode(gCode);
		String odId = orderDetailService.add(OrderDetailKit.toEntity(entity));
		String title = "Itours Booking Info";
		String content = "Hello!Dear"  + (entity.getGender()==1 ? "Mr" : "Mrs")+ entity.getReceiver()
				+ " Your booking information has been received and the booking success message will be sent to your email within 24 hours. Please pay attention to view.";
		if (EmailService.sendEmail(title, receiveremail, title, content, "")) {
			String result = sendSuccessResult(response, "Reservation is successful, please check the mailbox reservation success later!");
			return result;
		} else {
			String result = sendSuccessResult(response, "The reservation is successful, the message is not sent successfully, please wait 24 hours to send a scheduled success message to your mailbox!");
			return result;
		}
	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin = true, verifyURL = true)
	@ResponseBody
	@RequestMapping(value = "/getId", method = RequestMethod.POST)
	public String getId(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		TravelOrder entity = travelOrderService.queryById(id);
		if (entity == null) {
			return sendFailureResult(response, "没有找到对应的记录!");
		}
		context.put(SUCCESS, true);
		context.put("data", TravelOrderKit.toEditVo(entity));
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####" + (sessionuser != null ? ("id:" + sessionuser.getId() + "email:" + sessionuser.getEmail()+ ",nickName:" + sessionuser.getNickName()) : "") + "调用执行TravelOrderController的getId方法");
		String logId = logSettingService.add(new LogSetting("travel_order", "订单管理", "travelOrder/getId", sessionuser.getId(), "", "")); 
		logOperationService.add(new LogOperation(logId, "查看", entity.getId(), JsonUtils.encode(entity), "","travelOrder/getId", sessionuser.getId())); 
		return JsonUtils.encode(context);
	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin = true, verifyURL = true)
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(String[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		travelOrderService.delete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####" + (sessionuser != null ? ("id:" + sessionuser.getId() + "email:" + sessionuser.getEmail()
				+ ",nickName:" + sessionuser.getNickName()) : "") + "调用执行TravelOrderController的delete方法");
		String logId = logSettingService.add(new LogSetting("travel_order", "订单管理", "travelOrder/delete",
				sessionuser.getId(), "delete from travel_order where id in(" + JsonUtils.encode(id) + ")", ""));  
		logOperationService.add(new LogOperation(logId, "物理删除", JsonUtils.encode(id), JsonUtils.encode(id),
				JsonUtils.encode(id), "travelOrder/delete", sessionuser.getId()));
		return removeSuccessMessage(response);
	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Auth(verifyLogin = true, verifyURL = true)
	@ResponseBody
	@RequestMapping(value = "/logicdelete", method = RequestMethod.POST)
	public String logicdelete(String[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		travelOrderService.logicdelete(id);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####" + (sessionuser != null ? ("id:" + sessionuser.getId() + "email:" + sessionuser.getEmail()
				+ ",nickName:" + sessionuser.getNickName()) : "") + "调用执行TravelOrderController的logicdelete方法");
		String logId = logSettingService
				.add(new LogSetting("travel_order", "订单管理", "travelOrder/logicdelete", sessionuser.getId(),
						"update travel_order set valid=0 where id in(" + JsonUtils.encode(id) + ")", "")); 
		logOperationService.add(new LogOperation(logId, "逻辑删除", JsonUtils.encode(id), JsonUtils.encode(id),
				JsonUtils.encode(id), "travelOrder/logicdelete", sessionuser.getId())); 
		return removeSuccessMessage(response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toQuote1/{id}/{routeId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toQuote1(@PathVariable("id") String id, @PathVariable("routeId") String routeId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> context = getRootMap();
		RouteTemplateVO bean  = routeTemplateService.selectById(routeId);
		if(bean == null){
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
			return forward(request.getHeader("Referer"),context);
		}
		String itemIds = StringUtils.isNotEmpty(bean.getTravelItems())?bean.getTravelItems():"";
		List<String> itids = Arrays.asList(itemIds.split(","));
		List<TravelItemVO> items = travelItemService.queryByIds(itids);
		//Map<String,String> ticketsBlock = new HashMap<String,String>();
		StringBuffer adultticketsBlock = new StringBuffer();
		int idx = 0;
		for(TravelItemVO ti:items){
			String tickets = ti.getTicketsBlock();
			if(StringUtils.isNotEmpty(tickets)){
				String[] ticketArray = tickets.replace("slackseason:", "").replace("busyseason:", "").split(",");
				for(String map : ticketArray){
					String [] keyvalue = map.split(":");
					//ticketsBlock.put(keyvalue[0], keyvalue[1]);
					if(keyvalue.length==2){
						adultticketsBlock.append("<span name="+(PinYinUtil.getPinYin(keyvalue[0].length()>=3?keyvalue[0].substring(0, 3):keyvalue[0]))+">"+(++idx)+"."+keyvalue[0]+":&nbsp;&nbsp;&nbsp;<span name=ttprice>"+ keyvalue[1]+"</span>元/人</span>&nbsp;&nbsp;&nbsp;<input type='checkbox' checked='checked'/><br/>");
					}
				}
			}
		}
		TravelOrder entity = travelOrderService.queryById(id);
		OrderDetailVO od = orderDetailService.queryByOrderId(entity.getId());
		QuoteFormVO qf = quoteFormService.queryByRtId(bean.getId());
		CalculateQuoteVO vo = new CalculateQuoteVO();
		vo.setAdultticketsBlock(adultticketsBlock.toString());
		context.put(SUCCESS, true);
		context.put("bean", bean);
		context.put("qf", qf);
		context.put("torder", entity);
		context.put("od", od);
		context.put("vo",vo);
		context.put("adultticketsBlock", adultticketsBlock.toString().replaceAll("\"", ""));
		Constants.TDQUOTE1.put("bean", bean);
		Constants.TDQUOTE1.put("qf", qf);
		Constants.TDQUOTE1.put("torder", entity);
		Constants.TDQUOTE1.put("od", od);
		Constants.TDQUOTE1.put("adultticketsBlock",adultticketsBlock.toString().replaceAll("\"", ""));
		Constants.TDQUOTE1.put("od", od);
		Constants.TDQUOTE1.put("vo", vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelOrderController的toQuote1方法");
		String logId = logSettingService.add(new LogSetting("travel_order","订单管理","travelOrder/toQuote1",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logId,"查看",bean.getId(),JsonUtils.encode(bean),"","travelOrder/toQuote1",sessionuser.getId())); 
		return forward("server/sys/quote_step1",context);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/returntoQuote1", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView returntoQuote1(CalculateQuoteVO vo,HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> context = getRootMap();
		RouteTemplateVO bean  = routeTemplateService.selectById(vo.getRtid());
		if(bean == null){
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
			return forward(request.getHeader("Referer"),context);
		}
		String itemIds = StringUtils.isNotEmpty(bean.getTravelItems())?bean.getTravelItems():"";
		List<String> itids = Arrays.asList(itemIds.split(","));
		List<TravelItemVO> items = travelItemService.queryByIds(itids);
		//Map<String,String> ticketsBlock = new HashMap<String,String>();
		StringBuffer adultticketsBlock = new StringBuffer();
		int idx = 0;
		for(TravelItemVO ti:items){
			String tickets = ti.getTicketsBlock();
			if(StringUtils.isNotEmpty(tickets)){
				String[] ticketArray = tickets.replace("淡季：", "").replace("旺季：", "").split("、");
				for(String map : ticketArray){
					String [] keyvalue = map.split("：");
					//ticketsBlock.put(keyvalue[0], keyvalue[1]);
					if(keyvalue.length==2){
						adultticketsBlock.append("<span name="+(PinYinUtil.getPinYin(keyvalue[0].length()>=3?keyvalue[0].substring(0, 3):keyvalue[0]))+">"+(++idx)+"."+keyvalue[0]+":&nbsp;&nbsp;&nbsp;<span name=ttprice>"+ keyvalue[1]+"</span>元/人</span>&nbsp;&nbsp;&nbsp;");
						if(vo.getAdultticketsBlock().contains(keyvalue[0])){
							adultticketsBlock.append("<input type='checkbox' checked='checked'/><br/>");
						}else{
							adultticketsBlock.append("<input type='checkbox'/><br/>");
						}
					}
				}
			}
		}
		TravelOrder entity = travelOrderService.queryById(vo.getTorderid() );
		OrderDetailVO od = orderDetailService.queryByOrderId(entity.getId());
		QuoteFormVO qf = quoteFormService.queryByRtId(bean.getId());
		context.put(SUCCESS, true);
		context.put("bean", bean);
		context.put("qf", qf);
		context.put("torder", entity);
		context.put("od", od);
		vo.setAdultticketsBlock(adultticketsBlock.toString().replaceAll("\"", ""));
		if(StringUtils.isNotEmpty(vo.getQuotetraveldocadultsBlock())){
			String[] array = vo.getQuotetraveldocadultsBlock().split("<br/>");
			StringBuffer quotetraveldocadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = span.replace("<span>", "").replace("</span>", "").split(":");
				quotetraveldocadultsBlock.append("<span class='STYLE126'><input name='card' size='20' value='"+spandata[0]+"' type='text'>&nbsp;&nbsp;"+
                "<input name='cardprice' size='6' type='number' min='0' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
            	"元/人&nbsp;&nbsp;备注：<input name='cardremark' size='20' type='text'><a name='minusCard'><img src='images/minus.png' onclick='javascript:itour.quoteEdit.sightMinus(this)' width='20' height='20'></a></span>");
			}
			vo.setQuotetraveldocadultsBlock(quotetraveldocadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuotetourguideadultsBlock())){
			String [] array = vo.getQuotetourguideadultsBlock().split("<br/>");
			StringBuffer quotetourguideadultsBlock = new StringBuffer();
			for(String span:array){ 
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quotetourguideadultsBlock.append("<span class='style126'>"+ 
	            "<br><input name='alltheway' value='"+spandata[0]+"' size='10' type='text'> "+ 
	          "<select name='choselanguage' id='choselanguage' > "+ 
	           " <option>选择语种</option> "+ 
	           " <option value='中文'"+(spandata[1].equals("中文")?"selected='selected'":"")+">中文</option> "+ 
	           " <option value='英文'"+(spandata[1].equals("英文")?"selected='selected'":"")+">英文</option> "+ 
	          "</select>&nbsp;&nbsp; "+ 
	          "<input name='priceperday' size='6' value='"+StringUtil.getNumbers(spandata[2]).get(0)+"' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+ 
	          "元/天 &nbsp;&nbsp;X "+ 
	          " <input name='days' size='6' value='"+StringUtil.getNumbers(spandata[2]).get(1)+"' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+ 
	          "  天 &nbsp;&nbsp;备注：<input name='guideremark' size='10' type='text'>"+ 
              "<a name='guideminus' onclick='javascript:itour.quoteEdit.guideMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span> ");
			}
			vo.setQuotetourguideadultsBlock(quotetourguideadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoterentcaradultsBlock())){
			String[] array = vo.getQuoterentcaradultsBlock().split("<br/>");
			StringBuffer quoterentcaradultsBlock = new StringBuffer();
			for(String span :array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				String style=spandata[1].substring(spandata[1].indexOf('/')+1, spandata[1].indexOf('X'));
				quoterentcaradultsBlock.append(
				"<span class='STYLE126'><input name='alltheway' value='"+spandata[0]+"' size='10' type='text'>&nbsp;&nbsp; "+
				 "<input name='carprice' size='6' style='width:50px' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"元/ <select name='carstyle' id='carstyle' > "+
	            "<option selected='selected'>方式</option> "+
	            "<option value='天'"+(style.equals("天")?"selected='selected'":"")+">天</option> "+
	            "<option value='公里'"+(style.equals("公里")?"selected='selected'":"")+">公里 </option> "+
	            "<option value='趟'"+(style.equals("趟")?"selected='selected'":"")+">趟</option> "+
	              "</select>"+
	              "X<input name='carcount' size='6' value='"+StringUtil.getNumbers(spandata[1]).get(1)+"' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
	                	"数量&nbsp;&nbsp;　备注： "+
	              "<input name='carremark' size='20' type='text'><a name='carminus' onclick='javascript:itour.quoteEdit.carMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuoterentcaradultsBlock(quoterentcaradultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuotebigtrafficadultsBlock())){//大交通
			String[] array = vo.getQuotebigtrafficadultsBlock().split("<br/>");
			StringBuffer quotebigtrafficadultsBlock = new StringBuffer();
			for(String span :array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quotebigtrafficadultsBlock.append("<span class='STYLE126'><input name='traffic' value='"+spandata[0]+"' type='text'> "+
				"<input name='trafficperprice' size='6' type='number' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"'  min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"元/ 人 &nbsp;&nbsp;备注： <input name='trafficremark' size='20' type='text'>"+
				"<a name='trafficminus' onclick='javascript:itour.quoteEdit.trafficMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuotebigtrafficadultsBlock(quotebigtrafficadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoteinsuranceadultsBlock())){
			String [] array = vo.getQuoteinsuranceadultsBlock().split("<br/>");
			StringBuffer quoteinsuranceadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quoteinsuranceadultsBlock.append("<span class='style126'><br><select style='width:151' value='"+spandata[0]+"' name='insuranceselect' id='insuranceselect'> "+
					" <option value='内宾旅游意外保险'"+(spandata[1].equals("内宾旅游意外保险")?"selected='selected'":"")+">内宾旅游意外保险</option> "+
					" <option value='入境旅游意外保险'"+(spandata[1].equals("入境旅游意外保险")?"selected='selected'":"")+">入境旅游意外保险</option> "+
					" </select> "+
					"<input name='insuranceprice' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' size='6' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
					" 元/人&nbsp;&nbsp;备注： "+
					"<input name='insuranceremark' size='20' type='text'> "+
					"<a name='insuranceminus' onclick='javascript:itour.quoteEdit.insuranceMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuoteinsuranceadultsBlock(quoteinsuranceadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuotecomphcostadultsBlock())){
			String[] array = vo.getQuotecomphcostadultsBlock().split("<br/>");
			StringBuffer quotecomphcostadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quotecomphcostadultsBlock.append("<span class='style126'>  "+
		        "<input name='feeName' value='"+spandata[0]+"' size='20' type='text'>  "+
		        "<input name='feeperperson' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' size='6' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> "+
		        "元/人&nbsp;&nbsp;备注： <input name='feeremark' size='20' type='text'>  "+
		        "<a name='allfeeminus' onclick='javascript:itour.quoteEdit.allfeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuotecomphcostadultsBlock(quotecomphcostadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoterecreationadultsBlock())){
			String[] array = vo.getQuoterecreationadultsBlock().split("<br/>");
			StringBuffer quoterecreationadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quoterecreationadultsBlock.append("<span class='STYLE126'><input name='joyitem'value='"+spandata[0]+"' size='20' type='text'> "+
						 "<input name='perjoyprice' size='6' type='number' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
						 "元/人　&nbsp;&nbsp;备注：<input name='joyremark' size='20'  type='text'>"+
						 "<a name='joyminus' onclick='javascript:itour.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuoterecreationadultsBlock(quoterecreationadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoteitemguidecadultsBlock())){
			String[] array = vo.getQuoteitemguidecadultsBlock().split("<br/>");
			StringBuffer quoteitemguidecadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quoteitemguidecadultsBlock.append("<span class='style126'> "+
	            "<input name='hikingitem' value='"+spandata[0]+"' size='20' type='text'> "+
	            "<input name='guidename' size='4' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' type='text'> 向导数 X "+
	            "<input name='guideperday' size='6' value='"+StringUtil.getNumbers(spandata[1]).get(1)+"' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> 元/天 X   "+
	            "<input name='guidedays' size='4' value='"+StringUtil.getNumbers(spandata[1]).get(2)+"' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> 天　&nbsp;&nbsp;备注： "+
	            "<input name='hikingguideremark' size='20' type='text'> "+
	            "<a name='joyminus' onclick='javascript:itour.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuoteitemguidecadultsBlock(quoteitemguidecadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuotebathorseadultsBlock())){
			String[] array = vo.getQuotebathorseadultsBlock().split("<br/>");
			StringBuffer quotebathorseadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quotebathorseadultsBlock.append("<span class='STYLE126'><br><input value='"+spandata[0]+"' name='bathorseCost' size='20' type='text'> "+
				"<input name='bathorsenum' value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' size='4' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"马匹数 X<input name='bathorseperday' value='"+StringUtil.getNumbers(spandata[1]).get(1)+"' size='6' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"元/天  X  <input name='bathorseprice' value='"+StringUtil.getNumbers(spandata[1]).get(2)+"' size='4' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"天　&nbsp;&nbsp;备注：<input name='bathorseremark' size='20' type='text'> <a name='bathorseminus' onclick='javascript:itour.quoteEdit.bathhorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
				
			}
			vo.setQuotebathorseadultsBlock(quotebathorseadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoteridehorseadultsBlock())){
			String[] array = vo.getQuoteridehorseadultsBlock().split("<br/>");
			StringBuffer quoteridehorseadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quoteridehorseadultsBlock.append("<span class='style126'> "+
				"<input name='ridehorse' value='"+spandata[0]+"' size='20' type='text'> "+
				"<input name='ridehorseperday'  value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' size='4' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> "+
				"元/天  X<input name='ridehorsedays'  value='"+StringUtil.getNumbers(spandata[1]).get(1)+"' size='4' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">天　&nbsp;&nbsp;备注： "+
				"<input name='ridehorseremark' size='20' type='text'> "+
				"<a name='rideorseminus' onclick='javascript:itour.quoteEdit.ridehorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuoteridehorseadultsBlock(quoteridehorseadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoteclimbregisteradultsBlock())){
			String [] array = vo.getQuoteclimbregisteradultsBlock().split("<br/>");
			StringBuffer quoteclimbregisteradultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quoteclimbregisteradultsBlock.append("<span class='style126'> "+
						"<input name='climbRegister' size='20' value='"+spandata[0]+"' type='text'>&nbsp;&nbsp;<input name='climbRegisterperday'  value='"+StringUtil.getNumbers(spandata[1]).get(0)+"'size='6' type='text'> "+
						"元/天  X<input name='climbRegisterdays'  value='"+StringUtil.getNumbers(spandata[1]).get(1)+"'size='4' style='width:50' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
						"天　&nbsp;&nbsp;备注：<input name='climbRegisterremark' size='20' type='text'> "+
						"<a name='climbRegisterminus' onclick='javascript:itour.quoteEdit.climbRegisterMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>");
			}
			vo.setQuoteclimbregisteradultsBlock(quoteclimbregisteradultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoteclimbnexusadultsBlock())){
			String[] array = vo.getQuoteclimbnexusadultsBlock().split("<br/>");
			StringBuffer quoteclimbnexusadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				quoteclimbnexusadultsBlock.append("<span class=style126><br>"+
						"<input name=climbnexus value='"+spandata[0]+"' size=20 type=text>&nbsp;&nbsp;<input style='width:50px;' name=climbnexusnum  value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">人数 X"+
						"<input name=climbnexusperday style='width:50px;' value='"+StringUtil.getNumbers(spandata[1]).get(1)+"' size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">元/天  X  "+
						"<input name=climbnexusdays style='width:50px;' value='"+StringUtil.getNumbers(spandata[1]).get(2)+"' size=4  type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">天　&nbsp;&nbsp;备注："+
						"<input name=climbnexusremark size=20 type=text>"+
						"<a name=climbnexusminus onclick='javascript:itour.quoteEdit.climbnexusMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>");
			}
			vo.setQuoteclimbnexusadultsBlock(quoteclimbnexusadultsBlock.toString());
		}
		if(StringUtils.isNotEmpty(vo.getQuoteelsecostadultsBlock())){
			String[] array = vo.getQuoteelsecostadultsBlock().split("<br/>");
			StringBuffer quoteelsecostadultsBlock = new StringBuffer();
			for(String span:array){
				String [] spandata = StringUtil.trimEmpyArray(span.replace("<span>", "").replace("</span>", "").split(" "));
				String style = spandata[1].substring(spandata[1].indexOf('/')+1);
				quoteelsecostadultsBlock.append("<span class=STYLE126><br>"+
						"<input name=elseitem value='"+spandata[0]+"'  size=20 type=text>&nbsp;&nbsp;"+
						"<input name=elseitemprice value='"+StringUtil.getNumbers(spandata[1]).get(0)+"' size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			       	 	" 元/<select name=elseitemstyle   id=elseitemstyle>"+
			       	 	" <option selected=selected>方式</option>"+
			       	 	" <option value='人' "+(style.equals("人")?"selected='selected'":"")+">人</option>"+
			       	 	" <option value='团' "+(style.equals("团")?"selected='selected'":"")+">团</option>"+
			       	 	"</select>&nbsp;&nbsp;备注：<input name=elseitemremark size=20 type=text>"+
			           	" <a name=elseitemminus onclick='javascript:itour.quoteEdit.elsefeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>");
			}
			vo.setQuoteelsecostadultsBlock(quoteelsecostadultsBlock.toString());
		}
		//context.put("adultticketsBlock", adultticketsBlock.toString());
		context.put("returnvo",  vo);
		Constants.TDQUOTE1.put("bean", bean);
		Constants.TDQUOTE1.put("qf", qf);
		Constants.TDQUOTE1.put("torder", entity);
		Constants.TDQUOTE1.put("od", od);		
		Constants.TDQUOTE1.put("returnvo",  vo);
		Constants.TDQUOTE1.put("vo",  vo);
		SysUser sessionuser = SessionUtils.getUser(request);
		logger.info("#####"+(sessionuser != null?("id:"+sessionuser .getId()+"email:"+sessionuser.getEmail()+",nickName:"+sessionuser.getNickName()):"")+"调用执行TravelOrderController的toQuote1方法");
		String logId = logSettingService.add(new LogSetting("travel_order","订单管理","travelOrder/toQuote1",sessionuser.getId(),"",""));
		logOperationService.add(new LogOperation(logId,"查看",bean.getId(),JsonUtils.encode(bean),"","travelOrder/toQuote1",sessionuser.getId())); 
		return forward("server/sys/quote_step1",context);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin=true,verifyURL=true)
	@RequestMapping(value = "/toQuote2", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView toQuote2(CalculateQuoteVO vo,HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		TravelOrder entity = travelOrderService.queryById(vo.getTorderid());
		RouteTemplateVO bean = routeTemplateService.selectById(vo.getRtid());
		OrderDetailVO od = orderDetailService.queryByOrderId(entity.getId());
		QuoteFormVO qf = quoteFormService.queryByRtId(bean.getId());
		// RouteTemplateVO bean = routeTemplateService.selectById(id);
		if (bean == null || entity == null || qf == null) {
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
			return forward(request.getHeader("Referer"), context);
		}
		vo.setAdultticketsBlock(vo.getAdultticketsBlock().replaceAll("\"", ""));
		context.put(SUCCESS, true);
		context.put("bean", bean);
		context.put("qf", qf);
		context.put("torder", entity);
		context.put("od", od);
		if(StringUtils.isEmpty(vo.getAdultticketsBlock())){
			CalculateQuoteVO vv = (CalculateQuoteVO)Constants.TDQUOTE1.get("vo");
			if(vv != null){
				vo.setAdultticketsBlock(vv.getAdultticketsBlock());
			}
		}
		context.put("vo", vo);
		//Constants.TDQUOTE2.put("adultsumcost", adultsumcost + "");
		//Constants.TDQUOTE2.put("childrensumcost", childrensumcost + "");
		Constants.TDQUOTE2.put("rtid", vo.getRtid());
		Constants.TDQUOTE2.put("bean", bean);
		Constants.TDQUOTE2.put("qf", qf);
		Constants.TDQUOTE2.put("od", od);
		Constants.TDQUOTE2.put("torder", entity);
		Constants.TDQUOTE2.put("vo", vo);
		//context.put(MSG, "");
		return forward("server/sys/quote_step2", context);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = true, verifyURL = true)
	@RequestMapping(value = "/toQuote3", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView toQuote3(CalculateQuoteVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Float adultsumcost = 0f;
		Float childrensumcost = 0f;
		Map<String, Object> context = getRootMap();
		if (vo != null && StringUtils.isNotEmpty(vo.getId())) {
			TravelOrder entity = travelOrderService.queryById(vo.getTorderid());
			RouteTemplateVO bean = routeTemplateService.selectById(vo.getRtid());
			QuoteFormVO qf = quoteFormService.queryByRtId(bean.getId());
			OrderDetailVO od = orderDetailService.queryByOrderId(entity.getId());
			adultsumcost += Float.parseFloat(qf.getShowTicket().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowTraveldoc().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowTourguide().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowHotel().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowRentcar().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowBigtraffic().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowDinner().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowInsurance().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowComphcost().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowRecreation().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowItemguide().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowBathorse().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowRidehorse().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowClimbregister().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowClimbnexus().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowElsecost().split("\\|")[0]);

			childrensumcost += Float.parseFloat(qf.getShowTicket().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowTraveldoc().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowTourguide().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowHotel().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowRentcar().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowBigtraffic().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowDinner().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowInsurance().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowComphcost().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowRecreation().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowItemguide().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowBathorse().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowRidehorse().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowClimbregister().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowClimbnexus().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowElsecost().split("\\|")[0]);
			vo.setPlusSumPrice(0f);
			vo.setPlusDevicePrice(0f);
			context.put("adultsumcost", adultsumcost + "");
			context.put("childrensumcost", childrensumcost + "");
			context.put("rtid", vo.getRtid());
			context.put("bean", bean);
			context.put("qf", qf);
			context.put("od", od);
			context.put("torder", entity);
			context.put("vo", vo);
			Constants.TDQUOTE2.clear();
			Constants.TDQUOTE2.put("adultsumcost", adultsumcost + "");
			Constants.TDQUOTE2.put("childrensumcost", childrensumcost + "");
			Constants.TDQUOTE2.put("rtid", vo.getRtid());
			Constants.TDQUOTE2.put("bean", bean);
			Constants.TDQUOTE2.put("qf", qf);
			Constants.TDQUOTE2.put("od", od);
			Constants.TDQUOTE2.put("torder", entity);
			Constants.TDQUOTE2.put("vo", vo);
		}
		return forward("server/sys/quote_step3", context);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = true, verifyURL = true)
	@RequestMapping(value = "/returntoQuote2/{id}/{routeId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView returntoQuote2(@PathVariable("id") String id, @PathVariable("routeId") String routeId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		OrderDetailVO od = (OrderDetailVO) Constants.TDQUOTE2.get("od");
		TravelOrder to = (TravelOrder) Constants.TDQUOTE2.get("torder");
		RouteTemplateVO bean = (RouteTemplateVO) Constants.TDQUOTE2.get("bean");
		if (bean.getId().equals(routeId) && to.getId().equals(id)) {
			context.put("adultsumcost", Constants.TDQUOTE2.get("adultsumcost"));
			context.put("childrensumcost", Constants.TDQUOTE2.get("childrensumcost"));
			context.put("rtid", Constants.TDQUOTE2.get("rtid"));
			context.put("bean", bean);
			context.put("qf", Constants.TDQUOTE2.get("qf"));
			context.put("od", od);
			context.put("torder", to);
			context.put("vo", Constants.TDQUOTE2.get("vo"));
		}
		return forward("server/sys/quote_step2", context);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toQuote4", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView toQuote4(CalculateQuoteVO vo, HttpServletRequest request, HttpServletResponse response)throws Exception {
		Float adultsumcost = 0f;
		Float childrensumcost = 0f;
		Map<String, Object> context = getRootMap();
		if (vo != null && StringUtils.isNotEmpty(vo.getId())) {
			TravelOrder entity = travelOrderService.queryById(vo.getTorderid());
			RouteTemplateVO bean = routeTemplateService.selectById(vo.getRtid());
			bean = RouteTemplateKit.toRecord(RouteTemplateKit.toEntity(bean));
			// TravelStyle ts =	
			// travelStyleService.queryById(bean.getTravelStyle());
			QuoteFormVO qf = quoteFormService.selectById(vo.getId());
			OrderDetailVO od = orderDetailService.queryByOrderId(entity.getId());
			String itemIds = StringUtils.isNotEmpty(bean.getTravelItems()) ? bean.getTravelItems() : "";
			List<String> itids = Arrays.asList(itemIds.split(","));
			List<TravelItemVO> items = travelItemService.queryByAlias(itids);
			// String itemCoverpath = FilePros.httpitemCoverpath();
			// String itemPhotoPath = FilePros.httptravelitemPhotoPath();
			TravelStyle style = (TravelStyle) travelStyleService.queryByAlias(bean.getTravelStyle());
			bean.setTravelStyle(style.getType());
			String mappath = FilePros.httprouteMapPath();
			String coverpath = FilePros.httpRouteCoverpath();
			if (bean != null && StringUtils.isNotEmpty(bean.getRouteMap())) {
				bean.setRouteMap(mappath + "/" + StringUtils.trim(bean.getRouteCode()) + "_" + bean.getAlias() + "/"
						+ bean.getRouteMap());
			}
			if (bean != null && StringUtils.isNotEmpty(bean.getCover())) {
				bean.setCover(coverpath + "/" + StringUtils.trim(bean.getRouteCode()) + "_" + bean.getAlias() + "/"
						+ bean.getCover());
			}
			List<RouteTemplateVO> relates = routeTemplateService.queryByRelatedRoutes(bean.getId());
			bean.setRelates(relates);
			List<String> photoList = Lists.newArrayList();
			String rtPhotoPath = FilePros.httpRoutePhotos();
			String[] photos = StringUtils.isNotEmpty(bean.getViewphotos()) ? bean.getViewphotos().split("\\|")
					: new String[] {};
			for (String photo : photos) {
				photoList.add(StringUtils
						.trim(rtPhotoPath + "/" + bean.getRouteCode() + "_" + bean.getAlias() + "/" + photo));
			}
			bean.setPhotoList(photoList);
			StringBuffer routeLine = new StringBuffer(bean.getDeparture());
			for (TravelItemVO ti : items) {
				routeLine.append("-" + ti.getItem());
			}
			routeLine.append("-" + bean.getArrive());
			bean.setRouteLine(routeLine.toString());
			adultsumcost += Float.parseFloat(qf.getShowTicket().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowTraveldoc().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowTourguide().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowHotel().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowRentcar().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowBigtraffic().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowDinner().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowInsurance().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowComphcost().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowRecreation().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowItemguide().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowBathorse().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowRidehorse().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowClimbregister().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowClimbnexus().split("\\|")[0]);
			adultsumcost += Float.parseFloat(qf.getShowElsecost().split("\\|")[0]);

			childrensumcost += Float.parseFloat(qf.getShowTicket().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowTraveldoc().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowTourguide().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowHotel().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowRentcar().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowBigtraffic().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowDinner().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowInsurance().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowComphcost().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowRecreation().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowItemguide().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowBathorse().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowRidehorse().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowClimbregister().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowClimbnexus().split("\\|")[0]);
			childrensumcost += Float.parseFloat(qf.getShowElsecost().split("\\|")[0]);
			vo.setPlusSumPrice(0f);
			vo.setPlusDevicePrice(0f);
			context.put("adultsumcost", adultsumcost + "");
			context.put("childrensumcost", childrensumcost + "");
			context.put("rtid", vo.getRtid());
			context.put("bean", bean);
			context.put("qf", qf);
			context.put("od", od);
			context.put("torder", entity);
			context.put("vo", vo);
			// context.put("ts", ts);
			Constants.TDQUOTE3.clear();
			Constants.TDQUOTE3.put("adultsumcost", adultsumcost + "");
			Constants.TDQUOTE3.put("childrensumcost", childrensumcost + "");
			Constants.TDQUOTE3.put("rtid", vo.getRtid());
			Constants.TDQUOTE3.put("bean", bean);
			Constants.TDQUOTE3.put("qf", qf);
			Constants.TDQUOTE3.put("od", od);
			Constants.TDQUOTE3.put("torder", entity);
			Constants.TDQUOTE3.put("vo", vo);
			// Constants.TDQUOTE3.put("ts", ts);
		}
		return forward("server/sys/quote_step4", context);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = true, verifyURL = true)
	@RequestMapping(value = "/returntoQuote3/{id}/{routeId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView returntoQuote3(@PathVariable("id") String id, @PathVariable("routeId") String routeId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		OrderDetailVO od = (OrderDetailVO) Constants.TDQUOTE2.get("od");
		TravelOrder to = (TravelOrder) Constants.TDQUOTE2.get("torder");
		RouteTemplateVO bean = (RouteTemplateVO) Constants.TDQUOTE2.get("bean");
		if (bean.getId().equals(routeId) && to.getId().equals(id)) {
			context.put("adultsumcost", Constants.TDQUOTE3.get("adultsumcost"));
			context.put("childrensumcost", Constants.TDQUOTE3.get("childrensumcost"));
			context.put("rtid", Constants.TDQUOTE3.get("rtid"));
			context.put("bean", bean);
			context.put("qf", Constants.TDQUOTE3.get("qf"));
			context.put("od", od);
			context.put("torder", to);
			context.put("vo", Constants.TDQUOTE3.get("vo"));
		}
		return forward("server/sys/quote_step3", context);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Auth(verifyLogin = true, verifyURL = true)
	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	@ResponseBody
	public String generateReport(String basePath,String formContent, String tordername, String idrt, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = "";
		// OrderDetail entity = (OrderDetail) Constants.TDQUOTE3.get("od");
		TravelOrder to = (TravelOrder) Constants.TDQUOTE2.get("torder");
		RouteTemplateVO bean = (RouteTemplateVO) Constants.TDQUOTE2.get("bean");
		if (bean.getId().equals(idrt) && to.getOrderName().equals(tordername)) {
			// OrderDetail od =
			// orderDetailService.queryByOrderId(entity.getId());
			String orderpdfs = FilePros.orderpdfs();
			String orderhtmls = FilePros.orderhtmls();
			String markedorderpdfs = FilePros.markedorderpdfs();
			String httpmarkedorderpdfs = FilePros.httpmarkedorderpdfs();
			String htmlName = to.getOrderNo() + ".html";
			String pdfName = to.getOrderNo() + ".pdf";
			//System.out.println(formContent);
			// writehtmlToPdf(formContent,tordername, torders+pdfName);
			fromhtmlToPdf(basePath,formContent, tordername, orderhtmls + htmlName, orderpdfs + pdfName,markedorderpdfs + pdfName);
			// File attachment = new File(orderpdfs+pdfName);
			String title = "Itours Booking Info";
			String content = "Hello!Dear "  + (to.getGender()==1 ? "Mr" : "Mrs") + to.getReceiver() + "Your information has been booked successfully. Please open the mailbox to view your order details.";
			// String attachment =
			// String httporderpdfs = FilePros.httporderpdfs();
			String pdfurl = httpmarkedorderpdfs + "/" + pdfName;
			if (EmailService.sendEmail(title, to.getReceiveremail(), title, content, markedorderpdfs + pdfName)) {
				result = sendSuccessResult(response, "The reservation is successful, please check the mailbox reservation success later!", pdfurl);
			}
		}
		return result;
	}

	@Auth(verifyLogin = true, verifyURL = true)
	@RequestMapping(value = "/viewReport", method = RequestMethod.POST)
	@ResponseBody
	public String viewReport(String formContent, String tordername, String idrt, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = "";
		String orderpdfs = FilePros.orderpdfs();
		String orderhtmls = FilePros.orderhtmls();
		String httporderpdfs = FilePros.httporderpdfs();
		String htmlName = tordername + ".html";
		List list = new ArrayList();
		Arrays.asList(new String[]{});
		ImmutableList.of("Buenos Aires", "Córdoba", "La Plata");
		String pdfName = tordername + ".pdf";
		return result;
	}

	/**
	 * 
	 * @param content
	 * @param tordername
	 * @param outputFile
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void fromhtmlToPdf(String basePath,String content, String tordername, String htmlpath, String pdfpath,
			String markedorderpdfs) throws DocumentException, IOException {
		// Document document = new Document();
		// document.open();
		String group0 = "<\\s*img\\s+([^>]+)\\s*>";// 整个img标签,group0
		String group1 = "<\\s*input\\s+([^>]+)\\s*>";// 整个input标签,group1
		Pattern pattern0 = Pattern.compile(group0);
		Matcher matcher0 = pattern0.matcher(content);
		while (matcher0.find()) {
			String img = matcher0.group(0);
			content = content.replace(img, img + "</img>");
		}
		content = content.replaceAll("</img></img></img>", "</img>");
		content = content.replaceAll("</img></img>", "</img>");
		Pattern pattern1 = Pattern.compile(group1);
		Matcher matcher1 = pattern1.matcher(content);
		while (matcher1.find()) {
			String input = matcher1.group(0);
			content = content.replace(input, input + "</input>");
		}
		content = content.replaceAll("</input></input>", "</input>");
		content = ImageFilter.replaceImagesrc(content,basePath);
		content = ImageFilter.replaceTdBg(content,basePath);
		// content="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0
		// Transitional//EN'
		// 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> <html
		// xmlns='http://www.w3.org/1999/xhtml'><head><title>"+tordername+"</title></head><body>"+content+"</body></html>";
		content = "<!DOCTYPE html><html><head><meta charset='UTF-8'><meta name='applicable-device' content='pc'>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
				+ "<link rel='stylesheet' type='text/css' href='"+basePath+"css/easytab.css'>"
				+ "<link rel='stylesheet' type='text/css' href='"+basePath+"css/ScrollPic.css'>"
				+ "<script type='text/javascript' src='"+basePath+"js/jquery-easyui-1.5.1/jquery.min.js'></script>"
				+ "<script type='text/javascript' src='"+basePath+"js/commons/ScrollPic.js'></script>"
				+ "<script type='text/javascript' src='"+basePath+"js/plug-in/easytab/jquery.easytabs.min.js'></script>"
				+ "<script type='text/javascript' src='"+basePath+"js/plug-in/easytab/jquery.hashchange.min.js'></script>"
				+ "<title>" + tordername + "</title></head><body><center>" + content
				+ "<table style=width:1350;text-align:center;align:center;font-family: '微软雅黑'; border:0;>"
				+ "<tr><td width='1350' height='30' bgcolor='#EFEFEF'><div align='center' class='STYLE6'>主角旅行 www.iTours.com.cn</div></td></tr>"
				+ "<tr><td height='30' bgcolor='#EFEFEF'><div align='center' class='STYLE6'>Add: 成都一環路南三段15號華僑大廈9層<br />"
				+ "Tel: +86-28-85580038 / 85562905<br />E-mail: info@itours.com.cn </div></td></tr></table></center></body></html>";
		//http://zjj.itours.com.cn/itour/
/*		content = "<!DOCTYPE html><html><head><meta charset='UTF-8'><meta name='applicable-device' content='pc'>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
				+ "<link rel='stylesheet' type='text/css' href='http://zjj.itours.com.cn/itour/css/easytab.css'>"
				+ "<link rel='stylesheet' type='text/css' href='http://zjj.itours.com.cn/itour/css/ScrollPic.css'>"
				+ "<script type='text/javascript' src='http://zjj.itours.com.cn/itour/js/jquery-easyui-1.5.1/jquery.min.js'></script>"
				+ "<script type='text/javascript' src='http://zjj.itours.com.cn/itour/js/commons/ScrollPic.js'></script>"
				+ "<script type='text/javascript' src='http://zjj.itours.com.cn/itour/js/plug-in/easytab/jquery.easytabs.min.js'></script>"
				+ "<script type='text/javascript' src='http://zjj.itours.com.cn/itour/js/plug-in/easytab/jquery.hashchange.min.js'></script>"
				+ "<title>" + tordername + "</title></head><body><center>" + content
				+ "<table style=width:1350;text-align:center;align:center;font-family: '微软雅黑'; border:0;>"
				+ "<tr><td width='1350' height='30' bgcolor='#EFEFEF'><div align='center' class='STYLE6'>主角旅行 www.iTours.com.cn</div></td></tr>"
				+ "<tr><td height='30' bgcolor='#EFEFEF'><div align='center' class='STYLE6'>Add: 成都一環路南三段15號華僑大廈9層<br />"
				+ "Tel: +86-28-85580038 / 85562905<br />E-mail: info@itours.com.cn </div></td></tr></table></center></body></html>";*/
		// ByteArrayInputStream stream = new
		// ByteArrayInputStream(content.getBytes());
		// InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
		File htmlfile = new File(htmlpath);
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlfile), "UTF-8"));  
		writer.write(content);  
		writer.flush();  
		//Writer writer = new FileWriter(htmlfile);
		//System.out.println(content);
		//writer.write(content);// new String(content.getBytes(),"utf-8")
		writer.close();		   
		HtmlToPdf.convert(htmlpath, pdfpath);
		PdfReader pdfReader = new PdfReader(pdfpath);
		// Get the PdfStamper object
		PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(markedorderpdfs));
		WaterMarkUtilPDF.addWatermark(pdfStamper, "www.itours.com.cn");
		pdfStamper.close();
		// System.out.println( "PDF Created!" );
	}
}
