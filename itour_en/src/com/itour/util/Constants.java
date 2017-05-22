package com.itour.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itour.base.page.BasePage;
import com.itour.base.util.FilePros;
import com.itour.entity.AdLink;
import com.itour.entity.Areas;
import com.itour.entity.LevelArea;
import com.itour.service.ShowHappyService;
import com.itour.vo.AdLinkVo;
import com.itour.vo.FeedbackVo;
import com.itour.vo.RouteTemplateVo;
import com.itour.vo.ShowHappyVo;
import com.itour.vo.TravelItemVo;

public class Constants {
	//ResourceBundle.getBundle("conf");
	public static String basePhoto ="/images/";
	//private TravelStyleDao baseDao;
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	public static final Map<String,Object> TDQUOTE2 = Maps.newConcurrentMap();
	public static final Map<String,Object> TDQUOTE3 = Maps.newConcurrentMap();
	public static final Map<String,String> travelStyles = Maps.newHashMap();
	public static final int maxDestinations = 3;//每个地区最多显示的目的地数，若超出，则显示更多目的地选项
	public static final int perPage = 3;//前端回忆幸福每页数据
	public static final int happyperPage = 8;//前端回忆幸福每页数据
	public static final int fbperPage = 4;//前端反馈每页数据量
	public static final int hotview = 4;//首页显示的热门景点
	public static final int routesperrow = 3;//每行显示的路线
	public static final int destsPerPage=15;//每页显示的更多景点相关的路线
	public static final int moredestsPerPage=9;//每页显示的更多目的地
	public static final int rtPerPage=9;//每页显示的路线数
	public static  int perRow = 3;
	public static int ITEMPHOTOCOUNT=2;
	private static final String BUNDLE_NAME = "conf";///不要加上扩展名
	public static final String FREEMARKER_PATH="";
	public static final String CUSTOMIZED = "customized";
	public static final String CLIMB = "climb";
	public static final String SELFDRIVE = "selfdrive";
	public static final String LIGHT = "light";
	public static final String HOTSIGHT = "hotsight";
	public static final String HAPPINESS = "happiness";
	public static final String DESTINATION = "destination";
	public static final String HIKING = "hiking";
	public static final String ALARM_FILE_PATH = "";
	private static final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
	//
	public static final Set<String> TSTYLES = new HashSet<String>(){{
		add(CUSTOMIZED);
		add(CLIMB);
		add(SELFDRIVE);
		add(LIGHT);
		add(HOTSIGHT);
		add(HAPPINESS);
		add(DESTINATION);
		add(HIKING);
	}};
	public static final List<String> HOTTYLESKEYS= new ArrayList<String>(){{
		add(HIKING);
		add(CLIMB);
		add(SELFDRIVE);
		add(LIGHT);
	}};
	public static final LinkedHashMap<String,String> HOTTYLES = new LinkedHashMap<String,String>();
	static{
		HOTTYLES.put(HIKING,"徒步");
		HOTTYLES.put(CLIMB,"登山");
		HOTTYLES.put(SELFDRIVE,"自驾");
		HOTTYLES.put(LIGHT,"轻旅行");
	}
	
	/*public static final TreeMap<String,String> HOTTYLES = new TreeMap<String,String>(){{
		put(HIKING,"徒步");
		put(CLIMB,"登山");
		put(SELFDRIVE,"自驾");
		put(LIGHT,"轻旅行");
	}};*/
	public static void init(){
		basePhoto= bundle == null || StringUtils.isEmpty(bundle.getString("basePhoto")) ? basePhoto : bundle.getString("basePhoto");
		perRow = bundle == null ||StringUtils.isEmpty(bundle.getString("perRow")) ? perRow :  Integer.valueOf( bundle.getString("perRow"));
		String sql ="select id,type,alias,valid,remark from travel_style where valid=1";
		List<Map<String, Object>> list = null;
		System.out.println("WebInitListener.contextInitialized.Constants.sql="+sql);
		try{
	   		list =jdbcTemplate.queryForList(sql);  
		   for(Map<String,Object> map:list){
			   if(TSTYLES.contains(map.get("alias"))){				   
				   travelStyles.put((String)map.get("alias"),(String)map.get("alias"));
			   }
		   }
		   String lv1asql = "select distinct level1_area ,alias_code from level_area group by level1_area";
		   List<LevelArea> areas1 = new ArrayList<LevelArea>(){{add(new LevelArea("","请选择"));}};
		   areas1.addAll(jdbcTemplate.query(lv1asql,  new RowMapper<LevelArea>(){
		        @Override  
		        public LevelArea mapRow(ResultSet rs, int rowNum) throws SQLException {  
	        	  LevelArea sh = new LevelArea();  
                  sh.setLevel1Area(rs.getString("level1_area"));	
                  sh.setAliasCode(rs.getString("alias_code"));
                  return sh;   
		        }  
		   }));
		   level1Areas.clear();
		   level1Areas.addAll(areas1);
		   String tssql="select alias,type from travel_style where valid=1";
		   List<Map<String,Object>> newlist = Lists.newArrayList();
		   newlist.add(new HashMap(){{put("alias","");put("type","-所有-");}});
		   List<Map<String,Object>> tsmap = jdbcTemplate.queryForList(tssql);
		   newlist.addAll(tsmap);
		   allStyles.clear();
		   allStyles.addAll(newlist);
		   String adsql="select * from ad_link where valid=1";
		  String adlinpath = FilePros.httpadLinkPath();
		  List<AdLink> adlist = jdbcTemplate.query(adsql, new RowMapper<AdLink>(){
		        @Override  
		        public AdLink mapRow(ResultSet rs, int rowNum) throws SQLException {  
		        	AdLink sh = new AdLink();  
                   sh.setAdvertise(adlinpath+"/"+rs.getString("advertise"));
                   sh.setVideo(rs.getBoolean("is_video"));
                   sh.setTitle(rs.getString("title"));
                   sh.setAdlink(rs.getString("adlink"));
                   return sh;   
		        }  
		   });
		  alladLinks.clear();
		  alladLinks.addAll(adlist);
		   String shareHappyCoverPath = FilePros.httpshCoverPath();
		   String shsql = "select show_happy.sh_code,show_happy.cover,show_happy.title,show_happy.route,show_happy.tour_time,show_happy.short_content,show_happy.signature,areas.areaname from show_happy left join areas on show_happy.area=areas.id where is_valid=1";
		  // List<ShowHappyVo> shs =jdbcTemplate.query(shsql,new ColumnMapRowMapper());
		   List<ShowHappyVo> shs = jdbcTemplate.query(shsql, new RowMapper<ShowHappyVo>(){
		        @Override  
		        public ShowHappyVo mapRow(ResultSet rs, int rowNum) throws SQLException {  
	        	   ShowHappyVo sh = new ShowHappyVo();  
                   sh.setShCode(rs.getString("sh_code"));
                   sh.setCover(shareHappyCoverPath+"/"+rs.getString("sh_code")+"_"+rs.getString("route")+"/"+rs.getString("cover"));
                   sh.setTitle(rs.getString("title"));
                   sh.setTourTime(rs.getString("tour_time"));
                   sh.setAreaname(rs.getString("areaname"));
                   sh.setShortContent(rs.getString("short_content"));
                   sh.setSignature(rs.getString("signature"));
                   return sh;   
		        }  
		   });
		    showhappypage.clear();
		    showhappypage.addAll(shs);
		    String asql = "select id,areaname from areas";
		    List<Areas> areas = jdbcTemplate.query(asql, new RowMapper<Areas>(){
				@Override
				public Areas mapRow(ResultSet rs, int num) throws SQLException {
					Areas as = new Areas();
					as.setId(rs.getString("id"));
					as.setAreaname(rs.getString("areaname"));
					return as;
				}
		    });
		    allAreas.clear();
		    allAreas.addAll(areas);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	  public class SHRowMapper implements RowMapper<ShowHappyVo> {  
		  String shareHappyCoverPath = FilePros.httpshCoverPath();
	        @Override  
	        public ShowHappyVo  mapRow(ResultSet rs, int rowNum) throws SQLException {  
	        	   ShowHappyVo sh = new ShowHappyVo();  
                   sh.setShCode(rs.getString("sh_code"));
                   sh.setCover(shareHappyCoverPath+"/"+rs.getString("sh_code")+"_"+rs.getString("route")+"/"+rs.getString("cover"));
                   sh.setTitle(rs.getString("title"));
                   sh.setTourTime(rs.getString("tour_time"));
                   sh.setAreaname(rs.getString("areaname"));
                   sh.setShortContent(rs.getString("short_content"));
                   sh.setSignature(rs.getString("signature"));
                   return sh;   
	        }  
	          
    }  
	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		Constants.jdbcTemplate = jdbcTemplate;
	}
	public static final List<LevelArea> level1Areas = Lists.newArrayList();//一级区域
	public static final List<Map<String,Object>> allStyles = Lists.newArrayList();//所有旅行方式
	public static final List<AdLink> alladLinks = Lists.newArrayList();//所有首页链接
	public static final List<Areas> allAreas = Lists.newArrayList();//所在地区
	public static final List<LevelArea> allLevelAreas = Lists.newArrayList();//所有一级，二级区域
	public static final List<TravelItemVo> homehotSights = Lists.newArrayList();//首页展示的热门景点
	public static final Map<String,BasePage<ShowHappyVo>> homeshpage = Maps.newHashMap();//首页的回忆幸福
	public static final LinkedHashMap<String,List<RouteTemplateVo>>  homertmapvo = Maps.newLinkedHashMap();//首页
	public static final List<ShowHappyVo>  showhappypage = Lists.newArrayList();//回忆幸福
	//public static final List<FeedbackVo> hikingfbpage = Lists.newArrayList();//徒步旅行反馈列表
	//public static final List<FeedbackVo> climbfbpage = Lists.newArrayList();//登山反馈列表
	//public static final List<FeedbackVo> selfdrivefbpage = Lists.newArrayList();//自驾反馈列表
	//public static final List<FeedbackVo> lightfbpage = Lists.newArrayList();//轻旅行反馈列表
	//public static final List<FeedbackVo> feedbackpage = Lists.newArrayList();//轻旅行反馈列表
	
	
}
