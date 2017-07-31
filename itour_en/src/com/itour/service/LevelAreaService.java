package com.itour.service;

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
import com.itour.convert.LevelAreaKit;
import com.itour.dao.LevelAreaDao;
import com.itour.entity.LevelArea;
import com.itour.listener.event.AreasEvent;
import com.itour.listener.event.LevelAreaEvent;
import com.itour.listener.listener.AdLinkListener;
import com.itour.listener.listener.BaseListener;
import com.itour.listener.listener.LevelAreaListener;
import com.itour.listener.listener.impl.LevelAreaListenerImpl;
import com.itour.vo.LevelAreaVO;
@Service 
public class LevelAreaService extends BaseService<LevelArea>{
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private LevelAreaDao mapper;
		
	public LevelAreaDao getDao(){
		return mapper;
	}
	public LevelAreaListener baseListener = new LevelAreaListenerImpl();	
	private Vector  repository = new Vector ();
	public void addBaseListener(LevelAreaListener ll){
		repository.addElement(ll);//这步要注意同步问题  
	}
	public void notifyBaseEvent(LevelAreaEvent event) {  
     /* Enumeration<BaseListener> e = repository.elements();//这步要注意同步问题  
        while(e.hasMoreElements()){  
        	baseListener = e.nextElement();  
        	baseListener.event(event); 
        }  */
		// = new BaseListenerImpl();
		try {
			//BaseService bs = ;
			LevelAreaService obj = event.getSource().getClass().newInstance();
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
	
	public void removeBaseListener(LevelAreaListener ll){  
       repository.remove(ll);//这步要注意同步问题  
    }
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */

	public BasePage<Map<String, String>> pagedQuery(LevelAreaVO vo) {
			//vo.setGroupField("level1_area,level2_area");
			vo.setSort("level_area.level1_area desc,level_area.level2_area desc");
			vo.setOrderDirection(true);
			List<LevelAreaVO> list = mapper.queryByVoList(vo);
			int count = mapper.queryByCount(vo);
			List<Map<String, String>> records = Lists.newArrayList();
			for(int i = 0; i < list.size(); i++) {
				LevelAreaVO areas = list.get(i);
				records.add(LevelAreaKit.votoRecord(areas));
			}
			return new BasePage<Map<String, String>>(vo.getStart(), vo.getLimit(), records, count);
	}
	public List<LevelArea> queryLevel1(){
		return mapper.queryLevel1();
	};
	public List<LevelArea> queryLevel2ByLevel1(String level1Area){
		return mapper.queryLevel2ByLevel1(level1Area);
	};
	public List<LevelArea> allAreas(){
		return mapper.queryAll();
	}
	public LevelAreaVO selectById(@Param("id")String id){
		return mapper.selectById(id);
	};
	public String add(LevelArea t)throws Exception{
		//设置主键.字符类型采用UUID,数字类型采用自增
		String uuid = IDGenerator.getUUID();// UUID.randomUUID().toString();
		//System.out.println("uuid="+uuid);
		ClassReflectUtil.setIdKeyValue(t,"id",uuid);
		//ClassReflectUtil.setIdKeyValue(t,"id",IDGenerator.getLongId()+"");
		int result = getDao().add(t);
		if(result > 0 ){
			notifyBaseEvent(new LevelAreaEvent(this));
		}
		return uuid;
	}
	
	public void update(LevelArea t)  throws Exception{
		int result = getDao().update(t);
		if(result > 0 ){
			notifyBaseEvent(new LevelAreaEvent(this));
		}
	}
	
	
	public void delete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			 getDao().delete(id);
		}
		notifyBaseEvent(new LevelAreaEvent(this));
	}
	
	public void logicdelete(String... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(String id : ids ){
			getDao().logicdelete(id);
		}
		notifyBaseEvent(new LevelAreaEvent(this));
	}
}
