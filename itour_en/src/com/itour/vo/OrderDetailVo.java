package com.itour.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class OrderDetailVo extends BasePage implements Serializable{
	
		private java.lang.String id;//   	private java.lang.Integer status;//   	private String createTime;//   	private String updateTime;//   	private java.lang.String content;//   	private java.lang.String remark;//   	private java.lang.Float perPrice;//   	private java.lang.Float count;//   	private java.lang.String orderId;//   
	private boolean isValid;
	private int adults;
	private int children;
	private String groupCode;//团号
	private String groupDate;//出团日期
	private String travelfashion;
	private String singleorcluster;
	private String travelrequest;
	private String hotel;
	//private String requestdetail;
	private String stayrequest;
	private String traffic;
	private String tickets;
	private String foodrequest;
	private String recreation;
	private String specialrequest;
	private String travelOrder;//所属订单 
	private String comefrom;
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
	
	private BigDecimal budget;  //旅行预算
	private String routename;
	private String receiveremail;
	private boolean gender;
	private java.lang.String receiver;//   
	private java.lang.String receiverMobile;//   
	private String expectedDepart;//   
	private String expectedBack;//
	
	
	
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
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
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getGuide_other() {
		return guide_other;
	}
	public void setGuide_other(String guide_other) {
		this.guide_other = guide_other;
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
	public String getComefrom() {
		return comefrom;
	}
	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public String getTravelOrder() {
		return travelOrder;
	}
	public void setTravelOrder(String travelOrder) {
		this.travelOrder = travelOrder;
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
	public String getFoodArrange() {
		return foodArrange;
	}
	public void setFoodArrange(String foodArrange) {
		this.foodArrange = foodArrange;
	}
	public String getSpecialrequest() {
		return specialrequest;
	}
	public void setSpecialrequest(String specialrequest) {
		this.specialrequest = specialrequest;
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
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
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
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
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
}

