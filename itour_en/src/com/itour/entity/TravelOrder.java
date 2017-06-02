package com.itour.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.itour.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>TravelOrderEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelOrder extends BaseEntity {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 8753408936131541053L;
	private java.lang.String id;//   
	private Date createTime;//   	private Date updateTime;//   	private java.lang.String orderName;//   	private java.lang.String orderNo;//   	private java.lang.Integer orderStatus;//   	private java.lang.String receiver;//   	private java.lang.String receiverMobile;//   	private java.lang.String remark;//   	private java.lang.String customerId;//   	private Date expectedDepart;//   	private Date expectedBack;//  	private java.lang.Integer totalStaff;//   本次订单出行人数	private java.lang.String payed;//   是否支付完成.	private java.lang.String payType;//   1=线上支付,2=现金支付,3=邮政汇款,4=公司转帐	private java.lang.String payPlatform;//   付款平台,如1=微信,2=支付宝,3=网银.	private java.lang.String bank;//   如网银支付,即为付款方银行	private java.lang.String payAccount;//   付款方银行帐户	private Date payTime;//   付款时间	private java.lang.String payTerminal;//   付款终端,如有,则为PC,IOS,Android	private BigDecimal budget;  //旅行预算
	
	private List<OrderDetail> orderItems;
	private int valid;
	
	private String routename;
	private String receiveremail;
	private int gender;
	private String routeId;
		public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getExpectedDepart() {
		return expectedDepart;
	}
	public void setExpectedDepart(Date expectedDepart) {
		this.expectedDepart = expectedDepart;
	}
	public Date getExpectedBack() {
		return expectedBack;
	}
	public void setExpectedBack(Date expectedBack) {
		this.expectedBack = expectedBack;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
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

