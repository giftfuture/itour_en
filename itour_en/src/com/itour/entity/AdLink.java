package com.itour.entity;

import java.util.Date;

import com.itour.base.entity.BaseEntity;

public class AdLink extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7069705719789084689L;
	private String id;
	private String advertise;
	private String adlink;
	private boolean isVideo;
	private String title;
	private boolean valid;
	private String remark;
	private String createBy;
	private String updateBy;
	private Date createTime;
	private Date updateTime;
	
	public boolean isVideo() {
		return isVideo;
	}
	public void setVideo(boolean isVideo) {
		this.isVideo = isVideo;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdvertise() {
		return advertise;
	}
	public void setAdvertise(String advertise) {
		this.advertise = advertise;
	}
	public String getAdlink() {
		return adlink;
	}
	public void setAdlink(String adlink) {
		this.adlink = adlink;
	}
	
}
