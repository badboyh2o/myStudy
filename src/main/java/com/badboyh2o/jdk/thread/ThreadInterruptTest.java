package com.badboyh2o.jdk.thread;

/**
 * 中断： https://www.cnblogs.com/yangming1996/p/7612653.html
 * https://www.cnblogs.com/baoendemao/p/3804730.html
 * 
 * 1.interrupt()方法
 * 线程调用interrupt()方法后，线程内调用了Object#wait、Thread#join、Thread#sleep方法中的一种， 会抛出一个
 * InterruptedException，且中断标志被清除，重新设置为false。
 *
 * 2.获取线程中断标志位 static boolean interrupted() 静态方法，测试当前线程是否中断，并且产生副作用，将当前线程的中断状态置为
 * false boolean islnterrupted() 实例方法，测试某一个线程是否中断，不会重置中断状态
 * 
 * 
 * 3.中断的意义： 处于 RUNNABLE 状态的线程可以设置 中断 为true，应用程序判断可以通过判断中断标志位终止程序。 Thread t = new
 * Thread(() -> { while(true){ if (Thread.currentThread().isInterrupted()){
 * //判断中断标志位 System.out.println("exit MyThread"); break; } } // 业务代码 });
 * 
 * 4.不同状态下的线程，调用interrupt()中断的影响
 * NEW、TERMINATED：无意义，调用interrupt()后中断后中断标志仍然是false;
 * RUNNABLE、BLOCKED：调用interrupt()后中断后中断标志可以修改为 true;
 * WAITING、TIMED_WAITING：遇到中断操作的时候，会抛出一个InterruptedException异常，并重置中断标志位为false。
 * 
 */
public class ThreadInterruptTest {
	static Object o;

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			try {
				// 当线程进入 TIMED_WAITING，该线程再调用interrupt()方法将抛出 InterruptedException异常
				// TIMED_WAITING 的线程重新进入 RUNNABLE
				Thread.sleep(10000);

			} catch (InterruptedException e) {

				System.out.println("线程出现 InterruptedException 异常了，TIMED_WAITING 的线程 t 重新进入"
						+ Thread.currentThread().getState() + " 状态");
				System.out.println(
						"抛出InterruptedException异常后，此时线程 t 是否interrupt: " 
						+ Thread.currentThread().isInterrupted());

				// 模拟其他业务过程
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		t.start();

		System.out.println("线程 t 调用 interrupt()之前是否interrupt：  " + t.isInterrupted());
		t.interrupt(); // t调用interrupt()
		System.out.println("sleep的线程 t 调用 interrupt()之后是否interrupt：  " + t.isInterrupted());
	}

	/*
	 * 输出：
	 * 
	 * 线程 t 调用 interrupt()之前是否interrupt： false sleep的线程 t 调用
	 * interrupt()之后是否interrupt： true 线程出现 InterruptedException 异常了，TIMED_WAITING
	 * 的线程 t 重新进入RUNNABLE 状态 抛出InterruptedException异常后，此时线程 t 是否interrupt: false
	 */
}
