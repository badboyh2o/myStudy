package com.hqxu.json.fastjson;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * 1.需要有getter/setter才能输出
 * 2.toJsonString , 输出属性名首字母默认小写, @JSONField(name="Name")作用属性可输出属性首字母大写
 * 3.toJsonString默认不输出null值属性, 基本类型都会输出
 *
 */
public class FastJsonUtil {

    /** obj String ********************************************************************************/ 
    
    /**
     * obj to jsonString
     * @param obj
     * @return
     */
    public static String obj2JsonString(Object obj){
        return JSON.toJSONString(obj);
    }
    
    /**
     * jsonString to obj
     * 普通对象
     * 
     * @param jsonString
     * @param clazz
     * @return
     */
    public static <T> T jsonString2Obj(String jsonString, Class<T> clazz){
        return JSON.parseObject(jsonString, clazz);
    }
    
    
    /**
     * jsonString to obj
     * 泛型对象
     * 
     *  String json = "[{},...]";
     *  Type listType = new TypeReference<List<Model>>() {}.getType();
     *  List<Model> modelList = JSON.parseObject(json, listType);
     *  
     * @param jsonString
     * @param type
     * @return
     */
    public static <T> T jsonString2Obj(String jsonString,Type type){
        return JSON.parseObject(jsonString, type);
    }
    
    
    
    
    /** obj Array ********************************************************************************/ 
    
    public static <T> List<T> jsonString2Array(String jsonString,Class<T> clazz){
        return JSON.parseArray(jsonString, clazz);
    }
    
    
    
    
    /** obj Map ********************************************************************************/ 
    
    /**
     * obj to map
     * @param obj
     * @return
     */
    public static Map obj2Map(Object obj) {
        Map map = JSONObject.parseObject(JSON.toJSONString(obj));
        return map;
    }
    
    
}
