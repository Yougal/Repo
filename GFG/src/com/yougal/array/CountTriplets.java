package com.yougal.array;

import java.util.Arrays;

public class CountTriplets {
	long countTriplets(long arr[], int n, int sum) {
		Arrays.sort(arr);
		int result=0;
		for(int i=0;i<arr.length;i++) {
			int low=i+1;
			int high=arr.length-1;
			while(low<high) {
				long temp = arr[i]+arr[low]+arr[high];
				if(temp>=sum) {
					high--;
				}else {
					result+=(high-low);
					low++;
				}
			}
		}
		return result;
	}
	
}
