package com.itour.base.util;
import com.google.common.base.Strings;  

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest; 
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
public class SHA {
	/** 
     * 定义加密方式 
     */  
    private final static String KEY_SHA = "SHA";  
    private final static String KEY_SHA1 = "SHA-1";  
    /** 
     * 全局数组 
     */  
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };  
  
    /** 
     * 构造函数 
     */  
    public SHA() {  
  
    }  
  
    /** 
     * SHA 加密 
     * @param data 需要加密的字节数组 
     * @return 加密之后的字节数组 
     * @throws Exception 
     */  
    public static byte[] encryptSHA(byte[] data) throws Exception {  
        // 创建具有指定算法名称的信息摘要  
//        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);  
        // 使用指定的字节数组对摘要进行最后更新  
        sha.update(data);  
        // 完成摘要计算并返回  
        return sha.digest();  
    }  
  
    /** 
     * SHA 加密 
     * @param data 需要加密的字符串 
     * @return 加密之后的字符串 
     * @throws Exception 
     */  
    public static String encryptSHA(String data) throws Exception {  
        // 验证传入的字符串  
        if (Strings.isNullOrEmpty(data)) {  
            return "";  
        }  
        // 创建具有指定算法名称的信息摘要  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
        // 使用指定的字节数组对摘要进行最后更新  
        sha.update(data.getBytes());  
        // 完成摘要计算  
        byte[] bytes = sha.digest();  
        // 将得到的字节数组变成字符串返回  
        return byteArrayToHexString(bytes);  
    }  
  
    /** 
     * 将一个字节转化成十六进制形式的字符串 
     * @param b 字节数组 
     * @return 字符串 
     */  
    private static String byteToHexString(byte b) {  
        int ret = b;  
        //System.out.println("ret = " + ret);  
        if (ret < 0) {  
            ret += 256;  
        }  
        int m = ret / 16;  
        int n = ret % 16;  
        return hexDigits[m] + hexDigits[n];  
    }  
  
    /** 
     * 转换字节数组为十六进制字符串 
     * @param bytes 字节数组 
     * @return 十六进制字符串 
     */  
    private static String byteArrayToHexString(byte[] bytes) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < bytes.length; i++) {  
            sb.append(byteToHexString(bytes[i]));  
        }  
        return sb.toString().toUpperCase();  
    }  
    	  
	 /** 
	  * 使用MAC 算法的 消息摘要 
	  * @param data 
	  * @throws Exception 
	  */ 
	 public static String encodeByMAC(String data) throws Exception{ 
		//  KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA1"); 
		//  SecretKey key = keyGen.generateKey(); //这个每次生成的key不一样, 此处不能使用 
		   
		  PBEKeySpec keySpec = new PBEKeySpec("randomkey^(^&*^%$".toCharArray()); 
		  SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES"); 
		  SecretKey key = keyFactory.generateSecret(keySpec); 
		   
		  /* 
		   * 此类提供“消息验证码”（Message Authentication Code，MAC）算法的功能。 
		   * MAC 基于秘密密钥提供一种方式来检查在不可靠介质上进行传输或存储的信息的完整性。 
		   * 通常，消息验证码在共享秘密密钥的两个参与者之间使用，以验证这两者之间传输的信息。 
		   * 基于加密哈希函数的 MAC 机制也叫作 HMAC。结合秘密共享密钥， 
		   * HMAC 可以用于任何加密哈希函数（如 MD5 或 SHA-1） 
		   */ 
		  Mac mac = Mac.getInstance("HmacSHA1"); 
		  //以下三种都可用 
		//  Mac mac = Mac.getInstance("HmacSHA256"); 
		//  Mac mac = Mac.getInstance("HmacSHA384"); 
		//  Mac mac = Mac.getInstance("HmacSHA512"); 
		  mac.init(key); 
		  byte[] dest = mac.doFinal(data.getBytes()); 
		  System.out.println(dest.length); 
		  String result =byteArrayToHexString(dest); 
		  System.out.println("MAC摘要：" + result); 
		  return result;
	 } 
	  
	 /** 
	  * SHA1加密 使用消息摘要MessageDigest 处理 
	  * @throws Exception 
	  */ 
	 public static String encodeBySHA(String str) throws Exception{ 
		  MessageDigest sha1; 
		  sha1 = MessageDigest.getInstance("SHA1"); 
		  //以下三种不可用 
		//  sha1 = MessageDigest.getInstance("SHA256"); 
		//  sha1 = MessageDigest.getInstance("SHA384"); 
		//  sha1 = MessageDigest.getInstance("SHA512"); 
		   
		  sha1.update(str.getBytes()); //先更新摘要 
		  byte[] digest = sha1.digest(); //再通过执行诸如填充之类的最终操作完成哈希计算。在调用此方法之后，摘要被重置。 
		   
		  /* 
		   * 使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算。 
		   * 也就是说，此方法首先调用 update(input)， 
		   * 向 update 方法传递 input 数组，然后调用 digest()。 
		   */ 
		//  byte[] digest = sha1.digest(str.getBytes()); 
		   
		  String hex = toHex(digest); 
		  System.out.println("SHA1摘要:" + hex); 
		  return hex; 
	 } 
	  
	 /** 
	  * 文件数据摘要 
	  * @throws Exception 
	  */ 
	 public static void shaFile() throws Exception { 
		  MessageDigest messageDigest = MessageDigest.getInstance("SHA1"); 
		  DigestOutputStream dos = new DigestOutputStream(new FileOutputStream(new File("abc.txt")), messageDigest); 
		  dos.write("中华人民……&（））f*（214）admin*".getBytes()); 
		  dos.close(); 
		  byte[] digest = messageDigest.digest(); 
		  System.out.println("使用流写文件，该文件的摘要为:" + toHex(digest)); 
		   
		  DigestInputStream dis = new DigestInputStream(new FileInputStream(new File("abc.txt")), messageDigest); 
		  byte[] buf = new byte[100]; 
		  int len; 
		  while ((len = dis.read(buf)) != -1) { 
		   System.out.println("读取到的数据为：" + new String(buf, 0, len)); 
		  } 
		  dis.close(); 
		  byte[] digest2 = messageDigest.digest(); 
		  //当流读取完毕，即将文件读完了， 这时的摘要 才与 写入时的 一样 
		  System.out.println("使用流读文件，该文件的摘要为:" + toHex(digest2)); 
	 } 
	  
	 /** 
	  * sha1 摘要转16进制 
	  * @param digest 
	  * @return 
	  */ 
	 private static String toHex(byte[] digest) { 
		  StringBuilder sb = new StringBuilder(); 
		  int len = digest.length; 
		   
		  String out = null; 
		  for (int i = 0; i < len; i++) { 
		//   out = Integer.toHexString(0xFF & digest[i] + 0xABCDEF); //加任意 salt 
		   out = Integer.toHexString(0xFF & digest[i]);//原始方法 
		   if (out.length() == 1) { 
		    sb.append("0");//如果为1位 前面补个0 
		   } 
		   sb.append(out); 
		  } 
		  return sb.toString(); 
	 } 
    	 
    /** 
     * 测试方法 
     * @param args 
     */  
    public static void main(String[] args) throws Exception {  
        String key = "admin";  
      /*  System.out.println(key +"encryptSHA "+encryptSHA(key));  
        System.out.println(key +"encodeByMAC "+encodeByMAC(key));  
         key = "123456";  
        System.out.println(key +"encode  "+encryptSHA(key)); 
        key = "aaaaa";  
        System.out.println(key +"encode  "+encryptSHA(key)); 
        System.out.println("D033E22AE348AEB5660FC2140AEC35850C4DA997".length());*/
	  	//  encodeBySHA("中国oP……&*（）…&802134…"); 
	  //	  shaFile(); 
        String firstEncode = SHA.encryptSHA(key); 
        System.out.println(firstEncode);
        String second = firstEncode.substring(20, firstEncode.length());
		 String secondEncode = SHA.encryptSHA(second); 
		 String finalPwdCode = secondEncode.substring(1,secondEncode.length()-2);//SHA1加密原始密码后取前16位再SHA1加密,去掉头尾两位,剩余30位存入数据库
		 System.out.println(finalPwdCode+"     398A7190A349339E41D727090D95FA0DDF9D78  "+finalPwdCode.length());
	
    }  
}
