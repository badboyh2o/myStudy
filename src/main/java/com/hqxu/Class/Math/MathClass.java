package com.hqxu.Class.Math;


public class MathClass {

    
    public static void main(String[] args) {
        
        // 求最大值
        int max = Math.max(33, 76);
        System.out.println(max);//76
        
        // 向上取整
        double a = 3.40;
        double b = 5.61;
        System.out.println(Math.ceil(a));   //4.0
        System.out.println(Math.floor(b));  //5.0
        
        // 随机数       1.0 > d >= 0.0 
        System.out.println(Math.random());
        System.out.println(Math.random()*(36-6) + 6);   // >=6 <36
        
        
        
    }
    
    
    
}
