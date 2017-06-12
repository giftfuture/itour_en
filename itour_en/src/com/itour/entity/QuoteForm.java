package com.itour.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.itour.base.entity.BaseEntity;

public class QuoteForm extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4528413920923040955L;
	/**
	 * 
	 */
	private String id;
	private String routeTemplate;//所属路线
	private String beriefTrip;//简要行程
	private String showTrip;//文本固定化的行程
	private String travelItems;//旅行景点
	private int adults;
	private int children;
    @Min(value = 0, message = "asAdult 的最小值为0")
    @Max(value = 1, message = "asAdult 的最大值为1")
	private int asAdult;
	private String ticketBlock;//门票明细
    @Min(value = 0, message = "ticketAsadult 的最小值为0")
    @Max(value = 1, message = "ticketAsadult 的最大值为1")
	private int ticketAsadult;//小孩门票是否按孩子核算
	private String travelDocs;//旅行证件
    @Min(value = 0, message = "traveldocAsadult 的最小值为0")
    @Max(value = 1, message = "traveldocAsadult 的最大值为1")
	private int traveldocAsadult;//小孩旅行证件是否按孩子核算
	private String tourGuide;//导游
    @Min(value = 0, message = "tourguideAsadult 的最小值为0")
    @Max(value = 1, message = "tourguideAsadult 的最大值为1")
	private int tourguideAsadult;//小孩导游是否按孩子核算
	private String hotel;//酒店
    @Min(value = 0, message = "hotelAsadult 的最小值为0")
    @Max(value = 1, message = "hotelAsadult 的最大值为1")
	private int hotelAsadult;//小孩住酒店是否按孩子核算
	private String rentCar;//用车情况
    @Min(value = 0, message = "rentcarAsadult 的最小值为0")
    @Max(value = 1, message = "rentcarAsadult 的最大值为1")
	private int rentcarAsadult;//小孩用车是否按孩子核算
    @Min(value = 0, message = "bigTrafficSum 的最小值为0")
    @Max(value = 1, message = "bigTrafficSum 的最大值为1")
	private int bigTrafficSum;//true=计入总价，false=另外核算
	private String bigTraffic;//大交通
    @Min(value = 0, message = "bigtrafficeAsadult 的最小值为0")
    @Max(value = 1, message = "bigtrafficeAsadult 的最大值为1")
	private int bigtrafficeAsadult;//小孩大交通是否按孩子核算
	private String dinner;//用餐
    @Min(value = 0, message = "dinnerAsadult 的最小值为0")
    @Max(value = 1, message = "dinnerAsadult 的最大值为1")
	private int dinnerAsadult;//小孩用餐是否按孩子核算
	private String insurance;//保险
	@Min(value = 0, message = "insuranceAsadult 的最小值为0")
	@Max(value = 1, message = "insuranceAsadult 的最大值为1")
	private int insuranceAsadult;//小孩保险是否按孩子核算
	private String comprehensiveCosts;//综合费用 
	@Min(value = 0, message = "comphcostAsadult 的最小值为0")
	@Max(value = 1, message = "comphcostAsadult 的最大值为1")
	private int comphcostAsadult;//小孩子综合费用是否按孩子核算
	private String recreation;//娱乐费用
	@Min(value = 0, message = "recreationAsadult 的最小值为0")
	@Max(value = 1, message = "recreationAsadult 的最大值为1")
	private int recreationAsadult;//小孩娱乐费用是否按孩子核算
	private String itemGuide;//单项向导
	@Min(value = 0, message = "itemguideAsadult 的最小值为0")
	@Max(value = 1, message = "itemguideAsadult 的最大值为1")
	private int itemguideAsadult;//小孩向导费用是否按孩子核算
	private String bathorseCost;//驮马费
	@Min(value = 0, message = "bathcostAsadult 的最小值为0")
	@Max(value = 1, message = "bathcostAsadult 的最大值为1")
	private int bathcostAsadult;//小孩驮马费是否按孩子核算
	private String ridehorseCost;//骑马费
	@Min(value = 0, message = "ridecostAsadult 的最小值为0")
	@Max(value = 1, message = "ridecostAsadult 的最大值为1")
	private int ridecostAsadult;//小孩骑马费是否按孩子核算
	private String climbRegisterCost;//登山注册费
	@Min(value = 0, message = "climbrcostAsadult 的最小值为0")
	@Max(value = 1, message = "climbrcostAsadult 的最大值为1")
	private int climbrcostAsadult;//小孩登山注册费是否按孩子核算
	private String climbNexusCost;//登协联络官
	@Min(value = 0, message = "climbncostAsadult 的最小值为0")
	@Max(value = 1, message = "climbncostAsadult 的最大值为1")
	private int climbncostAsadult;//小孩登协联络官是否按孩子核算
	private String elseCost;//其他费用
	@Min(value = 0, message = "elsecostAsadult 的最小值为0")
	@Max(value = 1, message = "elsecostAsadult 的最大值为1")
	private int elsecostAsadult;//小孩其他费用是否按孩子核算
	private String presented;//赠送
	private String remark;
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private String createBy;
	private Date createTime;
	private Date updateTime;
	private String updateBy;
	private String groupCode;//团号
	private Date groupDate;//出团日期
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
	private String agodaDetail;//详细日程
	
	
	public String getAgodaDetail() {
		return agodaDetail;
	}
	public void setAgodaDetail(String agodaDetail) {
		this.agodaDetail = agodaDetail;
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
	public String getTravelItems() {
		return travelItems;
	}
	public void setTravelItems(String travelItems) {
		this.travelItems = travelItems;
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
	public Date getGroupDate() {
		return groupDate;
	}
	public void setGroupDate(Date groupDate) {
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
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getTravelDocs() {
		return travelDocs;
	}
	public void setTravelDocs(String travelDocs) {
		this.travelDocs = travelDocs;
	}
	public int getAsAdult() {
		return asAdult;
	}
	public void setAsAdult(int asAdult) {
		this.asAdult = asAdult;
	}
	public int getTicketAsadult() {
		return ticketAsadult;
	}
	public void setTicketAsadult(int ticketAsadult) {
		this.ticketAsadult = ticketAsadult;
	}
	public int getTraveldocAsadult() {
		return traveldocAsadult;
	}
	public void setTraveldocAsadult(int traveldocAsadult) {
		this.traveldocAsadult = traveldocAsadult;
	}
	public int getTourguideAsadult() {
		return tourguideAsadult;
	}
	public void setTourguideAsadult(int tourguideAsadult) {
		this.tourguideAsadult = tourguideAsadult;
	}
	public int getHotelAsadult() {
		return hotelAsadult;
	}
	public void setHotelAsadult(int hotelAsadult) {
		this.hotelAsadult = hotelAsadult;
	}
	public int getRentcarAsadult() {
		return rentcarAsadult;
	}
	public void setRentcarAsadult(int rentcarAsadult) {
		this.rentcarAsadult = rentcarAsadult;
	}
	public int getBigTrafficSum() {
		return bigTrafficSum;
	}
	public void setBigTrafficSum(int bigTrafficSum) {
		this.bigTrafficSum = bigTrafficSum;
	}
	public int getBigtrafficeAsadult() {
		return bigtrafficeAsadult;
	}
	public void setBigtrafficeAsadult(int bigtrafficeAsadult) {
		this.bigtrafficeAsadult = bigtrafficeAsadult;
	}
	public int getDinnerAsadult() {
		return dinnerAsadult;
	}
	public void setDinnerAsadult(int dinnerAsadult) {
		this.dinnerAsadult = dinnerAsadult;
	}
	public int getInsuranceAsadult() {
		return insuranceAsadult;
	}
	public void setInsuranceAsadult(int insuranceAsadult) {
		this.insuranceAsadult = insuranceAsadult;
	}
	public int getComphcostAsadult() {
		return comphcostAsadult;
	}
	public void setComphcostAsadult(int comphcostAsadult) {
		this.comphcostAsadult = comphcostAsadult;
	}
	public int getRecreationAsadult() {
		return recreationAsadult;
	}
	public void setRecreationAsadult(int recreationAsadult) {
		this.recreationAsadult = recreationAsadult;
	}
	public int getItemguideAsadult() {
		return itemguideAsadult;
	}
	public void setItemguideAsadult(int itemguideAsadult) {
		this.itemguideAsadult = itemguideAsadult;
	}
	public int getBathcostAsadult() {
		return bathcostAsadult;
	}
	public void setBathcostAsadult(int bathcostAsadult) {
		this.bathcostAsadult = bathcostAsadult;
	}
	public int getRidecostAsadult() {
		return ridecostAsadult;
	}
	public void setRidecostAsadult(int ridecostAsadult) {
		this.ridecostAsadult = ridecostAsadult;
	}
	public int getClimbrcostAsadult() {
		return climbrcostAsadult;
	}
	public void setClimbrcostAsadult(int climbrcostAsadult) {
		this.climbrcostAsadult = climbrcostAsadult;
	}
	public int getClimbncostAsadult() {
		return climbncostAsadult;
	}
	public void setClimbncostAsadult(int climbncostAsadult) {
		this.climbncostAsadult = climbncostAsadult;
	}
	public int getElsecostAsadult() {
		return elsecostAsadult;
	}
	public void setElsecostAsadult(int elsecostAsadult) {
		this.elsecostAsadult = elsecostAsadult;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	 
	
	
	
}
