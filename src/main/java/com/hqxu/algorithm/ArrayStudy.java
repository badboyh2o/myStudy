package com.hqxu.algorithm;

public class ArrayStudy {

    public static void main(String[] args) {
        maxIndex();
        
    }
    
    
    /**
     * 数组中的最大元素及其下标
     */
    public static void maxIndex() {
        
        int [] intArray = {1,54,2,-4,100,3,110,5};
        
        // 假设最大元素的索引为 0
        int maxIndex = 0;
        int max = intArray[0];
        
        // 从第1个元素开始比较
        for(int i = 1; i < intArray.length; i++) {
            // 如果当前元素是大的值
            if(max < intArray[i]) {
                // 重新设置最大值
                max = intArray[i];
                maxIndex = i;
            }
        }
        System.out.println("maxIndex: " + maxIndex + "; max: " + max ); //maxIndex: 6; max: 110
    }
    
    
    
}
