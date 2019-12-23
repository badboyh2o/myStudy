package com.hqxu.Class.object;

public class Base {

    protected String name;
    private String a;
    private Integer b;
    
    {
        
        System.out.println("构造块");
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public Integer getB() {
        return b;
    }
    public void setB(Integer b) {
        this.b = b;
    }
    
    
    
    public static void staticMethod( ){
        System.out.println("staticMethod Base"); 
    }  
    public void instanceMethod( ){
        System.out.println("instanceMethod base"); 
    } 
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        Base base1 = new Base(); //输出 构造块
    }
    
    
}
