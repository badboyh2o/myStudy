package com.hqxu.mode.SingletonMode;

/**
 * 双重检查单例
 *  线程安全
 *  效率高
 *  懒加载
 *
 */
public class PersonDoubleCheck {

    //无初始化值
    public static PersonDoubleCheck person;
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // 私有构造
    private PersonDoubleCheck() {
        
    }
    
    // 静态方法
    public static PersonDoubleCheck getPerson() {
        // 双重检查
        if(person == null) {
            synchronized (PersonDoubleCheck.class) {
                // 这里再检查一次是防止有多个线程同时通过第一个检查
                if(person == null) {
                    person = new PersonDoubleCheck();
                }
            }
        }
        return person;
    }
    
    
}
