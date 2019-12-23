package com.hqxu.design.innerClass;


/**
 * https://www.jianshu.com/p/f0fdea957792
 * 
 * 0.外部类
 *  0.1 只能使用public和 默认 访问修饰符
 *  0.2 外部类可以直接访问内部类的静态成员，但是需要通过实例化内部类才能访问内部类的普通成员。
 *  
 * 
 * 1.内部类
 *  1.1 内部类可访问外部类所有成员，包括private
 *  1.2 内部类 可以使用 public，默认（包限定），protected和private 四种修饰符修饰。访问权限与以前的约定一致。
 *  1.3 内部类的成员 的四种访问权限 含义 与之前的约定一致。
 *  1.4 内部类可分为静态内部类和非静态内部类
 *          静态内部类
 *          非静态内部类
 *              成员内部类
 *              局部内部类
 *              匿名内部类
 *  1.5 非静态内部类不能出现静态成员；但可以定义static final 常量。
 *      可以直接访问外部类的所有成员，包括静态、非静态。
 *  1.6 静态内类可以直接访问外部类的静态成员，但是需要通过实例化外部类才能访问外部类的普通成员。
 *  
 *  1.7 内部类是一个编译是的概念，一旦编译成功，就会成为完全不同的两个类，
 *          分别为outer.class和outer$inner.class类。
 *          所以内部类的成员变量/方法名可以和外部类的相同。
 *  
 *  
 *  
 * 2. 内部类的作用
 *  2.1 实现类的隐藏。外部类是不允许有 private 与protected权限的，但内部类可以。
 *  2.2 通过创建过个内部类，分别继承不同的父类，实现外部类的多继承。
 *  2.3 通过多个内部类实现同一个接口，不同的内部类对同一接口方法可以有不同的实现。
 *  
 *  
 * 3. 内部类 —— 静态内部类
 *  3.1 实例化方式： OuterClass.StaticInerCls staticInerCls = new OuterClass.StaticInerCls();  
 *  3.2 静态内部类的加载时机:
 *         当实例化静态内部类或者访问静态内部类的静态成员时，静态内部类被加载。
 *      
 * 
 * 4. 内部类 —— 非静态内部类 —— 成员内部类
 *    1) 非静态内部类不能出现静态成员。
 *    2) 可以直接访问外部类所有成员。
 *  
 * 
 * 5.内部类 —— 非静态内部类 —— 局部内部类
 *    1）指内部类定义在方法体内，只能在该方法或条件的作用域内才能使用，退出这写作用域就无法引用。
 *    2）作为非静态内部类的一种特殊形式, 非静态内部类的所有限制对局部类同样成立。
 *    3）局部类不仅可以访问外部类的所有成员，还可以访问方法体的局部变量，但必须是final修饰的局部变量。？？？ 
 *       
 *       解析：Java采用了一种copy local variable的方法实现，定义为final的变量，会拷贝一份存到局部内部类中，
 *            后续使用持续维护这个对象在生命周期内，所以可以继续访问。　？？？　　（jdk8 不需要final修饰，另外，方法体外部也无法将Object转为内部类）
 *  
 * 6. 内部类 —— 非静态内部类 —— 匿名内部类
 *    1）一般用于创建 子类实例 或者实现类实例，但是不想在代码里面创建一个子类或者实现类文件。
 *  
 *  
 */

public class OuterClass {
    
    private Integer a = 1;
    private static final String s = "1";
    
    static {
        System.out.println("Outer class load");
    }
    
    
    
    /**
     * 非静态内部类 —— 局部内部类
     */
    private Object OutterF() {
        
        // 局部变量 （jdk 8 不需要 final修饰）
        int localVariable = 22;
        
        class LocalInner{
            void println(){
                System.out.println("localVariable " + localVariable);
            }
        }
        
        Object in = new LocalInner();
        return in;
    }
    
    
    // start
    // 0.测试内部类
    public static void main(String[] args) {
        
        // 1. 同一个类中， 测试 内部类的访问权限
        // 在外部类中，可以实例化所有权限的内部类
        OuterClass.PrivateStaticInnerCls inner1 = new OuterClass.PrivateStaticInnerCls();
        OuterClass.DefaultStaticInnerCls inner2 = new OuterClass.DefaultStaticInnerCls();
        OuterClass.ProtectedStaticInnerCls inner3 = new OuterClass.ProtectedStaticInnerCls();
        System.out.println("--------------------------------------------------------");
        OuterClass.PublicStaticInnerClass inner4 = new OuterClass.PublicStaticInnerClass();
        
        // 2. 测试静态内部类
        // 2.1 外部类 可以直接访问 内部类 静态成员
        System.out.println(OuterClass.PublicStaticInnerClass.ii);
        // 2.2 外部类 可以通过实例化内部类 访问内部类 普通成员
        System.out.println(new OuterClass.PublicStaticInnerClass().is);
        // 2.3 外部类 可以通过实例化内部类 访问内部类 普通成员方法
        new OuterClass.PublicStaticInnerClass().privateF(); // 实例化静态内部类
        
        
        // 3.测试 非静态内部类 - 成员内部类
        OuterClass outerCls = new OuterClass();
        OuterClass.PrivateInnerCls iCls = outerCls.new PrivateInnerCls();   // 实例化成员内部类
        System.out.println(iCls.is);
        
        
        
        // 4.测试 非静态内部类 - 局部内部类
        Object localInner = new OuterClass().OutterF(); // 不在作用域内，类型不能转为为 LocalInner
        
        
        // 5.测试匿名内部类
            // 相当于
            // Thread t = new myThread();
            // t.start();
            // 不需要创建一个继承Thread 的 myThread 类
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        
            // 相当于 
            // Runnable r = new myRunnable();
            // new Thread(r).start();
            // 不需要创建 一个实现Runnable的 myRunnable 类
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        
    }
    
    
    /**
     *  静态内部类
     */
    // 1.1 静态内部类  private
    private static class PrivateStaticInnerCls {
        
        private String is = s;
        
    }
    // 1.2 静态内部类  默认
    static class DefaultStaticInnerCls {
        
        private String is = s;
        
    }
    // 1.3 静态内部类  protected
    protected static class ProtectedStaticInnerCls {
        
        private String is = s;
        
    }
    // 1.4 静态内部类 - 默认
    public static class PublicStaticInnerClass {
        
        // 1) 直接访问 外部类 静态成员
        private String is = s;
        private static int ii = 2; 
        
        static {
            
            System.out.println("static inner class load");
        }
        
        public void publicF() {
            // 2) 静态内部类 只能通过 实例化外部类，访问非静态成员
            System.out.println(new OuterClass().a);
        }
        
        // 3)内部类的成员 的访问权限与之前的约定一致
        private void privateF() {
            System.out.println(ii);
        }
        
    }
    
    
    /**
     * 非静态内部类 - 成员内部类
     */
    private class PrivateInnerCls {
        
        // 1) 非静态内部类 不能使用静态成员; 但可以定义常量
        // private static int ii = 2; 
        private static final int TYPE = 0; 
        
        // 2) 可以直接访问外部类所有成员
        private String is = s;
        private int ii = a;
    }
    
}
