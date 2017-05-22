package com.itour.dao;

import java.util.List;

import com.itour.base.dao.BaseDao;
import com.itour.entity.AdLink;

public interface AdLinkDao extends BaseDao<AdLink> {
	List<AdLink> queryAll();
}
