package com.hqxu.Exception;

public class Test3 {

    
    public static void func() throws RuntimeException, NullPointerException {

        throw new RuntimeException("func exception");

    }

     public static void main(String args[]) {

        try {

            func();

        } catch (Exception ex) {
        //} catch (RuntimeException re) {//Exception 'java.lang.RuntimeException' has already been caught
        }
        //因为 Exception 是 RuntimeException 的超类，func 方法执行的异常都会被第一个 catch 块捕获，所以会报编译时错误。
    }
    
    
    
    
    
    
    
    
}
