package com.hqxu.Class.Thread;


public class SaleTicketThread implements Runnable{
    
    // 实体
    private Ticket ticket;
    public SaleTicketThread(Ticket ticket) {
        this.ticket=ticket;
    }
    
    
    public void sale() {
            // 访问实体的共享变量
            ticket.saleTicket();
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            // 线程访问 实体的共享变量
            sale();
        }
    }

}
