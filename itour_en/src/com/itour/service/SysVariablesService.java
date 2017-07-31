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
import com.itour.convert.SysMenuKit;
import com.itour.dao.SysVariablesDao;
import com.itour.entity.ShowHappy;
import com.itour.entity.SysMenu;
import com.itour.entity.SysVariables;
import com.itour.listener.event.LevelAreaEvent;
import com.itour.listener.event.ShowHappyEvent;
import com.itour.listener.event.SystemVariablesEvent;
import com.itour.listener.listener.BaseListener;
import com.itour.listener.listener.LevelAreaListener;
import com.itour.listener.listener.SystemVariablesListener;
import com.itour.listener.listener.impl.ShowHappyListenerImpl;
import com.itour.listener.listener.impl.SystemVariablesListenerImpl;
import com.itour.vo.SysMenuVO;
import com.itour.vo.SysVariablesVO;

/**
 * 
 * <br>
 * <b>功能：</b>SysVariablesService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service 
public class SysVariablesService<SysVariables> extends BaseService<SysVariables> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	public SystemVariablesListener baseListener = new SystemVariablesListenerImpl();
	private Vector  repository = new Vector ();
	public void addBaseListener(SystemVariablesListener ll){
		repository.addElement(ll);//这步要注意同步问题  
	}
	public void notifyBaseEvent(SystemVariablesEvent event) {  
     /* Enumeration<BaseListener> e = repository.elements();//这步要注意同步问题  
        while(e.hasMoreElements()){  
        	baseListener = e.nextElement();  
        	baseListener.event(event); 
        }  */
		// = new BaseListenerImpl();
		try {
			//BaseService bs = ;
			SysVariablesService obj = event.getSource().getClass().newInstance();
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
	
	public void removeBaseListener(SystemVariablesListener ll){  
       repository.remove(ll);//这步要注意同步问题  
    }
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public BasePage<SysVariables> pagedQuery(SysVariablesVO vo) {
		List<SysVariables> list = (List<SysVariables>) mapper.queryByList(vo);
		int count = mapper.queryByCount(vo);
		return new BasePage<SysVariables>(vo.getStart(), vo.getLimit(), list, count);
	}
	@Autowired
    private SysVariablesDao<SysVariables> mapper;
		
	public SysVariablesDao<SysVariables> getDao() {
		return mapper;
	}
	public String add(SysVariables t)throws Exception{
		//设置主键.字符类型采用UUID,数字类型采用自增
		String uuid = IDGenerator.getUUID();// UUID.randomUUID().toString();
		//System.out.println("uuid="+uuid);
		ClassReflectUtil.setIdKeyValue(t,"id",uuid);
		//ClassReflectUtil.setIdKeyValue(t,"id",IDGenerator.getLongId()+"");
		int result = getDao().add(t);
		if(result > 0 ){
			notifyBaseEvent(new SystemVariablesEvent(this));
		}
		return uuid;
	}
	
	public void update(SysVariables t)  throws Exception{
		int result = getDao().update(t);
		if(result > 0 ){
			notifyBaseEvent(new SystemVariablesEvent(this));
		}
	}
	
	
	public void delete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			 getDao().delete(id);
		}
		notifyBaseEvent(new SystemVariablesEvent(this));
	}
	
	public void logicdelete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			getDao().logicdelete(id);
		}
		notifyBaseEvent(new SystemVariablesEvent(this));
	}
}
