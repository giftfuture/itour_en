package com.itour.entity;

import com.itour.base.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.io.File;
/**
 * 
 * <br>
 * <b>功能：</b>TravelItemEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelItem extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6120210586713700033L;
	private java.lang.String id;//   	private java.lang.String item;//   
	private String alias;//旅行项目别名	private java.lang.String itemCode;//   	private BigDecimal elevation;//海拔   	private java.lang.String content;//   	private java.lang.String photos;//   	private java.lang.String remark;//   	private java.lang.String mileage;//   	private java.lang.String scope;//地域   
	private String scopeAlias;//地域简称	private java.lang.String shortContent;//   	private java.lang.Integer rank;//   	private java.lang.String recommandReason;//   	private BigDecimal discount;//  折扣 	private java.lang.Integer rcdDays;//   建议天数	private java.lang.Integer difficultyRate;//   (挑战度)1为最低,5为最高,依次递增	private java.lang.Integer happyValue;//   1为最低,5为最高,依次递增	private java.lang.String recommandCrowd;//   建议适合的人群及要求,注意事项
	private String travelStyle;
	private File[] fileselect;
	private String cover;//封面图片
	private String feature;//特色
	private String equip;//装备
	private String exclude;//不包括的装备
	private String itinerary;//行程
	private String map;//地图
	private String season;//建议季节
	private String recommandEquip;
	private int hot;//1=热门景点，0=非热点
	private int valid;
	private String createBy;
	private String updateBy;
	private Date createTime;
	private Date updateTime;
	private int starLevel;//星级
	private String ticketsBlock;//门票块
	private int fullyearTicket;//是否分淡旺季
	private String busyseason;//旺季
	private String freeseason;//淡季
	
	public String getBusyseason() {
		return busyseason;
	}
	public void setBusyseason(String busyseason) {
		this.busyseason = busyseason;
	}
	public String getFreeseason() {
		return freeseason;
	}
	public void setFreeseason(String freeseason) {
		this.freeseason = freeseason;
	}
	public String getTicketsBlock() {
		return ticketsBlock;
	}
	public void setTicketsBlock(String ticketsBlock) {
		this.ticketsBlock = ticketsBlock;
	}
	public int getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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
	public String getScopeAlias() {
		return scopeAlias;
	}
	public void setScopeAlias(String scopeAlias) {
		this.scopeAlias = scopeAlias;
	}
	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}
	public String getItinerary() {
		return itinerary;
	}
	public void setItinerary(String itinerary) {
		this.itinerary = itinerary;
	}
	public java.lang.String getItem() {
		return item;
	}
	public String getRecommandEquip() {
		return recommandEquip;
	}
	public void setRecommandEquip(String recommandEquip) {
		this.recommandEquip = recommandEquip;
	}
	public void setItem(java.lang.String item) {
		this.item = item;
	}
	public java.lang.String getItemCode() {
		return itemCode;
	}
	public void setItemCode(java.lang.String itemCode) {
		this.itemCode = itemCode;
	}
	public BigDecimal getElevation() {
		return elevation;
	}
	public void setElevation(BigDecimal elevation) {
		this.elevation = elevation;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getPhotos() {
		return photos;
	}
	public void setPhotos(java.lang.String photos) {
		this.photos = photos;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getMileage() {
		return mileage;
	}
	public void setMileage(java.lang.String mileage) {
		this.mileage = mileage;
	}
	public java.lang.String getScope() {
		return scope;
	}
	public void setScope(java.lang.String scope) {
		this.scope = scope;
	}
	public java.lang.String getShortContent() {
		return shortContent;
	}
	public void setShortContent(java.lang.String shortContent) {
		this.shortContent = shortContent;
	}
	public java.lang.Integer getRank() {
		return rank;
	}
	public void setRank(java.lang.Integer rank) {
		this.rank = rank;
	}
	public java.lang.String getRecommandReason() {
		return recommandReason;
	}
	public void setRecommandReason(java.lang.String recommandReason) {
		this.recommandReason = recommandReason;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public java.lang.Integer getRcdDays() {
		return rcdDays;
	}
	public void setRcdDays(java.lang.Integer rcdDays) {
		this.rcdDays = rcdDays;
	}
	public java.lang.Integer getDifficultyRate() {
		return difficultyRate;
	}
	public void setDifficultyRate(java.lang.Integer difficultyRate) {
		this.difficultyRate = difficultyRate;
	}
	public java.lang.Integer getHappyValue() {
		return happyValue;
	}
	public void setHappyValue(java.lang.Integer happyValue) {
		this.happyValue = happyValue;
	}
	public java.lang.String getRecommandCrowd() {
		return recommandCrowd;
	}
	public void setRecommandCrowd(java.lang.String recommandCrowd) {
		this.recommandCrowd = recommandCrowd;
	}
	public File[] getFileselect() {
		return fileselect;
	}
	public void setFileselect(File[] fileselect) {
		this.fileselect = fileselect;
	}
	public String getTravelStyle() {
		return travelStyle;
	}
	public void setTravelStyle(String travelStyle) {
		this.travelStyle = travelStyle;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getEquip() {
		return equip;
	}
	public void setEquip(String equip) {
		this.equip = equip;
	}
	public String getExclude() {
		return exclude;
	}
	public void setExclude(String exclude) {
		this.exclude = exclude;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public int getFullyearTicket() {
		return fullyearTicket;
	}
	public void setFullyearTicket(int fullyearTicket) {
		this.fullyearTicket = fullyearTicket;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}	
}

