package com.hqxu.basic;

public class Test {

    protected int a;

    
    public Test(int a) {
        setA(a);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    
    public static void main(String[] args) {
        Test t = new Test(5);
        System.out.println(t.a);
        Sub s = new Sub();
        System.out.println(s.a);
        
    }
    
    
    
}
class Sub extends Test {
    
    public Sub() {
        super(5);
    }
    
    public void setA(int a) {
        super.setA(2*a);
    }
    
}