package com.itour.base.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
*
* Create Time : 2017-3-22-下午07:04:30
* Description : 处理汉字和对应拼音转换的工具类
* 	History：
*   Editor    
*   version 
*   Time      
*   Operation   
*   Description*
*  
*
*/
public class PinYinUtil {
	
	private static PinYinUtil instance;  
	  
    public static PinYinUtil getInstance() {  
        if (instance == null) {  
            instance = new PinYinUtil();  
        }  
        return instance;  
    }  
  
    private HanyuPinyinOutputFormat outputFormat = null;  
    HanyuPinyinOutputFormat format = null;  
    public static enum Type {  
        UPPERCASE,              //全部大写  
        LOWERCASE,              //全部小写  
        FIRSTUPPER              //首字母大写  
    }  
  
    public PinYinUtil(){  
        format = new HanyuPinyinOutputFormat();  
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);  
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
    }  
    
    public String toPinYin(String str) throws BadHanyuPinyinOutputFormatCombination{  
        return toPinYin(str, "", Type.UPPERCASE);  
    }  
  
    public String toPinYin(String str,String spera) throws BadHanyuPinyinOutputFormatCombination{  
        return toPinYin(str, spera, Type.UPPERCASE);  
    }  
  
    /** 
     * 将str转换成拼音，如果不是汉字或者没有对应的拼音，则不作转换 
     * 如： 明天 转换成 MINGTIAN 
     * @param str 
     * @param spera 
     * @return 
     * @throws BadHanyuPinyinOutputFormatCombination 
     */  
    public String toPinYin(String str, String spera, Type type) throws BadHanyuPinyinOutputFormatCombination {  
        if(str == null || str.trim().length()==0)  
            return "";  
        if(type == Type.UPPERCASE)  
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);  
        else  
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
  
        String py = "";  
        String temp = "";  
        String[] t;  
        for(int i=0;i<str.length();i++){  
            char c = str.charAt(i);  
            if((int)c <= 128)  
                py += c;  
            else{  
                t = PinyinHelper.toHanyuPinyinStringArray(c, format);  
                if(t == null)  
                    py += c;  
                else{  
                    temp = t[0];  
                    if(type == Type.FIRSTUPPER)  
                        temp = t[0].toUpperCase().charAt(0)+temp.substring(1);  
                    py += temp+(i==str.length()-1?"":spera);  
                }  
            }  
        }  
        return py.trim();  
    }  
    private HanyuPinyinOutputFormat getOutputFormat() {  
        if (outputFormat == null) {  
            outputFormat = new HanyuPinyinOutputFormat();  
            outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
            outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        }  
        return outputFormat;  
    }  
  
    /** 
     * 获取字符串中所有字符首字母 
     *  
     * @param str 
     * @return 
     * @throws Exception 
     */  
    public String getStringInitial(String str) {  
        StringBuffer sbf = new StringBuffer();  
        if (str != null) {  
            for (int i = 0; i < str.length(); i++) {  
                sbf.append(getCharInitial(str.charAt(i)));  
            }  
        }  
        return sbf.toString();  
    }  
  
    /** 
     * 获取中文字符首字母 
     *  
     * @param c 
     * @return 
     * @throws Exception 
     */  
    public String getCharInitial(char c) {  
        try {  
            String[] strs = PinyinHelper.toHanyuPinyinStringArray(c,  
                    getOutputFormat());  
            String initial = "";  
            if (strs != null && strs.length > 0) {  
                String str = strs[0];  
                if (str != null && str.length() > 0) {  
                    initial += str.charAt(0);  
                }  
            }  
            return initial;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return c + "";  
        }  
    }  
  
    public String getStringPinyin(String chines) {  
  
        char[] nameChar = chines.toCharArray();  
        String pinyinStr = "";  
        for (int i = 0; i < nameChar.length; i++) {  
            try {  
                char cha=nameChar[i];  
                if (nameChar[i] > 128) {  
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(cha, getOutputFormat())[0];  
                }  
            } catch (Exception ex) {  
                ex.printStackTrace();  
                pinyinStr += nameChar[i];  
            }  
        }  
        return pinyinStr;  
    }  
  
    /** 
     * 获取字符全拼 
     *  
     * @param c 
     * @return 
     */  
    public String getCharPinyin(char c) {  
  
        try {  
            String[] strs = PinyinHelper.toHanyuPinyinStringArray(c,  
                    getOutputFormat());  
            String str = "";  
            if (strs != null && strs.length > 0) {  
                str = strs[0];  
            }  
            return str;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return c + "";  
        }  
    }  
	  /**
    *
    * @param src
    * @return
    * author  : Robert
    * about version ：1.00
    * create time   : 2017-3-22-下午07:04:27
    * Description ：
    *             传入汉字字符串，拼接成对应的拼音,返回拼音的集合
    */
   public static Set<String> getPinYinSet(String src){
           Set<String> lstResult = new HashSet<String>();
           char[] t1 = null;  //字符串转换成char数组
           t1 = src.toCharArray();
          
           //①迭代汉字
           for(char ch : t1){  
                   String s[] = getPinYin(ch);  
                   Set<String> lstNew = new HashSet<String>();
                   //②迭代每个汉字的拼音数组
                   for(String str : s){
                           if(lstResult.size()==0){
                                   lstNew.add(str);
                           }else{
                                   for(String ss : lstResult){
                                           ss += str;
                                           lstNew.add(ss);
                                   }
                           }
                   }
                   lstResult.clear();
                   lstResult = lstNew;
           }

           return lstResult;
   }

   /**
    *
    * @param src
    * @return
    * author  : Robert
    * about version ：1.00
    * create time   : 2017-3-22-下午02:21:42
    * Description ：
    *             传入中文汉字，转换出对应拼音
    *             注：出现同音字，默认选择汉字全拼的第一种读音
    */
   public static String getPinYin(String src) {
           char[] t1 = null;
           t1 = src.toCharArray();
           String[] t2 = new String[t1.length];

           // 设置汉字拼音输出的格式
           HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
           t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
           t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
           t3.setVCharType(HanyuPinyinVCharType.WITH_V);
           String t4 = "";
           int t0 = t1.length;
           try {
                   for (int i = 0; i < t0; i++) {
                           // 判断能否为汉字字符
                           // System.out.println(t1[i]);
                           if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                                   t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中
                                   t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
                           } else {
                                   // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                                   t4 += Character.toString(t1[i]);
                           }
                   }
           } catch (BadHanyuPinyinOutputFormatCombination e) {
                   e.printStackTrace();
           }
           return t4;
   }
  
   /**
    * @param src
    * @return
    * author  : Robert
    * about version ：1.00
    * create time   : 2017-3-22-下午02:52:35
    * Description ：
    *             将单个汉字转换成汉语拼音，考虑到同音字问题，返回字符串数组的形式
    */
   public static String[] getPinYin(char src){
           char[] t1 = {src};
           String[] t2 = new String[t1.length];
          
           // 设置汉字拼音输出的格式
           HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
           t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
           t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
           t3.setVCharType(HanyuPinyinVCharType.WITH_V);
          
           // 判断能否为汉字字符
           if (Character.toString(t1[0]).matches("[\\u4E00-\\u9FA5]+")) {
                   try {
                           // 将汉字的几种全拼都存到t2数组中
                           t2 = PinyinHelper.toHanyuPinyinStringArray(t1[0], t3);
                   } catch (BadHanyuPinyinOutputFormatCombination e) {
                           e.printStackTrace();
                   }
           } else {
                   // 如果不是汉字字符，则把字符直接放入t2数组中
                   t2[0] = String.valueOf(src);
           }
           return t2;
   }
  
   /**
    *
    * @param src
    * @return
    * author  : Robert
    * about version ：1.00
    * create time   : 2017-3-22-下午03:03:02
    * Description ：
    *             传入没有多音字的中文汉字，转换出对应拼音
    *             注：如果传入的中文中有任一同音字都会返回字符串信息：false
    */
   public static String getNoPolyphone(String src){
           char[] t1 = null;
           t1 = src.toCharArray();
           String[] t2 = new String[t1.length];

           // 设置汉字拼音输出的格式
           HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
           t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
           t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
           t3.setVCharType(HanyuPinyinVCharType.WITH_V);
           String t4 = "";
           int t0 = t1.length;
           try {
                   for (int i = 0; i < t0; i++) {
                           // 判断能否为汉字字符
                           // System.out.println(t1[i]);
                           if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                                   t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中
                                   if(t2.length>1){
                                           return "false";
                                   }else{
                                           t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
                                   }
                           } else {
                                   // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                                   t4 += Character.toString(t1[i]);
                           }
                   }
           } catch (BadHanyuPinyinOutputFormatCombination e) {
                   e.printStackTrace();
           }
           return t4;
   }
   /** 
    * 汉字转换位汉语拼音首字母，英文字符不变，特殊字符丢失 支持多音字，生成方式如（长沙市长:cssc,zssz,zssc,cssz） 
    *  
    * @param chines 
    *            汉字 
    * @return 拼音 
    */  
   public static String converterToFirstSpell(String chines) {  
       StringBuffer pinyinName = new StringBuffer();  
       char[] nameChar = chines.toCharArray();  
       HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
       defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
       defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
       for (int i = 0; i < nameChar.length; i++) {  
           if (nameChar[i] > 128) {  
               try {  
                   // 取得当前汉字的所有全拼  
                   String[] strs = PinyinHelper.toHanyuPinyinStringArray(  
                           nameChar[i], defaultFormat);  
                   if (strs != null) {  
                       for (int j = 0; j < strs.length; j++) {  
                           // 取首字母  
                           pinyinName.append(strs[j].charAt(0));  
                           if (j != strs.length - 1) {  
                               pinyinName.append(",");  
                           }  
                       }  
                   }  
                   // else {  
                   // pinyinName.append(nameChar[i]);  
                   // }  
               } catch (BadHanyuPinyinOutputFormatCombination e) {  
                   e.printStackTrace();  
               }  
           } else {  
               pinyinName.append(nameChar[i]);  
           }  
           pinyinName.append(" ");  
       }  
       // return pinyinName.toString();  
       return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));  
   }  
 
   /** 
    * 汉字转换位汉语全拼，英文字符不变，特殊字符丢失 
    * 支持多音字，生成方式如（重当参:zhongdangcen,zhongdangcan,chongdangcen 
    * ,chongdangshen,zhongdangshen,chongdangcan） 
    *  
    * @param chines 
    *            汉字 
    * @return 拼音 
    */  
   public static String converterToSpell(String chines) {  
       StringBuffer pinyinName = new StringBuffer();  
       char[] nameChar = chines.toCharArray();  
       HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
       defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
       defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
       for (int i = 0; i < nameChar.length; i++) {  
           if (nameChar[i] > 128) {  
               try {  
                   // 取得当前汉字的所有全拼  
                   String[] strs = PinyinHelper.toHanyuPinyinStringArray(  
                           nameChar[i], defaultFormat);  
                   if (strs != null) {  
                       for (int j = 0; j < strs.length; j++) {  
                           pinyinName.append(strs[j]);  
                           if (j != strs.length - 1) {  
                               pinyinName.append(",");  
                           }  
                       }  
                   }  
               } catch (BadHanyuPinyinOutputFormatCombination e) {  
                   e.printStackTrace();  
               }  
           } else {  
               pinyinName.append(nameChar[i]);  
           }  
           pinyinName.append(" ");  
       }  
       // return pinyinName.toString();  
       return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));  
   }  
 
   /** 
    * 去除多音字重复数据 
    *  
    * @param theStr 
    * @return 
    */  
   private static List<Map<String, Integer>> discountTheChinese(String theStr) {  
       // 去除重复拼音后的拼音列表  
       List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();  
       // 用于处理每个字的多音字，去掉重复  
       Map<String, Integer> onlyOne = null;  
       String[] firsts = theStr.split(" ");  
       // 读出每个汉字的拼音  
       for (String str : firsts) {  
           onlyOne = new Hashtable<String, Integer>();  
           String[] china = str.split(",");  
           // 多音字处理  
           for (String s : china) {  
               Integer count = onlyOne.get(s);  
               if (count == null) {  
                   onlyOne.put(s, new Integer(1));  
               } else {  
                   onlyOne.remove(s);  
                   count++;  
                   onlyOne.put(s, count);  
               }  
           }  
           mapList.add(onlyOne);  
       }  
       return mapList;  
   }  
 
   /** 
    * 解析并组合拼音，对象合并方案(推荐使用) 
    *  
    * @return 
    */  
   private static String parseTheChineseByObject(List<Map<String, Integer>> list) {  
       Map<String, Integer> first = null; // 用于统计每一次,集合组合数据  
       // 遍历每一组集合  
       for (int i = 0; i < list.size(); i++) {  
           // 每一组集合与上一次组合的Map  
           Map<String, Integer> temp = new Hashtable<String, Integer>();  
           // 第一次循环，first为空  
           if (first != null) {  
               // 取出上次组合与此次集合的字符，并保存  
               for (String s : first.keySet()) {  
                   for (String s1 : list.get(i).keySet()) {  
                       String str = s + s1;  
                       temp.put(str, 1);  
                   }  
               }  
               // 清理上一次组合数据  
               if (temp != null && temp.size() > 0) {  
                   first.clear();  
               }  
           } else {  
               for (String s : list.get(i).keySet()) {  
                   String str = s;  
                   temp.put(str, 1);  
               }  
           }  
           // 保存组合数据以便下次循环使用  
           if (temp != null && temp.size() > 0) {  
               first = temp;  
           }  
       }  
       String returnStr = "";  
       if (first != null) {  
           // 遍历取出组合字符串  
           for (String str : first.keySet()) {  
               returnStr += (str + ",");  
           }  
       }  
       if (returnStr.length() > 0) {  
           returnStr = returnStr.substring(0, returnStr.length() - 1);  
       }  
       return returnStr;  
   }  
   public static void main(String[] args) {
           Set<String> lst = PinYinUtil.getPinYinSet("迭代每个汉字的拼音数组");
           for (String string : lst) {
               System.out.println(string);
           }
           String stringInitial = PinYinUtil.getInstance().getStringInitial("玥是个生僻字一般的拼音码解析不了");  
           System.out.println(stringInitial);  
           String stringPinyin = PinYinUtil.getInstance().getStringPinyin("玥是个生僻字一般的拼音码解析不了");  
           System.out.println(stringPinyin);  
   }
  
  
}