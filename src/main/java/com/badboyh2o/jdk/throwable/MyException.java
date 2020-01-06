package com.badboyh2o.jdk.throwable;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MyException {

	public static void main(String[] args) {
		
		try {
			test();
		} catch(Exception e) {
			//获取异常堆栈
			System.out.println(getStackTrace(e));
		}
	}
	
	public static void test() {
		int a = 0/0;
	}
	
	public static String getStackTrace(Throwable t) {
		StringWriter w = new StringWriter();
		PrintWriter p = new PrintWriter(w);
		//获取异常堆栈信息
		t.printStackTrace(p);
		String s = w.toString();
		return s;
	}
	
}
