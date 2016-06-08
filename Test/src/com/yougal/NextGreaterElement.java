package com.yougal;

import java.util.Stack;

public class NextGreaterElement {

	 public static void main(String[] args) {
	        int[] input = { 98, 23, 54, 12, 20, 7, 27 };
	        printNextGreaterElement(input);
	    }

	private static void printNextGreaterElement(int[] input) {

		Stack<Integer> integersStack = new Stack<Integer>();
		
		for (int item : input) {
			if(integersStack.isEmpty() || item<integersStack.peek()){
				integersStack.push(item);
			}else{
				System.out.println(integersStack.pop() +" = " +item );
				integersStack.push(item);
			}
		}
		int number = 0;
		while(!integersStack.isEmpty()){
			int item=integersStack.pop();
			if(number>item){
				System.out.println(item +" = " + number);
			}else{
				System.out.println(item +" = " + null);
			}
			number=item;
		}
		
	}
	 
	 
	
}
