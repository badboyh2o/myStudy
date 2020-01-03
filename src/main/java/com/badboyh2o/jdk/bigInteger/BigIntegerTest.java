package com.badboyh2o.jdk.bigInteger;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.TimeZone;


public class BigIntegerTest {

	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale.toString());
		
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz.getID());
		
		String mf = MessageFormat.format("{1}/{3}/{2}", 1, 0 , 2);
		System.out.println(mf);
	}
	
	
}

