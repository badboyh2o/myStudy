package com.hqxu.Class.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换
 * m.group()	//符合模式中所有组的子串
 * m.replaceAll()	替换符合模式的子串
 * m.appendReplacement()	按规则替换符合模式的子串
 *
 */
public class TRegex4 {
	public static void p(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		test1();	//group()   模式中的分组
		test2();	//replaceAll() 替换子串
		test3();	//指定规则替换子串
		test4();	//模式中个分组
	}
	
	public static void test1() {
		
		Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);	//忽略大小写
		Matcher m = p.matcher("java-Java-JAVA");
		
		while(m.find())
		{
			p(m.group());	//输出 java Java JAVA
		}
		
		
	}
	
	public static void test2() {
		
		Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);	//忽略大小写
		Matcher m = p.matcher("java-Java-JAVA");
		
		p(m.replaceAll("js"));	//将符合模式的子串替换为 js； 		js-js-js
		
		
	}
	
	
	public static void test3() {
		
		Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);	//忽略大小写
		Matcher m = p.matcher("java-Java-JAVA-yyy");
		
		StringBuffer buf = new StringBuffer();
		int i = 0;
		while(m.find())
		{
			i++;
			if(i%2 == 0)
			{
				m.appendReplacement(buf, "java");
			}
			else
			{
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);	//将未匹配的子串添加
		
		p(buf.toString());
		
	}
	
	public static void test4() {
		
		Pattern p = Pattern.compile("((\\d{3,3})([a-z]{2}))");	//分了 3 组
		Matcher m = p.matcher("123aa-3434bb-324cc-00");
		
		while(m.find())
		{
			p(m.group());	//模式中所有分组
		}
		
		/*
		while(m.find())
		{
			p(m.group(1));	//模式中分组1
		}
		while(m.find())
		{
			p(m.group(2));	//模式中分组2
		}
		while(m.find())
		{
			p(m.group(3));	//模式中分组3
		}
		*/
	
	}
	
}
