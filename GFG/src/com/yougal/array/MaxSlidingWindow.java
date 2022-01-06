package com.yougal.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 
 * 
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7] Explanation:
 * Window position 			Max 
 * --------------- 			----- 
 * [1 3 -1] -3 5 3 6 7 		3 
 * 1 [3 -1 -3] 5 3 6 7 		3 
 * 1 3 [-1 -3 5] 3 6 7 		5 
 * 1 3 -1 [-3 5 3] 6 7 		5 
 * 1 3 -1 -3 [5 3 6] 7 		6 
 * 1 3 -1 -3 5 [3 6 7] 		7 
 * 
 * Example 2:
 * Input: nums = [1], k = 1 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 
 * -104 <= nums[i] <= 104 
 * 1 <= k <= nums.length
 * 
 * @author yougal.bisht
 *
 */
public class MaxSlidingWindow {
	
	public static void main(String[] args) {
		MaxSlidingWindow msw = new MaxSlidingWindow();
		System.out.println(Arrays.toString(msw.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
		System.out.println(Arrays.toString(msw.maxSlidingWindow(new int[] {1,-1}, 1)));
		System.out.println(Arrays.toString(msw.maxSlidingWindow(new int[] {1,3,1,2,0,5},3)));
	}
	
	 public int[] maxSlidingWindow(int[] nums, int k) {
		   int result[] = new int[nums.length-k+1];
		   int startIndex=0;
	       Deque<Integer> dq = new ArrayDeque<Integer>();
	       for(int i=0;i<nums.length;i++) {
	    	  while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) {
	    		  dq.pollLast();
	    	  }
	    	  if(i-startIndex+1<k) {
	    		  dq.offerLast(i);
	    	  }else {
	    		 dq.offerLast(i);
	    		 int indexOfFront = dq.peekFirst();
	    		 if(i-indexOfFront+1>=k) {
	    			 result[i-k+1]=nums[dq.pollFirst()] ;
	    		 }else {
	    			 result[i-k+1]=nums[indexOfFront] ;
	    		 }
	    		 startIndex++;
	    	  }
	       }
	       return result;
	 }

}
