package com.hqxu.Class.object;

public class TestFinal
{
    // 必须初始化
    public final int x;
    
    // 方式1：所有构造方法都需要初始化
    // 方式1：声明的时赋值
    public TestFinal() {
        x=1;
    }
    
    public TestFinal(int a) {
        x = a;
    }
    
    public static void main(String []args) {
        
        System.out.println(new TestFinal(3).x);
        
    }
}