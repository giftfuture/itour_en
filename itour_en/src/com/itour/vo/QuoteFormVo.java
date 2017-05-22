package com.itour.vo;

import java.io.Serializable;
import java.util.Date;

import com.itour.base.page.BasePage;

public class QuoteFormVo extends BasePage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7575774322948827879L;
	
	private String id;
	private String routeTemplate;//所属路线
	private String beriefTrip;//简要行程
	private String showTrip;//文本固定化的行程
	private int adults;
	private int children;
	private boolean isAsAdult;
	private boolean isAsChild;
	private String ticketBlock;//门票明细
	private boolean ticketAsadult;//小孩门票是否按孩子核算
	private String travelDocs;//旅行证件
	private boolean traveldocAsadult;//小孩旅行证件是否按孩子核算
	private String tourGuide;//导游
	private boolean tourguideAsadult;//小孩导游是否按孩子核算
	private String hotel;//酒店
	private boolean hotelAsadult;//小孩住酒店是否按孩子核算
	private String rentCar;//用车情况
	private boolean rentcarAsadult;//小孩用车是否按孩子核算
	private boolean bigTrafficSum;//true=计入总价，false=另外核算
	private String bigTraffic;//大交通
	private boolean bigtrafficeAsadult;//小孩大交通是否按孩子核算
	private String dinner;//用餐
	private boolean dinnerAsadult;//小孩用餐是否按孩子核算
	private String insurance;//保险
	private boolean insuranceAsadult;//小孩保险是否按孩子核算
	private String comprehensiveCosts;//综合费用 
	private boolean comphcostAsadult;//小孩子综合费用是否按孩子核算
	private String recreation;//娱乐费用
	private boolean recreationAsadult;//小孩娱乐费用是否按孩子核算
	private String itemGuide;//向导
	private boolean itemguideAsadult;//小孩向导费用是否按孩子核算
	private String bathorseCost;//驮马费
	private boolean bathcostAsadult;//小孩驮马费是否按孩子核算
	private String ridehorseCost;//骑马费
	private boolean ridecostAsadult;//小孩骑马费是否按孩子核算
	private String climbRegisterCost;//登山注册费
	private boolean climbrcostAsadult;//小孩登山注册费是否按孩子核算
	private String climbNexusCost;//登协联络官
	private boolean climbncostAsadult;//小孩登协联络官是否按孩子核算
	private String elseCost;//其他费用
	private boolean elsecostAsadult;//小孩其他费用是否按孩子核算
	private String presented;//赠送
	private String remark;
	private boolean valid;
	private String createBy;
	private String createTime;
	private String updateTime;
	private String updateBy;
	private String groupCode;//团号
	private String groupDate;//出团日期
	private String showTicket;//前端显示的票价信息
	private String showTraveldoc;//前端显示的旅行证件信息 
	private String showTourguide;//前端显示的旅行导游信息
	private String showHotel;//前端显示的酒店信息
	private String showRentcar;//前端显示的租车信息
	private String showBigtraffic;//前端显示的大交通信息
	private String showDinner;//前端显示的用餐信息
	private String showInsurance;//前端显示的保险信息
	private String showComphcost;//前端显示的综合费用
	private String showRecreation;//前端显示的娱乐费用
	private String showItemguide;//前端显示的单项向导费用
	private String showBathorse;//前端显示的驮马费
	private String showRidehorse;//前端显示的骑马费
	private String showClimbregister;//前端显示的登山注册费
	private String showClimbnexus;//前端显示的登协联络官
	private String showElsecost;//前端显示的其他费用
	private String showPresented;//前端显示的赠品
	private float adultsQuote;//大人报价
	private float childquote;//小孩报价
	private String agodaDetail;//详细日程
	
	
	public String getAgodaDetail() {
		return agodaDetail;
	}
	public void setAgodaDetail(String agodaDetail) {
		this.agodaDetail = agodaDetail;
	}
	public float getAdultsQuote() {
		return adultsQuote;
	}
	public void setAdultsQuote(float adultsQuote) {
		this.adultsQuote = adultsQuote;
	}
	public float getChildquote() {
		return childquote;
	}
	public void setChildquote(float childquote) {
		this.childquote = childquote;
	}
	public String getShowTicket() {
		return showTicket;
	}
	public void setShowTicket(String showTicket) {
		this.showTicket = showTicket;
	}
	public String getShowTraveldoc() {
		return showTraveldoc;
	}
	public void setShowTraveldoc(String showTraveldoc) {
		this.showTraveldoc = showTraveldoc;
	}
	public String getShowTourguide() {
		return showTourguide;
	}
	public void setShowTourguide(String showTourguide) {
		this.showTourguide = showTourguide;
	}
	public String getShowHotel() {
		return showHotel;
	}
	public void setShowHotel(String showHotel) {
		this.showHotel = showHotel;
	}
	public String getShowRentcar() {
		return showRentcar;
	}
	public void setShowRentcar(String showRentcar) {
		this.showRentcar = showRentcar;
	}
	public String getShowBigtraffic() {
		return showBigtraffic;
	}
	public void setShowBigtraffic(String showBigtraffic) {
		this.showBigtraffic = showBigtraffic;
	}
	public String getShowDinner() {
		return showDinner;
	}
	public void setShowDinner(String showDinner) {
		this.showDinner = showDinner;
	}
	public String getShowInsurance() {
		return showInsurance;
	}
	public void setShowInsurance(String showInsurance) {
		this.showInsurance = showInsurance;
	}
	public String getShowComphcost() {
		return showComphcost;
	}
	public void setShowComphcost(String showComphcost) {
		this.showComphcost = showComphcost;
	}
	public String getShowRecreation() {
		return showRecreation;
	}
	public void setShowRecreation(String showRecreation) {
		this.showRecreation = showRecreation;
	}
	public String getShowItemguide() {
		return showItemguide;
	}
	public void setShowItemguide(String showItemguide) {
		this.showItemguide = showItemguide;
	}
	public String getShowBathorse() {
		return showBathorse;
	}
	public void setShowBathorse(String showBathorse) {
		this.showBathorse = showBathorse;
	}
	public String getShowRidehorse() {
		return showRidehorse;
	}
	public void setShowRidehorse(String showRidehorse) {
		this.showRidehorse = showRidehorse;
	}
	public String getShowClimbregister() {
		return showClimbregister;
	}
	public void setShowClimbregister(String showClimbregister) {
		this.showClimbregister = showClimbregister;
	}
	public String getShowClimbnexus() {
		return showClimbnexus;
	}
	public void setShowClimbnexus(String showClimbnexus) {
		this.showClimbnexus = showClimbnexus;
	}
	public String getShowElsecost() {
		return showElsecost;
	}
	public void setShowElsecost(String showElsecost) {
		this.showElsecost = showElsecost;
	}
	public String getShowPresented() {
		return showPresented;
	}
	public void setShowPresented(String showPresented) {
		this.showPresented = showPresented;
	}
	public String getShowTrip() {
		return showTrip;
	}
	public void setShowTrip(String showTrip) {
		this.showTrip = showTrip;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRouteTemplate() {
		return routeTemplate;
	}
	public void setRouteTemplate(String routeTemplate) {
		this.routeTemplate = routeTemplate;
	}
	public String getBeriefTrip() {
		return beriefTrip;
	}
	public void setBeriefTrip(String beriefTrip) {
		this.beriefTrip = beriefTrip;
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
	public boolean isAsAdult() {
		return isAsAdult;
	}
	public void setAsAdult(boolean isAsAdult) {
		this.isAsAdult = isAsAdult;
	}
	public String getTicketBlock() {
		return ticketBlock;
	}
	public void setTicketBlock(String ticketBlock) {
		this.ticketBlock = ticketBlock;
	}
	public String getTourGuide() {
		return tourGuide;
	}
	public void setTourGuide(String tourGuide) {
		this.tourGuide = tourGuide;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getRentCar() {
		return rentCar;
	}
	public void setRentCar(String rentCar) {
		this.rentCar = rentCar;
	}
	public boolean isBigTrafficSum() {
		return bigTrafficSum;
	}
	public void setBigTrafficSum(boolean bigTrafficSum) {
		this.bigTrafficSum = bigTrafficSum;
	}
	public String getBigTraffic() {
		return bigTraffic;
	}
	public void setBigTraffic(String bigTraffic) {
		this.bigTraffic = bigTraffic;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getComprehensiveCosts() {
		return comprehensiveCosts;
	}
	public void setComprehensiveCosts(String comprehensiveCosts) {
		this.comprehensiveCosts = comprehensiveCosts;
	}
	public String getRecreation() {
		return recreation;
	}
	public void setRecreation(String recreation) {
		this.recreation = recreation;
	}
	public String getItemGuide() {
		return itemGuide;
	}
	public void setItemGuide(String itemGuide) {
		this.itemGuide = itemGuide;
	}
	public String getBathorseCost() {
		return bathorseCost;
	}
	public void setBathorseCost(String bathorseCost) {
		this.bathorseCost = bathorseCost;
	}
	public String getRidehorseCost() {
		return ridehorseCost;
	}
	public void setRidehorseCost(String ridehorseCost) {
		this.ridehorseCost = ridehorseCost;
	}
	public String getClimbRegisterCost() {
		return climbRegisterCost;
	}
	public void setClimbRegisterCost(String climbRegisterCost) {
		this.climbRegisterCost = climbRegisterCost;
	}
	public String getClimbNexusCost() {
		return climbNexusCost;
	}
	public void setClimbNexusCost(String climbNexusCost) {
		this.climbNexusCost = climbNexusCost;
	}
	public String getElseCost() {
		return elseCost;
	}
	public void setElseCost(String elseCost) {
		this.elseCost = elseCost;
	}
	public String getPresented() {
		return presented;
	}
	public void setPresented(String presented) {
		this.presented = presented;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public boolean isTicketAsadult() {
		return ticketAsadult;
	}
	public void setTicketAsadult(boolean ticketAsadult) {
		this.ticketAsadult = ticketAsadult;
	}
	public String getTravelDocs() {
		return travelDocs;
	}
	public void setTravelDocs(String travelDocs) {
		this.travelDocs = travelDocs;
	}
	public boolean isTraveldocAsadult() {
		return traveldocAsadult;
	}
	public void setTraveldocAsadult(boolean traveldocAsadult) {
		this.traveldocAsadult = traveldocAsadult;
	}
	public boolean isTourguideAsadult() {
		return tourguideAsadult;
	}
	public void setTourguideAsadult(boolean tourguideAsadult) {
		this.tourguideAsadult = tourguideAsadult;
	}
	public boolean isHotelAsadult() {
		return hotelAsadult;
	}
	public void setHotelAsadult(boolean hotelAsadult) {
		this.hotelAsadult = hotelAsadult;
	}
	public boolean isRentcarAsadult() {
		return rentcarAsadult;
	}
	public void setRentcarAsadult(boolean rentcarAsadult) {
		this.rentcarAsadult = rentcarAsadult;
	}
	public boolean isBigtrafficeAsadult() {
		return bigtrafficeAsadult;
	}
	public void setBigtrafficeAsadult(boolean bigtrafficeAsadult) {
		this.bigtrafficeAsadult = bigtrafficeAsadult;
	}
	public boolean isDinnerAsadult() {
		return dinnerAsadult;
	}
	public void setDinnerAsadult(boolean dinnerAsadult) {
		this.dinnerAsadult = dinnerAsadult;
	}
	public boolean isInsuranceAsadult() {
		return insuranceAsadult;
	}
	public void setInsuranceAsadult(boolean insuranceAsadult) {
		this.insuranceAsadult = insuranceAsadult;
	}
	public boolean isComphcostAsadult() {
		return comphcostAsadult;
	}
	public void setComphcostAsadult(boolean comphcostAsadult) {
		this.comphcostAsadult = comphcostAsadult;
	}
	public boolean isRecreationAsadult() {
		return recreationAsadult;
	}
	public void setRecreationAsadult(boolean recreationAsadult) {
		this.recreationAsadult = recreationAsadult;
	}
	public boolean isItemguideAsadult() {
		return itemguideAsadult;
	}
	public void setItemguideAsadult(boolean itemguideAsadult) {
		this.itemguideAsadult = itemguideAsadult;
	}
	public boolean isBathcostAsadult() {
		return bathcostAsadult;
	}
	public void setBathcostAsadult(boolean bathcostAsadult) {
		this.bathcostAsadult = bathcostAsadult;
	}
	public boolean isRidecostAsadult() {
		return ridecostAsadult;
	}
	public void setRidecostAsadult(boolean ridecostAsadult) {
		this.ridecostAsadult = ridecostAsadult;
	}
	public boolean isClimbrcostAsadult() {
		return climbrcostAsadult;
	}
	public void setClimbrcostAsadult(boolean climbrcostAsadult) {
		this.climbrcostAsadult = climbrcostAsadult;
	}
	public boolean isClimbncostAsadult() {
		return climbncostAsadult;
	}
	public void setClimbncostAsadult(boolean climbncostAsadult) {
		this.climbncostAsadult = climbncostAsadult;
	}
	public boolean isElsecostAsadult() {
		return elsecostAsadult;
	}
	public void setElsecostAsadult(boolean elsecostAsadult) {
		this.elsecostAsadult = elsecostAsadult;
	}
	public boolean isAsChild() {
		return isAsChild;
	}
	public void setAsChild(boolean isAsChild) {
		this.isAsChild = isAsChild;
	}
	
}
