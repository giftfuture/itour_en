package com.itour.base.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Finger3des {
	//定义加密算法，有DES、DESede(即3DES)、Blowfish
  //  private static final String Algorithm = "3DES";//解密模式-关键
    private static final String Algorithm = "AES";//解密模式-关键"AES/ECB/PKCS5Padding
  //  public static final byte[] PASSWORD_CRYPT_KEY = "immanuel-Christ-Lord".getBytes();//约定密钥
    //1234567812345678
    public static final byte[] PASSWORD_CRYPT_KEY = "immanuel-Christ_".getBytes();//约定密钥
    /** 
     * 全局数组 
     */  
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };  
    /**
     * 解密函数
     * @param src 密文的字节数组
     */
    public static byte[] decryptMode(byte[] src) {
        try {
            SecretKey deskey = new SecretKeySpec((PASSWORD_CRYPT_KEY), Algorithm);
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);//初始化为解密模式
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
     }
    
    /**
     * 加密方法//未用
     * @param src 源数据的字节数组
     * @return 
     */
    public static byte[] encryptMode(byte[] src) {
        try {
             SecretKey deskey = new SecretKeySpec((PASSWORD_CRYPT_KEY), Algorithm);//生成密钥
             Cipher c1 = Cipher.getInstance(Algorithm);//实例化负责加密/解密的Cipher工具类
             c1.init(Cipher.ENCRYPT_MODE, deskey);  //初始化为加密模式
             byte[]  result = c1.doFinal(src);
             return result;
         } catch (java.security.NoSuchAlgorithmException e1) {
             e1.printStackTrace();
         } catch (javax.crypto.NoSuchPaddingException e2) {
             e2.printStackTrace();
         } catch (java.lang.Exception e3) {
             e3.printStackTrace();
         }
         return null;
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
        return sb.toString();  
    }  
    public static void main(String[]args){
    	String key ="admin";
    	String pwd = Arrays.toString(encryptMode(key.getBytes(Charset.forName("UTF-8"))));
    	System.out.println(pwd) ;
    	pwd = byteArrayToHexString(encryptMode(key.getBytes(Charset.forName("UTF-8"))));
    	System.out.println(pwd) ;
    	/*String pwd =java.util.Base64.getEncoder().encodeToString("some string".getBytes("utf-8")); 
    	try {
			System.out.println(key+" encode    "+new String(,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}
