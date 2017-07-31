package com.itour.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.ClassReflectUtil;
import com.itour.base.util.IDGenerator;
import com.itour.convert.SysMenuKit;
import com.itour.convert.TravelStyleKit;
import com.itour.dao.TravelStyleDao;
import com.itour.entity.TravelStyle;
import com.itour.listener.event.TravelStyleEvent;
import com.itour.listener.listener.BaseListener;
import com.itour.listener.listener.TravelStyleListener;
import com.itour.listener.listener.impl.SystemVariablesListenerImpl;
import com.itour.listener.listener.impl.TravelStyleListenerImpl;
import com.itour.vo.TravelStyleVO;

/**
 * 
 * <br>
 * <b>功能：</b>TravelStyleService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service 
public class TravelStyleService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	 
	public TravelStyleListener baseListener(){
		return new TravelStyleListenerImpl();
	};
	private Vector  repository = new Vector ();
	public void addTravelStyleListener(TravelStyleListener ll){
		repository.addElement(ll);//这步要注意同步问题  
	}
	public void notifyBaseEvent(TravelStyleEvent event) {  
      /*  Enumeration e = repository.elements();//这步要注意同步问题  
        while(e.hasMoreElements()){  
        	travelStyleListener = (TravelStyleListener)e.nextElement();  
        	travelStyleListener.event(event); 
        } */
		baseListener().event(event);
    }
	 public void removeTravelStyleListener(TravelStyleListener ll){  
        repository.remove(ll);//这步要注意同步问题  
     }
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<TravelStyleVO> pagedQuery(TravelStyleVO vo) {
		List<TravelStyle> list = (List<TravelStyle>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<TravelStyleVO> records = Lists.newArrayList();
		for(TravelStyle ts:list) {
			records.add(TravelStyleKit.toRecord(ts));
		}
		return new BasePage<TravelStyleVO>(vo.getStart(), vo.getLimit(), records, count);
	}
	/**
	 * 
	 * @param alias
	 * @return
	 */
	public TravelStyle queryByAlias(String alias){
		List<TravelStyle> list = mapper.queryByAlias(alias);
		if(list != null && list.size()>= 1){
			return list.get(0);
		}
		return new TravelStyle();
	};
	/**
	 * 
	 * @return
	 */
	public List<Map<String,Object>> loadStyles(){
		return mapper.loadStyles();
	};
	@Autowired
    private TravelStyleDao<T> mapper;

		
	public TravelStyleDao<T> getDao() {
		return mapper;
	}
	public List<TravelStyle> queryValid(){
		return mapper.queryValid();
	};
	public void updateCover(TravelStyle ts){
		int result = mapper.updateCover(ts);
		if(result > 0 ){
			notifyBaseEvent(new TravelStyleEvent(this));
		}
	};
	public String add(T t)throws Exception{
		//设置主键.字符类型采用UUID,数字类型采用自增
		String uuid = IDGenerator.getUUID();// UUID.randomUUID().toString();
		//System.out.println("uuid="+uuid);
		ClassReflectUtil.setIdKeyValue(t,"id",uuid);
		//ClassReflectUtil.setIdKeyValue(t,"id",IDGenerator.getLongId()+"");
		int result = getDao().add(t);
		if(result > 0 ){
			notifyBaseEvent(new TravelStyleEvent(this));
		}
		return uuid;
	}
	
	public void update(T t)  throws Exception{
		int result = getDao().update(t);
		if(result > 0 ){
			notifyBaseEvent(new TravelStyleEvent(this));
		}
	}
	
	
	public void delete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			 getDao().delete(id);
		}
		notifyBaseEvent(new TravelStyleEvent(this));
	}
	
	public void logicdelete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			getDao().logicdelete(id);
		}
		notifyBaseEvent(new TravelStyleEvent(this));
	}
}
