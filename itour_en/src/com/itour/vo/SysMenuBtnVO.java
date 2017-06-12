package com.itour.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class SysMenuBtnVO extends BasePage implements Serializable{
	
		private String id;//   主键	private String menuid;//    菜单id关联 sys_menu.id	private String btnName;//   按钮名称	private String btnType;//   按钮类型，用于列表页显示的按钮	private String actionUrls;//   url注册，用"," 分隔 。用于权限控制URL
	
	private String deleteFlag; //删除标记，与数据库字段无关 1=删除,其他不删除
    @Min(value = 0, message = "deleted 的最小值为0")
    @Max(value = 1, message = "deleted 的最大值为1")
	private java.lang.Integer deleted;//   是否删除,0=未删除，1=已删除
	private java.util.Date createTime;//   创建时间
	private java.util.Date updateTime;//   修改时间
	private java.lang.String actions;//   注册Action 按钮|分隔
	private java.lang.String createBy;//   
	private java.lang.String updateBy;//   	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getMenuid() {	    return this.menuid;	}	public void setMenuid(String menuid) {	    this.menuid=menuid;	}	public String getBtnName() {	    return this.btnName;	}	public void setBtnName(String btnName) {	    this.btnName=btnName;	}	public String getBtnType() {	    return this.btnType;	}	public void setBtnType(String btnType) {	    this.btnType=btnType;	}	public String getActionUrls() {	    return this.actionUrls;	}	public void setActionUrls(String actionUrls) {	    this.actionUrls=actionUrls;	}
	public java.lang.Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(java.lang.Integer deleted) {
		this.deleted = deleted;
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
	public java.lang.String getActions() {
		return actions;
	}
	public void setActions(java.lang.String actions) {
		this.actions = actions;
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
	
}
