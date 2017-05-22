package com.itour.convert;

import java.util.HashMap;
import java.util.Map;

import com.itour.entity.LogSetting;
import com.itour.entity.LogSettingDetail;
import com.itour.vo.LogSettingDetailVo;
import com.itour.vo.LogSettingVo;
/**
 * 
 * <br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
public class LogSettingDetailKit{
	public static LogSettingDetailVo toVo(LogSettingDetail ls)throws Exception{
		LogSettingDetailVo vo = new LogSettingDetailVo();
    	vo.setCreater(ls.getCreater());
    	vo.setCreateTime(ls.getCreateTime());
    	vo.setLogCode(ls.getLogCode());
    	vo.setColumnDatatype(ls.getColumnDatatype());
    	vo.setColumnName(ls.getColumnName());
    	vo.setColumnText(ls.getColumnText());
    	vo.setDetailCode(ls.getDetailCode());
    	return vo;
    }
    
    public static LogSettingDetail toEntity(LogSettingDetailVo ls)throws Exception{
    	LogSettingDetail vo = new LogSettingDetail();
    	vo.setCreater(ls.getCreater());
    	vo.setCreateTime(ls.getCreateTime());
    	vo.setLogCode(ls.getLogCode());
    	vo.setColumnDatatype(ls.getColumnDatatype());
    	vo.setColumnName(ls.getColumnName());
    	vo.setDetailCode(ls.getDetailCode());
    	vo.setColumnText(ls.getColumnText());
    	return vo;
    }
    
    public static Map<String,Object> toRecord(LogSettingDetail ls)throws Exception{
    	Map<String,Object> record = new HashMap<String,Object>();
    	record.put("logCode", ls.getLogCode());
    	record.put("creater",ls.getCreater());
    	record.put("createTime",ls.getCreateTime());
    	record.put("columnDatatype", ls.getColumnDatatype());
    	record.put("columnName", ls.getColumnName());
    	record.put("columnText", ls.getColumnText());
    	record.put("detailCode", ls.getDetailCode());
    	return record;
    }
}

