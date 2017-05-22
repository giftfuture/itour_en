package com.itour.base.cache;

import org.springframework.stereotype.Service;

@Service("cacheService")
public interface CacheService {
	 /**
     * 根据key删除
     * 
     * @param key
     */
    void remove(KEY key);
 
    /**
     * 存入对象
     * 
     * @param key
     * @param value
     */
    void put(KEY key, Object value);
 
    /**
     * 根据key和过期时间获取此前存入的对象
     * 
     * @param key
     * @param time
     * @return
     */
    Object get(KEY key, TIME time);
 
    /**
     * 缓存中已经存在的key
     * 
     */
    enum KEY {
 
        /**
         * 首页链接缓存
         */
    	allAdLink("_adLink_list");
        private String value;
 
        private KEY(String value) {
            this.value = value;
        }
 
        public String getValue() {
            return value;
        }
    }
	/* enum key{
		allAreas("_all_areas");
	 }*/
    /**
     * 
     * 缓存的时长
     */
    enum TIME {
 
        /**
         * 5分钟
         */
        fiveMinute(300),
        /**
         * 10分钟
         */
        tenMinute(600),
        /**
         * 15分钟
         */
        quarterHour(900),
        /**
         * 半小时
         */
        halfHour(1800),
        /**
         * 1小时
         */
        hour(3600),
        /**
         * 2小时
         */
        twoHour(7200),
        /**
         * 3小时
         */
        threeHour(10800),
        /**
         * 12小时
         */
        halfDay(43200),
        /**
         * 24小时
         */
        day(86400);
        private int value;
 
        private TIME(int value) {
            this.value = value;
        }
 
        public int getValue() {
            return value;
        }
    }
}
