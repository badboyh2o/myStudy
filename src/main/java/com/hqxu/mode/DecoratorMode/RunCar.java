package com.hqxu.mode.DecoratorMode;

public class RunCar implements Car{

    @Override
    public void show() {
        this.run();
    }

    @Override
    public void run() {
        System.out.println("can run");
    }
    
}
