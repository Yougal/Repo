package com.yougal.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.
 * Input:
 * 		The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Next line of each test contains N space seperated integers denoting the elements of the array.
 * Output:
 * 		For each test case output a single line containing the required sum.
 * Constraints:
 * 			1<=T<=100
 * 			1<=N<=50
 * Example:
 * 
 * Input
 * 
 * 2
 * 6
 * 6 8 4 5 2 3
 * 5
 * 5 3 0 7 4
 * 
 * Output
 * 
 * 604
 * 82
 * 
 * Explanation:
 * 
 * Test Case 1-
 * 
 * The minimum sum is formed by numbers 
 * 358 and 246
 * 
 * Test Case 2 -
 * 
 * The minimum sum is formed by numbers 
 * 35 and 047
 * 
 * <a href="http://www.practice.geeksforgeeks.org/problem-page.php?pid=1530">Problem Link</a>
 * 
 * @author yougal.bisht
 *
 */
public class MinSumFormedByDigits {

	public static void main(String[] args) {
		ArrayList<Input> inputList = new ArrayList<Input>(2);
		inputList.add(new Input(6,new int[]{6, 8, 4, 5, 2, 3}));
		inputList.add(new Input(5,new int[]{5, 3, 0, 7, 4}));
//		Scanner sc = new Scanner(System.in);
//		int numberOfInput  = Integer.valueOf(sc.nextInt());
//		ArrayList<Input> inputList = new ArrayList<Input>(numberOfInput);
//		for (int i=0;i<numberOfInput;i++) {
//			int sizeOfArray  = Integer.valueOf(sc.nextInt());
//			int[] arr = new int[sizeOfArray];
//			Input input = new Input(sizeOfArray, arr);
//			for (int j = 0; j < sizeOfArray; j++) {
//				arr[j] =  sc.nextInt();
//			}
//			inputList.add(input);
//		}
//		sc.close();
		
		findMinSumOfNumbers(inputList);
		for (Input input : inputList) {
			System.out.println(input);	
		}
		
			
	}

	private static void findMinSumOfNumbers(ArrayList<Input> inputList) {
		
		for (Input input : inputList) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(input.size);
			for (int i=0;i<input.size;i++) {
				minHeap.add(input.arr[i]);
			}
			int number1 = 0;
			int number2 = 0;
			
			while(!minHeap.isEmpty()){
				int element = minHeap.remove();
				if(number1*10 + element > number2*10+element){
					number2 = number2*10+element;
				}else{
					number1 = number1*10+element;
				}
			}
			input.number1=number1;
			input.number2=number2;
	
		}
	}
	
	static class Input{
		int size;
		int arr[];
		public Input(int size, int[] arr) {
			super();
			this.size = size;
			this.arr = arr;
		}
		
		int number1;
		int number2;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(number1+number2);
		}
		
	}
}
