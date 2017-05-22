package com.itour.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.entity.TravelStyle;
/**
 * 
 * <br>
 * <b>功能：</b>TravelStyleDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface TravelStyleDao<T> extends BaseDao<T> {
	
	List<TravelStyle> queryValid();
	
	/**
	 * 
	 * @return
	 */
	List<Map<String,Object>> loadStyles();
	
	/**
	 * 
	 * @param alias
	 * @return
	 */
	List<TravelStyle> queryByAlias(@Param(value="alias")String alias);
	/**
	 * 
	 * @param ts
	 */
	void updateCover(TravelStyle ts);
}
