package com.hqxu.json.fastjson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hqxu.json.fastjson.entity.GjjAccountInfoBody;
import com.hqxu.json.fastjson.entity.GjjAccountInfoBodyDetail;
import com.hqxu.json.fastjson.entity.GjjAccountInfoHead;

public class Test {

    public static void main(String[] args) {
        
        testJsonStringToObjec();
        
        testObjToMap();
        
    }

    
    
    public static void testJsonStringToObjec() {
        GjjAccountInfoBody gjjaccinfoboy = new GjjAccountInfoBody();
        
        GjjAccountInfoBodyDetail d1 = new GjjAccountInfoBodyDetail();
        GjjAccountInfoBodyDetail d2 = new GjjAccountInfoBodyDetail();
        d1.setSummary("1");
        d2.setSummary("2");
        List<GjjAccountInfoBodyDetail> list = new ArrayList<GjjAccountInfoBodyDetail>();
        list.add(d1);
        list.add(d2);
        
        gjjaccinfoboy.setDetail(list);
        
        
        
        System.out.println(JSON.toJSONString(gjjaccinfoboy.getDetail()));
        
        
        
        String json = JSON.toJSONString(gjjaccinfoboy.getDetail());
        Type listType = new TypeReference<List<GjjAccountInfoBodyDetail>>() {}.getType();
        List<GjjAccountInfoBodyDetail> modelList = JSON.parseObject(json, listType);
        
        System.out.println(modelList);
    }
    
    public static void testObjToMap() {
        GjjAccountInfoHead head = new GjjAccountInfoHead();
        head.setTran_ID("123");
        
        System.out.println(FastJsonUtil.obj2Map(head));
        
    }
    
}
