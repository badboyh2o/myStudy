package com.hqxu.jar.fastjson;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {
        
        
        /**
         * Map 转 实体类
         */
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", 25);
        map.put("isMarried", Boolean.FALSE);
        map.put("money", 2555555.3);
        map.put("height", 5666.2);
        map.put("birth", new Date());
        
        System.out.println(map);
        
        //Student student = (Student)JSONObject.toJavaObject((JSON)JSONObject.toJSON(map), Student.class);
        Student student = JSON.parseObject(JSONObject.toJSONString(map), Student.class);
        System.out.println(student);
        
        
        
        
        /**
         * 
         */
        String str = "你好吗";
        try {
            System.out.println(new String(str.getBytes("GBK"), "GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
}
