package com.badboyh2o.jdk.proxy.jdkdanymicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理处理程序类
 * 需要实现 InvocationHandler
 *
 */
public class LogDynamicProxyHandler implements InvocationHandler {

	// 目标类
    private Object target;
    
    /**
     * 创建代理
     * @param target 目标类
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }
	
    /**
     * 在代理实例调用方法时，方法调用被编码分派到调用处理程序的invoke方法
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null; // 返回结果
        try {
            System.out.println("调用方法之前记录日志...");
            result = method.invoke(this.target, args); // 调用目标类的方法
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}
}
