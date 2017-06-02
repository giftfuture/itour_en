package com.itour.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.convert.LogSettingKit;
import com.itour.dao.LogSettingDao;
import com.itour.entity.LogSetting;
import com.itour.vo.LogSettingVO;

/**
 * 
 * <br>
 * <b>功能：</b>LogSettingService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service("logSettingService")
public class LogSettingService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());

	@Autowired
    private LogSettingDao<T> mapper;

	public LogSettingDao<T> getDao() {
		return mapper;
	}
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */

	@SuppressWarnings("unchecked")
	public BasePage<Map<String, Object>> pagedQuery(LogSettingVO vo) {
		int count = 0;
		//BasePage<CustomerVO> basepage = (BasePage<CustomerVO>)mapper.pagedQuery(page);
				//Map<String, String> map = Maps.newHashMap();
		List<Map<String, Object>> records = Lists.newArrayList();
		try {
			List<LogSetting> list = (List<LogSetting>) mapper.queryByList(vo);
			count = mapper.queryByCount(vo);
			records = Lists.newArrayList();
			for(int i = 0; i < list.size(); i++) {
				LogSetting logsetting = list.get(i);
				records.add(LogSettingKit.toRecord(logsetting));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BasePage<Map<String, Object>>(vo.getStart(), vo.getLimit(), records, count);
	}
}
