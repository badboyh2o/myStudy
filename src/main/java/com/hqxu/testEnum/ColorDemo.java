package com.hqxu.testEnum;

import java.util.Arrays;

public class ColorDemo {

	public static void main(String[] args) {
	
		Color color=Color.GREEN;
		
		/**
		 * 1.父类属性 name、 ordinal
		 * 2.私有构造函数？：父类Enum私有构造函数  private Day(String name, int ordinal) 只能由编译器调用
		 * 3.获取枚举类的字节码对象 color.getDeclaringClass();
		 * 4.从字节码对象获取枚举常量 clazz.getEnumConstants()
		 * 5.只能重写父类没有使用final修饰的toString()
		 */
		
		Class<?> clazz = color.getDeclaringClass();
		
		p(color);						//绿色
		p(clazz);						//class com.hqxu.testEnum.Color
		
		p(color.name());				//name: GREEN
		p(color.ordinal());				//ordinal: 1
		
		p(color.toString());			//绿色
		p(Color.valueOf(color.name()));	//绿色
		p(Enum.valueOf(Color.class,color.name()));	//绿色
		p(Arrays.toString(Color.values()));			//[红色, 绿色, 黄色]
		
		if(clazz.isEnum()) {
		    System.out.println(Arrays.toString(clazz.getEnumConstants()));	//[红色, 绿色, 黄色]
		}
		
	}
	
	
	
	
	public static void p(Object o)
	{
		System.out.println(o);
	}
	
}
