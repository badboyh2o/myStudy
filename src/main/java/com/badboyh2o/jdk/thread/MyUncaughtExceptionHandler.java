package com.badboyh2o.jdk.thread;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("自定义的未捕获异常处理器");
		System.out.println(t.getId() + t.getName());
		System.out.println(t.getThreadGroup());
	}

}
