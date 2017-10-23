package com.yougal.stack;

public class ReverseStringStack {

	
	public static void main(String[] args) {
		String input= "Yougal";
		String reverseString = reverse(input);
		System.out.println(reverseString);
	}

	private static String reverse(String input) {
		if(input==null || input.length()<1){
			return "";
		}else{
			char character = input.charAt(0);
			String x = reverse(input.substring(1));
			return x+character;
		}
	}
}
