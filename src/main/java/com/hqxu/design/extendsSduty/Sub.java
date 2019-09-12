package com.hqxu.design.extendsSduty;

public class Sub extends Base{
        
    public Sub() {
        System.out.println("constructor sub");
    }
    static {
        System.out.println("static sub");
    }
    {
        System.out.println("constructor sub block");
    }

    
    
    public static void main(String[] args) {
        
/*        static base
        static sub
        constructor base block
        constructor base
        constructor sub block
        constructor sub*/
        Sub sub = new Sub();
        
        // 调用父类的toString
        System.out.println(sub.toString());
    }
}
