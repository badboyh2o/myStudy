package com.hqxu.Class.object;

public class Sub extends Base {

    
    public static void staticMethod( ){
        System.out.println("staticMethod Sub");  
    }  
    public void instanceMethod( ){
        System.out.println("instanceMethod Sub"); 
    } 
    
    
    
    
    public static void main(String[] args) {
        
        Base base = new Base();
        System.out.println(base.getA());
        Base.staticMethod();
        base.instanceMethod();
        
        
        Base sub = new Sub();
        Sub.staticMethod();
        sub.instanceMethod();
        
        
    }
    
    
}
