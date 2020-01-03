package com.badboyh2o.jdk.i18n;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MyCalendar {

	public static void main(String[] args) {
		
		TimeZone tz1 = TimeZone.getTimeZone("US/Eastern");
		Locale l = Locale.CHINESE;
		
		Calendar c = Calendar.getInstance(tz1, l);
		System.out.println(c.get(Calendar.HOUR));
	}
}
