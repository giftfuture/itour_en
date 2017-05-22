package com.itour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.FilePros;
import com.itour.dao.TravelItemDao;
import com.itour.entity.TravelItem;
import com.itour.vo.TravelItemVo;

/**
 * 
 * <br>
 * <b>功能：</b>TravelItemService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("travelItemService")
public class TravelItemService<T> extends BaseService<T> {
	
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
    private TravelItemDao<T> mapper;
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	public BasePage<TravelItemVo> pagedQuery(TravelItemVo vo) {
		/*Pager pager = new Pager();
		pager.setOrderDirection(false);
		pager.setOrderField("star_level");*/
		//vo.setPager(pager);
		vo.setSort("star_level");
		vo.setOrderDirection(false);
		//System.out.println("#################"+vo.getPager().getOrderCondition());
		List<TravelItemVo> list = (List<TravelItemVo>) mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		/*List<TravelItemVo> records = Lists.newArrayList();
		for(TravelItem fb:list) {
			records.add(TravelItemKit.toRecord(fb));
		}*/
		return new BasePage<TravelItemVo>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public BasePage<TravelItemVo> pagedQuery2(TravelItemVo vo) {
		vo.setSort("star_level");
		List<TravelItemVo> list = (List<TravelItemVo>) mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		//List<TravelItemVo> records = Lists.newArrayList();
		String coverpath = FilePros.httpitemCoverpath();
		for(TravelItemVo fb:list) {
			if(StringUtils.isNotEmpty(fb.getCover())){	 				
				fb.setCover(coverpath+"/"+StringUtils.trim(fb.getItemCode())+"_"+fb.getAlias()+"/"+fb.getCover());
			}
			//records.add(fb);
		}
		return new BasePage<TravelItemVo>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * 
	 * @param alias
	 * @return
	 * @throws Exception
	 */
	public TravelItemVo getByAlias(String alias)throws Exception{
		return mapper.getByAlias(alias);
	}
	public TravelItemDao<T> getDao() {
		return mapper;
	}
	public List<TravelItemVo> queryByAlias(List<String> alias){
		return mapper.queryByAlias(alias);
	};
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<TravelItemVo> searchTravelItem(Map map)throws Exception{
	   return mapper.searchTravelItem(map);
	}
	/**
	 * 
	 * @param scopeAlias
	 * @return
	 */
	/*public 	List<TravelItem> queryByScopeAlias(String scopeAlias){
		//return mapper.queryByScopeAlias(scopeAlias);
	};*/
	
	/**
	 * 
	 * @param scope
	 * @return
	 */
	public 	List<TravelItemVo> queryByScope(String scope){
		return mapper.queryByScope(scope);
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public BasePage<TravelItemVo> pageQueryByScope(TravelItemVo vo){
		List<TravelItemVo> list = (List<TravelItemVo>)mapper.pageQueryByScope(vo);
		int count = mapper.countByScope(vo);
		//List<TravelItemVo> records = Lists.newArrayList();
		String coverpath = FilePros.httpitemCoverpath();
		for(TravelItemVo fb:list) {
			if(StringUtils.isNotEmpty(fb.getCover())){	 
				fb.setCover(coverpath+"/"+StringUtils.trim(fb.getItemCode())+"_"+fb.getAlias()+"/"+fb.getCover());
			}
			//records.add(fb);
		}
		return new BasePage<TravelItemVo>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * @param style
	 * @return
	 * @throws Exception
	 */
	public List<TravelItemVo> queryByStyle(String style)throws Exception{
		return mapper.queryByStyle(style);
	}
	/**
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public List<TravelItemVo> queryByIds(List<String> ids)throws Exception{
		return mapper.queryByIds(ids);
	};
	
	/**
	 * 
	 * @return
	 */
/*	public List<HashMap<String,String>> allScopes(){
		List<HashMap<String,String>> maps = mapper.allScopes();
		return maps;
	};*/
	/**
	 * 
	 * @return
	 */
	public List<HashMap<String,String>> allItems(){
		List<HashMap<String,String>> maps = mapper.allItems();
		return maps;
	};
	/**
	 * 
	 * @param tsIds
	 * @return
	 */
	public String travelItems(List<String> tsIds){
		return mapper.travelItems(tsIds);
	};
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public TravelItemVo selectById(String id){
		return mapper.selectById(id);
	};
	/**
	 * 
	 * @param itemCode
	 * @return
	 */
	public TravelItemVo queryByItemCode(String itemCode){
		return mapper.queryByItemCode(itemCode);
	}
	
	/**
	 * 
	 * @param vo
	 */
	public void uploadCover(TravelItem vo){
		mapper.uploadCover(vo);
	};
	public List<TravelItemVo> queryMapByScope(String scope){
		return mapper.queryMapByScope(scope);
	}
	
	public List<TravelItemVo> queryBystarLevel(int num){
		List<TravelItemVo> vos = mapper.queryBystarLevel(num);
		String ticoverpath = FilePros.httpitemCoverpath();
		for(TravelItemVo vo:vos){
			vo.setCover(StringUtils.trim(ticoverpath+"/"+vo.getItemCode()+"_"+vo.getAlias()+"/"+vo.getCover()));
		}
		return vos;
	}
	
}
