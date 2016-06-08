package com.yougal.java8;

public class TestStatic {
	
	

	static{
		x =10;
		TestStatic a= new TestStatic();
		//System.out.println(x);
		main(null);
		y=20;
	}
	
	TestStatic(){
		System.out.println(x);
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello World" + y);
	}
	
	public static final int x;
	public static final int y;
	
	public static final int z=30;
	
	int p =10;
	
	

}
