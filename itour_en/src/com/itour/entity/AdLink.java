package com.itour.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.itour.base.entity.BaseEntity;

public class AdLink extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7069705719789084689L;
	private String id;
	private String advertise;
	private String adlink;
    @Min(value = 0, message = "video 的最小值为0")
    @Max(value = 1, message = "video 的最大值为1")
	private int video;
	private String title;
    @Min(value = 0, message = "valid 的最小值为0")
    @Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private String remark;
	private String createBy;
	private String updateBy;
	private Date createTime;
	private Date updateTime;
	
	 
	public int getVideo() {
		return video;
	}
	public void setVideo(int video) {
		this.video = video;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
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
