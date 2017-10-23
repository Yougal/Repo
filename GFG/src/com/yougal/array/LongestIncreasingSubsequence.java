package com.yougal.array;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	
	public static void main(String[] args) {
		int a [] = {3,4,-1,0,6,2,3};
		
		
		int temp[] =  new int[a.length];
		int maxValue=1;
		Arrays.fill(temp, 1);
		for (int i=1;i<a.length;i++) {
			for (int j=0;j<i ;j++) {
				if( a[j]<a[i]){
					temp[i]=Math.max(temp[j]+1, temp[i]);
					maxValue = Math.max(maxValue, temp[i]);
				}
			}
		}
		
		System.out.println(Arrays.toString(temp));
		System.out.println("Max Length Of Sequence: " + maxValue);
			
	}

}
