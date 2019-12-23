package com.hqxu.mode.FactoryModeMethod;

public class AppleFactory implements FruitFactory{

    @Override
    public Fruit getFruit() {
        return new Apple();
    }

}
