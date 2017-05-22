package com.itour.entity;

import com.itour.base.entity.BaseEntity;
import com.itour.base.util.IDGenerator;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>LogOperationEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class LogOperation extends BaseEntity {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 8826233846469737958L;
	private String id;
	private java.lang.String operCode;//   	private java.lang.String logCode;//   	private java.lang.String operationType;//   	private java.lang.String primaryKeyvalue;//   	private java.lang.String content;// 
	private String newContent;//更新时新值	private java.lang.String url;//   	private java.lang.String creater;//   	private java.util.Date createTime;//   
	public LogOperation(){}
	public LogOperation(String logCode,String operationType,String primaryKeyvalue,String content,String newContent,String url,String creater){
		this.operCode = IDGenerator.getUUID();
		this.logCode = logCode;
		this.operationType = operationType;
		this.primaryKeyvalue = primaryKeyvalue;
		this.content = content;
		this.newContent = newContent;
		this.url= url;
		this.creater = creater; 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public java.lang.String getOperCode() {
		return operCode;
	}
	public void setOperCode(java.lang.String operCode) {
		this.operCode = operCode;
	}
	public java.lang.String getLogCode() {
		return logCode;
	}
	public void setLogCode(java.lang.String logCode) {
		this.logCode = logCode;
	}
	public java.lang.String getOperationType() {
		return operationType;
	}
	public void setOperationType(java.lang.String operationType) {
		this.operationType = operationType;
	}
	public java.lang.String getPrimaryKeyvalue() {
		return primaryKeyvalue;
	}
	public void setPrimaryKeyvalue(java.lang.String primaryKeyvalue) {
		this.primaryKeyvalue = primaryKeyvalue;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getUrl() {
		return url;
	}
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	public java.lang.String getCreater() {
		return creater;
	}
	public void setCreater(java.lang.String creater) {
		this.creater = creater;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}	
}

