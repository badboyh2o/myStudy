package com.hqxu.testEnum;

	
public enum Color {  
	
	RED("红色"), GREEN("绿色"), YELLOW("黄色");
	
	/**
	 * 属性
	 */
	private String desc;
	
	/**
	 * 构造函数 只能是私有
	 * @param desc
	 */
	private Color(String desc) {
		this.desc = desc;
	}

	
	/**
	 * 重写 toString
	 */
	@Override
	public String toString() {
		return desc;
	}
	
}
