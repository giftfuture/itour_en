package com.itour.convert;

import com.itour.base.util.DateUtil;
import com.itour.entity.SysRole;
import com.itour.vo.SysRoleVo;

public class SysRoleKit{
	public static SysRoleVo toRecord(SysRole role){
		SysRoleVo sv = new SysRoleVo();
		sv.setCreateBy(role.getCreateBy());
		sv.setCreateTime(DateUtil.getDateYmdHs(role.getCreateTime()));
		sv.setDescr(role.getDescr());
		sv.setId(role.getId());
		sv.setLevel(role.getLevel());
		sv.setRoleName(role.getRoleName());
		sv.setState(role.getState());
		sv.setUpdateBy(role.getUpdateBy());
		sv.setUpdateTime(DateUtil.getDateYmdHs(role.getUpdateTime()));
		return sv;
	}
}
