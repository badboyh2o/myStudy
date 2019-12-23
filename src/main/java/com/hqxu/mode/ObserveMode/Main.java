package com.hqxu.mode.ObserveMode;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        // 注册观察者
        p.addObserver(new MyObserve());
        
        // 被观察者发生改变
        p.setName("hale"); // 对象发生变化
    }
}
