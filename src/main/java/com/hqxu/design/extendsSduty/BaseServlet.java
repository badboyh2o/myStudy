package com.hqxu.design.extendsSduty;

public class BaseServlet extends AbstractServlet {

    
    public BaseServlet() {
        super();
        System.out.println("BaseServlet");
    }


    @Override
    public void service() {
        System.out.println("this is BaseServlet");
        doService();
          
    }

    
    protected void doService() {
        System.out.println("doService in BaseServlet");
    }
    
    
}
