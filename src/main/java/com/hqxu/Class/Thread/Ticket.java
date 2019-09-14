package com.hqxu.Class.Thread;

import java.util.concurrent.locks.ReentrantLock;



// 实体 
public class Ticket {

    private ReentrantLock lock=new ReentrantLock();
    
    
    // 共享变量
    private int tid=80;
    
    
    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }
    
    
    // 方法一
    /*public synchronized void saleTicket() {
        if(tid>0)
        {
            System.out.println(Thread.currentThread().getName()+" 收费");
            System.out.println(Thread.currentThread().getName()+" 售票id："+tid);
            tid--;
        }
    }*/
    
    
    //方法二：
    /*public void saleTicket()
    {
        //给当前 实体对象 上锁
        synchronized (this) {
            if(tid>0)
            {
                System.out.println(Thread.currentThread().getName()+" 收费");
                System.out.println(Thread.currentThread().getName()+" 售票id："+tid);
                tid--;
            }
        }
    }*/
    
    //方法三：
    public void saleTicket() {
        lock.lock();// 上锁
        try {
            if(tid>0)
            {
                System.out.println(Thread.currentThread().getName()+" 收费");
                System.out.println(Thread.currentThread().getName()+" 售票id："+tid);
                tid--;
            }
        } finally {
            lock.unlock();//解锁，注意一般为了一定解锁，往往把这行代码放入finally语句块
        }
    }
    
    
    // 测试
    public static void main(String[] args) {
        
        //实例化 实体
        Ticket ticket=new Ticket();
        
        //四个线程同时访问同一个实体共享变量
        SaleTicketThread stt1=new SaleTicketThread(ticket);
        SaleTicketThread stt2=new SaleTicketThread(ticket);
        SaleTicketThread stt3=new SaleTicketThread(ticket);
        SaleTicketThread stt4=new SaleTicketThread(ticket);
        
        new Thread(stt1).start();
        new Thread(stt2).start();
        new Thread(stt3).start();
        new Thread(stt4).start();
        
    }
    
    
}
