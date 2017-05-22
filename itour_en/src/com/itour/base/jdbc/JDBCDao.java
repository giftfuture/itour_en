package com.itour.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.itour.entity.SysUser;

public class JDBCDao<T> extends JdbcDaoSupport{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
   /**   
     * 创建表  
     */   
    public void create(String tableName){ //tb_test1  
        jdbcTemplate.execute("create table "+tableName +" (id integer,user_name varchar2(40),password varchar2(40))");  
    }  
      
    //jdbcTemplate.update适合于insert 、update和delete操作；  
    /**   
     * 第一个参数为执行sql   
     * 第二个参数为参数数据   
     */   
    public void save3(SysUser user) {  
    	  Assert.assertNull( "user is not null",user);  
    	  jdbcTemplate.update("insert into tb_test1(name,password) values(?,?)",   
                new Object[]{user.getEmail(),user.getPwd()});  
    }  
      
    /**   
     * 第一个参数为执行sql   
     * 第二个参数为参数数据   
     * 第三个参数为参数类型   
     */   
   // @Override  
    public void save(SysUser user) {  
        Assert.assertNull( "user is not null",user);  
        jdbcTemplate.update(  
                "insert into tb_test1(name,password) values(?,?)",   
                new Object[]{user.getEmail(),user.getPwd()},   
                new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR}  
                );  
    }  
  
    //避免sql注入  
    public void save2(final SysUser user) {  
        Assert.assertNull( "user is not null",user);   
        jdbcTemplate.update("insert into tb_test1(name,password) values(?,?)",   
                new PreparedStatementSetter(){  
              
                    @Override  
                    public void setValues(PreparedStatement ps) throws SQLException {  
                        ps.setString(1, user.getEmail());  
                        ps.setString(2, user.getPwd());  
                    }  
        });  
          
    }  
      
    public void save4(SysUser user) {
        Assert.assertNull( "user is not null",user);  
        jdbcTemplate.update("insert into tb_test1(name,password) values(?,?)",   
                             new Object[]{user.getEmail(),user.getPwd()});  
    }  
      
    //返回插入的主键  
    public List save5(final SysUser user) {  
        KeyHolder keyHolder = new GeneratedKeyHolder();  
        jdbcTemplate.update(new PreparedStatementCreator() {  
								@Override
								public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
									// TODO Auto-generated method stub
									PreparedStatement ps = connection.prepareStatement("insert into tb_test1(name,password) values(?,?)", new String[] {"id"});  
									ps.setString(1, user.getEmail());  
									ps.setString(2, user.getPwd());  
									return ps;  
								}  
                            },  
                keyHolder);  
          
        return keyHolder.getKeyList();  
    }  
      
   // @Override  
    public void update(final SysUser user) {  
        jdbcTemplate.update(  
                "update tb_test1 set name=？,password=？ where id = ?",   
                new PreparedStatementSetter(){  
                    @Override  
                    public void setValues(PreparedStatement ps) throws SQLException {  
                        ps.setString(1, user.getEmail());  
                        ps.setString(2, user.getPwd());  
                        ps.setString(3, user.getId());  
                    }  
                }  
        );  
    }  
  
    //@Override  
    public void delete(SysUser user) {  
    	 Assert.assertNull( "user is not null",user);  
        jdbcTemplate.update(  
                "delete from tb_test1 where id = ?",   
                new Object[]{user.getId()},   
                new int[]{java.sql.Types.INTEGER});  
    }  
  
    //@Deprecated //因为没有查询条件，所以用处不大  
    public int queryForInt1(){  
        return jdbcTemplate.queryForObject("select count(0) from tb_test1",new RowMapper<Integer>(){

			@Override
			public Integer mapRow(ResultSet res, int arg1) throws SQLException {
				return res.getInt(0);
			}});  
    }  
      
    public int queryForInt2(SysUser user){  
        return jdbcTemplate.queryForObject("select count(0) from tb_test1 where username = ?" ,  
                new Object[]{user.getEmail()},new RowMapper<Integer>(){
					@Override
					public Integer mapRow(ResultSet res, int arg1) throws SQLException {
						return res.getInt(0);
					}});  
    }  
      
    //最全的参数3个  
    public int queryForInt3(SysUser user){  
        return jdbcTemplate.queryForObject("select count(0) from tb_test1 where username = ?" ,  
                new Object[]{user.getEmail()},  
                new int[]{java.sql.Types.VARCHAR},new RowMapper<Integer>(){
					@Override
					public Integer mapRow(ResultSet res, int arg1) throws SQLException {
						return res.getInt(0);
					}});  
    }  
      
    //可以返回是一个基本类型的值  
    @Deprecated  //因为没有查询条件，所以用处不大  
    public String queryForObject1(SysUser user) {  
        return (String) jdbcTemplate.queryForObject("select username from tb_test1 where id = 100",  
                                                    String.class);  
    }  
      
    //可以返回值是一个对象  
    @Deprecated //因为没有查询条件，所以用处不大  
    public SysUser queryForObject2(SysUser user) {  
        return (SysUser) jdbcTemplate.queryForObject("select * from tb_test1 where id = 100", SysUser.class); //class是结果数据的java类型  
    }  
      
    @SuppressWarnings("unchecked")
	@Deprecated //因为没有查询条件，所以用处不大  
    public SysUser queryForObject3(SysUser user) {  
        return (SysUser) jdbcTemplate.queryForObject("select * from tb_test1 where id = 100",   
                    new RowMapper(){  
      
                        @Override  
                        public Object mapRow(ResultSet rs, int rowNum)throws SQLException {  
                        	SysUser user  = new SysUser();  
                            user.setId(rs.getString("id"));  
                            user.setEmail(rs.getString("email"));  
                            user.setPwd(rs.getString("pwd"));  
                            return user;  
                        }  
                    }  
        );   
    }  
      
    public SysUser queryForObject4(SysUser user) {  
        return (SysUser) jdbcTemplate.queryForObject("select * from tb_test1 where id = ?",   
            new Object[]{user.getId()},  
            SysUser.class); //class是结果数据的java类型  实际上这里是做反射，将查询的结果和User进行对应复制  
    }  
      
    @SuppressWarnings("unchecked")
	public SysUser queryForObject5(SysUser user) {  
        return (SysUser) jdbcTemplate.queryForObject(  
                "select * from tb_test1 where id = ?",   
                new Object[]{user.getId()},  
                new RowMapper(){  
  
                    @Override  
                    public Object mapRow(ResultSet rs,int rowNum)throws SQLException {  
                        SysUser user  = new SysUser();  
                        user.setId(rs.getString("id"));  
                        user.setEmail(rs.getString("email"));  
                        user.setPwd(rs.getString("password"));  
                        return user;  
                    }  
              
        }); //class是结果数据的java类型  
    }  
      
  //  @Override  
    @SuppressWarnings("unchecked")
	public SysUser queryForObject(SysUser user) {  
        //方法有返回值  
        return (SysUser) jdbcTemplate.queryForObject("select * from tb_test1 where id = ?",  
                new Object[]{user.getId()},  
                new int[]{java.sql.Types.INTEGER},   
                new RowMapper() {  
              
                    @Override  
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {  
                        SysUser user  = new SysUser();  
                        user.setId(rs.getString("id"));  
                        user.setEmail(rs.getString("username"));  
                        user.setPwd(rs.getString("password"));  
                        return user;  
                    }  
                }  
        );  
    }  
  
    @SuppressWarnings("unchecked")  
    public List<SysUser> queryForList1(SysUser user) {  
        return (List<SysUser>) jdbcTemplate.queryForList("select * from tb_test1 where username = ?",   
                            new Object[]{user.getEmail()},  
                            SysUser.class);  
    }  
  
    @SuppressWarnings("unchecked")  
    public List<String> queryForList2(SysUser user) {  
        return (List<String>) jdbcTemplate.queryForList("select username from tb_test1 where sex = ?",   
                            new Object[]{"user.getSex()"},  
                            String.class);  
    }  
      
    @SuppressWarnings("unchecked")  
    //最全的参数查询  
    public List<SysUser> queryForList3(SysUser user) {  
        return (List<SysUser>) jdbcTemplate.queryForList("select * from tb_test1 where username = ?",  
                            new Object[]{user.getEmail()},  
                            new int[]{java.sql.Types.VARCHAR},  
                            SysUser.class);  
    }  
  
    //通过RowCallbackHandler对Select语句得到的每行记录进行解析，并为其创建一个User数据对象。实现了手动的OR映射。  
    public SysUser queryUserById4(String id){  
        final SysUser user  = new SysUser();  
          
        //该方法返回值为void  
        this.jdbcTemplate.query("select * from tb_test1 where id = ?",   
                new Object[] { id },   
                new RowCallbackHandler() {     
              
                    @Override    
                    public void processRow(ResultSet rs) throws SQLException {     
                    	SysUser user  = new SysUser();  
            user.setId(rs.getString("id"));  
            user.setEmail(rs.getString("username"));  
            user.setPwd(rs.getString("password"));    
                    }     
        });   
          
        return user;     
    }  
      
    @SuppressWarnings("unchecked")  
   // @Override  
    public List<SysUser> list(SysUser user) {  
        return jdbcTemplate.query("select * from tb_test1 where username like '%?%'",   
                new Object[]{user.getEmail()},   
                new int[]{java.sql.Types.VARCHAR},   
                new RowMapper(){  
              
                    @Override  
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {  
                    	SysUser user  = new SysUser();  
                        user.setId(rs.getString("id"));  
                        user.setEmail(rs.getString("email"));  
                        user.setPwd(rs.getString("pwd"));  
                        return user;  
                    }  
        });  
    }  
  
    //批量操作    适合于增、删、改操作  
    public int[] batchUpdate(final List users) {  
          
        int[] updateCounts = jdbcTemplate.batchUpdate(  
                "update tb_test1 set username = ?, password = ? where id = ?",  
                new BatchPreparedStatementSetter() {  
                        @Override  
                        public void setValues(PreparedStatement ps, int i) throws SQLException {  
                            ps.setString(1, ((SysUser)users.get(i)).getEmail());  
                            ps.setString(2, ((SysUser)users.get(i)).getPwd());  
                            ps.setString(3, ((SysUser)users.get(i)).getId());  
                        }  
                          
                        @Override  
                        public int getBatchSize() {  
                            return users.size();  
                        }  
                }   
        );  
          
        return updateCounts;  
    }  
      
    //调用存储过程  
    public void callProcedure(int id){  
        this.jdbcTemplate.update("call SUPPORT.REFRESH_USERS_SUMMARY(?)", new Object[]{Long.valueOf(id)});  
} 
	public static void main(String[] args) {
		 

	}

}
