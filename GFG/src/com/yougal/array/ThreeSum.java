package com.yougal.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * 
 * Input: nums = [] Output: [] Example 3:
 * 
 * Input: nums = [0] Output: []
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 3000 -105 <= nums[i] <= 105
 * 
 * @author yougal.bisht
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		ThreeSum ts = new ThreeSum();
		System.out.println(ts.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// if a is duplicate, skip that value
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			// fixed the a, now will search for b & c from (i+1) index to (nums.length-1)
			// index
			int a = nums[i];
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = a + nums[start] + nums[end];
				if (sum > 0) {
					end--;
				} else if (sum < 0) {
					start++;
				} else {
					result.add(Arrays.asList(a, nums[start], nums[end]));
					// if b value is duplicate skip that
					while (start < end && nums[start] == nums[start + 1])
						start++;
					// if c value is duplicate, skip that
					while (start < end && nums[end] == nums[end - 1])
						end--;
					start++;
					end--;
				}
			}
		}
		return result;
	}

}
