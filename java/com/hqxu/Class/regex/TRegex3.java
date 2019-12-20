package com.hqxu.Class.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * matches() 影响 find()
 *
 *
 *matches() 匹配整个字符串
 *find（）    匹配子串
 *lookingAt()从开始位置匹配
 *
 *
 *
 */

public class TRegex3 {

	public static void p(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);
		
		p(m.matches());  //false
		
		//m.reset();
		
		p(m.find());	//true
		p(m.start()+"-"+m.end());  //匹配的情况下才有开始、结束位置
		
		p(m.find());	//true
		p(m.start()+"-"+m.end());
		
		p(m.find());	//false

		p(m.find());	//false
		
		p("----------------------");
		p(m.lookingAt());	//true
		p(m.lookingAt());	//true
		p(m.lookingAt());	//true
		p(m.lookingAt());	//true
		p(m.lookingAt());	//true
		p(m.lookingAt());	//true
			
		
		
		
		
		
	}
	
	
	
	
}
