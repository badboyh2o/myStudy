package com.badboyh2o.jdk.proxy.jdkdanymicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;

/**
 * 目标类
 *
 */
public class Hello implements HelloInterface {
	@Override
	public void sayHello(String param) {
		System.out.println(param);
	}
	
	/**
	 * 测试动态代理
	 */
	public static void main(String[] args) {
		LogDynamicProxyHandler logProxyHandler = new LogDynamicProxyHandler(); // handler
		HelloInterface hello = new Hello(); // target
		// 创建动态代理
		HelloInterface proxy = (HelloInterface)(logProxyHandler).bind(hello);
		proxy.sayHello("hello, world!");
		
		System.out.println(Modifier.toString(proxy.getClass().getModifiers()));
		System.out.println(proxy.getClass());
	}
}
