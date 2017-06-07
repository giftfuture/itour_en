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
import com.itour.vo.TravelItemVO;

/**
 * 
 * <br>
 * <b>功能：</b>TravelItemService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service//("travelItemService")
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
	public BasePage<TravelItemVO> pagedQuery(TravelItemVO vo) {
		/*Pager pager = new Pager();
		pager.setOrderDirection(false);
		pager.setOrderField("star_level");*/
		//vo.setPager(pager);
		vo.setSort("star_level");
		vo.setOrderDirection(false);
		//System.out.println("#################"+vo.getPager().getOrderCondition());
		List<TravelItemVO> list = (List<TravelItemVO>) mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		/*List<TravelItemVO> records = Lists.newArrayList();
		for(TravelItem fb:list) {
			records.add(TravelItemKit.toRecord(fb));
		}*/
		return new BasePage<TravelItemVO>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public BasePage<TravelItemVO> pagedQuery2(TravelItemVO vo) {
		vo.setSort("star_level");
		List<TravelItemVO> list = (List<TravelItemVO>) mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		//List<TravelItemVO> records = Lists.newArrayList();
		String coverpath = FilePros.httpitemCoverpath();
		for(TravelItemVO fb:list) {
			if(StringUtils.isNotEmpty(fb.getCover())){	 				
				fb.setCover(coverpath+"/"+StringUtils.trim(fb.getItemCode())+"_"+fb.getAlias()+"/"+fb.getCover());
			}
			//records.add(fb);
		}
		return new BasePage<TravelItemVO>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * 
	 * @param alias
	 * @return
	 * @throws Exception
	 */
	public TravelItemVO getByAlias(String alias)throws Exception{
		return mapper.getByAlias(alias);
	}
	public TravelItemDao<T> getDao() {
		return mapper;
	}
	public List<TravelItemVO> queryByAlias(List<String> alias){
		return mapper.queryByAlias(alias);
	};
	/**
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<TravelItemVO> searchTravelItem(Map map)throws Exception{
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
	public 	List<TravelItemVO> queryByScope(String scope){
		return mapper.queryByScope(scope);
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public BasePage<TravelItemVO> pageQueryByScope(TravelItemVO vo){
		List<TravelItemVO> list = (List<TravelItemVO>)mapper.pageQueryByScope(vo);
		int count = mapper.countByScope(vo);
		//List<TravelItemVO> records = Lists.newArrayList();
		String coverpath = FilePros.httpitemCoverpath();
		for(TravelItemVO fb:list) {
			if(StringUtils.isNotEmpty(fb.getCover())){	 
				fb.setCover(coverpath+"/"+StringUtils.trim(fb.getItemCode())+"_"+fb.getAlias()+"/"+fb.getCover());
			}
			//records.add(fb);
		}
		return new BasePage<TravelItemVO>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * @param style
	 * @return
	 * @throws Exception
	 */
	public List<TravelItemVO> queryByStyle(String style)throws Exception{
		return mapper.queryByStyle(style);
	}
	/**
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public List<TravelItemVO> queryByIds(List<String> ids)throws Exception{
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
	public TravelItemVO selectById(String id){
		return mapper.selectById(id);
	};
	/**
	 * 
	 * @param itemCode
	 * @return
	 */
	public TravelItemVO queryByItemCode(String itemCode){
		return mapper.queryByItemCode(itemCode);
	}
	
	/**
	 * 
	 * @param vo
	 */
	public void uploadCover(TravelItem vo){
		mapper.uploadCover(vo);
	};
	public List<TravelItemVO> queryMapByScope(String scope){
		return mapper.queryMapByScope(scope);
	}
	
	public List<TravelItemVO> queryBystarLevel(int num){
		List<TravelItemVO> vos = mapper.queryBystarLevel(num);
		String ticoverpath = FilePros.httpitemCoverpath();
		for(TravelItemVO vo:vos){
			vo.setCover(StringUtils.trim(ticoverpath+"/"+vo.getItemCode()+"_"+vo.getAlias()+"/"+vo.getCover()));
		}
		return vos;
	}
	
}
