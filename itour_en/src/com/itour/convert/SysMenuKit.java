package com.itour.convert;

import java.util.HashMap;
import java.util.Map;

import com.itour.base.util.DateUtil;
import com.itour.entity.SysMenu;


public class SysMenuKit{
	public static Map<String,Object> toRecord(SysMenu menu){
		Map<String,Object> record = new HashMap<String,Object>();
		record.put("id", menu.getId());
		record.put("name", menu.getName());
		record.put("url", menu.getUrl());
		record.put("parentId", menu.getParentId());
		record.put("deleted", menu.getDeleted());
		record.put("createTime", DateUtil.getDateYmdHs(menu.getCreateTime()));
		record.put("updateTime", DateUtil.getDateYmdHs(menu.getUpdateTime()));
		record.put("rank", menu.getRank());
		record.put("actions", menu.getActions());
		record.put("createBy", menu.getCreateBy());
		record.put("updateBy", menu.getUpdateBy());
		record.put("subCount", menu.getSubCount());
		return record;
	}
}
