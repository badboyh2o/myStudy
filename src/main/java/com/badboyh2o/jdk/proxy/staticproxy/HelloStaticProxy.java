package com.badboyh2o.jdk.proxy.staticproxy;

/**
 * 代理类
 *
 */
public class HelloStaticProxy implements HelloInterface {
	// 目标类
	private HelloInterface target;
	public HelloStaticProxy(HelloInterface target) {
		this.target = target;
	}
	@Override
	public void sayHello(String param) {
		// 代理方法中调用目标方法
		target.sayHello(param);
		// 对目标方法增强，记录日志
		System.out.println("记录日志");
	}
	
	/**
	 * 测试代理类
	 */
	public static void main(String[] args) {
		HelloInterface t = new Hello();
		HelloInterface p = new HelloStaticProxy(t);
		p.sayHello("hello,world!");
	}
}
