package com.itour.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.itour.base.page.BasePage;
import com.itour.base.service.BaseService;
import com.itour.base.util.IDGenerator;
import com.itour.convert.OrderDetailKit;
import com.itour.dao.OrderDetailDao;
import com.itour.entity.OrderDetail;
import com.itour.vo.OrderDetailVO;

/**
 * 
 * <br>
 * <b>功能：</b>OrderDetailService<br>
 * <b>作者：</b>fred.zhao<br>
 * <b>日期：</b> Feb 2, 2016 <br>
 */
@Service//("orderDetailService")
public class OrderDetailService<T> extends BaseService<T> {
	protected final Logger logger =  LoggerFactory.getLogger(getClass());
	/**
	 * 分页查询
	 * 
	 * @param pageQuery 查询条件
	 * @return 查询结果
	 */
	public BasePage<OrderDetailVO> pagedQuery(OrderDetailVO vo) {
		List<OrderDetailVO> list = (List<OrderDetailVO>) mapper.queryByListVo(vo);
		int count = mapper.queryByCount(vo);
		/*List<OrderDetailVO> records = Lists.newArrayList();
		for(OrderDetail fb:list) {
			records.add(OrderDetailKit.toRecord(fb));
		}*/
		return new BasePage<OrderDetailVO>(vo.getStart(), vo.getLimit(), list, count);
	}
	public String queryGroupCode(String groupCode){
		 List<String> groupCodes = mapper.queryGroupCode(groupCode);
		 String gCode = "";
		if(groupCodes !=null && groupCodes.size() > 0){
			Collections.sort(groupCodes);
			String oldcode = groupCodes.get(0);
			StringBuffer sb = new StringBuffer();
				if(oldcode.toCharArray()[oldcode.length()-1]==IDGenerator.chars[IDGenerator.chars.length-1]){
					for(int i=0;i<=oldcode.length();i++){
						sb.append(IDGenerator.chars[0]);
					}
				}else{
					for(int i=0;i<oldcode.length();i++){
						if (i == oldcode.length()-1){
							int index = Arrays.asList(IDGenerator.chars).indexOf(oldcode.charAt(oldcode.length()-1))+1;
							sb.append(IDGenerator.chars[index]);
						}else{
							sb.append(oldcode.charAt(i));
						}
					}
				}
				gCode = groupCode+sb.toString();
		}else{
			gCode = groupCode+IDGenerator.chars[0];
		}
		return gCode;
	};
	public OrderDetailVO queryByOrderId(String orderId){
		return mapper.queryByOrderId(orderId);
	};
	@Autowired
    private OrderDetailDao<T> mapper;

		
	public OrderDetailDao<T> getDao() {
		return mapper;
	}

}
