package com.itour.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class IDGenerator {
	   
	  private static long num=0; 
	   
	  /**
	   * 随机生成UUID
	   * @return
	   */
	  public static synchronized String getUUID(){
	    UUID uuid=UUID.randomUUID();
	    String str = uuid.toString(); 
	    String uuidStr=str.replace("-", "");
	    return uuidStr;
	  }
	  /**
	   * 根据字符串生成固定UUID
	   * @param name
	   * @return
	   */
	  public static synchronized String getUUID(String name){
	    UUID uuid=UUID.nameUUIDFromBytes(name.getBytes());
	    String str = uuid.toString(); 
	    String uuidStr=str.replace("-", "");
	    return uuidStr;
	  }
	  /**
	   * 根据日期生成长整型id
	   * @param args
	   */
	  public static synchronized long getLongId(){
	    String date=DateUtil.format(new Date(),new SimpleDateFormat( "yyyyMMddHHmmssS"));
	    System.out.println("原始id="+date);
	    if(num>=99) num=0l;
	    ++num;
	    if(num<10) {
	      date=date+00+num;
	    }else{
	      date+=num;
	    }
	    return Long.valueOf(date);
	  }
	  final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',  
		        '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',  
		        'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',  
		        'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',  
		        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',  
		        'Z' };  
	  final static char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8','9' };  
		/** 
		 * 随机ID生成器，由数字、小写字母和大写字母组成 
		 *  
		 * @param size 
		 * @return 
		 */  
		public static String code(int size) {  
		    Random random = new Random();  
		    char[] cs = new char[size];  
		    for (int i = 0; i < cs.length; i++) {  
		        cs[i] = digits[random.nextInt(digits.length)];  
		    }  
		    return new String(cs);  
		} 
		/** 
		 * 随机ID生成器，由数字、小写字母和大写字母组成 
		 *  
		 * @param size 
		 * @return 
		 */  
		public static String number(int size) {  
		    Random random = new Random();  
		    char[] cs = new char[size];  
		    for (int i = 0; i < cs.length; i++) {  
		        cs[i] = numbers[random.nextInt(numbers.length)];  
		    }  
		    return new String(cs);  
		}
	  public static void main(String[]args){
		 /* for(int i=0;i<7;i++){
			  System.out.println(getUUID());
		  }*/
		  System.out.println(code(19));
	  }
	  
	}