package com.yougal.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/
 * 
 * Given an integer array nums, return true if there exists a triple of indices
 * (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
 * indices exists, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5] Output: true Explanation: Any triplet where i < j <
 * k is valid. Example 2:
 * 
 * Input: nums = [5,4,3,2,1] Output: false Explanation: No triplet exists.
 * Example 3:
 * 
 * Input: nums = [2,1,5,0,4,6] Output: true Explanation: The triplet (3, 4, 5)
 * is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 105 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you implement a solution that runs in O(n) time complexity
 * and O(1) space complexity?
 * 
 * @author yougal.bisht
 *
 */
public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5};
		IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
		System.out.println(increasingTripletSubsequence.increasingTriplet(nums));
		nums= new int [] {5,4,3,2,1};
		System.out.println(increasingTripletSubsequence.increasingTriplet(nums));
		nums= new int [] {2,1,5,0,4,6};
		System.out.println(increasingTripletSubsequence.increasingTriplet(nums));
		nums= new int [] {20,100,10,12,5,13};
		System.out.println(increasingTripletSubsequence.increasingTriplet(nums));
		
		nums= new int [] {1,5,0,4,1,3};
		System.out.println(increasingTripletSubsequence.increasingTriplet(nums));
	}

	public boolean increasingTriplet(int[] nums) {
		int first=Integer.MAX_VALUE;
	      int second=Integer.MAX_VALUE;
		for(int num:nums){
	        if(num<=first){
	          first=num;
	        }else if(num<=second){
	          second=num;
	        }else{  //Think of first<second<num
	          return true;
	        }
	      }
		

		return false;
	}

}
