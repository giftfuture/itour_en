package com.itour.base.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class RandomCodeUtil {
	 private ByteArrayInputStream image;//图像
	    private String str;//验证码
	    
	    private RandomCodeUtil(){
	        init();
	    }
	    
	    public static RandomCodeUtil instance(){
	        return new RandomCodeUtil();
	    }

	    public ByteArrayInputStream getImage() {
	        return image;
	    }

	    public String getStr() {
	        return str;
	    }
	    
	    private void init(){
	        //      在内存中创建图象  
	        int width=85, height=20;  
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	        //      获取图形上下文  
	        Graphics g = image.getGraphics();  
	        //      生成随机类  
	        Random random = new Random();  
	        //       设定背景色  
	        g.setColor(getRandColor(200,250));  
	        g.fillRect(0, 0, width, height);  
	        //      设定字体  
	        g.setFont(new Font("Time News Roman",Font.ROMAN_BASELINE,17));  

	        
	        //      随机产生300条干扰线，使图象中的认证码不易被其它程序探测到  
	        g.setColor(getRandColor(160,200));  
	        for (int i=0;i<300;i++){  
	            int x = random.nextInt(width);  
	            int y = random.nextInt(height);  
	            int xl = random.nextInt(12);  
	            int yl = random.nextInt(12);  
	            g.drawLine(x,y,x+xl,y+yl);  
	        }  
	        //       取随机产生的认证码(6位数字)  
	        String sRand="";  
	        for (int i=0;i<6;i++){  
	            //String rand=String.valueOf(random.nextInt(10));
	            String rand = getRandomChar();
	            sRand = sRand.concat(rand);  
	            // 将认证码显示到图象中  
	            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));  
	            //      调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成  
	            g.drawString(rand,13*i+6,16);    
	        }  
	        this.str=sRand;
	        //       图象生效  
	        g.dispose();  
	        ByteArrayInputStream input=null;  
	        ByteArrayOutputStream output = new ByteArrayOutputStream();  
	        try{  
	            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);  
	            ImageIO.write(image, "JPEG", imageOut);  
	            imageOut.close();  
	            input = new ByteArrayInputStream(output.toByteArray());  
	        }catch(Exception e){  
	        System.out.println("验证码图片产生出现错误："+e.toString());  

	        }
	        this.image=input;
	    }
	    
	      
	    private Color getRandColor(int fc,int bc){  
	        Random random = new Random();  
	        if(fc>255) fc=255;  
	        if(bc>255) bc=255;  
	        int r=fc+random.nextInt(bc-fc);  
	        int g=fc+random.nextInt(bc-fc);  
	        int b=fc+random.nextInt(bc-fc);  
	        return new Color(r,g,b);  
	    }  

	    
	    public static String getRandomChar() {
	          int index = (int) Math.round(Math.random() * 2);
	          String randChar = "";
	          switch (index) {
	          case 0://大写字符
	           randChar = String.valueOf((char)Math.round(Math.random() * 25 + 65));
	           break;
	          case 1://小写字符
	           randChar = String.valueOf((char)Math.round(Math.random() * 25 + 97));
	           break;
	          default://数字
	           randChar = String.valueOf(Math.round(Math.random() * 9));
	           break;
	          }
	          return randChar;
       }

	    public static void main(String[] args) {
			
		}
	    
}
