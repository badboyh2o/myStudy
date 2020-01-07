package com.badboyh2o.jdk.thread;

public class MyUncaughtExceptionHandlerTest {

	public static void main(String[] args) {
		// 为所有线程设置默认的 UncaughtExceptionHandler
		//Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		
		Thread t1 = new Thread(()->{
			throw new RuntimeException(); // 模拟抛出未捕获异常
		});
		t1.start();
		// 为某个线程设置一个 UncaughtExceptionHandler
		t1.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
	}
}