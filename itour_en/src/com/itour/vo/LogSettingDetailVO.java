package com.itour.vo;

import java.io.Serializable;

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
public class LogSettingDetailVO extends BasePage implements Serializable {
	
		private java.lang.String detailCode;//   	private java.lang.String logCode;//   	private java.lang.String columnName;//   	private java.lang.String columnText;//   	private java.lang.String columnDatatype;//   	private java.util.Date createTime;//   	private java.lang.String creater;//   
	public java.lang.String getDetailCode() {
		return detailCode;
	}
	public void setDetailCode(java.lang.String detailCode) {
		this.detailCode = detailCode;
	}
	public java.lang.String getLogCode() {
		return logCode;
	}
	public void setLogCode(java.lang.String logCode) {
		this.logCode = logCode;
	}
	public java.lang.String getColumnName() {
		return columnName;
	}
	public void setColumnName(java.lang.String columnName) {
		this.columnName = columnName;
	}
	public java.lang.String getColumnText() {
		return columnText;
	}
	public void setColumnText(java.lang.String columnText) {
		this.columnText = columnText;
	}
	public java.lang.String getColumnDatatype() {
		return columnDatatype;
	}
	public void setColumnDatatype(java.lang.String columnDatatype) {
		this.columnDatatype = columnDatatype;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getCreater() {
		return creater;
	}
	public void setCreater(java.lang.String creater) {
		this.creater = creater;
	}
}

