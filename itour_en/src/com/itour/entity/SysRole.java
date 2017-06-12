package com.itour.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.itour.base.entity.BaseEntity;


public class SysRole extends BaseEntity {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 7295974600738619416L;
	private String id;//   id主键	private String roleName;//   角色名称	private java.sql.Timestamp createTime;//   创建时间	private String createBy;//   创建人	private java.sql.Timestamp updateTime;//   修改时间	private String updateBy;//   修改人
    @Min(value = 0, message = "status 的最小值为0")
    @Max(value = 1, message = "status 的最大值为1")	private Integer state;//   状态0=可用 1=禁用	private String descr;//   角色描述
	@Min(value = 0, message = "level 的最小值为0")
    @Max(value = 10, message = "level 的最大值为10")
	private short level;//管理员级别,1=超级管理员，2.3.4=管理咒，站点管理员，测试管理员
	private int number;//角色编号
	@Min(value = 0, message = "deleted 的最小值为0")
    @Max(value = 1, message = "deleted 的最大值为1")
	private int deleted;
	
		public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}		public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public java.sql.Timestamp getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.sql.Timestamp createTime) {	    this.createTime=createTime;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public java.sql.Timestamp getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.sql.Timestamp updateTime) {	    this.updateTime=updateTime;	}	public String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(String updateBy) {	    this.updateBy=updateBy;	}	public Integer getState() {	    return this.state;	}	public void setState(Integer state) {	    this.state=state;	}	public String getDescr() {	    return this.descr;	}	public void setDescr(String descr) {	    this.descr=descr;	}
	public short getLevel() {
		return level;
	}
	public void setLevel(short level) {
		this.level = level;
	}
	
}
