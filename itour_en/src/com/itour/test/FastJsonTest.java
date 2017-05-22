package com.itour.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.jsoup.Jsoup;
//import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.itour.entity.Customers;

public class FastJsonTest {
	 /** 
     * 序列化 
     */  
    public void toJsonString()  
    {  
        Customers user = new Customers("105","testFastJson001", "maks");  
        String text = JSON.toJSONString(user);  
        System.out.println("toJsonString()方法：text=" + text);  
        System.out.println("toJsonString()方法：text=" +  JSON.toJSONString(user));  
        // 输出结果：text={"age":105,"id":"testFastJson001","name":"maks"}  
    }  
  
    /** 
     * 反序列化为json对象 
     */  
    public void parseJsonObject()  
    {  
        String text = "{\"id\":105,\"customername\":\"testFastJson001\",\"introduction\":\"maks\"}";  
        JSONObject json =  JSON.parseObject(text);  
        System.out.println("parseJsonObject()方法：json==" + json);  
        // 输出结果：json=={"age":105,"id":"testFastJson001","name":"maks"}  
    }  
  
    /** 
     * 反序列化为javaBean对象 
     */  
    public void parseBeanObject()  
    {  
	    String text = "{\"id\":105,\"customername\":\"testFastJson001\",\"introduction\":\"maks\"}"; 
        Customers user = (Customers) JSON.parseObject(text, Customers.class);  
        System.out.println("parseBeanObject()方法：user==" + user.getCustomerId() + "," + user.getCustomerName() + "," + user.getIntroduction());  
        // 输出结果：user==testFastJson001,maks,105  
    }  
  
    /** 
     * 将javaBean转化为json对象 
     */  
    public void bean2Json()  
    {  
    	Customers user = new Customers("11","testFastJson001", "maks");  
        JSONObject jsonObj = (JSONObject) JSON.toJSON(user);  
        System.out.println("bean2Json()方法：jsonObj==" + jsonObj);  
        // 输出结果：jsonObj=={"age":105,"id":"testFastJson001","name":"maks"}  
    }  
  
    /** 
     * 全序列化 直接把java bean序列化为json文本之后，能够按照原来的类型反序列化回来。支持全序列化，需要打开SerializerFeature.WriteClassName特性 
     */  
    public void parseJSONAndBeanEachother()  
    {  
    	Customers user = new Customers("111","testFastJson001", "maks");  
        SerializerFeature[] featureArr = { SerializerFeature.WriteClassName };  
        String text = JSON.toJSONString(user, featureArr);  
        System.out.println("parseJSONAndBeanEachother()方法：text==" + text);  
        // 输出结果：text=={"@type":"fastJson.test.User","age":105,"id":"testFastJson001","name":"maks"}  
        Customers userObj = (Customers) JSON.parse(text);  
        System.out.println("parseJSONAndBeanEachother()方法：userObj==" + userObj.getCustomerId() + "," + userObj.getCustomerName() + "," + userObj.getIntroduction());  
        // 输出结果：userObj==testFastJson001,maks,105  
    }  
  
    public static void main(String[] args)  
    {  
        FastJsonTest test = new FastJsonTest();  
        // 序列化  
        test.toJsonString();  
        // 反序列化为json对象  
        test.parseJsonObject();  
        // 反序列化为javaBean对象  
        test.parseBeanObject();  
        // 将javaBean转化为json对象  
        test.bean2Json();  
        // 全序列化  
        test.parseJSONAndBeanEachother();  
    }  

}
