package com.badboyh2o.jdk.i18n;

import java.util.Arrays;
import java.util.Locale;

public class MyLocale {

	public static void main(String[] args) {
		
		Locale locale = Locale.getDefault();
		System.out.println(locale.toString());
		
		System.out.println(Arrays.toString(Locale.getAvailableLocales()));
		
	}
}
