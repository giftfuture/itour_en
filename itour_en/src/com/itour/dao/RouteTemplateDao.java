package com.itour.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.entity.RouteTemplate;
import com.itour.vo.RouteTemplateVO;
/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateDao<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 */
public interface RouteTemplateDao<T> extends BaseDao<T> {
	
	/**
	 * 
	 * @param style
	 * @return
	 */
	List<RouteTemplate> queryByStyle(@Param(value="travelStyle")String travelStyle);
	/**
	 * 
	 * @param related
	 * @return
	 */
	List<RouteTemplate> queryByIds(List<String> ids);
	
	/**
	 * 
	 * @param travelItems
	 * @return
	 */
	List<RouteTemplateVO> queryByItems(@Param(value="travelItems")String travelItems);
	/**
	 * 
	 * @param alias
	 * @return
	 */
	RouteTemplate queryByAlias(@Param(value="alias")String alias);
	/**
	 * 
	 * @param id
	 * @param quoteForm
	 */
	public void update(RouteTemplate entity);//updateQuoteForm
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public RouteTemplateVO selectById(@Param(value="id")String id);
	
	/**
	 * 
	 * @param routeCode
	 * @return
	 */
	public RouteTemplate selectByRouteCode(@Param(value="routeCode")String routeCode);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<RouteTemplateVO> searchRts(BasePage page);
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public int searchRtsByCount(BasePage page);
	/**
	 * 
	 * @return
	 */
	List<RouteTemplateVO> queryAll();
	/**
	 * 
	 * @param vo
	 */
	 void uploadCover(RouteTemplate vo);
	
	/**
	 * 
	 * @param vo
	 */
	void uploadMap(RouteTemplate vo);
	
	/**
	 * 
	 * @param vo
	 */
	void updateQuotoForm(RouteTemplate vo);
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	List<RouteTemplateVO> pageQueryByItems(RouteTemplateVO vo);
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	int countQueryByItems(RouteTemplateVO page);
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	List<RouteTemplateVO> pageQueryByStyle(RouteTemplateVO vo);
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	int countQueryByStyle(RouteTemplateVO vo);
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<RouteTemplateVO> queryByRelatedRoutes(@Param(value="id")String id);
	
}
