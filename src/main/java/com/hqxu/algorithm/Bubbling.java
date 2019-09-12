package com.hqxu.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 * 升序
 *
 */
public class Bubbling {

    
    public static void main(String[] args) {
        
        int [] intArray = {1,6,2,45,48,0,-4,9,6};
        
        // 升序
        ascF(intArray);
        // 输出排序后的数组
        System.out.println(Arrays.toString(intArray));
        
        // 降序
        descF(intArray);
        // 输出排序后的数组
        System.out.println(Arrays.toString(intArray));
        
    }
    
    
    /**
     * 升序
     */
    public static void ascF(int[] intArray) {
        int temp = intArray[0];
        // 需要排序 intArray.length - 1 次
        for(int a = 0; a < intArray.length - 1; a++) {
            
            // 每次排序需要做的两两对比次数
            for(int b = 0; b < intArray.length - 1 - a; b++) {
                if(intArray[b] > intArray[b+1]) {
                    temp = intArray[b];
                    intArray[b] = intArray[b+1];
                    intArray[b+1] = temp;
                }
            }
        }
    }
    
    

    /**
     * 降序
     */
    public static void descF(int[] intArray) {
        int temp = intArray[0];
        // 需要排序 intArray.length - 1 次
        for(int a = 0; a < intArray.length - 1; a++) {
            
            // 每次排序需要做的两两对比次数
            for(int b = 0; b < intArray.length - 1 - a; b++) {
                if(intArray[b] < intArray[b+1]) {
                    temp = intArray[b];
                    intArray[b] = intArray[b+1];
                    intArray[b+1] = temp;
                }
            }
        }
    }
    
    
    
    
}
