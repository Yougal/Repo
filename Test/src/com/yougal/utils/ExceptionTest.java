package com.yougal.utils;

public class ExceptionTest {

	public static MyObject myObject=new MyObject();
	
	static class MyObject{
		
		int k=10;
	}
	
	
	public static MyObject myFunction(){
		
		
		try{
			myObject.k=9;
			throw new Exception();
		}catch(Exception e){
			myObject.k=0;
			return myObject;
		}finally{
			myObject= new MyObject();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(myFunction().k);
		System.out.println(myObject.k);
	}
	
}
