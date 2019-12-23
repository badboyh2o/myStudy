package com.hqxu.mode.ObserveMode;

import java.util.Observable;

public class Person extends Observable {

    
    private String name;
    private int age;
    private String sex;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.setChanged();
        // 通知观察者
        this.notifyObservers();
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        this.setChanged();
        // 通知观察者
        this.notifyObservers();
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
        this.setChanged();
        // 通知观察者
        this.notifyObservers();
    }
}
