package com.yougal.array;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
 * 
 * Given two integer arrays nums1 and nums2, return the maximum length of a
 * subarray that appears in both arrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7] 
 * Output: 3 
 * Explanation: The repeated subarray with maximum length is [3,2,1]. Example 2:
 * 
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0] 
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 1000 
 * 0 <= nums1[i],  nums2[i] <= 100
 * 
 * @author yougal.bisht
 *
 */
public class MaximumLengthRepeatedSubarray {
	public int findLength(int[] nums1, int[] nums2) {
		int maxRes = -1;
		int res[][] = new int[nums1.length+1][];
		for (int i = 0; i <=nums1.length; i++) {
			res[i] = new int[nums2.length+1];
			for (int j = 0; j <=nums2.length; j++) {
				if(i==0 || j==0 ) {
					res[i][j] = 0;
				}else {
					if (nums1[i-1] == nums2[j-1]) {
						res[i][j] = 1 + res[i-1][j-1];
					} else {
						res[i][j] =  Math.min(Math.min(res[i-1][j], res[i][j-1]),res[i-1][j-1]);
					}
					maxRes = Math.max(maxRes, res[i][j]);
				}
			}
		}
		return maxRes;
	}

	
	public static void main(String[] args) {
		MaximumLengthRepeatedSubarray maximumLengthRepeatedSubarray = new MaximumLengthRepeatedSubarray();
		int[] nums1= {0,0,0,0,0};
		int[] nums2= {0,0,0,0,0};
		System.out.println(maximumLengthRepeatedSubarray.findLength(nums1, nums2));
		nums1= new int[] {0,1,1,1,1};
		nums2= new int[] {1,0,1,0,1};
		System.out.println(maximumLengthRepeatedSubarray.findLength(nums1, nums2));
		nums1= new int[] {1,2,3,2,1};
		nums2= new int[] {3,2,1,4,7};
		System.out.println(maximumLengthRepeatedSubarray.findLength(nums1, nums2));
		
	}
}
