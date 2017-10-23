package com.yougal.array;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * 
 * @author yougal.bisht
 *
 */
public class ZigZagArray {

	public static void main(String[] args) {
		int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		convertToZigZag(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void convertToZigZag(int[] arr) {
		boolean toggle=false;
		for (int i = 0; i < arr.length-1; i++) {
			if(toggle){
				if(arr[i]>arr[i+1]){
					int a = arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=a;
				}
			}else{
				if(arr[i]<arr[i+1]){
					int a = arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=a;
				}
			}
			toggle=!toggle;
		}
		
	}
	
}
