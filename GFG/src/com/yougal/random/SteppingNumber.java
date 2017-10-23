package com.yougal.random;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumber {

	//Driver program to test above function
	public static void main(String[] args) {
	    int n = 0, m = 100;
	 
	    // Display Stepping Numbers in the
	    // range [n,m]
	    displaySteppingNumbers(n,m);
	 
	}
	private static void displaySteppingNumbers(int n, int m) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<9;i++ )
			queue.offer(i);
		while(!queue.isEmpty()){
			int number = queue.poll();
			if(number>=n && number<=m){
				System.out.printf("%d,",number);
			}else{
				break;
			}
			
			if(number==0){
				continue;
			}else{
				int lastDigit = number%10;
				if(lastDigit>1){
					int newNumber = number*10 + (lastDigit-1);
					queue.offer(newNumber);
				}
				
				if(lastDigit<9){
					int newNumber = number*10 + (lastDigit+1);
					queue.offer(newNumber);
				}
				
			}
		}
		
		
		
	}
	
}
