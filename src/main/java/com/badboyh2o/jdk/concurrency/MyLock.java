package com.badboyh2o.jdk.concurrency;

/**
 * 
 * 1.对象锁：
 *	synchronized(obj){ .... }
  *     多个线程竞争同一个对象锁才会发生阻塞。
 * 
 * 2.类锁：一个类只有一个Class实例
 * 	synchronized 修饰静态方法，使用的是类锁，等同于 synchronized(xxx.class){ .... }
 *	所以一个线程进入一个同步静态方法，该类的其他静态同步方法也被锁住。
 *      类锁其实是对象锁。
 *
 */
public class MyLock {

	public static void main(String[] args) throws InterruptedException {
		/*
		
		MyLock o = new MyLock();
		
		Thread t1 = new Thread(()->{
			MyLock.test(o);
		});
		t1.start();
		//test(o); // 两个线程同时调同一个上锁的方法，没抢到锁的只能阻塞
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		o.test1(o);
		
		
		*/
		
		
		
		new Thread(()->{hello1();}).start();
		
		new Thread(()->{hello2();}).start();
		
	}
	
	public static void test(MyLock o) {
		
		synchronized (o) {
			System.out.println("begin test");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test body");
		}
	}
	
	public void test1(MyLock o) {
		System.out.println("begin test1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test1 body");
	}

	
	
	
	
	public static synchronized void hello1() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello1");
	}
	
	public static synchronized void hello2() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello2");
	}
	
}
