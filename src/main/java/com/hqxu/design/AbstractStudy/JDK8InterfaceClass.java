package com.hqxu.design.AbstractStudy;


/**
 * 1.jdk8之后,支持default方法，即：default static方法可以有方法体。
 * 2.default方法可以看作以实现的成员方法？
 *
 */
public interface JDK8InterfaceClass {

    default void defaultMethod() {
        System.out.println("This is a default method!");
        //可以在default方法中调用static方法
        JDK8InterfaceClass.staticMethod();
    }

    static void staticMethod() {
        System.out.println("This is a static method!");
    }
    
    public void method();
    
    
}
