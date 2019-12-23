package com.hqxu.Class.String;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringClass {
    
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        
        
        /**
         * String 的构造方法
         */
        // 1.byte[]
        String s1= "hello";
        byte[] b1 = s1.getBytes("utf-8");   // 编码
        String s2 = new String(b1, "utf-8");    // 解码
        System.out.println(s2);
        
        // 2.char[]
        char[] c1 = {'a','b','c'};
        String s3 = new String(c1);
        System.out.println(s3);
        
        // 3.StringBuffer
        StringBuffer buffer1 = new StringBuffer("abcd");
        String s4 = new String(buffer1);
        System.out.println(s4);
        
        
        
        /**
         * String 常用方法
         */
        String s5 = "hereloghshhedlgpluh";
        s5.equals("he");    // false
        s5.equalsIgnoreCase("Hello");   //true
        s5.toUpperCase();   // HELLO
        s5.toLowerCase();
        s5.charAt(0);   // h
        s5.substring(1);    //ello， 包含开始索引，直到结束
        s5.substring(1, s5.length());   // 包含开始索引，不包含结束索引
        
        // 返回第一次出现的索引（方向不一样）
        System.out.println(s5.indexOf('e'));    // 1；从0索引开始 从左向右查询，返回第一次出现的索引；如果没有该字符，则返回 -1 
        System.out.println(s5.lastIndexOf('l')); //16; 从最后索引开始 从右向左查询，返回第一次出现的索引；
        System.out.println(s5.indexOf('e', 2)); //3; 从指定索引开始 从左向右查询，返回第一次出现该字符的索引
        System.out.println(s5.lastIndexOf('e', 5)); //3； 从指定索引开始 从右向左查询，返回 第一次出现该字符的索引
        
        // 忽略前导 尾部空白
        String s6 = "\t123 ";   //123
        
        // 拼接字符串
        String s7 = "abc";
        System.out.println(s7.concat("123"));   //abc123
        
        // 劈开
        String s8 = "1,2,3,4";
        String[] sa1 = s8.split(",");
        System.out.println(Arrays.toString(sa1));   // [1, 2, 3, 4]

        
        // 替换
        String s9 = s8.replace(',', ' ');
        System.out.println(s9);
        
        s8.startsWith("1");
        s8.endsWith("4");
        
    }
    
}
