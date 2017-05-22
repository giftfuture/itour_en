package com.itour.vo;

import java.io.File;
import java.io.Serializable;
import java.util.List;

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
public class RouteTemplateVo extends BasePage implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 401324215962210890L;
	private java.lang.String id;//   	private java.lang.String d1;//   	private java.lang.String d2;//   	private java.lang.String d3;//   	private java.lang.String d4;//   	private java.lang.String d5;//   	private java.lang.String d6;//   	private java.lang.String d7;//   	private java.lang.String d8;//   	private java.lang.String d9;//   	private java.lang.String d10;//   	private java.lang.String d11;//   	private java.lang.String d12;//   	private java.lang.String d13;//   	private java.lang.String d14;//   	private java.lang.String d15;//   	private java.lang.String d16;//   	private java.lang.String d17;//   	private java.lang.String d18;//   	private java.lang.String d19;//   	private java.lang.String d20;//   	private java.lang.String d21;//   	private java.lang.String d22;//   	private java.lang.String d23;//   	private java.lang.String d24;//   	private java.lang.String d25;//   	private java.lang.String d26;//   	private java.lang.String d27;//   	private java.lang.String d28;//   	private java.lang.String d29;//   	private java.lang.String d30;//   	private java.lang.String d31;//   	private java.lang.String d32;//   	private java.lang.String d33;//   	private java.lang.String d34;//   	private java.lang.String d35;//   	private java.lang.String d36;//   	private java.lang.String d37;//   	private java.lang.String d38;//   	private java.lang.String d39;//   	private java.lang.String d40;//   	private java.lang.String d41;//   	private java.lang.String d42;//   	private java.lang.String d43;//   	private java.lang.String d44;//   	private java.lang.String d45;//   	private java.lang.String d46;//   	private java.lang.String d47;//   	private java.lang.String d48;//   	private java.lang.String d49;//   	private java.lang.String d50;//   	private java.lang.String d51;//   	private java.lang.String d52;//   	private java.lang.String d53;//   	private java.lang.String d54;//   	private java.lang.String d55;//   	private java.lang.String d56;//   	private java.lang.String d57;//   	private java.lang.String d58;//   	private java.lang.String d59;//   	private java.lang.String d60;//   	private java.lang.String customerId;//   
	private String customerName;
	private String city;
	private String district;	private String createTime;//   	private String updateTime;//   
	private String special;//线路特色	private java.lang.String createBy;//   	private java.lang.String updateBy;//   	private java.lang.String remark;//  
	private String routeLine;//路线图
	private List<RouteTemplateVo> relates;//相关线路
	private List<String> photoList;//照片
	private String related;
	private String routeMap;//线路地图
	private String travelStyle;//线路类别
	private String travelStyleType;//线路类别名称
	private String travelStyleAlias;
	private String travelItems;//线路中的景点
	private String cover;//封面图片
	//private File coverImg;//
	private String title;//路线名称
	private String shortContent;//简略介绍
	private String alias;
	private String routeCode;//线路编号
	private boolean isValid;
	private int rcdDays;//建议天数
	private float mileage;//里程
	private String mountStyle;//山峰类型
	private String departure;//出发地
	private String arrive;//到达地
	private float trekDistance;//徒步距离
	private String transportation;//交通工具
	private int difficultyRate;//难度 (挑战度)1为最低,5为最高,依次递增
	private List<Integer> diffRate;//难度 (挑战度)1为最低,5为最高,依次递增
	private List<Integer> undiffRate;//难度 (挑战度)1为最低,5为最高,依次递增
	private String quotoForm;//报价单表
	private String beriefTrip;//详细日程
	private String designConcept;//设计理念
	private String customizedService;//定制服务
	private String beforeInstruction;
	private String similars;//相似线路
	private float elevation;//海拔
	private List<String> itemitems;
	private String verifyCode;//验证码
	private int rcdDays1;//建议天数
	private int rcdDays2;//建议天数
	private int starLevel;//线路星级
	private String levelArea;//
	private String level1Area;//线路一级区域
	private String level2Area;//线路一级区域
	private String viewphotos;
	//private String travelStyleAlias;
	
	
	public String getViewphotos() {
		return viewphotos;
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
	public String getSimilars() {
		return similars;
	}
	public void setSimilars(String similars) {
		this.similars = similars;
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
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
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
	public String getRelated() {
		return related;
	}
	public void setRelated(String related) {
		this.related = related;
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
	public java.lang.String getD1() {
		return d1;
	}
	public void setD1(java.lang.String d1) {
		this.d1 = d1;
	}
	public java.lang.String getD2() {
		return d2;
	}
	public void setD2(java.lang.String d2) {
		this.d2 = d2;
	}
	public java.lang.String getD3() {
		return d3;
	}
	public void setD3(java.lang.String d3) {
		this.d3 = d3;
	}
	public java.lang.String getD4() {
		return d4;
	}
	public void setD4(java.lang.String d4) {
		this.d4 = d4;
	}
	public java.lang.String getD5() {
		return d5;
	}
	public void setD5(java.lang.String d5) {
		this.d5 = d5;
	}
	public java.lang.String getD6() {
		return d6;
	}
	public void setD6(java.lang.String d6) {
		this.d6 = d6;
	}
	public java.lang.String getD7() {
		return d7;
	}
	public void setD7(java.lang.String d7) {
		this.d7 = d7;
	}
	public java.lang.String getD8() {
		return d8;
	}
	public void setD8(java.lang.String d8) {
		this.d8 = d8;
	}
	public java.lang.String getD9() {
		return d9;
	}
	public void setD9(java.lang.String d9) {
		this.d9 = d9;
	}
	public java.lang.String getD10() {
		return d10;
	}
	public void setD10(java.lang.String d10) {
		this.d10 = d10;
	}
	public java.lang.String getD11() {
		return d11;
	}
	public void setD11(java.lang.String d11) {
		this.d11 = d11;
	}
	public java.lang.String getD12() {
		return d12;
	}
	public void setD12(java.lang.String d12) {
		this.d12 = d12;
	}
	public java.lang.String getD13() {
		return d13;
	}
	public void setD13(java.lang.String d13) {
		this.d13 = d13;
	}
	public java.lang.String getD14() {
		return d14;
	}
	public void setD14(java.lang.String d14) {
		this.d14 = d14;
	}
	public java.lang.String getD15() {
		return d15;
	}
	public void setD15(java.lang.String d15) {
		this.d15 = d15;
	}
	public java.lang.String getD16() {
		return d16;
	}
	public void setD16(java.lang.String d16) {
		this.d16 = d16;
	}
	public java.lang.String getD17() {
		return d17;
	}
	public void setD17(java.lang.String d17) {
		this.d17 = d17;
	}
	public java.lang.String getD18() {
		return d18;
	}
	public void setD18(java.lang.String d18) {
		this.d18 = d18;
	}
	public java.lang.String getD19() {
		return d19;
	}
	public void setD19(java.lang.String d19) {
		this.d19 = d19;
	}
	public java.lang.String getD20() {
		return d20;
	}
	public void setD20(java.lang.String d20) {
		this.d20 = d20;
	}
	public java.lang.String getD21() {
		return d21;
	}
	public void setD21(java.lang.String d21) {
		this.d21 = d21;
	}
	public java.lang.String getD22() {
		return d22;
	}
	public void setD22(java.lang.String d22) {
		this.d22 = d22;
	}
	public java.lang.String getD23() {
		return d23;
	}
	public void setD23(java.lang.String d23) {
		this.d23 = d23;
	}
	public java.lang.String getD24() {
		return d24;
	}
	public void setD24(java.lang.String d24) {
		this.d24 = d24;
	}
	public java.lang.String getD25() {
		return d25;
	}
	public void setD25(java.lang.String d25) {
		this.d25 = d25;
	}
	public java.lang.String getD26() {
		return d26;
	}
	public void setD26(java.lang.String d26) {
		this.d26 = d26;
	}
	public java.lang.String getD27() {
		return d27;
	}
	public void setD27(java.lang.String d27) {
		this.d27 = d27;
	}
	public java.lang.String getD28() {
		return d28;
	}
	public void setD28(java.lang.String d28) {
		this.d28 = d28;
	}
	public java.lang.String getD29() {
		return d29;
	}
	public void setD29(java.lang.String d29) {
		this.d29 = d29;
	}
	public java.lang.String getD30() {
		return d30;
	}
	public void setD30(java.lang.String d30) {
		this.d30 = d30;
	}
	public java.lang.String getD31() {
		return d31;
	}
	public void setD31(java.lang.String d31) {
		this.d31 = d31;
	}
	public java.lang.String getD32() {
		return d32;
	}
	public void setD32(java.lang.String d32) {
		this.d32 = d32;
	}
	public java.lang.String getD33() {
		return d33;
	}
	public void setD33(java.lang.String d33) {
		this.d33 = d33;
	}
	public java.lang.String getD34() {
		return d34;
	}
	public void setD34(java.lang.String d34) {
		this.d34 = d34;
	}
	public java.lang.String getD35() {
		return d35;
	}
	public void setD35(java.lang.String d35) {
		this.d35 = d35;
	}
	public java.lang.String getD36() {
		return d36;
	}
	public void setD36(java.lang.String d36) {
		this.d36 = d36;
	}
	public java.lang.String getD37() {
		return d37;
	}
	public void setD37(java.lang.String d37) {
		this.d37 = d37;
	}
	public java.lang.String getD38() {
		return d38;
	}
	public void setD38(java.lang.String d38) {
		this.d38 = d38;
	}
	public java.lang.String getD39() {
		return d39;
	}
	public void setD39(java.lang.String d39) {
		this.d39 = d39;
	}
	public java.lang.String getD40() {
		return d40;
	}
	public void setD40(java.lang.String d40) {
		this.d40 = d40;
	}
	public java.lang.String getD41() {
		return d41;
	}
	public void setD41(java.lang.String d41) {
		this.d41 = d41;
	}
	public java.lang.String getD42() {
		return d42;
	}
	public void setD42(java.lang.String d42) {
		this.d42 = d42;
	}
	public java.lang.String getD43() {
		return d43;
	}
	public void setD43(java.lang.String d43) {
		this.d43 = d43;
	}
	public java.lang.String getD44() {
		return d44;
	}
	public void setD44(java.lang.String d44) {
		this.d44 = d44;
	}
	public java.lang.String getD45() {
		return d45;
	}
	public void setD45(java.lang.String d45) {
		this.d45 = d45;
	}
	public java.lang.String getD46() {
		return d46;
	}
	public void setD46(java.lang.String d46) {
		this.d46 = d46;
	}
	public java.lang.String getD47() {
		return d47;
	}
	public void setD47(java.lang.String d47) {
		this.d47 = d47;
	}
	public java.lang.String getD48() {
		return d48;
	}
	public void setD48(java.lang.String d48) {
		this.d48 = d48;
	}
	public java.lang.String getD49() {
		return d49;
	}
	public void setD49(java.lang.String d49) {
		this.d49 = d49;
	}
	public java.lang.String getD50() {
		return d50;
	}
	public void setD50(java.lang.String d50) {
		this.d50 = d50;
	}
	public java.lang.String getD51() {
		return d51;
	}
	public void setD51(java.lang.String d51) {
		this.d51 = d51;
	}
	public java.lang.String getD52() {
		return d52;
	}
	public void setD52(java.lang.String d52) {
		this.d52 = d52;
	}
	public java.lang.String getD53() {
		return d53;
	}
	public void setD53(java.lang.String d53) {
		this.d53 = d53;
	}
	public java.lang.String getD54() {
		return d54;
	}
	public void setD54(java.lang.String d54) {
		this.d54 = d54;
	}
	public java.lang.String getD55() {
		return d55;
	}
	public void setD55(java.lang.String d55) {
		this.d55 = d55;
	}
	public java.lang.String getD56() {
		return d56;
	}
	public void setD56(java.lang.String d56) {
		this.d56 = d56;
	}
	public java.lang.String getD57() {
		return d57;
	}
	public void setD57(java.lang.String d57) {
		this.d57 = d57;
	}
	public java.lang.String getD58() {
		return d58;
	}
	public void setD58(java.lang.String d58) {
		this.d58 = d58;
	}
	public java.lang.String getD59() {
		return d59;
	}
	public void setD59(java.lang.String d59) {
		this.d59 = d59;
	}
	public java.lang.String getD60() {
		return d60;
	}
	public void setD60(java.lang.String d60) {
		this.d60 = d60;
	}
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
	public List<RouteTemplateVo> getRelates() {
		return relates;
	}
	public void setRelates(List<RouteTemplateVo> relates) {
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

