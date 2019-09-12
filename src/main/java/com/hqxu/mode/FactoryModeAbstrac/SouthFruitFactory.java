package com.hqxu.mode.FactoryModeAbstrac;

public class SouthFruitFactory implements FruitFactory{

    @Override
    public Fruit getApple() {
        return new SouthApple();
    }

    @Override
    public Fruit getBanana() {
        return new SouthBanana();
    }

}
