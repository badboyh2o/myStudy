package com.hqxu.mode.SingletonMode;



/**
 * 懒汉式单例
 *  线程不安全
 *  懒加载
 *
 */
public class PersonLazy {
    //无初始化值
    public static PersonLazy person;
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // 私有构造
    private PersonLazy() {
        
    }
    
    // 静态方法
    public static PersonLazy getPerson() {
        // 
        if(person == null) {
            person = new PersonLazy();
        }
        return person;
    }

}