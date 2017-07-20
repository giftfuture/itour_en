package com.itour.service;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.FilePros;
import com.itour.dao.ShowHappyDao;
import com.itour.entity.ShowHappy;
import com.itour.listener.event.ShowHappyEvent;
import com.itour.listener.event.TravelStyleEvent;
import com.itour.listener.listener.ShowHappyListener;
import com.itour.listener.listener.TravelStyleListener;
import com.itour.util.Constants;
import com.itour.vo.ShowHappyVO;

/**
 * 
 * <br>
 * <b>功能：</b>CustomersService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service 
public class ShowHappyService extends BaseService<ShowHappy> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private ShowHappyDao mapper;
									
	public ShowHappyDao getDao(){
		return mapper;
	}
	private ShowHappyListener showHappyListener;
	private Vector  repository = new Vector ();
	public void addShowHappyListener(ShowHappyListener ll){
		repository.addElement(ll);//这步要注意同步问题  
	}
	public void notifyShowHappyEvent(ShowHappyEvent event) {  
        Enumeration e = repository.elements();//这步要注意同步问题  
        while(e.hasMoreElements()){  
        	showHappyListener = (ShowHappyListener)e.nextElement();  
        	showHappyListener.event(event); 
        }  
    }
	public void removeTravelStyleListener(TravelStyleListener ll){  
        repository.remove(ll);//这步要注意同步问题  
    }
	public List<ShowHappyVO> queryAll()throws Exception{
		return mapper.queryAll();
	}
	public int countAll()throws Exception{
		return mapper.countAll();
	}
	public BasePage<ShowHappyVO> showPageQuery(ShowHappyVO vo) throws Exception{
		List<ShowHappyVO> list = null;
		int count=0;
		if(Constants.showhappypage.size()>=Constants.happyperPage){
			count = Constants.showhappypage.size();
			int start = (int)(vo.getPager().getPageId()-1)*Constants.happyperPage;
			int end = start + Constants.happyperPage > count ? count : start + Constants.happyperPage ;
			list = Constants.showhappypage.subList(start, end);
		}else{
			list = mapper.queryByListVo(vo);
			count = mapper.countAll();
			String shareHappyCoverPath = FilePros.httpshCoverPath();
			for(ShowHappyVO shvo:list) {
				String coverpath = shareHappyCoverPath+"/"+shvo.getShCode()+"_"+shvo.getRoute()+"/";
				shvo.setCover(coverpath+shvo.getCover());
			}
		}
		return new BasePage<ShowHappyVO>(vo.getStart(), vo.getLimit(), list, count);
	}
	public void addShowHappy(ShowHappy sh)throws Exception{
		int result = mapper.add(sh);
		if(result > 0 ){
			notifyShowHappyEvent(new ShowHappyEvent(this));
		}
	}
	public ShowHappyVO queryByCode(String shCode){
		return mapper.queryByCode(shCode);
	}
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<ShowHappyVO> pagedQuery(ShowHappyVO vo) {
		List<ShowHappyVO> list = mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		String shareHappyCoverPath = FilePros.httpshCoverPath();
		//BasePage<CustomerVO> basepage = (BasePage<CustomerVO>)mapper.pagedQuery(page);
		//Map<String, String> map = Maps.newHashMap();
		//List<Map<String, Object>> records = Lists.newArrayList();
		for(ShowHappyVO shvo:list) {
			//ShowHappy sh = list.get(i);
			String coverpath = shareHappyCoverPath+"/"+shvo.getShCode()+"_"+shvo.getRoute()+"/";
			shvo.setCover(coverpath+shvo.getCover());
			//records.add(ShowHappyKit.toRecord(sh));
		}
		return new BasePage<ShowHappyVO>(vo.getStart(), vo.getLimit(), list, count);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ShowHappyVO selectById(String id){
		return mapper.selectById(id);
	};
	
	/**
	 * 
	 * @param vo
	 * @return
	 */
	List<ShowHappyVO> queryByListVo(ShowHappyVO vo){
		return mapper.queryByListVo(vo);
	};
	
}
