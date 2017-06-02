package com.itour.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.LevelAreaKit;
import com.itour.dao.LevelAreaDao;
import com.itour.entity.LevelArea;
import com.itour.vo.LevelAreaVO;
@Service("levelAreaService")
public class LevelAreaService extends BaseService<LevelArea>{
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private LevelAreaDao mapper;
		
	public LevelAreaDao getDao(){
		return mapper;
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
}
