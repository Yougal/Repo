package com.yougal.array;

import java.util.Arrays;
/**
 * 
 * 
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * @author yougal.bisht
 *
 */
public class MinNumberOfJump {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJumps(arr));
	}

	private static int minJumps(int[] arr) {
		int jump[] = new int[arr.length];
		Arrays.fill(jump, Integer.MAX_VALUE);
		jump[0]=0;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(i<=j+arr[j]){
					jump[i]=Math.min(jump[i], jump[j]+1);
				}
			}
		}
		System.out.println(Arrays.toString(jump));
		return jump[arr.length-1];
	}
	
}
