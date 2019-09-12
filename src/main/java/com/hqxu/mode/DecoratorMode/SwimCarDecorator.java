package com.hqxu.mode.DecoratorMode;

public class SwimCarDecorator extends CarDecorator{

    // 子类显式调用父类的构造函数
    public SwimCarDecorator(Car car) {
        super(car);
    }
    
    
    // 新增的功能
    public void swim() {
        System.out.println("can swim");
    }
    
    // 实现接口的方法
    public void show() {
        this.getCar().show();
        this.swim();
    }


    @Override
    public void run() {
        
    }
    
    
}
