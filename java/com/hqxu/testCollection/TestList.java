package com.hqxu.testCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestList {

    
    public static void main(String[] args) {
        
        
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new Vector<>();

        for (int i = 0; i < 10; i++) {
            
         //产生一个随机数，并将其放入List中
         int value = (int) (Math.random() * 100);
         log("第 " + i + " 次产生的随机数为：" + value);
         list1.add(value);
         list2.add(value);
         list3.add(value);
        }

        log("ArrayList：" + list1);
        log("LinkedList：" + list2);
        log("Vector：" + list3);
        
        
        //输出
        /*
         * List 有序
                    第 0 次产生的随机数为：23
                    第 1 次产生的随机数为：79
                    第 2 次产生的随机数为：87
                    第 3 次产生的随机数为：1
                    第 4 次产生的随机数为：62
                    第 5 次产生的随机数为：28
                    第 6 次产生的随机数为：2
                    第 7 次产生的随机数为：56
                    第 8 次产生的随机数为：60
                    第 9 次产生的随机数为：90
            ArrayList：[23, 79, 87, 1, 62, 28, 2, 56, 60, 90]
            LinkedList：[23, 79, 87, 1, 62, 28, 2, 56, 60, 90]
            Vector：[23, 79, 87, 1, 62, 28, 2, 56, 60, 90]
         */
        
    }
    
    public static void log(Object o) {
        System.out.println(o.toString());
    }
    
}
