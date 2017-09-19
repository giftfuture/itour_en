package com.itour.vo;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class RouteTemplateVO extends BasePage implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 401324215962210890L;
	private java.lang.String id;//   	private java.lang.String customerId;//   
	private String customerName;
	private String city;
	private String district;	private String createTime;//   	private String updateTime;//   
	private String special;//线路特色	private java.lang.String createBy;//   	private java.lang.String updateBy;//   	private java.lang.String remark;//  
	private String routeLine;//路线图
	private List<RouteTemplateVO> relates;//相关线路
	private List<String> relatedRouteTitles;
	private List<String> photoList;//照片
	private String routeMap;//线路地图
	private String travelStyle;//线路类别
	private String travelStyleType;//线路类别名称
	private String travelStyleAlias;
	private String travelItems;//线路中的景点
	private String travelItemAliass;
	private String cover;//封面图片
	//private File coverImg;//
	private String title;//路线名称
	private String shortContent;//简略介绍
	private String alias;
	private String routeCode;//线路编号
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private int rcdDays;//建议天数
	private float mileage;//里程
	private String mountStyle;//山峰类型
	private String departure;//出发地
	private String arrive;//到达地
	private float trekDistance;//徒步距离
	private String transportation;//交通工具
    @Min(value = 1, message = "difficultyRate 的最小值为1")
    @Max(value = 5, message = "difficultyRate 的最大值为5")
	private int difficultyRate;//难度 (挑战度)1为最低,5为最高,依次递增
	private List<Integer> diffRate;//难度 (挑战度)1为最低,5为最高,依次递增
	private List<Integer> undiffRate;//难度 (挑战度)1为最低,5为最高,依次递增
	private String quotoForm;//报价单表
	private String beriefTrip;//详细日程
	private String designConcept;//设计理念
	private String customizedService;//定制服务
	private String beforeInstruction;
	private float elevation;//海拔
	private List<String> itemitems;
	private String verifyCode;//验证码
	private int rcdDays1;//建议天数
	private int rcdDays2;//建议天数
    @Min(value = 1, message = "starLevel 的最小值为1")
    @Max(value = 5, message = "starLevel 的最大值为5")
	private int starLevel;//线路星级
	private String levelArea;//
	private String level1Area;//线路一级区域
	private String level2Area;//线路一级区域
	private String viewphotos;
	//private String travelStyleAlias;
	private String serviceAndQuote;
	
	
	public String getServiceAndQuote() {
		return serviceAndQuote;
	}
	public void setServiceAndQuote(String serviceAndQuote) {
		this.serviceAndQuote = serviceAndQuote;
	}
	
	public String getViewphotos() {
		return viewphotos;
	}
	public String getTravelItemAliass() {
		return travelItemAliass;
	}
	public void setTravelItemAliass(String travelItemAliass) {
		this.travelItemAliass = travelItemAliass;
	}
	public List<String> getRelatedRouteTitles() {
		return relatedRouteTitles;
	}
	public void setRelatedRouteTitles(List<String> relatedRouteTitles) {
		this.relatedRouteTitles = relatedRouteTitles;
	}
	public void setViewphotos(String viewphotos) {
		this.viewphotos = viewphotos;
	}
	public String getTravelStyleType() {
		return travelStyleType;
	}
	public void setTravelStyleType(String travelStyleType) {
		this.travelStyleType = travelStyleType;
	}
	public String getLevel1Area() {
		return level1Area;
	}
	public void setLevel1Area(String level1Area) {
		this.level1Area = level1Area;
	}
	public String getLevel2Area() {
		return level2Area;
	}
	public void setLevel2Area(String level2Area) {
		this.level2Area = level2Area;
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
	public int getRcdDays1() {
		return rcdDays1;
	}
	public void setRcdDays1(int rcdDays1) {
		this.rcdDays1 = rcdDays1;
	}
	public int getRcdDays2() {
		return rcdDays2;
	}
	public void setRcdDays2(int rcdDays2) {
		this.rcdDays2 = rcdDays2;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public List<String> getItemitems() {
		return itemitems;
	}
	public void setItemitems(List<String> itemitems) {
		this.itemitems = itemitems;
	}
	public String getRouteLine() {
		return routeLine;
	}
	public void setRouteLine(String routeLine) {
		this.routeLine = routeLine;
	}
	public float getElevation() {
		return elevation;
	}
	public void setElevation(float elevation) {
		this.elevation = elevation;
	}
/*	public File getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(File coverImg) {
		this.coverImg = coverImg;
	}*/
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
	public String getBeriefTrip() {
		return beriefTrip;
	}
	public void setBeriefTrip(String beriefTrip) {
		this.beriefTrip = beriefTrip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getQuotoForm() {
		return quotoForm;
	}
	public void setQuotoForm(String quotoForm) {
		this.quotoForm = quotoForm;
	}
	public List<Integer> getUndiffRate() {
		return undiffRate;
	}
	public void setUndiffRate(List<Integer> undiffRate) {
		this.undiffRate = undiffRate;
	}
	public List<Integer> getDiffRate() {
		return diffRate;
	}
	public void setDiffRate(List<Integer> diffRate) {
		this.diffRate = diffRate;
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
	public List<String> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<String> photoList) {
		this.photoList = photoList;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getRouteCode() {
		return routeCode;
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
	}
	public String getTravelItems() {
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
	public String getRouteMap() {
		return routeMap;
	}
	public void setRouteMap(String routeMap) {
		this.routeMap = routeMap;
	}
	 	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}
	public java.lang.String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(java.lang.String customerId) {
		this.customerId = customerId;
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
	public List<RouteTemplateVO> getRelates() {
		return relates;
	}
	public void setRelates(List<RouteTemplateVO> relates) {
		this.relates = relates;
	}
	public String getTravelStyleAlias() {
		return travelStyleAlias;
	}
	public void setTravelStyleAlias(String travelStyleAlias) {
		this.travelStyleAlias = travelStyleAlias;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}	
}

