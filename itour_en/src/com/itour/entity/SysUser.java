package com.itour.entity;

import java.sql.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.itour.base.entity.BaseEntity;


public class SysUser extends BaseEntity {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -7694404748102354148L;
	private String id;//   id主键	private String email;//   邮箱也是登录帐号	private String pwd;//   登录密码	private String nickName;//   昵称
	@Min(value = 0, message = "state 的最小值为0")
    @Max(value = 1, message = "state 的最大值为1")	private Integer state;//   状态 0=可用,1=禁用	private Integer loginCount;//   登录总次数	private java.sql.Timestamp loginTime;//   最后登录时间
	@Min(value = 0, message = "deleted 的最小值为0")
    @Max(value = 1, message = "deleted 的最大值为1")	private Integer deleted;//   删除状态 0=未删除,1=已删除	private java.sql.Timestamp createTime;//   创建时间	private java.sql.Timestamp updateTime;//   修改时间	private String createBy;//   创建人	private String updateBy;//   修改人
	@Min(value = 0, message = "superAdmin 的最小值为0")
    @Max(value = 1, message = "superAdmin 的最大值为1")
	private Integer superAdmin;//超级管理员
	
	private String validateCode;
	private Timestamp expireDate;
	private String roleStr;//用户权限, 按","区分
	
	public SysUser (){}
	public SysUser (String id,String email,String nickname){
		this.id = id;
		this.email = email;
		this.nickName = nickname;
	}
		public String getRoleStr() {
		return roleStr;
	}
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getEmail() {	    return this.email;	}	public void setEmail(String email) {	    this.email=email;	}	public String getPwd() {	    return this.pwd;	}	public void setPwd(String pwd) {	    this.pwd=pwd;	}	public String getNickName() {	    return this.nickName;	}	public void setNickName(String nickName) {	    this.nickName=nickName;	}	public Integer getState() {	    return this.state;	}	public void setState(Integer state) {	    this.state=state;	}	public Integer getLoginCount() {	    return this.loginCount;	}	public void setLoginCount(Integer loginCount) {	    this.loginCount=loginCount;	}	public java.sql.Timestamp getLoginTime() {	    return this.loginTime;	}	public void setLoginTime(java.sql.Timestamp loginTime) {	    this.loginTime=loginTime;	}	public Integer getDeleted() {	    return this.deleted;	}	public void setDeleted(Integer deleted) {	    this.deleted=deleted;	}	public java.sql.Timestamp getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.sql.Timestamp createTime) {	    this.createTime=createTime;	}	public java.sql.Timestamp getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.sql.Timestamp updateTime) {	    this.updateTime=updateTime;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(String updateBy) {	    this.updateBy=updateBy;	}
	public Integer getSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(Integer superAdmin) {
		this.superAdmin = superAdmin;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
	
}
