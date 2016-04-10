package com.yougal;

import java.util.Arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
 * The functions should put all 0s first, then all 1s and all 2s in last. 
 * Example
 * 		Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 * 		Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 * @author yougal.bisht
 *
 */
public class SortAnArrayZeroOneTwo {

	
	public static void main(String[] args) {
		int arr[] = {0, 1, 1, 0, 1, 2, 0, 2, 0, 0, 0, 1};
		int left = 0;
		int right = arr.length-1;
		int mid = (left+right)/2;
		sortArray(arr,left,mid,right);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(int[] arr, int left, int mid, int right) {
		while(left<right && mid<=right){
			while(arr[left]==0){
				left++;
			}
			while(arr[right]==2){
				right--;
			}
			if(left<right){
				switch(arr[mid]){
					case 0:
							if(arr[left]==1){
								swap(arr, left, mid);
								left++;
							}else if(arr[left]==2){
								swap(arr, left, mid);
								left++;
							}
							break;
							
					case 1:
							mid++;
							break;

					case 2:
							if(arr[right]==1){
								swap(arr, right, mid);
								right--;
							}else if(arr[right]==0){
								swap(arr, right, mid);
								right--;
							}
						break;
						
				}
			}
		}
		
	}

	private static void swap(int[] arr, int to, int from) {
		int temp = arr[to];
		arr[to] = arr[from];
		arr[from] = temp;
	}
}
