package com.itour.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.entity.TravelItem;
import com.itour.vo.TravelItemVo;
/**
 * 
 * <br>
 * <b>功能：</b>TravelItemDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface TravelItemDao<T> extends BaseDao<T> {
	/**
	 * 
	 * @param map
	 * @return
	 */
	List<TravelItemVo> searchTravelItem(Map map);
	/**
	 * 
	 * @param style
	 * @return
	 */
	List<TravelItemVo> queryByStyle(@Param(value="travelStyle")String travelStyle);
	/**
	 * 
	 * @param scopeAlias
	 * @return
	 */
	//List<TravelItem> queryByScopeAlias(@Param(value="scopeAlias")String scopeAlias);
	
	/**
	 * 
	 * @param scope
	 * @return
	 */
	List<TravelItemVo> queryByScope(@Param(value="scope")String scope);
	/**
	 * 
	 * @param ids
	 * @return
	 */
	List<TravelItemVo> queryByIds(List<String> ids);
	
	/**
	 * 
	 * @param alias
	 * @return
	 */
	List<TravelItemVo> queryByAlias(List<String> alias);
	/**
	 * 
	 * @param item
	 * @return
	 */
	TravelItemVo getByAlias(@Param(value="alias")String alias);
	
	/**
	 * 加载所有地区，省份 List<Map<String, String>>
	 * @return
	 */
/*	@MapKey("scopeAlias")
	 List<HashMap<String,String>> allScopes();{
		FblMapResultHandler fbl = new FblMapResultHandler();  
		//getSqlSession().select(NAMESPACE +"getAllSetDays",fbl);  
		Map<String,String> map =fbl.getMappedResults();  
		return map;
	};*/
	/*   */
	@MapKey("alias")
	List<HashMap<String,String>> allItems();
	/**
	 * 
	 * @param tsIds
	 * @return
	 */
	String travelItems(List<String> tsIds);
	
	/**
	 * 
	 * @return
	 */
	List<TravelItemVo> queryByListVo(BasePage vo);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
    TravelItemVo selectById(@Param(value="id")String id);
    
    /**
     * 
     * @param itemCode
     * @return
     */
    TravelItemVo queryByItemCode(@Param(value="itemCode")String itemCode);
    /**
     * 
     * @param vo
     * @return
     */
    List<TravelItemVo> pageQueryByScope(TravelItemVo vo);
    /**
     * 
     * @param vo
     * @return
     */
    int countByScope(TravelItemVo vo);
    
    /**
     * 
     * @param ti
     */
    void uploadCover(TravelItem ti);
    
    /**
     * 
     * @param scope
     * @return
     */
    List<TravelItemVo> queryMapByScope(@Param(value="scope")String scope);
    
    /**
     * 
     * @return
     */
    List<TravelItemVo> queryBystarLevel(@Param(value="limit")int limit);
    
}
