package com.yougal.array;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
	
	
	public static void main(String[] args) {
		int a [] = {1, 101, 2, 3, 100, 4, 5};
		
		
		int temp[] =  new int[a.length];
		int maxValue=1;
		
		for (int i=0;i<a.length;i++){
			temp[i]=a[i];
		}
		
		for (int i=1;i<a.length;i++) {
			for (int j=0;j<i ;j++) {
				if( a[j]<a[i]){
					temp[i]=Math.max(temp[j]+a[i], temp[i]);
					maxValue = Math.max(maxValue, temp[i]);
				}
			}
			System.out.println(Arrays.toString(temp));
		}
		
		System.out.println(Arrays.toString(temp));
		System.out.println("Max Sum Subsequence in Sequence: " + maxValue);
			
	}

}
