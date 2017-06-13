package com.itour.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性  
@JsonInclude(Include.NON_NULL)
public class LoginVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2058639024289489702L;
	private String email;
	private String oldPwd;
	private String newPwd;
	private String pwdCode;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getPwdCode() {
		return pwdCode;
	}
	public void setPwdCode(String pwdCode) {
		this.pwdCode = pwdCode;
	}
	
}
