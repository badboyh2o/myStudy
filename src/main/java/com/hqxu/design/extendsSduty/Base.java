package com.hqxu.design.extendsSduty;

public class Base {

    private String name = "name";
    private int age = 1;
    
    public static String s = "132";
    
    
    public String nameEn = "nameEn";
    public int ageEn = 11;
    
    String name1 = "name1";
    int age2 = 22;
    
        
    protected String name3 = "name3";
    protected int age3 = 33;
    
    
    public Base() {
        System.out.println("constructor base");
    }  
    static {
        System.out.println("static base");
    }
    {
        System.out.println("constructor base block");
    }
    
    
    @Override
    public String toString() {
        return "Base [name=" + name + ", age=" + age + ", nameEn=" + nameEn + ", ageEn=" + ageEn + ", name1=" + name1
                + ", age2=" + age2 + ", name3=" + name3 + ", age3=" + age3 + "]";
    }
    
}
