package com.hqxu.Exception;

public class Test2 {
    
    static int i;

    
    public static void main(String[] args) {
        
        System.out.println(i);
        
        System.out.println(test2());
        
        System.out.println(test3());
        
    }
    
    public static int test1(){
        int ret = 0;
        try{
            return ret;
        }finally{
            ret = 2;
        }
    }
    
    
    public static int test2(){
        int ret = 0;
        try{
            int a = 5/0;
            return ret;
        }finally{
            return 2;
        }
    }
    
    public static A test3(){
        A ret = new A("123",123);
        try{
            return ret;
        }finally{
            ret = new A("124",124);
            ret.setA("456");
        }
    }
    
}


class A {
    private String a;
    private int b;
    
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public A(String a, int b) {
        super();
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {
        return "A [a=" + a + ", b=" + b + "]";
    }
    
    
    
    
}
