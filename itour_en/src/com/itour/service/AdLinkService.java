package com.itour.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.ClassReflectUtil;
import com.itour.base.util.IDGenerator;
import com.itour.convert.AdLinkKit;
import com.itour.dao.AdLinkDao;
import com.itour.entity.AdLink;
import com.itour.listener.event.AdLinkEvent;
import com.itour.listener.event.BaseEvent;
import com.itour.listener.event.TravelStyleEvent;
import com.itour.listener.listener.AdLinkListener;
import com.itour.listener.listener.BaseListener;
import com.itour.listener.listener.impl.AdLinkListenerImpl;
import com.itour.listener.listener.impl.BaseListenerImpl;
import com.itour.vo.AdLinkVO;
@Service 
public class AdLinkService extends BaseService<AdLink>{

	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private AdLinkDao mapper;
		
	public AdLinkDao getDao(){
		return mapper;
	}
	/*protected BaseListenerImpl baseListener(){
		return new BaseListenerImpl();
	};*/
	public AdLinkListener baseListener = new AdLinkListenerImpl();	
	private Vector  repository = new Vector ();
	public void addBaseListener(AdLinkListener ll){
		repository.addElement(ll);//这步要注意同步问题  
	}
	public void notifyBaseEvent(AdLinkEvent event) {  
     /* Enumeration<BaseListener> e = repository.elements();//这步要注意同步问题  
        while(e.hasMoreElements()){  
        	baseListener = e.nextElement();  
        	baseListener.event(event); 
        }  */
		// = new BaseListenerImpl();
		try {
			//BaseService bs = ;
			AdLinkService obj = event.getSource().getClass().newInstance();
			if(obj instanceof BaseService){//obj.getClass().isInstance(BaseService.class) && obj.getClass().isAssignableFrom(this.getClass())
				//event.getSource().getClass().isInstance(obj);
				//System.out.println("#############"+event.getSource().getClass().newInstance().baseListener());
				//TravelStyleService ts = new TravelStyleService();
				//ts.baseListener; 
				obj.baseListener.event(event);
				/*BaseListener baseListener = obj.baseListener();   //.baseListener; //obj.baseListener;
				if(baseListener != null){
					baseListener.event(event);
				}*/
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
    }
	
	public void removeBaseListener(AdLinkListener ll){  
       repository.remove(ll);//这步要注意同步问题  
    } 
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */

	public BasePage<Map<String, String>> pagedQuery(AdLinkVO vo) {
		List<AdLink> list = mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		List<Map<String, String>> records = Lists.newArrayList();
		for(int i = 0; i < list.size(); i++) {
			AdLink areas = list.get(i);
			records.add(AdLinkKit.toRecord(areas));
		}
		return new BasePage<Map<String, String>>(vo.getStart(), vo.getLimit(), records, count);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<AdLink> allAdLink(int foot){
		 List<AdLink> allinks =  mapper.queryAll(foot);
		 return allinks;
	}
	public String add(AdLink t)throws Exception{
		//设置主键.字符类型采用UUID,数字类型采用自增
		String uuid = IDGenerator.getUUID();// UUID.randomUUID().toString();
		//System.out.println("uuid="+uuid);
		ClassReflectUtil.setIdKeyValue(t,"id",uuid);
		//ClassReflectUtil.setIdKeyValue(t,"id",IDGenerator.getLongId()+"");
		int result = getDao().add(t);
		if(result > 0 ){
			notifyBaseEvent(new AdLinkEvent(this));
		}
		return uuid;
	}
	
	public void update(AdLink t)  throws Exception{
		int result = getDao().update(t);
		if(result > 0 ){
			notifyBaseEvent(new AdLinkEvent(this));
		}
	}
	
	
	public void delete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			 getDao().delete(id);
		}
		notifyBaseEvent(new AdLinkEvent(this));
	}
	
	public void logicdelete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			getDao().logicdelete(id);
		}
		notifyBaseEvent(new AdLinkEvent(this));
	}
}
