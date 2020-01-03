package com.badboyh2o.jdk.string;

public class MyString {

	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(MyString o) {
		if(this.getName().equals(o.getName())) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyString o1 = new MyString();
		MyString o2 = new MyString();
		o1.setName("1");
		o2.setName("1");
		
		
		System.out.println(o1.equals(o2));
	
	
	}
}