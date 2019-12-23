package com.hqxu.Class.FunctionalInterface;


/**
 * 测试 lambda 表达式/ 匿名内部类 中的this
 * 
 * 1. 如果lambda表达式用在静态方法中，不能使用this;  ？？？
 *    静态方法中的 匿名内部类 可以使用 this.
 *    
 * 
 * 2.  lambda中的this不是指函数式接口实现实例;而是外部类实例？？？
 *
 */
public class LambdaThis {

    // 成员1
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("r1" + this); // 指的是 Runnable实例
        }
    };
    
    // 成员2
    Runnable r2 = () -> {
        System.out.println("r2" + this); // ？??? 当前类实例？ 
    };
    
    
    
    
    
    /**
     * 测试 lambda表达式的 this
     */
    public static void main(String[] args) {
        
        // 匿名内部类
        Runnable r3 = new Runnable() {

            @Override
            public void run() {
                System.out.println("r3" + this);  // 指的是 Runnable实例
            }
        };
        
        
        // lambda表达式
//        Runnable r2 = () -> {
//            System.out.println(this); // 不能在静态方法内使用this
//        };
        
        
        LambdaThis o = new LambdaThis();
        
        System.out.println("r0" + o); // r0com.hqxu.Class.FunctionalInterface.LambdaThis@ef9176
        new Thread(o.r2).start(); // r0com.hqxu.Class.FunctionalInterface.LambdaThis@ef9176
        
        new Thread(o.r1).start(); // r1com.hqxu.Class.FunctionalInterface.LambdaThis$1@1378143
        new Thread(r3).start(); // r3com.hqxu.Class.FunctionalInterface.LambdaThis$2@1c92c54
        
    }
    
    
}
