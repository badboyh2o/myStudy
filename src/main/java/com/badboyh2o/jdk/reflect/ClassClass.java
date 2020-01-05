package com.badboyh2o.jdk.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClassClass {

    public static void main(String[] args) {
        int[] a = {1,2,4,5,6};
        System.out.println(Arrays.toString((int[])copyArray(a, 10)));
    }
    
    
    // reflect Array
    public static Object copyArray(Object array, int newLength){
        Class<?> cl = array.getClass();
        if (!cl .isArray()) return null ;
        Class<?> componentType = cl.getComponentType();
        
        int length = Array.getLength(array) ;
        Object newArray = Array.newInstance(componentType, newLength); //反射生成数组对象
        
        System.arraycopy(array, 0, newArray, 0, Math.min(length, newLength)) ; // 复制数组
        
        return newArray;
    }
    
}
