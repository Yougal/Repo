package com.yougal.queues;
/**
 * 
 * 
 * Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
 * 
 * Examples:
 * 		Input: n = 2
 * 		Output: 1, 10
 * 		
 * 		Input: n = 5
 * 		Output: 1, 10, 11, 100, 101
 * 
 * @author yougal.bisht
 *
 */
public class BinaryNumbersUsingQueue {
	
	
	public static void main(String[] args) {
		int n=7;
		printNumbers(n);
	}

	private static void printNumbers(int n) {
		Queue<String> q = new Queue<String>(n);
		q.enqueue("1");
		while(n>0){
			System.out.println(q.peek());
			q.enqueue(q.peek()+"0");
			q.enqueue(q.peek()+"1");
			q.dequeue();
			n--;
		}
	}

}
