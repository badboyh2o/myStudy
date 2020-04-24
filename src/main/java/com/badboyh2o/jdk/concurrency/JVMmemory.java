package com.badboyh2o.jdk.concurrency;

public class JVMmemory {
	static boolean answerReady = false;
	static int answer = 0;
	static Thread t1 = new Thread(()->{
		answer = 1;
		answerReady = true;
	});
	static Thread t2 = new Thread(()->{
		if(answerReady) {
			System.out.println(answerReady + "," + answer);
		} else {
			System.out.println("I don't know answer!");
		}
	});
	
	public static void main(String[] args) throws InterruptedException {
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		// 可能输出：true,0  !!
		/*
		 * 编译器的静态优化可以打乱代码的执行顺序
		 * JVM的动态优化也会打乱代码的执行顺序
		 * 硬件可以通过乱序来优化其性能
		 */
	}
}
