package com.yougal.array;

import java.util.Arrays;

public class NumberOfTriangle {

	public static void main(String[] args) {
		int arr[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Total number of triangles is " +
                            findNumberOfTriangles(arr));
	}

	private static int findNumberOfTriangles(int[] arr) {
		Arrays.sort(arr);
		int count =0;
		for (int i = 0; i < arr.length-2; i++) {
			int k = i+2;
			for (int j = i+1; j < arr.length-1; j++) {
				while(k<arr.length && arr[i]+arr[j]>arr[k]){
					k++;
				}
				count+=(k-j-1);
			}
			
		}
		return count;
	}
	
}
