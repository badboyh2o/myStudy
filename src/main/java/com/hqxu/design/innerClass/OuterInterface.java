package com.hqxu.design.innerClass;


/**
 * 0.内部接口
 *   1）内部类可以有静态内部类 和 非静态内部类。
 *   2）因为接口不能被实例化，所以内部接口只有在是静态的时才有意义。 因此内部接口是静态的。
 * 
 * 
 * 1.内部接口的作用
 *  对那些在同一个地方使用的接口进行逻辑上分组
 * 
 * 
 * 2.内部接口加载时机：
 *   1）调用内部接口的静态方法 ？
 *   2）实例化 内部接口 实现类？
 * 
 * 
 * 3. 如何实现内部接口
 *   public class InnerInterfaceImpl implements OuterInterface.InnerInterface4{ }
 *  
 * 
 * 
 *   
 */
public interface OuterInterface {

    public abstract void of();
    
    // 1.内部接口不能使用 protected private 
    //protected static interface InnerInterface {}
    //private static interface InnerInterface {}
    
    
    // 2.内部接口 默认是 public static 修饰的
                  interface InnerInterface1{}  
           static interface InnerInterface2 {}
           public interface InnerInterface3 {}
           
    public static interface InnerInterface4 {
        void innerF();
    }
    
    
    // 成员
    public static void sf() {
        System.out.println("static mothod");
    }
    public abstract void outerF();
    
}
