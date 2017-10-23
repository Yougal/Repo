package com.yougal.queues;

import java.util.ArrayDeque;

/**
 * 
 * Sum of minimum and maximum elements of all subarrays of size k.
 * 
 * Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
 * 
 * Examples:
 * 			Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
 * 					K = 4
 * 			Output : 18
 * 
 * Explanation : 
 * 			Subarrays of size 4 are : 
 * 						{2, 5, -1, 7},   min + max = -1 + 7 = 6
 * 						{5, -1, 7, -3},  min + max = -3 + 7 = 4      
 * 						{-1, 7, -3, -1}, min + max = -3 + 7 = 4
 * 						{7, -3, -1, -2}, min + max = -3 + 7 = 4   
 * 			Sum of all min & max = 6 + 4 + 4 + 4 = 18               
 * 
 * 
 * <a href="http://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/">Problem Link</a>
 * 
 * @author yougal.bisht
 *
 */
public class SumMaxMinElementInArraySizeK {

	
	public static void main(String[] args) {
		
		int arr[] =  {2, 5, -1, 7, -3, -1, -2} ;
		int k =4;
		int result= evaluateResult(arr, k);
		System.out.println(result);		
	}

	private static int evaluateResult(int[] arr, int k) {
		
		int sumMin =0;
		int sumMax =0;
		
		if(arr.length<k){
			return 0;
		}else{
			ArrayDeque<Integer> maxElementIndexDequeue = new ArrayDeque<Integer>();
			ArrayDeque<Integer> minElementIndexDequeue = new ArrayDeque<Integer>();
			for(int i=0;i<k;i++){
				while(!maxElementIndexDequeue.isEmpty() && arr[maxElementIndexDequeue.peekLast()] < arr[i]){
					maxElementIndexDequeue.removeLast();
				}
				maxElementIndexDequeue.addLast(i);
				
				while(!minElementIndexDequeue.isEmpty() && arr[minElementIndexDequeue.peekLast()] > arr[i]){
					minElementIndexDequeue.removeLast();
				}
				minElementIndexDequeue.addLast(i);
			}
			
			for(int i=k;i<arr.length;i++){
				int maxElementK = arr[maxElementIndexDequeue.peekFirst()];
				int minElementK = arr[minElementIndexDequeue.peekFirst()];
				//System.out.println("Element -> " + minElementK + "  --  " + maxElementK);
				sumMin+= minElementK;
				sumMax+= maxElementK;
				
				while(!maxElementIndexDequeue.isEmpty() && maxElementIndexDequeue.peekFirst() <=i-k){
					maxElementIndexDequeue.removeFirst();
				}
				
				while(!maxElementIndexDequeue.isEmpty() && arr[maxElementIndexDequeue.peekLast()] < arr[i]){
					maxElementIndexDequeue.removeLast();
				}
				maxElementIndexDequeue.addLast(i);
				
				while(!minElementIndexDequeue.isEmpty() && minElementIndexDequeue.peekLast() <=i-k){
					minElementIndexDequeue.removeLast();
				}
				
				while(!minElementIndexDequeue.isEmpty() && arr[minElementIndexDequeue.peekLast()] > arr[i]){
					minElementIndexDequeue.removeLast();
				}
				minElementIndexDequeue.addLast(i);
			}
			int maxElementK = arr[maxElementIndexDequeue.peekFirst()];
			int minElementK = arr[minElementIndexDequeue.peekFirst()];
			//System.out.println("Element -> " + minElementK + "  --  " + maxElementK);
			sumMin+= minElementK;
			sumMax+= maxElementK;
			
		}
		
		
		return sumMax+sumMin;
	}
}
