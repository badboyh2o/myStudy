package com.hqxu.mode.FactoryModeSimple;

public class Test {

    public static void main(String[] args) {
        
        // 通过工厂获取苹果
        FruitFactory.getApple().get(); //get apple
        
        // 通过工厂获取香蕉
        FruitFactory.getBanana().get(); //get banana
    }
}
