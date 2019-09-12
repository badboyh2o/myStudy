package com.hqxu.testEnum;

public enum Country {

	CHINESE {
		@Override
		public String getInfo() {			//实现抽象方法
			return "China";
		}
	},
	AMERICA {
		@Override
		public String getInfo() {
			return "America";
		}
	};
	
	
	/**
	 * 枚举类的抽象方法
	 * @return
	 */
	public abstract String getInfo();
	
	
	
	public static void main(String[] args) {
		 System.out.println(Country.CHINESE.getInfo());			//输出 China
	}
	
	
}
