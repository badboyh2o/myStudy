package com.hqxu.mode.SingletonMode;


/**
 * 俄汉式单例：
 *  线程安全
 *  耗费资源，类加载就创建了一个实例
 *
 */
public class PersonHungery {
    
    // 有初始化值
    public static final PersonHungery person = new PersonHungery();
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // 私有构造
    private PersonHungery() {
        
    }
    
    // 静态方法
    public static Person getPerson() {
        return new Person();
    }
    
    
}
