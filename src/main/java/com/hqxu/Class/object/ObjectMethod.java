package com.hqxu.Class.object;

import java.util.Date;

public class ObjectMethod {

    final static Object lock = new Object();
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
        cloneTest();
        getClassTest();
        hashCodeTest();
        waitTest();
    }
    
    
    /**
     * 测试 Object clone
     */
    public static void cloneTest() {
        Date d1 = new Date();
        Date d2 = (Date) d1.clone();
        
        System.out.println(d1 == d2); // fasle
        System.out.println(d1.equals(d2)); // true
        System.out.println(d1);
        System.out.println(d2);
    }
    
    /**
     * 测试 getClass
     */
    public static void getClassTest() throws InstantiationException, IllegalAccessException {
        Date d1 = new Date();
        Date d2 = d1.getClass().newInstance();
        System.out.println(d2 instanceof Date); // true
    }
    
    /**
     * 测试 hashCode
     */
    public static void hashCodeTest() {
        Date d1 = new Date();
        Date d2 = (Date) d1.clone();
        
        System.out.println(d1 == d2); // fasle
        System.out.println(d1.equals(d2)); // true
        System.out.println(d1.hashCode() == d2.hashCode()); // true
    }
    
    
    /**
     * 测试 wait
     */
    public static void waitTest() throws InterruptedException {
        synchronized(lock) {
            lock.wait(1000);
        }
        
    }
    
}
