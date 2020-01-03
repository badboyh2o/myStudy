package com.badboyh2o.jdk.i18n;

import java.util.Arrays;
import java.util.TimeZone;

public class MyTimeZone {

	
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.timezone"));
		
		// 获取默认时区
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz.getID());
		
		// 获取时区实例的两种方式
		TimeZone tz1 = TimeZone.getTimeZone("US/Eastern");
		TimeZone tz2 = TimeZone.getTimeZone("GMT+08:00");
		
		System.out.println(tz1.getID());
		System.out.println(tz1.getDisplayName());
		System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
		
		
		
	}
}
