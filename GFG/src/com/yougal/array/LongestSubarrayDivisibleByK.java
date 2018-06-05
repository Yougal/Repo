package com.yougal.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k/0
 * 
 * Given an array containing N integers and a positive integer K. 
 * The task is to find the length of the longest sub array with sum of the elements divisible by the given value K.
 * 
 * Input:
 * 		The first line of input contains an integer T denoting the number of test cases. 
 * 		Then T test cases follow. Each test case consists of two lines. 
 * 		First line of each test case contains two Integers N and K and the second line contains N space separated elements.
 * 
 * Output:
 * 		For each test case, print the required longest sub array length in new line.
 * 
 * Constraints:
 * 		1<=T<=100
 * 		1<=N,K<=106
 * 	   -105<=A[i]<=105
 * Example:
 * 		Input:
 * 				2
 * 				
 * 				6 3
 * 				2 7 6 1 4 5
 * 
 * 				7 3
 * 			   -2 2 -5 12 -11 -1 7
 * 		Output:
 * 				4
 * 				5
 * Explanation:
 * 		Input 	: A[] = {2, 7, 6, 1, 4, 5}, K = 3
 * 		Output 	: 4
 * 		The sub array is {7, 6, 1, 4} with sum 18, which is divisible by 3.
 * 
 * @author yougal.bisht
 *
 */
public class LongestSubarrayDivisibleByK {

	
	public static void main(String[] args) {
		LongestSubarrayDivisibleByK byK = new LongestSubarrayDivisibleByK();
		/*Scanner sc = new Scanner(System.in);
		int numberOfInput  = Integer.valueOf(sc.nextLine());
		while (numberOfInput>0) {
			int lengthInputArray = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[lengthInputArray];
			int i = 0;
			while(i<lengthInputArray) {
				arr[i]=sc.nextInt();
				i++;
			}
			numberOfInput--;
			int maxLength = byK.findMaxSizeArrayDivisibleByK(arr, k);
			System.out.println(maxLength);
		}
		sc.close();*/
		int arr[] = {2, 7, 6, 1, 4, 5};
	    int k = 3;
		int maxLength = byK.findMaxSizeArrayDivisibleByK(arr, k);
		System.out.println(maxLength);
	}
	
	int findMaxSizeArrayDivisibleByK(int arr[], int k){
	    Map<Integer, Integer> um=new HashMap<>();
	     
	    int mod_arr[] = new int[arr.length], max = 0;
	    int curr_sum = 0;
	     
	    for (int i = 0; i < arr.length; i++) {
	        curr_sum += arr[i];
	        mod_arr[i] = curr_sum % k;        
	    }    
	     
	    for (int i = 0; i < arr.length; i++){
	        if (mod_arr[i] == 0)
	            max = i + 1;
	         
	        else if (!um.containsKey(mod_arr[i]))
	            um.put(mod_arr[i],i);
	             
	        else
	            if (max < (i - um.get(mod_arr[i]))) {
	                max = i - um.get(mod_arr[i]);
	            }
	    }
	     
	    return max;
	}   
	
}
