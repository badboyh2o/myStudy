package com.badboyh2o.jdk.thread;

/**
 * 在当前线程内调用 join()，当前线程将当主线程调用 t1.join() 方法 [ synchronize方法 ] 时，
 * 当前线程先获得了t1对象的锁， 随后进入join方法，调用了t1对象的wait()方法，使主线程进入了t1对象的等待池
 *
 */
public class ThreadJoinTest {

	public static void main(String[] args) {
		// 线程1
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(10000); // 模拟等待10000 ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("thread-1");
		});
		t1.start();
		
		// 线程2
		Thread t2 = new Thread(() -> {
			System.out.println("thread-2");
		});
		t2.start();
		
		try {
			t1.join(6000); // 只有当前线程在等待 t1 线程 6000ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("thread-main");
	}
}
