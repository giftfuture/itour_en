package com.itour.convert;

import com.itour.base.util.DateUtil;
import com.itour.entity.SysUser;
import com.itour.vo.SysUserVo;


public class SysUserKit{
	
	public static SysUserVo toRecord(SysUser su){
		SysUserVo sv = new SysUserVo();
		sv.setCreateBy(su.getCreateBy());
		sv.setCreateTime(DateUtil.getDateYmdHs(su.getCreateTime()));
		sv.setEmail(su.getEmail());
		sv.setExpireDate(DateUtil.getDateYmdHs(su.getExpireDate()));
		sv.setId(su.getId());
		sv.setLoginCount(su.getLoginCount());
		sv.setLoginTime(DateUtil.getDateYmdHs(su.getLoginTime()));
		sv.setNickName(su.getNickName());
		sv.setRoleStr(su.getRoleStr());
		sv.setState(su.getState());
		sv.setSuperAdmin(su.getSuperAdmin());
		sv.setUpdateBy(su.getUpdateBy());
		sv.setUpdateTime(DateUtil.getDateYmdHs(su.getUpdateTime()));
		sv.setValidateCode(su.getValidateCode());
		return sv;
	}
	
}
