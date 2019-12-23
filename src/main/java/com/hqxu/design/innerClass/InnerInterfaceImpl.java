package com.hqxu.design.innerClass;

public class InnerInterfaceImpl implements OuterInterface.InnerInterface4{

    @Override
    public void innerF() {
        System.out.println("InnerInterfaceImpl implements OuterInterface.InnerInterface4");
    }

    public static void main(String[] args) {
        
        // 测试 内部接口实现类
        new InnerInterfaceImpl().innerF();
        
    }
    
    
}
