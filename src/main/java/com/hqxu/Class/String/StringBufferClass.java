package com.hqxu.Class.String;


/**
 * StringBuffer 节省内存开销，修改时不会产生对象
 *
 */
public class StringBufferClass {

    
    public static void main(String[] args) {
        
        // 构造方法
        StringBuffer sb1 = new StringBuffer("123456");
        
        // reverse()
        System.out.println(sb1.reverse());  //654321
        
        // setCharAt()
        StringBuffer sb2 = new StringBuffer("01234567");
        sb2.setCharAt(0, '0');
        System.out.println(sb2);    //01234567
        
        // delete()
        StringBuffer sb3 = new StringBuffer("01234567");
        sb3.delete(0, sb3.length());
        System.out.println(sb3);    //空
        
        // append
        StringBuffer sb4 = new StringBuffer("abc");
        System.out.println(sb4.append(123));    //abc123
        System.out.println(sb4.append(new Object()));   //拼接对象.toString(); abc123java.lang.Object@8b7f67
        
        // insert
        StringBuffer sb5 = new StringBuffer("abc");
        System.out.println(sb5.insert(1, 123));    //a123bc; 从索引位置开始插入
        System.out.println(sb5.insert(1, new Object()));    //从索引位置开始插入Object.toString() ; ajava.lang.Object@c7a4e4123bc
    }
    
    
}
