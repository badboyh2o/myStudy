package com.hqxu.design.extendsSduty;

public abstract class AbstractServlet implements Servlet{

    
    public AbstractServlet() {
        super();
        System.out.println("AbstractServlet");
    }

    @Override
    public abstract void service();

}
