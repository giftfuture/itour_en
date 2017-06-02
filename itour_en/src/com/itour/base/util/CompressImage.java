package com.itour.base.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.itour.util.Constants;
import com.itour.vo.ShowHappyVO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import sun.misc.BASE64Decoder;

public class CompressImage {
	public final static Map<String,String> base64ImgExt = new HashMap<String,String>(){{
		put("jpg","jpeg");
		put("png","png");
		put("gif","gif");
		put("bmp","bmp");
		put("tif","tif");
		put("psd","psd");
		put("ico","x-icon");
	}};
	public final static Map<String,String> convertbase64ImgExt = new HashMap<String,String>(){{
		put("jpeg","jpg");
		put("png","png");
		put("gif","gif");
		put("bmp","bmp");
		put("tif","tif");
		put("psd","psd");
		put("x-icon","ico");
	}};
	//使用正则表达式，排除img标签src属性值已经是base64编码的情况  
   static Pattern pattern = Pattern.compile("^data:image/(png|gif|jpg|jpeg|bmp|tif|psd|ico);base64,.*");  
   static final String base64 = "base64,";
   static Matcher matcher = null;
   static final BASE64Decoder d = new BASE64Decoder();  
	public static void compressBySize(String originalPath ,String zipPath,int width,int height){
		try {
		   //keepAspectRatio(false)默认是按照比例缩放的  
			Thumbnails.of(originalPath)  
			    .size(width,height)  
			    .keepAspectRatio(false)  
			    .toFile(zipPath); 
			Thumbnails.of("");
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	public static String compressBySize(String base64cover,String surface,String serRoot,String subpath){
        try {
        	File directory = new File(serRoot);  
			if(!directory.exists()||!directory.isDirectory()){//文件根目录不存在时创建  
				directory.mkdirs();  
			} 
			File ff = new File(serRoot+File.separatorChar+subpath);  
			if(!ff.exists()||!ff.isDirectory()){//文件根目录不存在时创建  
				ff.mkdirs();  
			}
			String ext = base64cover.substring(base64cover.indexOf("data:image/")+"data:image/".length(),base64cover.indexOf(";base64,"));
			boolean iscn = false;
			String realext  = convertbase64ImgExt.get(ext);
			if(StringUtils.isNotEmpty(surface)){
    			for(char c:surface.toCharArray()){
    				if(StringUtil.checkCharContainChinese(c)){
    					iscn = true;
    					break;
    				}
    			};
			}
			if(StringUtil.checkStringContainChinese(surface)||iscn||StringUtils.isEmpty(surface)){
				String newname = IDGenerator.code(16)+"."+realext;
				base64cover = base64cover.replace("data:image/"+ext+";base64,", "");//ImageIO.read(new File("images/watermark.png")
				byte[] bs = d.decodeBuffer(base64cover);
				Thumbnails.of(new ByteArrayInputStream(bs)).size(Constants.compressWidth,Constants.compressHeight).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(FilePros.watermark()),0.5f).outputQuality(0.8f).keepAspectRatio(false).toFile(serRoot+File.separatorChar+subpath+File.separatorChar+newname);
				return newname;
			}else{
				byte[] bs = d.decodeBuffer(base64cover); 
				Thumbnails.of(new ByteArrayInputStream(bs)).size(Constants.compressWidth,Constants.compressHeight).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(FilePros.watermark()),0.5f).outputQuality(0.8f).keepAspectRatio(false).toFile(serRoot+File.separatorChar+subpath+File.separatorChar+surface);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "";//cover.getName();
	}
	/** 
     * 替换html中的base64图片数据为实际图片 
     * @param html 
     * @param fileRoot 本地路径 
     * @param serRoot 服务器路径 
     * @return 
     */  
    public static void writeSHBase64Image(ShowHappyVO showhappy,String serRoot){  
        try {
		String html = showhappy.getContent();
			Map<String,String> srcs = getImgSrc(html);
			Pattern pattern = Pattern.compile("^data:image/(png|gif|jpg|jpeg|bmp|tif|psd|ico);base64,.*");  
			for(Map.Entry<String,String> entry:srcs.entrySet()){
				String src = entry.getValue().replaceAll("'", "");
				String fileName = entry.getKey().replaceAll("'", "");//待存储的文件名  
				boolean iscn = false;
				String newname = fileName;
				String ext = fileName.substring(fileName.indexOf('.'));//图片后缀         
    			for(char c:fileName.toCharArray()){
    				if(StringUtil.checkCharContainChinese(c)){
    					iscn = true;
    					break;
    				}
    			};
				if(StringUtil.checkStringContainChinese(fileName)||iscn){
    				 newname = IDGenerator.code(16)+ext;
    			}
				Matcher m = pattern.matcher(src);  
		 		if(m.find()){
				       String str = src.substring(src.indexOf(base64)+base64.length());
				       System.out.println(html.indexOf(src)+"     "+src.indexOf(str)+"    "+html.length());
				       html = html.replace(src, fileName);
				       System.out.println(html.length());
				        if(StringUtils.isNotEmpty(ext)){  
				            	File directory = new File(serRoot);  
				    			if(!directory.exists()||!directory.isDirectory()){//文件根目录不存在时创建  
				    				directory.mkdirs();  
				    			} 
				    			String path = showhappy.getShCode()+"_"+showhappy.getRoute();
				    			File ff = new File(serRoot+File.separatorChar+path);  
				    			if(!ff.exists()||!ff.isDirectory()){//文件根目录不存在时创建  
				    				ff.mkdirs();  
				    			}
				              //  convertBase64DataToImage(str, serRoot+File.separatorChar+path+File.separatorChar+newname);//转成文件  
				                str = str.replace("data:image/"+ext+";base64,", "");//ImageIO.read(new File("images/watermark.png")
								byte[] bs = d.decodeBuffer(str);																																															 	
								Thumbnails.of(new ByteArrayInputStream(bs)).size(Constants.compressWidth,Constants.compressHeight).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(FilePros.watermark()),0.5f).outputQuality(0.8f).keepAspectRatio(false).toFile(serRoot+File.separatorChar+path+File.separatorChar+newname);
				                if(!fileName.equals(newname)){
				                	html = html.replace(fileName, newname);
				                }
				        }      
			    }   
			}
			showhappy.setContent(html);
			String shortContent = html2Text(html);
			if(StringUtils.isNotEmpty(shortContent)){
				if(shortContent.length()> 30){
					showhappy.setShortContent(shortContent.substring(0, 30)+"...");
				}else{
					showhappy.setShortContent(shortContent);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }  
    /**
     * 
     * @param inputString
     * @return
     */
    public static String html2Text(String inputString){
        String htmlStr = inputString; //含html标签的字符串
        String textStr ="";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
       try{
             String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
             String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
             String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

             p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
             m_script = p_script.matcher(htmlStr);
             htmlStr = m_script.replaceAll(""); //过滤script标签

             p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
             m_style = p_style.matcher(htmlStr);
             htmlStr = m_style.replaceAll(""); //过滤style标签

             p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
             m_html = p_html.matcher(htmlStr);
             htmlStr = m_html.replaceAll(""); //过滤html标签
             textStr = htmlStr;
        }catch(Exception e){
            e.printStackTrace();
        }
        return textStr;//返回文本字符串
    } 
	/**
	 * 
	 * @param htmlStr
	 * @return
	 */
	public static Map<String,String> getImgSrc(String htmlStr) {  
        String img = "";  
        Pattern p_image;  
        Matcher m_image;  
      //  List<String> pics = new ArrayList<String>();  
        Map<String,String> imgs = Maps.newHashMap();
      String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址  
    //    String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?/>";  
        p_image = Pattern.compile(regEx_img);  //, Pattern.CASE_INSENSITIVE
        m_image = p_image.matcher(htmlStr);  
        while (m_image.find()) {  
            img = img + "," + m_image.group();  
            // Matcher m =  
            // Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src  
            Matcher mc = Pattern.compile("data-filename\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img); 
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img); 
            while(m.find()&& mc.find()) {  
                //pics.add(m.group(1));  
            	imgs.put(mc.group(1), m.group(1));
            }  
        }  
        return imgs;  
    }
	/**
     * 
     * @Description:保存图片并且生成缩略图
     * @param imageFile 图片文件
     * @param request 请求对象
     * @param uploadPath 上传目录
     * @return
     */
/*    public static BaseResult uploadFileAndCreateThumbnail(MultipartFile imageFile,HttpServletRequest request,String uploadPath) {
        if(imageFile == null ){
            return new BaseResult(false, "imageFile不能为空");
        }
        
        if (imageFile.getSize() >= 10*1024*1024)
        {
            return new BaseResult(false, "文件不能大于10M");
        }
        String uuid = UUID.randomUUID().toString();
        
        String fileDirectory = CommonDateUtils.date2string(new Date(), CommonDateUtils.YYYY_MM_DD);
        
        //拼接后台文件名称
        String pathName = fileDirectory + File.separator + uuid + "."
                            + FilenameUtils.getExtension(imageFile.getOriginalFilename());
        //构建保存文件路劲
        //2016-5-6 yangkang 修改上传路径为服务器上 
        String realPath = request.getServletContext().getRealPath("uploadPath");
        //获取服务器绝对路径 linux 服务器地址  获取当前使用的配置文件配置
        //String urlString=PropertiesUtil.getInstance().getSysPro("uploadPath");
        //拼接文件路劲
        String filePathName = realPath + File.separator + pathName;
        log.info("图片上传路径："+filePathName);
        //判断文件保存是否存在
        File file = new File(filePathName);
        if (file.getParentFile() != null || !file.getParentFile().isDirectory()) {
            //创建文件
            file.getParentFile().mkdirs();
        }
        
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = imageFile.getInputStream();
            fileOutputStream = new FileOutputStream(file);
            //写出文件
            //改为增加缓存
//            IOUtils.copy(inputStream, fileOutputStream);
            byte[] buffer = new byte[2048];
            IOUtils.copyLarge(inputStream, fileOutputStream, buffer);
            buffer = null;

        } catch (IOException e) {
            filePathName = null;
            return new BaseResult(false, "操作失败", e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                filePathName = null;
                return new BaseResult(false, "操作失败", e.getMessage());
            } 
         }
        *//**
         * 缩略图begin
         *//*
        //拼接后台文件名称
        String thumbnailPathName = fileDirectory + File.separator + uuid + "small."
                                    + FilenameUtils.getExtension(imageFile.getOriginalFilename());
        //added by yangkang 2016-3-30 去掉后缀中包含的.png字符串 
        if(thumbnailPathName.contains(".png")){
            thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
        }
        long size = imageFile.getSize();
        double scale = 1.0d ;
        if(size >= 200*1024){
            if(size > 0){
                scale = (200*1024f) / size  ;
            }
        }
        //拼接文件路劲
        String thumbnailFilePathName = realPath + File.separator + thumbnailPathName;
        try {
            // 注释掉之前长宽的方式，改用大小
//            Thumbnails.of(filePathName).size(width, height).toFile(thumbnailFilePathName);
            if(size < 200*1024){
                Thumbnails.of(filePathName).scale(1f).outputFormat("jpg").toFile(thumbnailFilePathName);
            }else{
                Thumbnails.of(filePathName).scale(1f).outputQuality(scale).outputFormat("jpg").toFile(thumbnailFilePathName);
            }
            
        } catch (Exception e1) {
            return new BaseResult(false, "操作失败", e1.getMessage());
        }
        *//**
         * 缩略图end
         *//*
        
        Map<String, Object> map = new HashMap<String, Object>();
        //原图地址
        map.put("originalUrl", pathName);
        //缩略图地址
        map.put("thumbnailUrl", thumbnailPathName);
        return new BaseResult(true, "操作成功", map);
    }*/
	public static void main(String[] args) {
		//CompressImage.compressBySize("D:\\itours\\photos\\images\\watermark.gif" ,"D:\\itours\\photos\\images\\aa.gif",100,60);
		/*File of = new File("D:\\itours_en\\photos\\images\\upload");
		String destpath="D:\\itoursen_temp\\photos\\images\\upload";
		File[] ffs = of.listFiles();
		for(File f:ffs){
			if(f.isDirectory()){
				if(f.getName().equals("adlink")){
					File[] fileorimgs = f.listFiles();
					for(File fileorimg:fileorimgs){
						if(fileorimg.isFile()){
							File destd = new File(destpath+File.separatorChar+f.getName());
							if(!destd.exists()){
								destd.mkdirs();
							}
							File destfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName());
							CompressImage.compressBySize(fileorimg.getAbsolutePath() ,destfile.getAbsolutePath(),Constants.compressHomeWidth,Constants.compressHomeHeight);
						}else if (fileorimg.isDirectory()){
							File[] imgs = fileorimg.listFiles();
							for(File img:imgs){
								if(img.isFile()){
									File dest = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName());
									if(!dest.exists()){
										dest.mkdirs();
									}
									File destfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName());
									CompressImage.compressBySize(img.getAbsolutePath() ,destfile.getAbsolutePath(),Constants.compressHomeWidth,Constants.compressHomeHeight);
								}else if(img.isDirectory()){
									File[] igs = img.listFiles();
									for(File ig:igs){
										if(ig.isFile()){
											File dt = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName()+File.separatorChar+ig.getName());
											if(!dt.exists()){
												dt.mkdirs();
											}
											CompressImage.compressBySize(ig.getAbsolutePath() ,dt.getAbsolutePath(),Constants.compressHomeWidth,Constants.compressHomeHeight);
										}
								}
							}
						}
					}
				}
			}else if(f.getName().equals("routemap")){
					File[] fileorimgs = f.listFiles();
					for(File fileorimg:fileorimgs){
						if(fileorimg.isFile()){
							File destfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName());
							if(!destfile.exists()){
								destfile.mkdirs();
							}
							CompressImage.compressBySize(fileorimg.getAbsolutePath() ,destfile.getAbsolutePath(),Constants.compressMapWidth,Constants.compressMapHeight);
						}else if (fileorimg.isDirectory()){
							File[] imgs = fileorimg.listFiles();
							for(File img:imgs){
								if(img.isFile()){
									File dest = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName());
									if(!dest.exists()){
										dest.mkdirs();
									}
									File destfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName());
									CompressImage.compressBySize(img.getAbsolutePath() ,destfile.getAbsolutePath(),Constants.compressMapWidth,Constants.compressMapHeight);
								}else if(img.isDirectory()){
									File[] igs = img.listFiles();
									for(File ig:igs){
										if(ig.isFile()){
											File dt = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName());
											if(!dt.exists()){
												dt.mkdirs();
											}
											File dtfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName()+File.separatorChar+ig.getName());
											CompressImage.compressBySize(ig.getAbsolutePath() ,dtfile.getAbsolutePath(),Constants.compressMapWidth,Constants.compressMapHeight);
										}
								}
							}
						}
					}
				}
			}else{
					File[] fileorimgs = f.listFiles();
					for(File fileorimg:fileorimgs){
						if(fileorimg.isFile()){
							File dest = new File(destpath+File.separatorChar+f.getName());
							if(!dest.exists()){
								dest.mkdirs();
							}
							File destfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName());
							CompressImage.compressBySize(fileorimg.getAbsolutePath() ,destfile.getAbsolutePath(),Constants.compressWidth,Constants.compressHeight);
						}else if (fileorimg.isDirectory()){
							File[] imgs = fileorimg.listFiles();
							for(File img:imgs){
								if(img.isFile()){
									File dest = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName());
									if(!dest.exists()){
										dest.mkdirs();
									}
									File destfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName());
									CompressImage.compressBySize(img.getAbsolutePath() ,destfile.getAbsolutePath(),Constants.compressWidth,Constants.compressHeight);
								}else if(img.isDirectory()){
									File[] igs = img.listFiles();
									for(File ig:igs){
										if(ig.isFile()){
											File dt = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName());
											if(!dt.exists()){
												dt.mkdirs();
											}
											File dtfile = new File(destpath+File.separatorChar+f.getName()+File.separatorChar+fileorimg.getName()+File.separatorChar+img.getName()+File.separatorChar+ig.getName());
											CompressImage.compressBySize(ig.getAbsolutePath() ,dtfile.getAbsolutePath(),Constants.compressWidth,Constants.compressHeight);
										}
								}
							}
						}
					}
				}
			}
			}
		}*/
	}
}
