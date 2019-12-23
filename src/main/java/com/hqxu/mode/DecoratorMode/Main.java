package com.hqxu.mode.DecoratorMode;

public class Main {

    
    public static void main(String[] args) {

        // 创建一个可以跑的车
        Car car = new RunCar();
        // 通过装饰器装饰 可以跑
        Car flyCar = new FlyCarDecorator(car);
        // 通过装饰器装饰 可以游
        Car flySwimCar = new SwimCarDecorator(flyCar);
        
        // RunCar 增加了可以飞、可以游 的功能
        flySwimCar.show(); // can run,  can fly, can swim
        
    }
    
    
}
