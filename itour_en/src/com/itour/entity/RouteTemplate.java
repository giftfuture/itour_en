package com.itour.entity;

import com.itour.base.entity.BaseEntity;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class RouteTemplate extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504658958087999522L;
	private String id;
	private java.lang.String customerId;//   	private java.util.Date createTime;//   	private java.util.Date updateTime;//   
	private String special;//线路特色
	private String routeMap;//线路地图
	private java.lang.String createBy;//   	private java.lang.String updateBy;//   	private java.lang.String remark;//   	private String travelStyle;//线路类别
	private String travelItems;//线路中的景点
	private String cover;//封面
	private String title;//路线名称
	private String shortContent;//简略介绍
	private String alias;//线路别称
	private String routeCode;//线路编号
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private int rcdDays;//建议天数
	private float mileage;//海拔
	private String mountStyle;//山峰类型
	private String departure;//出发地
	private String arrive;//到达地
	private float trekDistance;//徒步距离
	private String transportation;//交通工具
    @Min(value = 1, message = "difficultyRate 的最小值为1")
    @Max(value = 5, message = "difficultyRate 的最大值为5")
	private int difficultyRate;//难度
	private String quotoForm;//报价单表
	private String designConcept;//设计理念
	private String customizedService;//定制服务
	private String beforeInstruction;//行前须知
	private float elevation;
    @Min(value = 1, message = "starLevel 的最小值为1")
    @Max(value = 5, message = "starLevel 的最大值为5")
	private int starLevel;//线路星级
	private String levelArea;//线路区域
	private String viewphotos;
	private String serviceAndQuote;
	public RouteTemplate(){} 
	public RouteTemplate(String id,String levelArea){
		this.id = id;
		this.levelArea = levelArea;
	}	 
	
	public String getServiceAndQuote() {
		return serviceAndQuote;
	}
	public void setServiceAndQuote(String serviceAndQuote) {
		this.serviceAndQuote = serviceAndQuote;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getViewphotos() {
		return viewphotos;
	}
	public void setViewphotos(String viewphotos) {
		this.viewphotos = viewphotos;
	}
	public int getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}
	public String getLevelArea() {
		return levelArea;
	}
	public void setLevelArea(String levelArea) {
		this.levelArea = levelArea;
	}
	public float getElevation() {
		return elevation;
	}
	public void setElevation(float elevation) {
		this.elevation = elevation;
	}
	public String getBeforeInstruction() {
		return beforeInstruction;
	}
	public void setBeforeInstruction(String beforeInstruction) {
		this.beforeInstruction = beforeInstruction;
	}
	public String getCustomizedService() {
		return customizedService;
	}
	public void setCustomizedService(String customizedService) {
		this.customizedService = customizedService;
	}
	public String getDesignConcept() {
		return designConcept;
	}
	public void setDesignConcept(String designConcept) {
		this.designConcept = designConcept;
	}
	public String getQuotoForm() {
		return quotoForm;
	}
	public void setQuotoForm(String quotoForm) {
		this.quotoForm = quotoForm;
	}
	public int getDifficultyRate() {
		return difficultyRate;
	}
	public void setDifficultyRate(int difficultyRate) {
		this.difficultyRate = difficultyRate;
	}
	public float getTrekDistance() {
		return trekDistance;
	}
	public void setTrekDistance(float trekDistance) {
		this.trekDistance = trekDistance;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public float getMileage() {
		return mileage;
	}
	public void setMileage(float mileage) {
		this.mileage = mileage;
	}
	public String getMountStyle() {
		return mountStyle;
	}
	public void setMountStyle(String mountStyle) {
		this.mountStyle = mountStyle;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public int getRcdDays() {//rcd_days
		return rcdDays;
	}
	public void setRcdDays(int rcdDays) {
		this.rcdDays = rcdDays;
	}
	
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}	public String getTravelItems() {
		return travelItems;
	}
	public void setTravelItems(String travelItems) {
		this.travelItems = travelItems;
	}
	public String getTravelStyle() {
		return travelStyle;
	}
	public void setTravelStyle(String travelStyle) {
		this.travelStyle = travelStyle;
	}
	
	public java.lang.String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(java.lang.String customerId) {
		this.customerId = customerId;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}
	public java.lang.String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getRouteMap() {
		return routeMap;
	}
	public void setRouteMap(String routeMap) {
		this.routeMap = routeMap;
	}
}

