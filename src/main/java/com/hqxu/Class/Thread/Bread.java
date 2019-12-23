package com.hqxu.Class.Thread;

/**
 * 
 * 
 * 1.线程间通信
 *      instance.wait()       获取到当前实例的线程释放当前实例，进入阻塞状态，其他线程可以获取该实例
 *      instance.notify()       唤醒 等待 该实例的一个线程
 *      instance.notifyAll()    唤醒 等待 该实例的所有线程
 *  
 * 2.死锁
 *
 */
// 实体
public class Bread {
	
    // 共享变量
	private boolean flag=false;    //默认没有面包
	
	
	// 实体的方法 互斥锁
	public synchronized void consumer()
	{
		
	    // 访问实体的共享变量
	    if(flag)
		{
			System.out.println(Thread.currentThread().getName()+"  消费面包了。。。");
			flag=false;
			
			// 同步：唤醒 等待 该实例的所有线程
			this.notifyAll();
		}else
		{
			try {
			    // 同步：获取到当前实例的线程，释放当前实例，进入阻塞，等待该实例
			    System.out.println(Thread.currentThread().getName()+" wait");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 实体的方法
	public synchronized void product()
	{
		if(!flag)
		{
			System.out.println(Thread.currentThread().getName()+" 生产面包。。。");
			flag=true;
			this.notifyAll();
		}else
		{
			try {
			    System.out.println(Thread.currentThread().getName()+" wait");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
