package com.hqxu.work.temp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapToDB {

    public static void main(String[] args) {
        
        Map map = new HashMap();
        map.put("a", 3.2);
        map.put("b", 3);
        map.put("c", "hello");
        
        
        
        Object[] data = new Object[map.size()];
        int index = 0;
        StringBuffer sql1 = new StringBuffer();
        StringBuffer sql2 = new StringBuffer();
        
        StringBuffer sql3 = new StringBuffer();
        
        Set<Map.Entry<String, String>> es = map.entrySet();
        for(Map.Entry<String, String> entry : es){
            data[index] = entry.getValue();
            index ++;
            sql1.append(entry.getKey() + ",");
            sql2.append("?,");
            
            sql3.append(entry.getKey() + " varchar2(30),\n");
        }
        
        String sql1Str = sql1.toString();
        String sql2Str = sql2.toString();
        String sql = "insert into table-xxx (" + sql1Str.substring(0, sql1Str.length() - 1)  + ") values (" + sql2Str.substring(0, sql2Str.length() - 1) + ")";
        
        System.out.println(sql); // insert into table-xxx (a,b,c) values (?,?,?)
        System.out.println(sql3.toString()); //
    }
    
}
