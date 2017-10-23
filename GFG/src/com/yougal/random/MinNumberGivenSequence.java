package com.yougal.random;

import java.util.Stack;

public class MinNumberGivenSequence {

	public static void main(String[] args) {
		printMinNumberForPattern("IDID");//1 3 2 5 4
	    printMinNumberForPattern("I");
	    printMinNumberForPattern("DD");// 3 2 1
	    printMinNumberForPattern("II");
	    printMinNumberForPattern("DIDI");
	    printMinNumberForPattern("IIDDD");
	    printMinNumberForPattern("DDIDDIID");
	}

	private static void printMinNumberForPattern(String pattern) {
		int number =1;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i <=pattern.length(); i++) {
				st.push(number);
				if(i==pattern.length() || pattern.charAt(i)=='I'){
					while(!st.isEmpty()){
						sb.append(st.pop());
					}
				}
				number++;
		}
		System.out.println(sb.toString());
	}
	
}
