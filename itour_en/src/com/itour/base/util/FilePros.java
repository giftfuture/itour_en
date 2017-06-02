package com.itour.base.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;



public class FilePros   {

	private static final String resourceFile = "conf";    
	private static final ResourceBundle rb = ResourceBundle.getBundle(resourceFile);
    //属性文件的路径
	//static String profilepath=ClassLoader.getSystemResource("").getPath()+"/conf.properties";
    /**
    * 采用静态方法
    */
    private static Properties props = new Properties();
    
    public static String basePath()throws Exception{
    	return rb.getString("basePath");
    }
/*    static {
        try {
        	InputStream is = ClassLoader.getSystemResourceAsStream("conf.properties");
            props.load(is);//new FileInputStream(profilepath)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {       
            System.exit(-1);
        }
    }*/
    /**
     * 水印图片
     * @return
     * @throws Exception
     */
    public static File watermark()throws Exception{
    	String watermark =  rb.getString("watermark");
    	return new File(watermark);
    }
    /**
     * 订单正式报价单所在文件夹
     * @param key
     * @return
     * @throws Exception
     */
    public static String httporderhtmls()throws Exception{
    	return rb.getString("httporderhtmls");
    }
    public static String orderhtmls()throws Exception{
    	return rb.getString("orderhtmls");
    }
    public static String orderpdfs()throws Exception{
    	return rb.getString("orderpdfs");
    }
    public static String httporderpdfs()throws Exception{
    	return rb.getString("httporderpdfs");
    }
    public static String markedorderpdfs()throws Exception{
    	return rb.getString("markedorderpdfs");
    }
    public static String httpmarkedorderpdfs()throws Exception{
    	return rb.getString("httpmarkedorderpdfs");
    }
    /**
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static String read(String key)throws Exception{
    	return rb.getString(key);
    }
	/**
	 * 上传图片的磁盘存放路径
	 * @return
	 */
	public static String baseUploadPath(){
		//return  rb.getString("url");//rb.getString("upload");//upload_ptopath
		return rb.getString("upload_path");
	}
	/**
	 * 路线地图
	 * @param request
	 * @return
	 */
	public static String routeMapPath(){
		return rb.getString("route_map_path");
	}
	public static String httprouteMapPath(){
		return rb.getString("httproute_map_path");
	}
	
	/**
	 * 
	 * @return
	 */
	public static String routePhotos(){
		return rb.getString("route_Photos");
	}
	public static String httpRoutePhotos(){
		return rb.getString("httproute_Photos");
	}		
	/**
	 * 旅行方式封面图片
	 * @return
	 */
	public static String tsCoverPath(){
		return rb.getString("ts_cover_path");
	}
	public static String httptsCoverPath(){
		return rb.getString("httpts_cover_path");
	}
	/**
	 * 上传图片的物理路径
	 * @return
	 */
	public static String travelitemPhotoPath(){
		String propath = rb.getString("travelitem_photo");//FilePros.class.getResource("/").toString();//此方法在jar包中无效。返回的内容最后包含/
		//return  rb.getString("url");//rb.getString("upload");//upload_ptopath
		return propath;
	}
	public static String httptravelitemPhotoPath(){
		String propath = rb.getString("http_travelitem_photo");//FilePros.class.getResource("/").toString();//此方法在jar包中无效。返回的内容最后包含/
		//return  rb.getString("url");//rb.getString("upload");//upload_ptopath
		return propath;
	}
	
	/**
	 * 回忆幸福的上传图片
	 * @return
	 */
	public static String shareHappyPath(){
		String sharePath = rb.getString("share_happy_path");
		return sharePath;
	}
	public static String httpshareHappyPath(){
		String sharePath = rb.getString("httpshare_happy_path");
		return sharePath;
	}
	/**
	 * 回忆幸福封面图片
	 * @return
	 */
	public static String shareHappyCoverPath(){
		String shcoverPath = rb.getString("sh_cover_path");
		return shcoverPath;
	}
	public static String httpshCoverPath(){
		String shcoverPath = rb.getString("httpsh_cover_path");
		return shcoverPath;
	}
	
	/**
	 * 详细行程上传图片
	 * @return
	 */
	public static String rtschedulePath(){
		String sharePath = rb.getString("rtschedule_path");
		return sharePath;
	}
	public static String httprtschedulePath(){
		String sharePath = rb.getString("httprtschedule_path");
		return sharePath;
	}
	/**
	 * 路线模板封面图
	 * @return
	 */
/*	public static String rtCoverPath(){
		String rtCover = rb.getString("rtcover_path");
		return rtCover;
	}
	public static String httprtCoverPath(){
		String rtCover = rb.getString("httprtcover_path");
		return rtCover;
	}*/
	
	/**
	 * 首页链接图片
	 * @return 
	 */
	public static String adLinkPath(){
		String rtCover = rb.getString("adlink_path");
		return rtCover;
	}
	public static String httpadLinkPath(){
		String rtCover = rb.getString("httpadlink_path");
		return rtCover;
	}
	/**
	 * 首页广告视频
	 * @return
	 */
	public static String bannervideoPath(){
		String bannervideo = rb.getString("bannervideo");
		return bannervideo;
	}
	public static String httpbannervideoPath(){
		String bannervideo = rb.getString("http_bannervideo");
		return bannervideo;
	}
	/**
	 * 上传图片的本项目相关的存储路径
	 * @param request
	 * @return
	 */
	public static String itemCoverpath(){
		//RequestAware ra = null;
		//String path = request.getContextPath();    
		//String ptopath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/images/upload_ptopath/";    
		String ptopath = rb.getString("item_cover_path");
		return ptopath;
	}
	public static String httpitemCoverpath(){
		String ptopath = rb.getString("httpitem_cover_path");
		return ptopath;
	}
	
	
	/**
	 * 路线封面图片
	 * @return
	 */
	public static String routeCoverpath(){
		String routepath = rb.getString("route_cover_path");
		return routepath;
	}
	public static String httpRouteCoverpath(){
		String routepath = rb.getString("httproute_cover_path");
		return routepath;
	}
	    /**
	    * 更新properties文件的键值对
	    * 如果该主键已经存在，更新该主键的值；
	    * 如果该主键不存在，则插件一对键值。
	    * @param keyname 键名
	    * @param keyvalue 键值
	    */
    public static void updateProperties(String key,String value) {
        try {
        	String path = getWEB_INF()+"classes/conf.properties";
        	File f = new File(path);
        	//System.out.println(f.exists());
           // props.load(new FileInputStream(profilepath));
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        	Iterator<String> keys = rb.keySet().iterator();
        	while(keys.hasNext()){
        		String name = keys.next();
        		props.put(name, rb.getString(name));
        	}
            OutputStream fos = new FileOutputStream(f);  
            //InputStream is = new FileInputStream(f)	;
            //Reader reader = new InputStreamReader(is);
           // System.out.println("####"+f.length());
           // System.out.println("####"+is.available());
           // System.out.println("####"+new FileOutputStream(f).getChannel().size());
            //TestLoad.class.getResourceAsSteam("myprops.properties");
            // props.load(is);
           // props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.put(key, value);
            props.store(fos, "");
        } catch (IOException e) {
            System.err.println("属性文件更新错误");		
        }
	}
	/**

	 * 获取当前对象的路径

	 * @param object

	 * @return path

	 */

	public static String getObjectPath(Object object){

		return object.getClass().getResource(".").getFile().toString();

	}

	/**

	 * 获取到项目的路径

	 * @return path

	 */

	public static String getProjectPath(){

		return System.getProperty("user.dir");

	}

	/**

	 * 获取 root目录

	 * @return path

	 */

	public static String getRootPath(){

		return getWEB_INF().replace("WEB-INF/", "");

	}

	/**

	 * 获取输出HTML目录

	 * @return

	 */

	public static String getHTMLPath(){

		return getFreePath() + "html/html/";

	}

	/**

	 * 获取输出FTL目录

	 * @return

	 */

	public static String getFTLPath(){

		return getFreePath() + "html/ftl/";

	}

	/**

	 * 获取 web-inf目录

	 * @return path

	 */

	public static String getWEB_INF(){
		return getClassPath().replace("classes/", "");

	}

	/**

	 * 获取模版文件夹路径

	 * @return path

	 */

	public static String getFreePath(){

		return getWEB_INF() + "ftl/";

	}

	/**

	 * 文本换行，因为Linux  和 Windows 的换行符不一样

	 * @return

	 */

	public static String nextLine(){
		 String nextLine = System.getProperty("line.separator");
		 return nextLine;
	}

	/**

	 * 获取images 路径

	 * @return

	 */

	public static String getImages(){
		return getRootPath() + "images/" ;
	}

	/**

	 * 获取sitemap 路径

	 * @return

	 */

	public static String getSiteMapPath(){
		return getRootPath() + "txt/sitemap" ;
	}

	/**

	 * 获取Txt 路径

	 * @return

	 */

	public static String getTxt(){
		return getRootPath() + "txt" ;
	}

	/**

	 * 获取到classes目录

	 * @return path

	 */

	public static String getClassPath(){
		String systemName = System.getProperty("os.name");
		//判断当前环境，如果是Windows 要截取路径的第一个 '/'
		if(!StringUtils.isBlank(systemName) && systemName.indexOf("Windows") !=-1){
			return FilePros.class.getResource("/").getFile().toString().substring(1);
		}else{
			return FilePros.class.getResource("/").getFile().toString();
		}

	}
	public static void main(String[] args) {
		//String resourceFile = "jdbc";    
//        创建一个默认的ResourceBundle对象   
//        ResourceBundle会查找包Forum下的CNS.properties的文件   
//        Forum是资源的包名，它跟普通java类的命名规则完全一样：   
//        - 区分大小写   
//        - 扩展名 .properties 省略。就像对于类可以省略掉 .class扩展名一样   
//        - 资源文件必须位于指定包的路径之下（位于所指定的classpath中）   
//        假如你是在非Web项目中使用，则一定要写资源文件的路径，也就是包路径必须存在。
//        如果是Web项目，不写包路径可以，此时将资源文件放在WEB-INF\classes\目录下就可以。
	//ResourceBundle rb = ResourceBundle.getBundle(resourceFile);
	File f = new File(getWEB_INF()+"classes/conf.properties");
	System.out.println(f.exists());//这里是分大小写的，嘿嘿输出值为
		
	}
}
