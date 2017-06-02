package com.itour.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.entity.TravelItem;
import com.itour.vo.TravelItemVO;
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
	List<TravelItemVO> searchTravelItem(Map map);
	/**
	 * 
	 * @param style
	 * @return
	 */
	List<TravelItemVO> queryByStyle(@Param(value="travelStyle")String travelStyle);
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
	List<TravelItemVO> queryByScope(@Param(value="scope")String scope);
	/**
	 * 
	 * @param ids
	 * @return
	 */
	List<TravelItemVO> queryByIds(List<String> ids);
	
	/**
	 * 
	 * @param alias
	 * @return
	 */
	List<TravelItemVO> queryByAlias(List<String> alias);
	/**
	 * 
	 * @param item
	 * @return
	 */
	TravelItemVO getByAlias(@Param(value="alias")String alias);
	
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
	List<TravelItemVO> queryByListVo(BasePage vo);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
    TravelItemVO selectById(@Param(value="id")String id);
    
    /**
     * 
     * @param itemCode
     * @return
     */
    TravelItemVO queryByItemCode(@Param(value="itemCode")String itemCode);
    /**
     * 
     * @param vo
     * @return
     */
    List<TravelItemVO> pageQueryByScope(TravelItemVO vo);
    /**
     * 
     * @param vo
     * @return
     */
    int countByScope(TravelItemVO vo);
    
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
    List<TravelItemVO> queryMapByScope(@Param(value="scope")String scope);
    
    /**
     * 
     * @return
     */
    List<TravelItemVO> queryBystarLevel(@Param(value="limit")int limit);
    
}
