package com.hqxu.mode.FactoryModeMethod;

public class Test {

    public static void main(String[] args) {
        
        // 通过苹果工厂，再获取苹果
        FruitFactory appleFactory = new AppleFactory();
        appleFactory.getFruit().get(); // get apple
        
        // 通过香蕉工厂，然后再获取香蕉
        FruitFactory bananaFactory = new BananaFactory();
        bananaFactory.getFruit().get(); // get banana
        
    }
}
