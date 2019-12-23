package com.hqxu.design.AbstractStudy;


/**
 * 1.如果一个类继承了一个接口，但是不想实现接口的方法，可以把这个类定义为抽象类
 *
 */
public abstract class AbstractClass implements InterfaceClass{

    // 不实现接口的方法
    public abstract void f();
    
    // 重写的方法返回类型必须是 原类型 或 原类型的派生类
    @Override
    public Number h() {
        return 1;
    }
    
    {
        System.out.println("抽象类的 构造代码块");
    }
    
    
    // 静态方法
    public static void a() {
        System.out.println("base()");
    }
    

    
}
