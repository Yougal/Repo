package com.yougal.queues;

import java.util.LinkedList;

/**
 * 
 * 
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * 
 * 
 * Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k. If a window does not contain a negative interger, then print 0 for that window.

	Examples:
	
	Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
	Output : -8 0 -6 -6
	First negative integer for each window of size k
	{-8, 2} = -8
	{2, 3} = 0 (does not contain a negative integer)
	{3, -6} = -6
	{-6, 10} = -6
	
	Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
	Output : -1 -1 -7 -15 -15 0 
 * 
 * @author yougal.bisht
 *
 */
public class FirstNegativeNumberInKSizeWindow {

	public static void main(String[] args) {
		    int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		    int k = 3;
		    printFirstNegativeInteger(arr, k);
		}
	
	

	private static void printFirstNegativeInteger(int[] arr, int k) {
			LinkedList<Integer> deQueue = new LinkedList<>();
			
			for(int i=0;i<k && k<arr.length;i++) {
				if(arr[i]<0) {
					deQueue.add(i);
				}
			}
			
			int p =0;
			for(int i= k ;i<arr.length;i++) {
				if(deQueue.size()>0) {
					Integer index = deQueue.getFirst();
					System.out.println(arr[index]);
					if(p>=index) {
						deQueue.removeFirst();
					}
				}else {
					System.out.println("0");
				}
				if(arr[i]<0) {
					deQueue.add(i);
				}
				p++;
			}
			if(deQueue.size()>0) {
				System.out.println(arr[deQueue.getFirst()]);
			}else {
				System.out.println("0");
			}
	}
}
