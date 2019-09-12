package com.hqxu.mode.FactoryModeAbstrac;

public class Test {

    public static void main(String[] args) {
        
        // 获取具体工厂，再获取水果
        FruitFactory northFruitFactory = new NorthFruitFactory();
        northFruitFactory.getApple().get(); // get north apple
        northFruitFactory.getBanana().get(); // get north banana
        
        // 获取具体工厂，再获取水果
        FruitFactory southFruitFactory = new SouthFruitFactory();
        southFruitFactory.getApple().get(); // get south apple
        southFruitFactory.getBanana().get(); // get south banana
    }
}