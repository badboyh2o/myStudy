package com.hqxu.Class.FunctionalInterface;

import java.util.function.Consumer;


/**
 * 匿名内部类 和 lambda表达式同时使用
 *
 */
public class LambdaScope {

    public int x = 0;
    
    // 内部类
    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {    //参数是 23
            
            // lambda表达式 创建一个函数式接口实例
            Consumer<Integer> myConsumer = (y) -> 
            {
                System.out.println("x = " + x);     //!只能使用作用域内的x，即方法参数x
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " +
                    LambdaScope.this.x);
            };
            myConsumer.accept(x);
        }
    }

    public static void main(String... args) {
        
        // 实例化内部类
        LambdaScope st = new LambdaScope();
        LambdaScope.FirstLevel fl = st.new FirstLevel();
        
        fl.methodInFirstLevel(23);
    }
}