package com.itour.test.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.itour.base.util.SpringContextUtil;
public class JdbcTest {
    
	
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext context=  new ClassPathXmlApplicationContext("classpath:/spring-common.xml"); 
		//JdbcTemplate bean =  context.getBean("jdbcTemplate",JdbcTemplate.class);
		/*Object obj = bean.queryForObject("select count(1) from customers",new RowMapper<Integer>(){
			@Override
			public Integer mapRow(ResultSet res, int arg1) throws SQLException {
				return res.getInt(0);
			}});*/
		JdbcTemplate bean = (JdbcTemplate) SpringContextUtil.getBean("jdbcTemplate",JdbcTemplate.class);
		//DataSource ds = bean.getDataSource();
		//bean.update("update sys_role_rel set id=(select replace(uuid(), '-', '')) ");
		//System.out.println(ds);
	}

}
