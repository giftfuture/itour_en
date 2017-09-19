package com.itour.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;

/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;
import com.itour.entity.OrderDetail;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class TravelOrderVO extends BasePage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8753408936131541053L;
	private java.lang.String id;//   	private String createTime;//   	private String updateTime;//   	private java.lang.String orderName;//   	private java.lang.String orderNo;//   	private java.lang.Integer orderStatus;//   	private java.lang.String remark;//   	private java.lang.String customerId;//   	private java.lang.String receiver;//   	private java.lang.String receiverMobile;//   	private String expectedDepart;//   	private String expectedBack;//   	private java.lang.Integer totalStaff;//   本次订单出行人数	private java.lang.String payed;//   是否支付完成.	private java.lang.String payType;//   1=线上支付,2=现金支付,3=邮政汇款,4=公司转帐	private java.lang.String payPlatform;//   付款平台,如1=微信,2=支付宝,3=网银.	private java.lang.String bank;//   如网银支付,即为付款方银行	private java.lang.String payAccount;//   付款方银行帐户	private String payTime;//   付款时间	private java.lang.String payTerminal;//   付款终端,如有,则为PC,IOS,Android
	private List<OrderDetail> orderItems;
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private BigDecimal budget;  //旅行预算
	private String routename;
	@Email
	private String receiveremail;
    @Min(value = 0, message = "gender 的最小值为0")
    @Max(value = 1, message = "gender 的最大值为1")
	private int gender;
	private String routeTitle;//路线名称
	private String routeAlias;//路线别名
	private String routeId;
	
	
	
	private java.lang.String content;//   
	private java.lang.Float perPrice;//   
	private java.lang.Float count;//   
	private java.lang.String orderId;//
	private int adults;
	private int children;
	private String groupCode;//团号
	private String groupDate;//出团日期
	private String travelfashion;
	private String singleorcluster;
	private String travelrequest;
	private String hotel;
	private String stayrequest;
	private String traffic;
	private String tickets;
	private String foodrequest;
	private String recreation;
	private String specialrequest;
	private String travelOrder;//所属订单 
	private String comefrom;
	private String areaname;
	private String guide;
	private String guide_other;
	private String foodArrange;
	private String taste;
	private String hatefood;
	private String train;
	private String cruise;
	private String car_new;
	private String car_no_smoking;
	private String car;
	private String shipping_space;
	private String plane;
	private String hotel_info;
	private String hotel_quiet;
	private String hotel_no_smoking;
	private int suite;
	private int db_room;
	private int bb_room;
	private String position;
	private String verifyCode;
	
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
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.Float getPerPrice() {
		return perPrice;
	}
	public void setPerPrice(java.lang.Float perPrice) {
		this.perPrice = perPrice;
	}
	public java.lang.Float getCount() {
		return count;
	}
	public void setCount(java.lang.Float count) {
		this.count = count;
	}
	public java.lang.String getOrderId() {
		return orderId;
	}
	public void setOrderId(java.lang.String orderId) {
		this.orderId = orderId;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupDate() {
		return groupDate;
	}
	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}
	public String getTravelfashion() {
		return travelfashion;
	}
	public void setTravelfashion(String travelfashion) {
		this.travelfashion = travelfashion;
	}
	public String getSingleorcluster() {
		return singleorcluster;
	}
	public void setSingleorcluster(String singleorcluster) {
		this.singleorcluster = singleorcluster;
	}
	public String getTravelrequest() {
		return travelrequest;
	}
	public void setTravelrequest(String travelrequest) {
		this.travelrequest = travelrequest;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getStayrequest() {
		return stayrequest;
	}
	public void setStayrequest(String stayrequest) {
		this.stayrequest = stayrequest;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getTickets() {
		return tickets;
	}
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	public String getFoodrequest() {
		return foodrequest;
	}
	public void setFoodrequest(String foodrequest) {
		this.foodrequest = foodrequest;
	}
	public String getRecreation() {
		return recreation;
	}
	public void setRecreation(String recreation) {
		this.recreation = recreation;
	}
	public String getSpecialrequest() {
		return specialrequest;
	}
	public void setSpecialrequest(String specialrequest) {
		this.specialrequest = specialrequest;
	}
	public String getTravelOrder() {
		return travelOrder;
	}
	public void setTravelOrder(String travelOrder) {
		this.travelOrder = travelOrder;
	}
	public String getComefrom() {
		return comefrom;
	}
	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public String getGuide_other() {
		return guide_other;
	}
	public void setGuide_other(String guide_other) {
		this.guide_other = guide_other;
	}
	public String getFoodArrange() {
		return foodArrange;
	}
	public void setFoodArrange(String foodArrange) {
		this.foodArrange = foodArrange;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getHatefood() {
		return hatefood;
	}
	public void setHatefood(String hatefood) {
		this.hatefood = hatefood;
	}
	public String getTrain() {
		return train;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public String getCruise() {
		return cruise;
	}
	public void setCruise(String cruise) {
		this.cruise = cruise;
	}
	public String getCar_new() {
		return car_new;
	}
	public void setCar_new(String car_new) {
		this.car_new = car_new;
	}
	public String getCar_no_smoking() {
		return car_no_smoking;
	}
	public void setCar_no_smoking(String car_no_smoking) {
		this.car_no_smoking = car_no_smoking;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getShipping_space() {
		return shipping_space;
	}
	public void setShipping_space(String shipping_space) {
		this.shipping_space = shipping_space;
	}
	public String getPlane() {
		return plane;
	}
	public void setPlane(String plane) {
		this.plane = plane;
	}
	public String getHotel_info() {
		return hotel_info;
	}
	public void setHotel_info(String hotel_info) {
		this.hotel_info = hotel_info;
	}
	public String getHotel_quiet() {
		return hotel_quiet;
	}
	public void setHotel_quiet(String hotel_quiet) {
		this.hotel_quiet = hotel_quiet;
	}
	public String getHotel_no_smoking() {
		return hotel_no_smoking;
	}
	public void setHotel_no_smoking(String hotel_no_smoking) {
		this.hotel_no_smoking = hotel_no_smoking;
	}
	public int getSuite() {
		return suite;
	}
	public void setSuite(int suite) {
		this.suite = suite;
	}
	public int getDb_room() {
		return db_room;
	}
	public void setDb_room(int db_room) {
		this.db_room = db_room;
	}
	public int getBb_room() {
		return bb_room;
	}
	public void setBb_room(int bb_room) {
		this.bb_room = bb_room;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}

