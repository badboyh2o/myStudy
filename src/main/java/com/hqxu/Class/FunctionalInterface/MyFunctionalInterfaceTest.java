package com.hqxu.Class.FunctionalInterface;

import java.util.Arrays;
import java.util.List;

public class MyFunctionalInterfaceTest{

    
    
    public static void main(String[] args) {
        
        // 测试自定义函数式接口
        MyFunctionalInterface impl1 = (Object a) -> true;
        System.out.println(impl1.test(new Object()));   // true
        
        // 测试 consumer
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(i -> System.out.println(i));
        
    }

}
