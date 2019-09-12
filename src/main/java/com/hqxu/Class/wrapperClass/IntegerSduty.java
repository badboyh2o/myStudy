package com.hqxu.Class.wrapperClass;

/**
 * 包装类的作用：
 * 
 * 包装类型是为了方便对基本数据类型进行操作，包装类型可以解决一些基本类型解决不了的问题：
      集合不允许存放基本数据类型，只能存放应用数据类型。 add(Object o)
      基本类型可以和包装类型直接相互转换，自动装箱拆箱，
      通过包装类型的parse方法可以实现基本数据类型+String类型之间的相互转换。
       函数需要传递进去的参数为Object类型，传入基本数据类型就不可行
 *
 */
public class IntegerSduty {

    
    public static void main(String[] args) {
        
        /**
         * String Integer 转换
         */
        
        // String to Integer
        Integer i = new Integer("-0123");   // new Integer
        System.out.println(i);
        
        Integer i0 = Integer.valueOf("-01234"); // Integer.valueOf
        System.out.println(i0);
        
        // Integer to String 
        String s = i.toString();    // toString()
        System.out.println(s); 
        
        
        
        /**
         * int Integer 转换 (自动拆箱、装箱)
         */
        // int to Integer
        int a = 2;
        Integer i1 = new Integer(a);    // new Integer
        System.out.println(i1);
        
        // Integer to int
        int i2 = i1.intValue(); // intValue()
        
        
        
        
        /**
         * String 和 int 之间转换
         */
        
        // int to String 
        int b = -234;
        String s1 = String.valueOf(b);  // String.valueOf
        System.out.println(s1);
        
        // String to int 
        int c = Integer.parseInt(s1);   // Integer.parseInt
        System.out.println(c);
        
    }
    
}
