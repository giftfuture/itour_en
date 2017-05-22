package com.itour.vo;


import com.itour.base.entity.BaseEntity;
import com.itour.base.page.BasePage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class LevelAreaVo extends BasePage {

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
	private String createTime;
	private String updateTime;
	private boolean valid;
	private String aliasCode;
	private String item;
	private String alias;
	private String newlevel1Area;
	private String newlevel2Area;
	private String title;
	private String routeTemplate;
	
	public String getRouteTemplate() {
		return routeTemplate;
	}
	public void setRouteTemplate(String routeTemplate) {
		this.routeTemplate = routeTemplate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewlevel1Area() {
		return newlevel1Area;
	}
	public void setNewlevel1Area(String newlevel1Area) {
		this.newlevel1Area = newlevel1Area;
	}
	public String getNewlevel2Area() {
		return newlevel2Area;
	}
	public void setNewlevel2Area(String newlevel2Area) {
		this.newlevel2Area = newlevel2Area;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getAliasCode() {
		return aliasCode;
	}
	public void setAliasCode(String aliasCode) {
		this.aliasCode = aliasCode;
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
