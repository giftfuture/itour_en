package com.itour.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.FilePros;
import com.itour.convert.RouteTemplateKit;
import com.itour.dao.RouteTemplateDao;
import com.itour.dao.TravelItemDao;
import com.itour.dao.TravelStyleDao;
import com.itour.entity.RouteTemplate;
import com.itour.entity.TravelStyle;
import com.itour.vo.RouteTemplateVO;
import com.itour.vo.TravelItemVO;

/**
 * 
 * <br>
 * <b>功能：</b>RouteTemplateService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service//("routeTemplateService")
public class RouteTemplateService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<RouteTemplateVO> pagedQuery(RouteTemplateVO vo) {
		//vo.setOrder("star_level");
		vo.setSort("star_level");
		vo.setOrderDirection(false);
		List<RouteTemplateVO> list = (List<RouteTemplateVO>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<RouteTemplateVO> records = Lists.newArrayList();
		//tring rtCoverPath = FilePros.httpRouteCoverpath();
		for(RouteTemplateVO fb:list) {
			if(StringUtils.isNotEmpty(fb.getTravelItems())){
				 String[] params = fb.getTravelItems().split(",");
				String travelItems = tiDao.travelItems(Arrays.asList(params));
				fb.setTravelItems(travelItems);
			}
		/*	if(StringUtils.isNotEmpty(fb.getSimilars())){
				String[] similars = fb.getSimilars().split(",");
				List<RouteTemplate> simlist = mapper.queryByRelated(Arrays.asList(similars));
				List<String> sims = Lists.newArrayList();
				for(RouteTemplate rt:simlist){
					sims.add(rt.getTitle());
				}
				fb.setSimilars(StringUtils.join(sims.toArray(), ","));
			}*/
			List<RouteTemplateVO>  relates = mapper.queryByRelatedRoutes(vo.getId());
			fb.setRelates(relates);
			StringBuffer relatedRouteTitles = new StringBuffer();
			for(RouteTemplateVO rtvo:relates){
				relatedRouteTitles.append(rtvo.getTitle()+",");
			}
			fb.setRelatedRouteTitles(relatedRouteTitles.toString());
			//String coverpath = rtCoverPath+"/"+fb.getRouteCode()+"_"+fb.getAlias()+"/"+fb.getCover();
			//fb.setCover(coverpath);
			records.add(fb);
		}
		return new BasePage<RouteTemplateVO>(vo.getStart(), vo.getLimit(), records,count);
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public BasePage<RouteTemplateVO> searchpagedQuery(RouteTemplateVO vo) {
		//vo.setOrder("starLevel");
		vo.setSort("star_level");
		vo.setOrderDirection(false);
		List<RouteTemplateVO> list = (List<RouteTemplateVO>) mapper.searchRts(vo);
		int count = mapper.searchRtsByCount(vo);
		List<RouteTemplateVO> records = Lists.newArrayList();
		String rtCoverPath = FilePros.httpRouteCoverpath();
		for(RouteTemplateVO fb:list){
		/*	if(StringUtils.isNotEmpty(fb.getTravelItems())){
				String[] params = fb.getTravelItems().split(",");
				String travelItems = tiDao.travelItems(Arrays.asList(params));
				fb.setTravelItems(travelItems);
			}
			if(StringUtils.isNotEmpty(fb.getSimilars())){
				String[] similars = fb.getSimilars().split(",");
				List<RouteTemplate> simlist = mapper.queryByRelated(Arrays.asList(similars));
				List<String> sims = Lists.newArrayList();
				for(RouteTemplate rt:simlist){
					sims.add(rt.getTitle());
				}
				fb.setSimilars(StringUtils.join(sims.toArray(), ","));
			}*/
			//rt.setCover(coverpath+"/"+rt.getRouteCode()+"_"+rt.getAlias()+"/"+rt.getCover());
			String coverpath = rtCoverPath+"/"+StringUtils.trim(fb.getRouteCode())+"_"+StringUtils.trim(fb.getAlias())+"/"+fb.getCover();
			fb.setCover(coverpath);
			List<RouteTemplateVO> relates = mapper.queryByRelatedRoutes(fb.getId());
			fb.setRelates(relates);
			StringBuffer relatedRouteTitles = new StringBuffer();
			for(RouteTemplateVO rtvo:relates){
				relatedRouteTitles.append(rtvo.getTitle()+",");
			}
			fb.setRelatedRouteTitles(relatedRouteTitles.toString());
			records.add(fb);
		}
		return new BasePage<RouteTemplateVO>(vo.getStart(), vo.getLimit(), list,count);
	}
	/**
	 * 
	 * @param style
	 * @return
	 * @throws Exception
	 */
	public List<RouteTemplateVO> queryByStyle(String style)throws Exception{
		List<RouteTemplate> list = mapper.queryByStyle(style);
		List<RouteTemplateVO> vos = Lists.newArrayList();
		String rtCoverPath = FilePros.httpRouteCoverpath();
		for(RouteTemplate rt :list){
			String coverpath = rtCoverPath+"/"+StringUtils.trim(rt.getRouteCode())+"_"+StringUtils.trim(rt.getAlias())+"/"+rt.getCover();
			rt.setCover(coverpath);
			vos.add(RouteTemplateKit.toRecord(rt));
		}
		return vos;
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public BasePage<RouteTemplateVO> pageQueryByStyle(RouteTemplateVO vo)throws Exception{
		List<RouteTemplateVO> list = mapper.pageQueryByStyle(vo);
		int count = mapper.countQueryByStyle(vo);
		//List<RouteTemplateVO> vos = Lists.newArrayList();
		String rtCoverPath = FilePros.httpRouteCoverpath();
		for(RouteTemplateVO rt :list){
			String coverpath = rtCoverPath+"/"+StringUtils.trim(rt.getRouteCode())+"_"+StringUtils.trim(rt.getAlias())+"/"+rt.getCover();
			rt.setCover(coverpath);
			List<RouteTemplateVO> relates = mapper.queryByRelatedRoutes(rt.getId());
			rt.setRelates(relates);
			StringBuffer relatedRouteTitles = new StringBuffer();
			for(RouteTemplateVO rtvo:relates){
				relatedRouteTitles.append(rtvo.getTitle()+",");
			}
			rt.setRelatedRouteTitles(relatedRouteTitles.toString());
			//vos.add(RouteTemplateKit.toRecord(rt));
		}
		return new BasePage<RouteTemplateVO>(vo.getStart(), vo.getLimit(), list,count);
	}
	/**
	 * 
	 * @param related
	 * @return
	 * @throws Exception
	 */
	public List<RouteTemplateVO> queryByIds(List<String> ids)throws Exception{
		List<RouteTemplate> list = mapper.queryByIds(ids);
		List<RouteTemplateVO> vos = Lists.newArrayList();
		for(RouteTemplate rt:list){
			vos.add(RouteTemplateKit.toRecord(rt));
		}
		return vos;
	}
	
	/**
	 * 
	 * @param travelItems
	 * @return
	 * @throws Exception
	 */
	public List<RouteTemplateVO> queryByItems(String travelItems)throws Exception{
		List<RouteTemplateVO> list = mapper.queryByItems(travelItems);
		List<RouteTemplateVO> vos = Lists.newArrayList();
		String rtCoverPath = FilePros.httpRouteCoverpath();
		for(RouteTemplateVO rt:list){
			String coverpath = rtCoverPath+"/"+StringUtils.trim(rt.getRouteCode())+"_"+StringUtils.trim(rt.getAlias())+"/"+rt.getCover();
			rt.setCover(coverpath);
			List<RouteTemplateVO> relates = mapper.queryByRelatedRoutes(rt.getId());
			rt.setRelates(relates);
			StringBuffer relatedRouteTitles = new StringBuffer();
			for(RouteTemplateVO rtvo:relates){
				relatedRouteTitles.append(rtvo.getTitle()+",");
			}
			rt.setRelatedRouteTitles(relatedRouteTitles.toString());
			vos.add(rt);
		}
		return vos;
	}
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public BasePage<RouteTemplateVO> pageQueryByItems(RouteTemplateVO vo)throws Exception{
		List<RouteTemplateVO> list = mapper.pageQueryByItems(vo);
		List<RouteTemplateVO> vos = Lists.newArrayList();
		String rtCoverPath = FilePros.httpRouteCoverpath();
		for(RouteTemplateVO rt:list){
			String coverpath = rtCoverPath+"/"+StringUtils.trim(rt.getRouteCode())+"_"+StringUtils.trim(rt.getAlias())+"/"+rt.getCover();
			rt.setCover(coverpath);
			List<RouteTemplateVO> relates = mapper.queryByRelatedRoutes(rt.getId());
			rt.setRelates(relates);
			StringBuffer relatedRouteTitles = new StringBuffer();
			for(RouteTemplateVO rtvo:relates){
				relatedRouteTitles.append(rtvo.getTitle()+",");
			}
			rt.setRelatedRouteTitles(relatedRouteTitles.toString());
			vos.add(rt);
		}
		int count = mapper.countQueryByItems(vo);
		return new BasePage<RouteTemplateVO>(vo.getStart(), vo.getLimit(), vos,count);
	}
	/**
	 * 
	 * @param alias
	 * @return
	 * @throws Exception
	 */
	public RouteTemplateVO queryByAlias(String alias)throws Exception{
		RouteTemplate rt = mapper.queryByAlias(alias);
		return RouteTemplateKit.toRecord(rt);
	}
	/**
	 * 
	 * @param vo
	 */
	public void uploadCover(RouteTemplate vo){
		mapper.uploadCover(vo);
	};
	/**
	 * 
	 * @param vo
	 */
	public void uploadMap(RouteTemplate vo){
		mapper.uploadMap(vo);
	};
	/**
	 * 
	 * @param id
	 * @param quoteForm
	 */
	/*public void updateQuoteForm(RouteTemplate entity){
		mapper.update(entity);
	};*/
	/**
	 * 
	 * @param entity
	 */
	public void updateQuotoForm(RouteTemplate entity){
		mapper.update(entity);
	};
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public RouteTemplateVO selectById(String id){
		RouteTemplateVO vo =  mapper.selectById(id);
		String ts = vo.getTravelItems();
		List<TravelItemVO> list = tiDao.queryByIds(Arrays.asList(ts.split(",")));
		List<String> alias = Lists.newArrayList();
		for(TravelItemVO ti:list){
			alias.add(ti.getAlias());
		}
		//StringUtils.collectionToDelimitedString(list, ",");  
		//StringUtils.join(list.toArray(), ","); 
		vo.setTravelItems(Joiner.on(",").join(alias));
		List<RouteTemplateVO> relates = mapper.queryByRelatedRoutes(id);
		//List<String> relates = Lists.newArrayList();
		/*for(RouteTemplateVO rt:rts){
			relates.add(rt.getRouteCode());
		}*/
		vo.setRelates(relates);
		StringBuffer relatedRouteTitles = new StringBuffer();
		for(RouteTemplateVO rtvo:relates){
			relatedRouteTitles.append(rtvo.getTitle()+",");
		}
		vo.setRelatedRouteTitles(relatedRouteTitles.toString());
		/*TravelStyle tstyle =(TravelStyle)tsDao.queryById(vo.getTravelStyle());
		vo.setTravelStyle(tstyle!=null?tstyle.getAlias():"");*/
		return vo;
	}

	/**
	 * 
	 * @param routeCode
	 * @return
	 */
	public RouteTemplate selectByRouteCode(String routeCode){
		return mapper.selectByRouteCode(routeCode);
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
/*	public List<RouteTemplateVO> searchRts(Map map)throws Exception{
		return mapper.searchRts(map);
	};*/
	public 	List<RouteTemplateVO> queryAll()throws Exception{
		return mapper.queryAll();
	};
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<RouteTemplateVO> queryByRelatedRoutes(String id){
		return mapper.queryByRelatedRoutes(id);
	};
	@Autowired
    private RouteTemplateDao<T> mapper;
		
	public RouteTemplateDao<T> getDao() {
		return mapper;
	}
	@Autowired
	private TravelItemDao<T> tiDao;
	public TravelItemDao<T> gettiDao() {
		return tiDao;
	}
	@Autowired
	private TravelStyleDao<T> tsDao;
	public TravelStyleDao<T> gettsDao(){
		return tsDao;
	}
	
	
}
