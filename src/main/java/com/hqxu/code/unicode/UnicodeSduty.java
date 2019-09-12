package com.hqxu.code.unicode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 
 * 字符串的实现是 字符数组 char[] 
 * 
 * 一个char 是一个 码元 ？
 *
 */
public class UnicodeSduty {

	
	public static void main(String[] args) throws Exception {
		

		String str = new String(Character.toChars(0x1D56B));  //字符串 str 仅包含一个字符，unicode 码点是  0x1D56B
		
		System.out.println("码点: "+Integer.toHexString(str.codePointAt(0)));
		System.out.println("utf-8编码的内存形式: 字节数量  "+str.getBytes().length); //4   ， 按utf-8编码格式，保存码点 0x1D56B对应的字符  需要4个字节
		System.out.println("utf-8编码的内存形式: 字节序列  "+Arrays.toString(str.getBytes()));
		System.out.println("utf-16编码的内存形式: 双字节(码元)数量  "+str.toCharArray().length); //2
		System.out.println("utf-16编码的内存形式: 双字节(码元)序列  "+"["+Integer.toHexString((int)str.charAt(0))+","+Integer.toHexString((int)str.charAt(1))+"]");
		//System.out.println(str.toCharArray());  //显示为特殊字符
		System.out.println("字符串长度（码元）: "+str.length());	//2	java统计字符串长度实际是计算char[]数组长度（码元总数），而不是字符（码点）个数
		System.out.println("字符串字符（码点）个数: "+str.codePointCount(0,str.length()));	//1
		
		
		
		
		System.out.println("===========================================");
		

		String s = new String(Character.toChars(0x4f60)); 
		System.out.println("码点: "+Integer.toHexString(s.codePointAt(0)));
		
		System.out.println("utf-8编码的内存形式: 字节数量  "+s.getBytes().length);	//3
		System.out.println("utf-8编码的内存形式: 字节序列  "+Arrays.toString(s.getBytes()));
		System.out.println("utf-16编码的内存形式: 双字节(码元)数量  "+s.toCharArray().length); //1
		System.out.println("utf-16编码的内存形式: 双字节(码元)序列  "+"["+Integer.toHexString((int)s.charAt(0))+"]");
		System.out.println("字符串长度（码元）: "+s.length());	//1	java统计字符串长度实际是计算char[]数组长度（码元总数），而不是字符（码点）个数
		System.out.println("字符串字符（码点）个数: "+s.codePointCount(0,s.length()));	//1
		
		//System.out.println(s.toCharArray());  
		
		//内存中的字符串以utf-16BE编码存在
		//System.out.print() 将内存中的字符串（char[])按utf-16解码为码点序列,以系统编码方式(如utf-8,将码点编码)输出字节流,
		//控制台收到的字节流,以相同的方式(utf-8)解码为码点
		//系统将码点以图形的形式显示
		
 		
		
	}	
		
	private static byte[] toByteArray(InputStream in) throws IOException {
		 
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024 * 4];
	    int n = 0;
	    while ((n = in.read(buffer)) != -1) {
	        out.write(buffer, 0, n);
	    }
	    return out.toByteArray();
	}
	
	
}
