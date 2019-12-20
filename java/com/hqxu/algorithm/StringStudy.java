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
    
    /**
     * 反转字符串
     * @param str
     * @return
     */
    public static String reverse3(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
          reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
    
    public static String reverse2(String str) {
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
          reverse += chars[i];
        }
        return reverse;
    }
    
    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    
    
    
}
