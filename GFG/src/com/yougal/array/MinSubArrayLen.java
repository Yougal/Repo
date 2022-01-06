package com.yougal.array;

/***
 * 
 * 
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * @author yougal.bisht
 *
 */
public class MinSubArrayLen {

	public int minSubArrayLen(int target, int[] nums) {
		int sum=0;
		int countOfElement=0;
		int minCountOfElement=Integer.MAX_VALUE;
		int i=0;
		int j=0;
		while(i<nums.length) {
			sum+=nums[i];
			countOfElement++;
			while(sum-nums[j]>=target) {
				sum-=nums[j];
				j++;
				countOfElement--;
			}
			i++;
			if(sum>=target) {
				minCountOfElement=Math.min(minCountOfElement, countOfElement);
			}
		}
		if(sum>=target) {
			return minCountOfElement;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		MinSubArrayLen minSubArrayLen=new MinSubArrayLen();
		int target = 7, nums[] = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
		target = 4; nums = new int[]{1,4,4};
		System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
		target = 11; nums = new int[]{1,1,1,1,1,1,1,1};
		System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
		target =11; nums = new int[]{1,2,3,4,5};
		System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
	}
}
