package com.hqxu.mode.FactoryModeSimple;


/**
 * 简单工厂模式，提供返回不同具体类型实例的方法
 *
 */
public class FruitFactory {

    /**
     * 工厂返回Apple实例
     */
    public static Fruit getApple() {
        return new Apple();
    }
    
    
    /**
     * 工厂返回Banana实例
     */
    public static Fruit getBanana() {
        return new Banana();
    }
    
}
