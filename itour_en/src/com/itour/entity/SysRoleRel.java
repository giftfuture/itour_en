package com.itour.entity;

import java.util.Date;

import com.itour.base.entity.BaseEntity;


public class SysRoleRel extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6080631663815131651L;
	private String id;	private String roleId;//   角色主键 sys_role.id	private String objId;//   关联主键 relType=0管理sys_menu.id, relType=1关联sys_user.id,relType=2,sys_menu_btn.id	private Integer relType;//   关联类型 0=菜单,1=用户,2=按钮
	private boolean isValid;//是否有效
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
	/**
 	 * 枚举
 	 * @author  fred
 	 *
 	 */
 	public static enum RelType {
		MENU(0, "菜单"), USER(1,"用户"),BTN(2,"按钮");
		public int key;
		public String value;
		private RelType(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public static RelType get(int key) {
			RelType[] values = RelType.values();
			for (RelType object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}
	
		public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {	    return this.roleId;	}	public void setRoleId(String roleId) {	    this.roleId=roleId;	}	public String getObjId() {	    return this.objId;	}	public void setObjId(String objId) {	    this.objId=objId;	}	public Integer getRelType() {	    return this.relType;	}	public void setRelType(Integer relType) {	    this.relType=relType;	}
}
