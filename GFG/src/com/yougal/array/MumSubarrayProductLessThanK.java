package com.yougal.array;

/**
 * 
 * 
 * Given an array of integers nums and an integer k, return the number of
 * contiguous subarrays where the product of all the elements in the subarray is
 * strictly less than k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * nums = [10,5,2,6], k = 100 
 * Output: 8 
 * Explanation: The 8 subarrays that
 * have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6],
 * [5, 2, 6] Note that [10, 5, 2] is not included as the product of 100 is not
 * strictly less than k. Example 2:
 * 
 * Input: nums = [1,2,3], k = 0 
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 1 <= nums[i] <= 1000 0 <= k <= 106
 * 
 * @author yougal.bisht
 *
 */
public class MumSubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int prod=1;
		int count=0;
		int j=0;
		int countProd=0;
		for(int i=0;i<nums.length;i++) {
			prod=prod*nums[i];
			while(prod>=k && j<=i) {
				int div = prod/nums[j];
				prod=div<=0?1:div;
				count=count+countProd;
				countProd--;
				j++;
			}
			countProd++;
		}
		while(countProd>0) {
			prod=prod/nums[j];
			count=count+countProd;
			countProd--;
			j++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int nums[] = {10,5,2,6};int k = 100 ;
		MumSubarrayProductLessThanK lessThanK = new MumSubarrayProductLessThanK();
		System.out.println(lessThanK.numSubarrayProductLessThanK(nums, k));
		nums= new int[]{1,2,3};
		k = 0 ;
		System.out.println(lessThanK.numSubarrayProductLessThanK(nums, k));
		
		nums= new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		k=19;
		System.out.println(lessThanK.numSubarrayProductLessThanK(nums, k));
		
	}

}
