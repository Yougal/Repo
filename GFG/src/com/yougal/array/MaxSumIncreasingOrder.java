package com.yougal.array;

import java.util.Arrays;
/**
 * 
 * https://www.geeksforgeeks.org/maximum-sum-increasing-order-elements-n-arrays/
 * 
 * 
 * @author yougal.bisht
 *
 */
public class MaxSumIncreasingOrder {

	
	public static void main(String[] args) {
		int arr1[][] = {{1, 7, 3, 4},
                {4, 2, 5, 1},
                {9, 5, 1, 8}};
		int arr2[][] = {{9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}};
		System.out.println(maximumSum(arr1, arr1.length));
		System.out.println(maximumSum(arr2, arr2.length));
	}

	private static int maximumSum(int[][] arr, int n) {
		int prev = findMaximumLessThan(arr[n-1],Integer.MAX_VALUE);
		int sum = prev;
		for(int i=n-2;i>=0;i--) {
			int result = findMaximumLessThan(arr[i], prev);
			if(result==-1) {
				return 0;
			}else {
				prev =result;
			}
			sum+=prev;
		}
		return sum;
	}

	private static int findMaximumLessThan(int[] arr, int lessThan) {
		return Arrays.stream(arr).reduce(-1, (int x, int y )-> {
			if(y<lessThan) {
				if(x>y) {
					return x;
				}else {
					return y;
				}
			}else {
				return x;
			}
		});
	}
	
}
