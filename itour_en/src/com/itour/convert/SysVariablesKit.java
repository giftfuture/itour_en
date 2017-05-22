package com.itour.convert;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.itour.base.util.DateUtil;
import com.itour.entity.SysVariables;
import com.itour.vo.SysVariablesVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class SysVariablesKit{
	public static SysVariables toEntity(SysVariablesVo vo)throws Exception{
		SysVariables variable = new SysVariables();
		variable.setId(vo.getId());
		variable.setValid(vo.isValid());
		variable.setVarHostip(vo.getVarHostip());
		variable.setVarHostname(vo.getVarHostname());
		variable.setVarName(vo.getVarName());
		variable.setVarProject(vo.getVarProject());
		variable.setVarValue(vo.getVarValue());
		variable.setRemark(vo.getRemark());
		variable.setCreateBy(vo.getCreateBy());
		variable.setUpdateBy(vo.getUpdateBy());
		if(StringUtils.isNotEmpty(vo.getCreateTime())){
			variable.setCreateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getCreateTime()));
		}
		if(StringUtils.isNotEmpty(vo.getUpdateTime())){
			variable.setUpdateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, vo.getUpdateTime()));
		}
		return variable;
	}
	public static SysVariablesVo toVo(SysVariables vo)throws Exception{
		SysVariablesVo variable = new SysVariablesVo();
		variable.setId(vo.getId());
		variable.setValid(vo.isValid());
		variable.setRemark(vo.getRemark());
		variable.setCreateBy(vo.getCreateBy());
		variable.setUpdateBy(vo.getUpdateBy());
		variable.setVarHostip(vo.getVarHostip());
		variable.setVarHostname(vo.getVarHostname());
		variable.setVarName(vo.getVarName());
		variable.setVarProject(vo.getVarProject());
		variable.setVarValue(vo.getVarValue());
		variable.setCreateTime(DateUtil.getDateYmdHs(vo.getCreateTime()));
		variable.setUpdateTime(DateUtil.getDateYmdHs(vo.getUpdateTime()));
		return variable;
	}
	public static Map<String,String> toRecord(SysVariables vo){
		Map<String,String> map = Maps.newHashMap();
		map.put("id", vo.getId());
		map.put("varHostip",vo.getVarHostip());
		map.put("varHostname", vo.getVarHostname());
		map.put("valid", vo.isValid()?"是":"否");
		map.put("varName", vo.getVarName());
		map.put("varProject", vo.getVarProject());
		map.put("varValue", vo.getVarValue());
		map.put("remark", vo.getRemark());
		map.put("createBy", vo.getCreateBy());
		map.put("updateBy", vo.getUpdateBy());
		return map;
	}
}

