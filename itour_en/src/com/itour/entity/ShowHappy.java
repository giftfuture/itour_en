package com.itour.entity;

import com.itour.base.entity.BaseEntity;

public class ShowHappy extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4185203270653265565L;
	private String id;
	private String customer;
	private java.util.Date createTime;
	private java.util.Date updateTime;
	private int status;
	private String content;
	private String title;
	private String result;
	private String signature;
	private String area;
	private java.util.Date tourTime;//旅行时间
	private String route;//该晒图所属路线
	private String cover;//分享的封面图片
	private boolean isValid;
	private String shortContent;
	private String shCode;
	
	public String getShCode() {
		return shCode;
	}
	public void setShCode(String shCode) {
		this.shCode = shCode;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public java.util.Date getTourTime() {
		return tourTime;
	}
	public void setTourTime(java.util.Date tourTime) {
		this.tourTime = tourTime;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
