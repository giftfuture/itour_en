package com.itour.convert;


import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;
import com.itour.base.util.DateUtil;
import com.itour.entity.LogOperation;
import com.itour.entity.LogSetting;
import com.itour.vo.LogOperationVo;
import com.itour.vo.LogSettingVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class LogOperationKit{
	public static LogOperationVo toVo(LogOperation ls)throws Exception{
		LogOperationVo vo = new LogOperationVo();
    	vo.setCreater(ls.getCreater());
    	vo.setCreateTime(DateUtil.formatDate(ls.getCreateTime(), DateUtil.y_m_dhms));
    	vo.setLogCode(ls.getLogCode());
    	vo.setContent(ls.getContent());
    	vo.setNewContent(ls.getNewContent());
    	vo.setOperationType(ls.getOperationType());
    	vo.setOperCode(ls.getOperCode());
    	vo.setPrimaryKeyvalue(ls.getPrimaryKeyvalue());
    	vo.setUrl(ls.getUrl());
    	vo.setId(ls.getId());
    	return vo;
    }
    
    public static LogOperation toEntity(LogOperationVo ls)throws Exception{
    	LogOperation vo = new LogOperation();
    	vo.setCreater(ls.getCreater());
    	vo.setCreateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, ls.getCreateTime()));
    	vo.setLogCode(ls.getLogCode());
    	vo.setContent(ls.getContent());
    	vo.setNewContent(ls.getNewContent());
    	vo.setOperationType(ls.getOperationType());
    	vo.setOperCode(ls.getOperCode());
    	vo.setPrimaryKeyvalue(ls.getPrimaryKeyvalue());
    	vo.setUrl(ls.getUrl());
    	vo.setId(ls.getId());
    	return vo;
    }
    
    public static Map<String,Object> toRecord(LogOperation ls)throws Exception{
    	Map<String,Object> record = Maps.newHashMap();
    	record.put("logCode", ls.getLogCode());
    	record.put("creater",ls.getCreater());
    	record.put("createTime",ls.getCreateTime());
    	record.put("content", ls.getContent());
    	record.put("operationType", ls.getOperationType());
    	record.put("operCode", ls.getOperCode());
    	record.put("primaryKeyvalue", ls.getPrimaryKeyvalue());
    	record.put("newContent", ls.getNewContent());
    	record.put("url", ls.getUrl());
    	record.put("id", ls.getId());
    	return record;
    }
}

