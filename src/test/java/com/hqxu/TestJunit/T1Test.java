package com.hqxu.TestJunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.hamcrest.Matchers.*;

import org.junit.Test;


//使用到两个包： org.junit、 org.hamcrest
//静态引用，直接使用静态方法 import static
//使用两个包，classLoader错误；删除Eclipse Junit的包，重新引入
public class T1Test {

	//执行每个 @Test 测试方法前执行 @Before测试方法；执行每个测试方法后执行@After测试方法
	@Before
	public void before() {
		System.out.println("======before=========");
	}
	@After
	public void after() {
		System.out.println("======after=========");
	}
	
	
	//所有测试开始之前之后执行的方法；    类实例化前能执行的是静态方法
	@BeforeClass
	public static void beforeClass() {
		System.out.println("======beforeclass=========");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("======afterclass=========");
	}
	
	
	//1.测试方法的返回值
	@Test
	public void testAddtest() {
		
		int z = new T1().addtest(2, 3);
		assertThat(z, is(5));
		
	}
	
	//2.测试异常
	@Test(expected=java.lang.ArithmeticException.class)
	public void testdivide()
	{
		int z = new T1().dividetest(8, 0);
		//assertThat(z, is(4));
	}
	
	//@Ignore 暂时忽略该测试方法
	@Ignore
	@Test(expected=java.lang.ArithmeticException.class)
	public void testdivide1()
	{
		int z = new T1().dividetest(8, 0);
		//assertThat(z, is(4));
	}

	

	
	
}
