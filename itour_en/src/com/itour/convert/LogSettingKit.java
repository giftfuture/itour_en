package com.itour.convert;

import java.util.HashMap;
import java.util.Map;

import com.itour.base.util.DateUtil;
import com.itour.entity.LogSetting;
import com.itour.vo.LogSettingVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class LogSettingKit{
	
    public static LogSettingVo toVo(LogSetting ls)throws Exception{
    	LogSettingVo vo = new LogSettingVo();
    	vo.setCreater(ls.getCreater());
    	vo.setCreateTime(DateUtil.formatDate(ls.getCreateTime(), DateUtil.y_m_dhms));
    	vo.setDeletescriptTemplate(ls.getDeletescriptTemplate());
    	vo.setFunction(ls.getFunction());
    	vo.setLogCode(ls.getLogCode());
    	vo.setTableName(ls.getTableName());
    	vo.setUpdatescriptTemplate(ls.getUpdatescriptTemplate());
    	vo.setUrlTeimplate(ls.getUrlTeimplate());
    	vo.setId(ls.getId());
    	return vo;
    }
    
    public static LogSetting toEntity(LogSettingVo ls)throws Exception{
    	LogSetting vo = new LogSetting();
    	vo.setCreater(ls.getCreater());
    	vo.setCreateTime(DateUtil.fromStringToDate(DateUtil.y_m_dhms, ls.getCreateTime()));
    	vo.setDeletescriptTemplate(ls.getDeletescriptTemplate());
    	vo.setFunction(ls.getFunction());
    	vo.setLogCode(ls.getLogCode());
    	vo.setTableName(ls.getTableName());
    	vo.setUpdatescriptTemplate(ls.getUpdatescriptTemplate());
    	vo.setUrlTeimplate(ls.getUrlTeimplate());
    	vo.setId(ls.getId());
    	return vo;
    }
    
    public static Map<String,Object> toRecord(LogSetting ls)throws Exception{
    	Map<String,Object> record = new HashMap<String,Object>();
    	record.put("logCode", ls.getLogCode());
    	record.put("creater",ls.getCreater());
    	record.put("createTime",DateUtil.formatDate(ls.getCreateTime(), DateUtil.y_m_dhms));
    	record.put("deletescriptTemplate", ls.getDeletescriptTemplate());
    	record.put("function", ls.getFunction());
    	record.put("tableName", ls.getTableName());
    	record.put("updatescriptTemplate", ls.getUpdatescriptTemplate());
    	record.put("urlTeimplate", ls.getUrlTeimplate());
    	record.put("id", ls.getId());
    	return record;
    }
}

