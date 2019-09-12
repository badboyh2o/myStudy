package com.hqxu.functionInterface;


import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {

    
    public static void main(String[] args) {
        BinaryOperatorTest o = new BinaryOperatorTest();
        
        //测试 binaryoperator apply
        System.out.println(o.compute(1, 2, (a, b) -> a + b));
        
        //minby    比较字符串长度
        System.out.println(o.getShort("hello", "ha", (a,b) -> a.length()-b.length())); //ha
        
        //minby    比较首字母
        System.out.println(o.getShort("hello", "abc", (a,b) -> a.charAt(0)-b.charAt(0)));   //abc
        
        
        
    }
    
    /**
     * 使用BinaryOperator
     * 
     * @param a
     * @param b
     * @param binaryOperator
     * @return
     */
    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator)
    {
     return binaryOperator.apply(a, b);
    }
    
    /**
     * 使用BinaryOperator.minby
     * 
     * @param a
     * @param b
     * @param comparator
     * @return
     */
    public String getShort(String a, String b, Comparator<String> comparator)
    {
     return BinaryOperator.minBy(comparator).apply(a,b);
    }
    
}
