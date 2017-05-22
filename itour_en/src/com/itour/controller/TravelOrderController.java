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
import com.itour.base.easyui.DataGridAdapter;
import com.itour.base.easyui.EasyUIGrid;
import com.itour.base.json.JsonUtils;
import com.itour.base.page.BasePage;
import com.itour.base.util.DateUtil;
import com.itour.base.util.FilePros;
import com.itour.base.util.HtmlToPdf;
import com.itour.base.util.IDGenerator;
import com.itour.base.util.SessionUtils;
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
import com.itour.vo.CalculateQuoteVo;
import com.itour.vo.OrderDetailVo;
import com.itour.vo.QuoteFormVo;
import com.itour.vo.RouteTemplateVo;
import com.itour.vo.TravelItemVo;
import com.itour.vo.TravelOrderVo;
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
	public ModelAndView list(TravelOrderVo page, HttpServletRequest request) throws Exception {
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
	public EasyUIGrid datalist(TravelOrderVo vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// List<TravelOrder> dataList = travelOrderService.queryByList(page);
		BasePage<TravelOrderVo> pagination = travelOrderService.pagedQuery(vo);
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
	public String save(TravelOrderVo entity, HttpServletRequest request, HttpServletResponse response)
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
	public String booking(@RequestBody OrderDetailVo entity, HttpServletRequest request, HttpServletResponse response)
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
		customers.setValid(true);
		customers.setIntroduction("");
		customers.setStatus(1);
		customers.setNickName(entity.getReceiver());
		String customerId = customersService.add(customers);
		TravelOrderVo to = new TravelOrderVo();
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
		to.setGender(entity.isGender());
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
		String odId = orderDetailService.add(OrderDetailKit.toEntity(entity));
		String title = "主角旅行itours网站";
		String content = "尊敬的客户" + entity.getReceiver() + (entity.isGender() ? "先生" : "女士")
				+ "您好：您的预定信息已收到，预定成功信息将于24小时内发送到您的邮箱，请留意查看";
		if (EmailService.sendEmail(title, receiveremail, title, content, "")) {
			String result = sendSuccessResult(response, "预定成功，请稍后查看邮箱预定成功信息！");
			return result;
		} else {
			String result = sendSuccessResult(response, "预定成功，邮件未发送成功,请等待客服24小时内发送预定成功信息到您的邮箱！");
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
						"update travel_order set is_valid=0 where id in(" + JsonUtils.encode(id) + ")", "")); 
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
	@RequestMapping(value = "/toQuote1", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toQuote1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		// context.put("items", items);
		// context.put("rt", rt);
		return forward("front/trek/quote_step1", context);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toQuote2/{id}/{routeId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView toQuote2(@PathVariable("id") String id, @PathVariable("routeId") String routeId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		TravelOrder entity = travelOrderService.queryById(id);
		RouteTemplateVo bean = routeTemplateService.selectById(routeId);
		OrderDetail od = orderDetailService.queryByOrderId(entity.getId());
		QuoteFormVo qf = quoteFormService.queryByRtId(bean.getId());
		// RouteTemplateVo bean = routeTemplateService.selectById(id);
		if (bean == null || entity == null || qf == null) {
			context.put(SUCCESS, false);
			context.put("bean", "没有找到对应的记录!");
			return forward(request.getHeader("Referer"), context);
		}
		context.put(SUCCESS, true);
		context.put("bean", bean);
		context.put("qf", qf);
		context.put("torder", entity);
		context.put("od", od);
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
	public ModelAndView toQuote3(CalculateQuoteVo vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Float adultsumcost = 0f;
		Float childrensumcost = 0f;
		Map<String, Object> context = getRootMap();
		if (vo != null && StringUtils.isNotEmpty(vo.getId())) {
			TravelOrder entity = travelOrderService.queryById(vo.getTorderid());
			RouteTemplateVo bean = routeTemplateService.selectById(vo.getRtid());
			QuoteFormVo qf = quoteFormService.queryByRtId(bean.getId());
			OrderDetail od = orderDetailService.queryByOrderId(entity.getId());
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
			context.put("calvo", vo);
			Constants.TDQUOTE2.clear();
			Constants.TDQUOTE2.put("adultsumcost", adultsumcost + "");
			Constants.TDQUOTE2.put("childrensumcost", childrensumcost + "");
			Constants.TDQUOTE2.put("rtid", vo.getRtid());
			Constants.TDQUOTE2.put("bean", bean);
			Constants.TDQUOTE2.put("qf", qf);
			Constants.TDQUOTE2.put("od", od);
			Constants.TDQUOTE2.put("torder", entity);
			Constants.TDQUOTE2.put("calvo", vo);
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
		OrderDetail od = (OrderDetail) Constants.TDQUOTE2.get("od");
		TravelOrder to = (TravelOrder) Constants.TDQUOTE2.get("torder");
		RouteTemplateVo bean = (RouteTemplateVo) Constants.TDQUOTE2.get("bean");
		if (bean.getId().equals(routeId) && to.getId().equals(id)) {
			context.put("adultsumcost", Constants.TDQUOTE2.get("adultsumcost"));
			context.put("childrensumcost", Constants.TDQUOTE2.get("childrensumcost"));
			context.put("rtid", Constants.TDQUOTE2.get("rtid"));
			context.put("bean", bean);
			context.put("qf", Constants.TDQUOTE2.get("qf"));
			context.put("od", od);
			context.put("torder", to);
			context.put("calvo", Constants.TDQUOTE2.get("calvo"));
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
	public ModelAndView toQuote4(CalculateQuoteVo vo, HttpServletRequest request, HttpServletResponse response)throws Exception {
		Float adultsumcost = 0f;
		Float childrensumcost = 0f;
		Map<String, Object> context = getRootMap();
		if (vo != null && StringUtils.isNotEmpty(vo.getId())) {
			TravelOrder entity = travelOrderService.queryById(vo.getTorderid());
			RouteTemplateVo bean = routeTemplateService.selectById(vo.getRtid());
			bean = RouteTemplateKit.toRecord(RouteTemplateKit.toEntity(bean));
			// TravelStyle ts =	
			// travelStyleService.queryById(bean.getTravelStyle());
			QuoteFormVo qf = quoteFormService.selectById(vo.getId());
			OrderDetail od = orderDetailService.queryByOrderId(entity.getId());
			String itemIds = StringUtils.isNotEmpty(bean.getTravelItems()) ? bean.getTravelItems() : "";
			List<String> itids = Arrays.asList(itemIds.split(","));
			List<TravelItemVo> items = travelItemService.queryByAlias(itids);
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
			if (bean != null && StringUtils.isNotEmpty(bean.getRelated())) {
				String[] ids = bean.getRelated().split(",");
				List<RouteTemplateVo> relates = routeTemplateService.queryByRelated(Arrays.asList(ids));
				for (RouteTemplateVo rtp : relates) {
					TravelStyle ts = (TravelStyle) travelStyleService.queryById(rtp.getTravelStyle());
					if (ts != null) {
						rtp.setTravelStyleAlias(ts.getAlias());
					}
				}
				bean.setRelates(relates);
			}
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
			for (TravelItemVo ti : items) {
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
			context.put("calvo", vo);
			// context.put("ts", ts);
			Constants.TDQUOTE3.clear();
			Constants.TDQUOTE3.put("adultsumcost", adultsumcost + "");
			Constants.TDQUOTE3.put("childrensumcost", childrensumcost + "");
			Constants.TDQUOTE3.put("rtid", vo.getRtid());
			Constants.TDQUOTE3.put("bean", bean);
			Constants.TDQUOTE3.put("qf", qf);
			Constants.TDQUOTE3.put("od", od);
			Constants.TDQUOTE3.put("torder", entity);
			Constants.TDQUOTE3.put("calvo", vo);
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
		OrderDetail od = (OrderDetail) Constants.TDQUOTE2.get("od");
		TravelOrder to = (TravelOrder) Constants.TDQUOTE2.get("torder");
		RouteTemplateVo bean = (RouteTemplateVo) Constants.TDQUOTE2.get("bean");
		if (bean.getId().equals(routeId) && to.getId().equals(id)) {
			context.put("adultsumcost", Constants.TDQUOTE3.get("adultsumcost"));
			context.put("childrensumcost", Constants.TDQUOTE3.get("childrensumcost"));
			context.put("rtid", Constants.TDQUOTE3.get("rtid"));
			context.put("bean", bean);
			context.put("qf", Constants.TDQUOTE3.get("qf"));
			context.put("od", od);
			context.put("torder", to);
			context.put("calvo", Constants.TDQUOTE3.get("calvo"));
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
	public String generateReport(String formContent, String tordername, String idrt, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = "";
		// OrderDetail entity = (OrderDetail) Constants.TDQUOTE3.get("od");
		TravelOrder to = (TravelOrder) Constants.TDQUOTE2.get("torder");
		RouteTemplateVo bean = (RouteTemplateVo) Constants.TDQUOTE2.get("bean");
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
			fromhtmlToPdf(formContent, tordername, orderhtmls + htmlName, orderpdfs + pdfName,markedorderpdfs + pdfName);
			// File attachment = new File(orderpdfs+pdfName);
			String title = "主角旅行itours网站";
			String content = "尊敬的客户" + to.getReceiver() + (to.isGender() ? "先生" : "女士") + "您好：您的信息已经预定成功。请打开邮箱查看您的订单详情";
			// String attachment =
			// String httporderpdfs = FilePros.httporderpdfs();
			String pdfurl = httpmarkedorderpdfs + "/" + pdfName;
			if (EmailService.sendEmail(title, to.getReceiveremail(), title, content, markedorderpdfs + pdfName)) {
				result = sendSuccessResult(response, "预定成功，请稍后查看邮箱预定成功信息！", pdfurl);
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
	public static void fromhtmlToPdf(String content, String tordername, String htmlpath, String pdfpath,
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
		// content="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0
		// Transitional//EN'
		// 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> <html
		// xmlns='http://www.w3.org/1999/xhtml'><head><title>"+tordername+"</title></head><body>"+content+"</body></html>";
		content = "<!DOCTYPE html><html><head><meta charset='UTF-8'><meta name='applicable-device' content='pc'>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
				+ "<link rel='stylesheet' type='text/css' href='http://localhost:8080/itour/css/easytab.css'>"
				+ "<link rel='stylesheet' type='text/css' href='http://localhost:8080/itour/css/ScrollPic.css'>"
				+ "<script type='text/javascript' src='http://localhost:8080/itour/js/jquery-easyui-1.5.1/jquery.min.js'></script>"
				+ "<script type='text/javascript' src='http://localhost:8080/itour/js/commons/ScrollPic.js'></script>"
				+ "<script type='text/javascript' src='http://localhost:8080/itour/js/plug-in/easytab/jquery.easytabs.min.js'></script>"
				+ "<script type='text/javascript' src='http://localhost:8080/itour/js/plug-in/easytab/jquery.hashchange.min.js'></script>"
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
