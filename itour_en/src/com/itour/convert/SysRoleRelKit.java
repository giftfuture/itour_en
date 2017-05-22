package com.itour.convert;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.itour.base.util.DateUtil;
import com.itour.entity.SysRoleRel;
import com.itour.vo.SysRoleRelVo;


public class SysRoleRelKit{
	public static SysRoleRel toEntity(SysRoleRelVo vo)throws Exception{
		SysRoleRel sysrolerel = new SysRoleRel();
		sysrolerel.setId(vo.getId());
		sysrolerel.setRoleId(vo.getRoleId());
		sysrolerel.setObjId(vo.getObjId());
		sysrolerel.setRelType(vo.getRelType());
		sysrolerel.setValid(vo.isValid());
		sysrolerel.setCreateBy(vo.getCreateBy());
		sysrolerel.setUpdateBy(vo.getUpdateBy());
		if(StringUtils.isNotEmpty(vo.getCreateTime())){
			sysrolerel.setCreateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getCreateTime()));
		}
		if(StringUtils.isNotEmpty(vo.getUpdateTime())){
			sysrolerel.setUpdateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getUpdateTime()));
		}
		return sysrolerel;
	}
	public static SysRoleRelVo toVo(SysRoleRel vo)throws Exception{
		SysRoleRelVo sysrolerel = new SysRoleRelVo();
		sysrolerel.setId(vo.getId());
		sysrolerel.setRoleId(vo.getRoleId());
		sysrolerel.setObjId(vo.getObjId());
		sysrolerel.setRelType(vo.getRelType());
		sysrolerel.setValid(vo.isValid());
		sysrolerel.setCreateBy(vo.getCreateBy());
		sysrolerel.setUpdateBy(vo.getUpdateBy());
		sysrolerel.setCreateTime(DateUtil.getDateYmdHs(vo.getCreateTime()));
		sysrolerel.setUpdateTime(DateUtil.getDateYmdHs(vo.getUpdateTime()));
		return sysrolerel;
	}
	public static Map<String,String> toRecord(SysRoleRel vo){
		Map<String,String> map = Maps.newHashMap();
		map.put("id", vo.getId());
		map.put("roleId",vo.getRoleId());
		map.put("objId", vo.getObjId());
		map.put("isValid", vo.isValid()?"是":"否");
		map.put("relType", vo.getRelType()+"");
		map.put("createBy", vo.getCreateBy());
		map.put("updateBy", vo.getUpdateBy());
		return map;
	}
}
