package com.itour.base.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;  
import java.awt.RenderingHints;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;  
  
import com.lowagie.text.Image;
import javax.imageio.ImageIO;  
import javax.swing.ImageIcon;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;  
/**
 * 
 * @author THUNDEROBOT
 *
 */
public class ImageMarkLogoByIcon {
    /**   
     * @param args   
     */    
    public static void main(String[] args) {     
        String srcImgPath = "c:/1111.png";     
        String iconPath = "c:/0439.jpg";     
        String targerPath = "c:/c.png" ;   
        //String srcImgPath = "d:/test/michael/myblog_01.jpg"; 
        String logoText = "[ 测试文字水印 http://sjsky.iteye.com ]"; 
        //String targerPath = "d:/test/michael/img_mark_text.jpg"; 
        String targerPath2 = "d:/test/michael/img_mark_text_rotate.jpg"; 
         // 给图片添加水印     
        ImageMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, targerPath , -45);    
        // 给图片添加水印 
        ImageMarkLogoByIcon.markByText(logoText, srcImgPath, targerPath); 
        // 给图片添加水印,水印旋转-45 
        ImageMarkLogoByIcon.markByText(logoText, srcImgPath, targerPath2, -45); 
    }     
    /**   
     * 给图片添加水印   
     * @param iconPath 水印图片路径   
     * @param srcImgPath 源图片路径   
     * @param targerPath 目标图片路径   
     */    
    public static void markImageByIcon(String iconPath, String srcImgPath,String targerPath) {     
        markImageByIcon(iconPath, srcImgPath, targerPath, null) ;   
    }     
    /**   
     * 给图片添加水印、可设置水印图片旋转角度   
     * @param iconPath 水印图片路径   
     * @param srcImgPath 源图片路径   
     * @param targerPath 目标图片路径   
     * @param degree 水印图片旋转角度 
     */    
    public static void markImageByIcon(String iconPath, String srcImgPath,String targerPath, Integer degree) {     
        OutputStream os = null;     
        try {     
        	BufferedImage srcImg = ImageIO.read(new File(srcImgPath));   
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);   
            // 得到画笔对象     
            // Graphics g= buffImg.getGraphics();     
            Graphics2D g = buffImg.createGraphics();     
            // 设置对线段的锯齿状边缘处理     
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);     
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.SCALE_SMOOTH), 0, 0, null);     
            if (null != degree) {  // 设置水印旋转        
                g.rotate(Math.toRadians(degree),(double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);     
            }     
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度    
            ImageIcon imgIcon = new ImageIcon(iconPath);    
            // 得到Image对象。     
            java.awt.Image img =  imgIcon.getImage();     
            float alpha = 0.2f; // 透明度     
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));     
            // 表示水印图片的位置     
            g.drawImage(img, 150, 300, null);     
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));     
            g.dispose();     
            os = new FileOutputStream(targerPath);     
            // 生成图片     
            ImageIO.write(buffImg, "JPG", os);     
        } catch (Exception e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if (null != os)     
                    os.close();     
            } catch (Exception e) {     
                e.printStackTrace();     
            }     
        }     
    }     
    /** 
     * 给pdf文件添加水印 
     * @param InPdfFile 要加水印的原pdf文件路径 
     * @param outPdfFile 加了水印后要输出的路径 
     * @param markImagePath 水印图片路径 
     * @param pageSize 原pdf文件的总页数（该方法是我当初将数据导入excel中然后再转换成pdf所以我这里的值是用excel的行数计算出来的，如果不是我这种可以 直接用reader.getNumberOfPages()获取pdf的总页数） 
     * @throws Exception 
     */  
   public static void addPdfMark(String InPdfFile, String outPdfFile, String markImagePath, int pageSize) throws Exception {  
    PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());  
    PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPdfFile));  
    Image img = Image.getInstance(markImagePath);// 插入水印     
    img.setAbsolutePosition(150, 100);  
    for(int i = 1; i <= pageSize; i++) {  
	     PdfContentByte under = stamp.getUnderContent(i);  
	     under.addImage(img);  
    }  
    stamp.close();// 关闭   
    File tempfile = new File(InPdfFile);  
    if(tempfile.exists()) {  
     tempfile.delete();  
    }  
   }  
   /**
    * 给图片添加水印
    * @param logoText
    * @param srcImgPath
    * @param targerPath
    */ 
   public static void markByText(String logoText, String srcImgPath,String targerPath) { 
       markByText(logoText, srcImgPath, targerPath, null); 
   } 

   /**
    * 给图片添加水印、可设置水印的旋转角度
    * @param logoText
    * @param srcImgPath
    * @param targerPath
    * @param degree
    */ 
   public static void markByText(String logoText, String srcImgPath,String targerPath, Integer degree) { 
       // 主图片的路径 
       InputStream is = null; 
       OutputStream os = null; 
       try { 
           BufferedImage srcImg = ImageIO.read(new File(srcImgPath)); 
           BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB); 
           // 得到画笔对象 
           // Graphics g= buffImg.getGraphics(); 
           Graphics2D g = buffImg.createGraphics(); 
           // 设置对线段的锯齿状边缘处理 
           g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
           g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg .getHeight(null), BufferedImage.SCALE_SMOOTH), 0, 0, null); 
           if (null != degree) { 
               // 设置水印旋转 
               g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2); 
           } 
           // 设置颜色 
           g.setColor(Color.red); 
           // 设置 Font 
           g.setFont(new Font("宋体", Font.BOLD, 30)); 
           float alpha = 0.5f; 
           g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha)); 
           // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y) . 
           g.drawString(logoText, 150, 300); 
           g.dispose(); 
           os = new FileOutputStream(targerPath); 
           // 生成图片 
           ImageIO.write(buffImg, "JPG", os); 
           System.out.println("图片完成添加文字印章。。。。。。"); 
       } catch (Exception e) { 
           e.printStackTrace(); 
       } finally { 
           try { 
               if (null != is) 
                   is.close(); 
           } catch (Exception e) { 
               e.printStackTrace(); 
           } 
           try { 
               if (null != os) 
                   os.close(); 
           } catch (Exception e) { 
               e.printStackTrace(); 
           } 
       } 
   } 
}
