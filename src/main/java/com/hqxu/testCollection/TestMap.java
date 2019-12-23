package com.hqxu.testCollection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

    public static void main(String[] args) {
        
        Map map1 = new HashMap();
        Map map2 = new TreeMap();
        Map map3 = new LinkedHashMap();
        Map map4 = new WeakHashMap();
        Map map5 = new Hashtable();
        Map map6 = new ConcurrentHashMap();

        for (int i = 0; i < 10; i++) {
         //产生一个随机数，并将其放入map中
         int value = (int) (Math.random() * 100);
         log("第 " + i + " 次产生的随机数为：" + value);
         if (!map1.containsKey(value)){
         map1.put(value, i);
         map2.put(value, i);
         map3.put(value, i);
         map4.put(value, i);
         map5.put(value, i);
         map6.put(value, i);
         }
        }

        log("产生的随机数为key，index为value");
        log("HashMap：" + map1);
        log("TreeMap：" + map2);
        log("LinkedHashMap：" + map3);
        log("WeakHashMap：" + map4);
        log("Hashtable：" + map5);
        log("ConcurrentHashMap：" + map5);
        
        /*
         * 
         * 
         * 第 0 次产生的随机数为：32
                    第 1 次产生的随机数为：18
                    第 2 次产生的随机数为：75
                    第 3 次产生的随机数为：1
                    第 4 次产生的随机数为：9
                    第 5 次产生的随机数为：22
                    第 6 次产生的随机数为：98
                    第 7 次产生的随机数为：8
                    第 8 次产生的随机数为：47
                    第 9 次产生的随机数为：8
                    产生的随机数为key，index为value
            HashMap：{32=0, 1=3, 18=1, 98=6, 22=5, 8=7, 9=4, 75=2, 47=8}
            TreeMap：{1=3, 8=7, 9=4, 18=1, 22=5, 32=0, 47=8, 75=2, 98=6}
            LinkedHashMap：{32=0, 18=1, 75=2, 1=3, 9=4, 22=5, 98=6, 8=7, 47=8}
            WeakHashMap：{75=2, 47=8, 9=4, 8=7, 22=5, 98=6, 18=1, 32=0, 1=3}
            Hashtable：{22=5, 18=1, 9=4, 32=0, 8=7, 75=2, 98=6, 47=8, 1=3}
            ConcurrentHashMap：{22=5, 18=1, 9=4, 32=0, 8=7, 75=2, 98=6, 47=8, 1=3}
         * 
         */
        
        
    }
    
    public static void log(Object o) {
        System.out.println(o.toString());
    }
    
}
