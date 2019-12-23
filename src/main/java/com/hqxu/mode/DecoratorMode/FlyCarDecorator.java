package com.hqxu.mode.DecoratorMode;


/**
 * 可以飞 的装饰器
 *
 */
public class FlyCarDecorator extends CarDecorator{

    // 子类显式调用父类的构造函数
    public FlyCarDecorator(Car car) {
        super(car);
    }
    
    
    // 新增的功能
    public void fly() {
        System.out.println("can fly");
    }
    
    // 实现接口的方法
    public void show() {
        this.getCar().show();
        this.fly();
    }


    @Override
    public void run() {
        
    }

}
