package com.hqxu.jar.fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GjjMapToEntityTest {

    public static void main(String[] args) {
        
        
        
        
        GjjAccountInfo gjjAccountInfo = new GjjAccountInfo();
        List<GjjAccountInfoHead> head = new ArrayList<GjjAccountInfoHead>();
        List<GjjAccountInfoBody> body = new ArrayList<GjjAccountInfoBody>();
        
        GjjAccountInfoHead gjjAccountInfoHead = new GjjAccountInfoHead();
        GjjAccountInfoBody gjjAccountInfoBody = new GjjAccountInfoBody();
        List<GjjAccountInfoBodyDetail> gjjAccountInfoBodyDetails = new ArrayList<GjjAccountInfoBodyDetail>();
        
        
        GjjAccountInfoBodyDetail gjjAccountInfoBodyDetail1 = new GjjAccountInfoBodyDetail();
        gjjAccountInfoBodyDetail1.setSummary("summary123");
        GjjAccountInfoBodyDetail gjjAccountInfoBodyDetail2 = new GjjAccountInfoBodyDetail();
        gjjAccountInfoBodyDetail2.setSummary("summary456");
        
        gjjAccountInfoBodyDetails.add(gjjAccountInfoBodyDetail1);
        gjjAccountInfoBodyDetails.add(gjjAccountInfoBodyDetail2);
        
        gjjAccountInfoBody.setZjhm("12345679");
        gjjAccountInfoBody.setDetail(gjjAccountInfoBodyDetails);
        
        gjjAccountInfoHead.setTran_ID("45678798789979");
        
        head.add(gjjAccountInfoHead);
        body.add(gjjAccountInfoBody);
        
        gjjAccountInfo.setBody(body);
        gjjAccountInfo.setHead(head);
        
        
        System.out.println(gjjAccountInfo);
        
        JSON jsons = (JSON)JSON.toJSON(gjjAccountInfo);
        Map paramMap = (Map)JSONObject.parseObject(jsons.toString());
        
        System.out.println(paramMap);
        
        
    }
}
