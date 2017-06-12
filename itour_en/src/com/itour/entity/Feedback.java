package com.itour.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;

import com.itour.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>FeedbackEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class Feedback extends BaseEntity {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -467544411280728177L;
	private java.lang.String id;//   	private Date createTime;//   	private java.lang.Integer status;//   	private Date updateTime;//   	private java.lang.String title;//   	private java.lang.String content;//   	private java.lang.String customerId;//   	private java.lang.String result;//   	private java.lang.String customerName;
	@Email
	private String email;
	private String mobile;
	private String name;
	private short teamPersons;
	private Timestamp preferedDate;
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private String route;//路线
    @Min(value = 0, message = "sex 的最小值为0")
    @Max(value = 1, message = "sex 的最大值为1")
	private int sex;//true=male,false=female
    @Min(value = 0, message = "publicShow 的最小值为0")
    @Max(value = 1, message = "publicShow 的最大值为1")
	private int publicShow;//公开展示
	
	
 
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPublicShow() {
		return publicShow;
	}
	public void setPublicShow(int publicShow) {
		this.publicShow = publicShow;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getTeamPersons() {
		return teamPersons;
	}
	public void setTeamPersons(short teamPersons) {
		this.teamPersons = teamPersons;
	}
	public Timestamp getPreferedDate() {
		return preferedDate;
	}
	public void setPreferedDate(Timestamp preferedDate) {
		this.preferedDate = preferedDate;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public java.lang.String getTitle() {
		return title;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(java.lang.String customerId) {
		this.customerId = customerId;
	}
	public java.lang.String getResult() {
		return result;
	}
	public void setResult(java.lang.String result) {
		this.result = result;
	}
	public java.lang.String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(java.lang.String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}

