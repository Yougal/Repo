package com.yougal.array;
/**
 * 
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * 
 * @author yougal.bisht
 *
 */
public class RemoveDuplicateElement {

	public static void main(String[] args) {
		int arr[] = {12, 1, 12, 3, 12, 1, 1, 2,2, 3, 3};
		int ones=0, twoes=0;
		for (int i = 0; i < arr.length; i++) {
			twoes  = twoes | (ones & arr[i]);
			ones = ones ^ arr[i];
			int common_bit_mask = ~(ones & twoes);
			ones=ones&common_bit_mask;
			twoes=twoes&common_bit_mask;
		}
		System.out.println(ones);
	}
	
}
