package com.hqxu.Class.object;

public class T2 {

    private static final T2 signton = new T2();
    
    private T2() {
        
        System.out.println("========T2=======");
        
    }
    public T2 getInstance() {
        
        return signton;
        
    }
    
    public static void main(String[] args) {
        
    }
    
}
