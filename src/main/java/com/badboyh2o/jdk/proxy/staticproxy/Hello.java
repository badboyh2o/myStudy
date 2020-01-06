package com.badboyh2o.jdk.proxy.staticproxy;

/**
 * 目标类
 *
 */
public class Hello implements HelloInterface {
	@Override
	public void sayHello(String param) {
		System.out.println(param);
	}
}
