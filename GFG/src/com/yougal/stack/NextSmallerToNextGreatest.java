package com.yougal.stack;

import java.util.Arrays;

/**
 * 
 * Find next Smaller of next Greater in an array
	Given array of integer, find the next smaller of next greater element of every element in array.
	
	Note : Elements for which no greater element exists or no smaller of greater element exist, print -1.
	
	Examples:
	
	Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
	Output:          2  2 -1  1 -1 -1 -1
	Explanation :  
	Next Greater ->      Right Smaller 
	   5 ->  9             9 ->  2 
	   1 ->  9             9 ->  2
	   9 -> -1            -1 -> -1
	   2 ->  5             5 ->  1
	   5 ->  7             7 -> -1
	   1 ->  7             7 -> -1
	   7 -> -1            -1 -> -1 
	
	Input  : arr[] = {4, 8, 2, 1, 9, 5, 6, 3}
	Output :          2  5  5  5 -1  3 -1 -1 
 * 
 * 
 * @author yougal.bisht
 *
 */
public class NextSmallerToNextGreatest {

	public static void main(String[] args) {
		int arr[] = {4, 8, 2, 1, 9, 5, 6, 3};
		findNSToNG(arr);
	}
	
	static int [] findNSToNG(int arr[]){
		
		Stack<Integer> stk = new Stack<Integer>(arr.length);
		int ng[] = new int[arr.length];
		int ns[] = new int[arr.length];
		Arrays.fill(ng, -1);
		Arrays.fill(ns, -1);
		for (int i=0;i<arr.length;i++) {
			if(stk.isEmpty()){
				stk.push(i);
			}else{
				int top = arr[stk.peek()];
				int ele = arr[i];
				if(ele<top){
					stk.push(i);
				}else{
					while(!stk.isEmpty() && arr[stk.peek()]<ele){
						ng[stk.peek()] = i;
						stk.pop();
					}
					stk.push(i);
				}
			}
		}
		
		stk.clear();
		for (int i=0;i<ng.length;i++) {
			if(ng[i]==-1){
				ns[i]=-1;
			}else{
				for(int j = ng[i]; j<arr.length;j++){
					if(arr[j]<arr[ng[i]]){
						ns[i]=j;
						break;
					}
				}
			}
		}
		
		
		for (int i : ns) {
			if(i<0){
				System.out.println(i);
			}else{
				System.out.println(arr[i]);
			}
		}
		return null;
	}
	
	
}
