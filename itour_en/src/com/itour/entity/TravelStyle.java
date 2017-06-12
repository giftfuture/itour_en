package com.itour.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.itour.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>TravelStyleEntity<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class TravelStyle extends BaseEntity {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 857054434524741892L;
	private java.lang.String id;//   	private java.lang.String type;//   
	private java.lang.String remark;//  	private String alias;
    @Min(value = 0, message = "valid 的最小值为0")
	@Max(value = 1, message = "valid 的最大值为1")
	private int valid;
	private String descrip;
	private String cover;
	private String createBy;
	private String updateBy;
	private Date createTime;
	private Date updateTime;
	
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
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}	public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	 	
}

