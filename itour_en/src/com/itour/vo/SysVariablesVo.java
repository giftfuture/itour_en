package com.itour.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;
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
public class SysVariablesVo extends BasePage implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -8356212737850829975L;
	private java.lang.String id;//   	private java.lang.String varName;//   	private java.lang.String varValue;//   	private java.lang.String varHostname;//   	private java.lang.String varHostip;//   	private java.lang.String remark;//   	private java.lang.String varProject;//   
	private boolean isValid;
	private String createBy;
	private String updateBy;
	private String createTime;
	private String updateTime;
	
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
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}
	public java.lang.String getVarName() {
		return varName;
	}
	public void setVarName(java.lang.String varName) {
		this.varName = varName;
	}
	public java.lang.String getVarValue() {
		return varValue;
	}
	public void setVarValue(java.lang.String varValue) {
		this.varValue = varValue;
	}
	public java.lang.String getVarHostname() {
		return varHostname;
	}
	public void setVarHostname(java.lang.String varHostname) {
		this.varHostname = varHostname;
	}
	public java.lang.String getVarHostip() {
		return varHostip;
	}
	public void setVarHostip(java.lang.String varHostip) {
		this.varHostip = varHostip;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getVarProject() {
		return varProject;
	}
	public void setVarProject(java.lang.String varProject) {
		this.varProject = varProject;
	}	
}

