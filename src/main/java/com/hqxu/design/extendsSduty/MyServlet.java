package com.hqxu.design.extendsSduty;

public class MyServlet extends BaseServlet {

    
    
    public MyServlet() {
        super();
        System.out.println("MyServlet");
    }

    @Override
    protected void doService() {
        System.out.println("doService in MyServlet");
    }
    
    /**
     * 测试 接口 抽象类 实现方法
     * 
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        
        Servlet servlet = new MyServlet();
        servlet.service();
    }
    
}
