package com.hqxu.algorithm;

/**
 * 大于或等于 输入整数的第一个质数（被1和自己整除）
 *
 */
public class ForSduty {

    // 测试
    public static void main(String[] args) {
        f(20); //23
        f(1);
    }
    
    
    /**
     * 大于或等于 num 的第一个质数
     * 
     * @param num
     * @return
     */
    public static int f(int num) {
        for(int a = num ; ; a++) {
            boolean flag = true;
            for(int b = 2; b < a; b++) {
                if(a%b == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("大于" + num + "的第一个质数： " + a);
                return a;
            }
        }
    }
}
