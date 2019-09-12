package com.hqxu.testCollection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

    public static void main(String[] args) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> set3 = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
         //产生一个随机数，并将其放入Set中
         int value = (int) (Math.random() * 100);
         log("第 " + i + " 次产生的随机数为：" + value);
         set1.add(value);
         set2.add(value);
         set3.add(value);
        }

        log("HashSet：" + set1);
        log("LinkedHashSet：" + set2);
        log("TreeSet ：" + set3);
        
        /*
         * Set 无序
         * 第 0 次产生的随机数为：51
                    第 1 次产生的随机数为：86
                    第 2 次产生的随机数为：24
                    第 3 次产生的随机数为：66
                    第 4 次产生的随机数为：76
                    第 5 次产生的随机数为：59
                    第 6 次产生的随机数为：13
                    第 7 次产生的随机数为：34
                    第 8 次产生的随机数为：89
                    第 9 次产生的随机数为：21
            HashSet：[66, 34, 51, 21, 86, 24, 89, 59, 76, 13]
            LinkedHashSet：[51, 86, 24, 66, 76, 59, 13, 34, 89, 21]
            TreeSet ：[13, 21, 24, 34, 51, 59, 66, 76, 86, 89]
         * 
         * 
         * 
         */
        
    }
    
    public static void log(Object o) {
        System.out.println(o.toString());
    }
    
}
