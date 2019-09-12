package com.hqxu.algorithm;

public class IfStudy {

    // 测试
    public static void main(String[] args) {
        f(6);
        year(2000);
    }
    
    
    /**
     * 测试 if
     * @param n
     */
    public static void f(int n) {
        if(n>10) {
            System.out.println( "n > 10");
        } else if(n>8) {
            System.out.println("8 < n <= 10");
        } else if(n>6) {
            System.out.println("6 < n <= 8");
        } else {
            System.out.println("n <= 6");
        }
        
    }
    
    /**
     * 闰年： 能被4整除但不能被100整除；或者 能被400整除的 年份
     * 
     */
    public static boolean year(int y) {
        if(y%4 == 0 && y%100 != 0 || y%400 == 0) {
            System.out.println(y + "是闰年");
            return true;
        }
        System.out.println(y + "不是闰年");
        return false;
    }
}
