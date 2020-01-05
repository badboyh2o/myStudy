package com.badboyh2o.jdk.interface1;

/**
 * 1.接口中可以定义和Object中同名的非final方法，修饰符为public abstract
 * 因为所有类都是Object的子类，所以这些同名的方法的返回类型需要兼容Object方法的返回类型
 * 对于 clone finalize方法，在Object中是protected，所以如果接口声明了这两个方法，接口的子类必须重写者两个方法。
 * （继承自Object的是protected不能覆盖接口的public）
 * 
 * 2.当子类的接口和父类声明了同名的方法，如果子类继承自父类的方法不能兼容接口的方法，则必须重写该方法。
 *  如访问权限、返回类型
 * 
 */
public interface MyInterface {
    
    /**
        1.Object的final方法不能被子类继承
        public final native Class<?> getClass();
        public final native void notify();
        public final native void notifyAll();
        public final void wait() throws InterruptedException
    */
    public abstract boolean equals(Object obj);
    public abstract int hashCode();
    public abstract String toString();
    public abstract Object clone() throws CloneNotSupportedException; //protected to public
    public abstract void finalize() throws Throwable; //protected to public
    
    /**
     * 2.子类实现的接口的方法的返回类型，需要兼容和该子类的父类的方法的返回类型。
     * 即接口的方法返回类型必须和该子类的父类的方法的返回类型一致（或者是子类）
     * 
     * 3.子类重写的方法必须兼容该子类实现的接口的方法的，如访问权限、返回类型
     */
    public abstract Integer test();
    //public abstract Integer test2();
    public abstract int test3();
    
    default Integer test2() {return 1;}
}


class ParentClass {
    protected Number test() {
        return null;
    }
    
    public Object test2() {
        return null;
    }
    
    public int test3() {
        return 1;
    }
}

class SubClass extends ParentClass implements MyInterface{
    /**
     * 继承自Object的clone finalize 方法是protect，无法覆盖接口的public的clone finalize方法
     * 因此需要重写接口
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }
    @Override
    public void finalize() throws Throwable {
    }
    
    /**
     * 继承自ParentClass的test 方法是protect，无法覆盖接口的public的test 方法
     * 因此需要重写该方法
     */
    public Integer test() {
        return null;
    }
    /**
     * 继承自ParentClass的test2 方法返回类型是Object，不能兼容接口的返回类型 Integer
     * 因此需要重写该方法
     */
    public Integer test2() {
        return null;
    }
}