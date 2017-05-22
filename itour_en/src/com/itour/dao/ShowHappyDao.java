package com.itour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itour.base.dao.BaseDao;
import com.itour.vo.ShowHappyVo;

public interface ShowHappyDao<ShowHappy> extends BaseDao<ShowHappy> {
	/*public default void addShowHappy(){
		shCode
	}*/
	ShowHappyVo queryByCode(@Param(value="shCode")String shCode);
	ShowHappyVo	selectById(@Param(value="id")String id);
	List<ShowHappyVo> queryByListVo(ShowHappyVo vo);
	List<ShowHappyVo> queryAll();
	int countAll();
}
