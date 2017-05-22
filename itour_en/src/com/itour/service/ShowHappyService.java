package com.itour.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.jdbc.JDBCDao;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.FilePros;
import com.itour.convert.ShowHappyKit;
import com.itour.dao.ShowHappyDao;
import com.itour.entity.ShowHappy;
import com.itour.util.Constants;
import com.itour.vo.ShowHappyVo;

/**
 * 
 * <br>
 * <b>功能：</b>CustomersService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("showHappyService")
public class ShowHappyService extends BaseService<ShowHappy> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private ShowHappyDao mapper;
									
	public ShowHappyDao getDao(){
		return mapper;
	}
	public List<ShowHappyVo> queryAll()throws Exception{
		return mapper.queryAll();
	}
	public int countAll()	throws Exception{
		return mapper.countAll();
	}
	public BasePage<ShowHappyVo> showPageQuery(ShowHappyVo vo) throws Exception{
		List<ShowHappyVo> list = null;
		int count=0;
		if(Constants.showhappypage.size()>=Constants.happyperPage){
			list = Constants.showhappypage.subList((int)vo.getPager().getPageOffset(), Constants.happyperPage);
			count = Constants.showhappypage.size();
		}else{
			list = mapper.queryByListVo(vo);
			count = mapper.countAll();
			String shareHappyCoverPath = FilePros.httpshCoverPath();
			for(ShowHappyVo shvo:list) {
				String coverpath = shareHappyCoverPath+"/"+shvo.getShCode()+"_"+shvo.getRoute()+"/";
				shvo.setCover(coverpath+shvo.getCover());
			}
		}
		return new BasePage<ShowHappyVo>(vo.getStart(), vo.getLimit(), list, count);
	}
	public void addShowHappy(ShowHappy sh)throws Exception{
		 mapper.add(sh);
	}
	public ShowHappyVo queryByCode(String shCode){
		return mapper.queryByCode(shCode);
	}
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<ShowHappyVo> pagedQuery(ShowHappyVo vo) {
		List<ShowHappyVo> list = mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		String shareHappyCoverPath = FilePros.httpshCoverPath();
		//BasePage<CustomerVo> basepage = (BasePage<CustomerVo>)mapper.pagedQuery(page);
		//Map<String, String> map = Maps.newHashMap();
		//List<Map<String, Object>> records = Lists.newArrayList();
		for(ShowHappyVo shvo:list) {
			//ShowHappy sh = list.get(i);
			String coverpath = shareHappyCoverPath+"/"+shvo.getShCode()+"_"+shvo.getRoute()+"/";
			shvo.setCover(coverpath+shvo.getCover());
			//records.add(ShowHappyKit.toRecord(sh));
		}
		return new BasePage<ShowHappyVo>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ShowHappyVo selectById(String id){
		return mapper.selectById(id);
	};
	/**
	 * 
	 * @param vo
	 * @return
	 */
	List<ShowHappyVo> queryByListVo(ShowHappyVo vo){
		return mapper.queryByListVo(vo);
	};
	
}
