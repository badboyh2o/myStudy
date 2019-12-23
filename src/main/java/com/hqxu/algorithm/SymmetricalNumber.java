package com.hqxu.algorithm;


/**
 * 对称数
 *
 */
public class SymmetricalNumber {

    public static void main(String[] args) {
        
        // 测试
        System.out.println(f(0));   //true
        System.out.println(f(12));  //false
        System.out.println(f(11));  //true
        System.out.println(f(123));  //false
        System.out.println(f(121));  //true
        System.out.println(f(1221));  //true
        System.out.println(f(1222));  //false
        
    }
    
    
    /**
     * 判断一个整数是否为对称数
     * @param a
     * @return
     */
    public static boolean f(int a) {
        
        String s = String.valueOf(a);
        char [] c = s.toCharArray();
        for(int i = 0; i < c.length/2; i++) {
            if(c[i] != c[c.length-1-i]) {
                return false;
            }
        }
        return true;
    }
    
}
