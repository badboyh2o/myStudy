package com.hqxu.mode.PrototypeMode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    
    public static void main(String[] args) {
        
        Person  person1 = new Person();
        person1.setAge(20);
        person1.setName("hqxu");
        person1.setSex("男");
        person1.setFriends(new ArrayList<String>(Arrays.asList("wangwu","xiaoming")));
        
        
        Person person2 = person1.clone();
        
        System.out.println(person2 == person1); //false； 克隆出来的是一个新的对象
        
        
        System.out.println(person1.getName()== (person2.getName())); //true
        System.out.println((person2.getFriends()) == person1.getFriends()); // true； 引用类型 浅克隆
        
        
        
        person1.setAge(200);
        System.out.println(person2.getAge());
        person1.setName("hhh");
        System.out.println(person2.getName());
        person1.setFriends(null);
        System.out.println(person2.getFriends());
    }
    
    
}
