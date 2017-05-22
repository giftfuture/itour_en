package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.base.page.BasePage;
import com.itour.entity.LevelArea;
import com.itour.vo.LevelAreaVo;

public interface LevelAreaDao extends BaseDao<LevelArea> {
	List<LevelArea> queryAll();
	List<LevelArea> queryLevel1();
	List<LevelArea> queryLevel2ByLevel1(@Param("level1Area")String level1Area);
	List<LevelAreaVo> queryByVoList(BasePage page);
	LevelAreaVo selectById(@Param("id")String id);
}
