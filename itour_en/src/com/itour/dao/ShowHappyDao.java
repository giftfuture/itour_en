package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.vo.ShowHappyVO;

public interface ShowHappyDao<ShowHappy> extends BaseDao<ShowHappy> {
	
	 int add(ShowHappy t);
		
	 int update(ShowHappy t);
	
	 int delete(@Param(value="id")String id);
	
	 int logicdelete(@Param(value="id")String id);
	/*public default void addShowHappy(){
		shCode
	}*/
	ShowHappyVO queryByCode(@Param(value="shCode")String shCode);
	
	ShowHappyVO	selectById(@Param(value="id")String id);
	
	List<ShowHappyVO> queryByListVo(ShowHappyVO vo);
	
	List<ShowHappyVO> queryAll();
	
	int countAll();
	
	List<ShowHappyVO> queryByRoute(@Param(value="route")String route);
}
