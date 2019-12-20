package com.hqxu.Class.FunctionalInterface;



/**
 * 1.函数式接口
 * 
 *  1.1 如何定义一个函数式接口
 *      1)方法：有且仅有一个抽象方法，但是可以有多个非抽象方法（default方法、静态方法）;
 *          注意：可以继承 Object类中的 public 非final 方法。？？？？？ //TODO
 *          
 *      2)接口使用 @FunctionalInterface 注解;
 *          如果仅有一个抽象方法，不使用 @FunctionalInterface 注解 ，编译器依旧认为这是一个函数式接口。
 *  
 * 
 *  1.2 default 方法
 *  
 *      1）实现类会继承接口中的default方法；
 *      
 *      2）如果一个类同时实现接口A和B，接口A和B中有相同的default方法，这时，该类必须重写接口中的default方法
 *          因为，类在继承接口中的default方法时，不知道应该继承哪一个接口中的default方法。
 *          
 *      3） 如果子类继承父类，父类中有b方法，该子类同时实现的接口中也有b方法（被default修饰），
 *          那么子类会继承父类的b方法而不是继承接口中的b方法
 * 
 * 
 * 
 * 
 *  
 * 2. lambda表达式
 *  2.1 什么lambda表达式
 *      函数式接口的匿名实现类的一个实例。
 *      
 *      -- 可以将函数表达式即函数式接口抽象方法的实现 ？
 *      
 *      注意：只有函数式接口才有lambda表达式。
 *  
 *  2.2 函数式接口的 写法
 *      1）  (T a,...) -> {}
 *          如果没有参数则写()
 *          如果只有一个参数，则可不写()
 *          {}如果有返回值，则必须使用 return
 *           
 *      2） (T a,..) -> 一个表达式
 *          如果参数使用类型推断， a -> 表达式
 *          如： a -> System.out.println(i)
 *      
 *      3）方法引用
 *      
 *          基于实例方法引用    object::methodName
 *          构造方法引用  className::new
 *          静态方法引用  className::staticMethodName
 *          基于参数实例方法引用  className::methodName
 *      
 *   
 *          示例：
 *          @FunctionalInterface 
 *          public interface MyLoves {
                void compare(String wife, String mom);
            }

            @Test
            public void test() {
                MyLoves love = String::compareTo; //基于参数实例方法引用
            }
 *  
 *  
 *  3. Java8 内置的四大函数式接口

        Consumer<T> : 消费型接口：有入参，无返回值
            void accept(T t);
            
        Supplier<T> : 供给型接口：无入参，有返回值
            T get(); 
            
        Function<T, R> : 函数型接口：有入参，有返回值
            R apply(T t);
            
        Predicate<T> : 断言型接口：有入参，有返回值，返回值类型确定是boolea
            boolean test(T t);
 *  
 */

@FunctionalInterface
public interface MyFunctionalInterface<T> {

    // 有且仅有一个抽象
    boolean test(T o);
    
    // TODO Object里面的方法
    public abstract String toString();
    public abstract boolean equals(Object obj);
    public abstract int hashCode();
    
    
    // default方法
    public default void f1() {
        System.out.println("1");
    }
   
    public static void f2() {
        System.out.println("2");
    }
    
}
