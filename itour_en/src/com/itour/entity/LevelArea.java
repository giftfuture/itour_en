package com.itour.entity;

import java.util.Date;

import com.itour.base.entity.BaseEntity;

public class LevelArea extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6320578221762411544L;
	private String id;
	private String level1Area;
	private String level2Area;
	private String travelItem;
	private String remark;
	private String createBy;
	private String updateBy;
	private Date createTime;
	private Date updateTime;
	private boolean valid;
	private String aliasCode;
	private String routeTemplate;
	public LevelArea(){}
	public LevelArea(String aliasCode,String level1Area){
		this.aliasCode = aliasCode;
		this.level1Area = level1Area;
	}
	public LevelArea(String id,String aliasCode,String level1Area,String level2Area,String travelItem){
		this.id = id;
		this.aliasCode = aliasCode;
		this.level1Area = level1Area;
		this.level2Area = level2Area;
		this.travelItem = travelItem;
	}
	
	
	public String getRouteTemplate() {
		return routeTemplate;
	}
	public void setRouteTemplate(String routeTemplate) {
		this.routeTemplate = routeTemplate;
	}
	public String getAliasCode() {
		return aliasCode;
	}
	public void setAliasCode(String aliasCode) {
		this.aliasCode = aliasCode;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTravelItem() {
		return travelItem;
	}
	public void setTravelItem(String travelItem) {
		this.travelItem = travelItem;
	}
		
}
