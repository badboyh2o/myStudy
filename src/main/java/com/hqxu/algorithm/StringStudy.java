package com.hqxu.algorithm;

public class StringStudy {

    // 测试
    public static void main(String[] args) {
        f(102);
    }
    
    
    
    /**
     * 输入一个整数，求各位数字之和
     * @param a
     */
    public static void f(int a) {
        String s = String.valueOf(a);
        char [] c = s.toCharArray();
        int sum = 0;
        for(char ch : c) {
            sum += ((int)ch - 48);
        }
        System.out.println(sum);
    }
    
    public static void f1(int a) {
        
        
        
    }
    
    
}
