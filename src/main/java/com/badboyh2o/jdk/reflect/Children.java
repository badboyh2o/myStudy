package com.badboyh2o.jdk.reflect;

import java.util.Arrays;

public class Children extends Parent {

    private String addr;
    public int height;
    double money;
    
    private void test1() {}
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(Children.class.getDeclaredFields()));
        System.out.println(Arrays.toString(Children.class.getDeclaredMethods()));
        System.out.println(Arrays.toString(Children.class.getDeclaredConstructors()));
    }
    
    
}
