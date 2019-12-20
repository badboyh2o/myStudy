package com.hqxu.Class.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1.String的方法实现利用了正则表达式
 String.matches(String regex)  //验证字符串是否匹配模式
 String.repalaceAll(regex, 被替换的子串);   //将匹配模式的子串替换
 *
 */
public class TRegex1 {

	public static void p(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		p("sdf".matches("..."));			//true
		p("1af23".replaceAll("\\d", "*"));	//*af**
		
		
		
		
		
		String filename = ".asd.j";		// 非 空判断才行 
		String filename_length_limit = ".{3,10}";      // 用 String.length代替
		String filename_char_limit = "[\\u4e00-\\u9fa5\\w\\.-]+\\.[a-zA-Z0-9]+";
		
		Pattern length_limit = Pattern.compile(filename_length_limit);
		Pattern char_limit = Pattern.compile(filename_char_limit);
		Matcher m1 = length_limit.matcher(filename);
		Matcher m2 = char_limit.matcher(filename);
		
		p(m1.matches() && m2.matches());	//
		
		
		p("4aa".matches("a+"));
	}
	
	

	
	
	
}
