package com.hqxu.Class.FunctionalInterface;

/**
 * 如果一个类同时实现接口A和B，接口A和B中有相同的default方法，这时，该类必须重写接口中的default方法
 *
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface<Object>, MyFunctionalInterface1{

    @Override
    public boolean test(Object o) {
        return false;
    }
    
    
    // 必须重写 default 方法
    @Override
    public void f1() {
        MyFunctionalInterface.super.f1(); // MyFunctionalInterface.super
        System.out.println("MyFunctionalInterfaceImpl");
    }

    
    
    // 测试子类
    public static void main(String[] args) {
        
        MyFunctionalInterfaceImpl o = new MyFunctionalInterfaceImplSub();
        o.f1();
        
        
    }
    
    
}


/**
 * 函数式接口实现类的子类
 * 继承父类的方法而不是继承父类实现接口中的方法
 *
 */
class MyFunctionalInterfaceImplSub extends MyFunctionalInterfaceImpl {
    
    
}