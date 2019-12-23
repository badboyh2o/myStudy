package com.hqxu.design.AbstractStudy;

public class SubClass extends AbstractClass{

    /**
     * 1.抽象类的子类如果不是抽象类，则必须实现所有抽线方法
     */
    @Override
    public void f() {
        System.out.println("抽象类的子类如果不是抽象类，则必须实现所有抽线方法");
    }

    
    /**
     * 重写的方法的返回类型必须是 原方法返回类型 或 原方法返回类型的子类
     */
    @Override
    public Integer h() {
        return 0;
    }
    
    public static void a() {
        System.out.println("sub()");
    }

    
    public static void main(String[] args) {
        
        new SubClass();
    }
    
}
