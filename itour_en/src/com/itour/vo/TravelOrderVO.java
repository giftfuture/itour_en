package com.itour.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;
import com.itour.entity.OrderDetail;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class TravelOrderVO extends BasePage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8753408936131541053L;
	private java.lang.String id;//   	private String createTime;//   	private String updateTime;//   	private java.lang.String orderName;//   	private java.lang.String orderNo;//   	private java.lang.Integer orderStatus;//   	private java.lang.String remark;//   	private java.lang.String customerId;//   	private java.lang.String receiver;//   	private java.lang.String receiverMobile;//   	private String expectedDepart;//   	private String expectedBack;//   	private java.lang.Integer totalStaff;//   本次订单出行人数	private java.lang.String payed;//   是否支付完成.	private java.lang.String payType;//   1=线上支付,2=现金支付,3=邮政汇款,4=公司转帐	private java.lang.String payPlatform;//   付款平台,如1=微信,2=支付宝,3=网银.	private java.lang.String bank;//   如网银支付,即为付款方银行	private java.lang.String payAccount;//   付款方银行帐户	private String payTime;//   付款时间	private java.lang.String payTerminal;//   付款终端,如有,则为PC,IOS,Android
	private List<OrderDetail> orderItems;
	private int valid;
	private BigDecimal budget;  //旅行预算
	private String routename;
	private String receiveremail;
	private int gender;
	private String routeTitle;//路线名称
	private String routeAlias;//路线别名
	private String routeId;
	
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getRouteTitle() {
		return routeTitle;
	}
	public void setRouteTitle(String routeTitle) {
		this.routeTitle = routeTitle;
	}
	public String getRouteAlias() {
		return routeAlias;
	}
	public void setRouteAlias(String routeAlias) {
		this.routeAlias = routeAlias;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public String getReceiveremail() {
		return receiveremail;
	}
	public void setReceiveremail(String receiveremail) {
		this.receiveremail = receiveremail;
	}
	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public java.lang.String getOrderName() {
		return orderName;
	}
	public void setOrderName(java.lang.String orderName) {
		this.orderName = orderName;
	}
	public java.lang.String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}
	public java.lang.Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(java.lang.Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public java.lang.String getReceiver() {
		return receiver;
	}
	public void setReceiver(java.lang.String receiver) {
		this.receiver = receiver;
	}
	public java.lang.String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(java.lang.String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(java.lang.String customerId) {
		this.customerId = customerId;
	}
	public java.lang.Integer getTotalStaff() {
		return totalStaff;
	}
	public void setTotalStaff(java.lang.Integer totalStaff) {
		this.totalStaff = totalStaff;
	}
	public java.lang.String getPayed() {
		return payed;
	}
	public void setPayed(java.lang.String payed) {
		this.payed = payed;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public java.lang.String getPayType() {
		return payType;
	}
	public void setPayType(java.lang.String payType) {
		this.payType = payType;
	}
	public java.lang.String getPayPlatform() {
		return payPlatform;
	}
	public void setPayPlatform(java.lang.String payPlatform) {
		this.payPlatform = payPlatform;
	}
	public java.lang.String getBank() {
		return bank;
	}
	public void setBank(java.lang.String bank) {
		this.bank = bank;
	}
	public java.lang.String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(java.lang.String payAccount) {
		this.payAccount = payAccount;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getExpectedDepart() {
		return expectedDepart;
	}
	public void setExpectedDepart(String expectedDepart) {
		this.expectedDepart = expectedDepart;
	}
	public String getExpectedBack() {
		return expectedBack;
	}
	public void setExpectedBack(String expectedBack) {
		this.expectedBack = expectedBack;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public java.lang.String getPayTerminal() {
		return payTerminal;
	}
	public void setPayTerminal(java.lang.String payTerminal) {
		this.payTerminal = payTerminal;
	}
	public List<OrderDetail> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderDetail> orderItems) {
		this.orderItems = orderItems;
	}
	
}

