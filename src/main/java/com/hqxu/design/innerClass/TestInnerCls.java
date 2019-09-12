package com.hqxu.design.innerClass;

import com.hqxu.design.innerClass.OuterClass.PublicStaticInnerClass;

public class TestInnerCls {

    
    public static void main(String[] args) {
        
        // 不在类中，测试实例化 内部类
        privateInnerClassStatic();
        defaultInnerClassStatic();
        protectedInnerClassStatic();
        publicInnerClassStatic();
        
        
    }
    
    
    public static void privateInnerClassStatic() {
        System.out.println("1.其他类中不能实例化 私有 内部类");
        //OuterClass.PrivateStaticInnerCls outer = new OuterClass.PrivateStaticInnerCls();
    }
    
    public static void defaultInnerClassStatic() {
        System.out.println("1.同一个包中的其他类中可以实例化 默认修饰 内部类");
        OuterClass.DefaultStaticInnerCls outer = new OuterClass.DefaultStaticInnerCls();
    }
    
    public static void protectedInnerClassStatic() {
        System.out.println("1.同一个包中的其他类中可以实例化 protected 内部类");
        OuterClass.ProtectedStaticInnerCls outer = new OuterClass.ProtectedStaticInnerCls();
    }
    public static void publicInnerClassStatic() {
        System.out.println("1.同一个包中的其他类中可以实例化 protected 内部类");
        OuterClass.PublicStaticInnerClass outer = new OuterClass.PublicStaticInnerClass();
        
        // 访问外部类的 普通成员
        outer.publicF();
    }
    
    
}
