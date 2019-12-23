package com.hqxu.mode.DecoratorMode;

/**
 * 装饰器抽象类
 *
 */
public abstract class CarDecorator implements Car{

    private Car car;
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    // 构造方法
    public CarDecorator(Car car) {
        super();
        this.car = car;
    }
    
    
    // 抽象方法
    //public abstract void show();
    
}
