package com.itour.vo;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.itour.base.page.BasePage;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class ShowHappyVO extends BasePage implements Serializable{
	
	private String id;
	private String customer;
	private String createTime;
	private String updateTime;
    @Min(value = 0, message = "status 的最小值为0")
    @Max(value = 1, message = "status 的最大值为1")
	private int status;
	private String content;
	private String title;
	private String result;
	private String signature;
	private String area;
	private String tourTime;//旅行时间
	private String route;//该晒图所属路线
	private String cover;//分享的封面图片
	private String surface;//封面图片文件
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private String verifyCode;
	private List<MultipartFile> imagefiles;
	private String shortContent;
	private String shCode;
	private String areaname;
	private String routeTitle;
	private String customerName;
	@Email
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRouteTitle() {
		return routeTitle;
	}
	public void setRouteTitle(String routeTitle) {
		this.routeTitle = routeTitle;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
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
	
	public List<MultipartFile> getImagefiles() {
		return imagefiles;
	}
	public void setImagefiles(List<MultipartFile> imagefiles) {
		this.imagefiles = imagefiles;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public String getTourTime() {
		return tourTime;
	}
	public void setTourTime(String tourTime) {
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
