package com.hqxu.Class.object.finalize;

public class TestFinalize {

    public static void main(String[] args) {
        Person p = new Person("badboyh2o",20);
        
        p = null;
        
        System.gc();    // Person [name=badboyh2o, age=20]
        //Runtime.getRuntime().gc();
        
        System.out.println();
    }
    

}

class Person {

    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    /**
     * 
     */
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    
    /**
     * 重写 finalize
     * 
     * finalize()方法是在垃圾收集器删除对象之前对这个对象调用的子类覆盖 finalize() 方法
     * 以整理系统资源或者执行其他清理操作。
     * 
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this);
    }
    
    
    

}
