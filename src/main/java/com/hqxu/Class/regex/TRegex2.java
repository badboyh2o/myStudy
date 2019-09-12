package com.hqxu.Class.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 
 1.java.util.regex 两个类 Pattern 编译后的模式	//静态方法 Pattern.compile(regex)
 Matcher 模式与指定字符串匹配后的产生的结果	//方法 p.matcher();
 
 
 2.String.matches() 的实现
 	//String.matches()
    public boolean matches(String regex) {
        return Pattern.matches(regex, this);
    }
 
 	//Pattern.matches()
    public static boolean matches(String regex, CharSequence input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
     }
 
 
 
 *
 */
public class TRegex2 {

	public static void p(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("...");	//一个.代表一个字符
		Matcher m = p.matcher("dsd");
		boolean r = m.matches();			//true，匹配
		p(r);

		p("==========测试 matches ： 完全匹配==========");
		//String.matches()
		p("".matches("a?"));	//出现字符a零次或一次	true
		p("".matches("a+"));	//出现字符a一次或多次	false
		p("".matches("a*"));	//出现字符a0次或多次	true
		
		p("A".matches("[A-Z&&[ABC]]"));	//交集，匹配某个字符	true
		p("A".matches("[a-z]|[A-z]"));	//并集，匹配某个字符	true
		p("A".matches("[^\\w]|[A-z]"));	//并集，匹配某个字符	true
		
		p("1".matches("\\w"));		// \d 一个数字[a-zA-Z0-9_]	true
		p("1".matches("\\W"));		// \D 不是一个数字[^\w]	false
		
		
		p("1".matches("\\d"));		// \d 一个数字[0-9]	true
		p("1".matches("\\D"));		// \D 不是一个数字[^0-9]	[^\d]	false
		
		p(" ".matches("\\s"));		// \d 一个空白字符[\t\n\x0B\f\r]	true
		p(" ".matches("\\S"));		// \d 一个非空白字符[^\s]	true
		
		
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));	//空白行：以空白符（不包括\n）开始的，以\n结尾的一行	true
		
		
		p("hello*sir".matches("^he[a-z]{3}\\b\\*\\bsir$"));	//hello(单词边界^\w)*(单词边界^\w)sir	true
		
		
		
	}
	
	

	
	
	
}
