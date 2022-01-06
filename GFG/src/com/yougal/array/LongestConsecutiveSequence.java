package com.yougal.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * @author yougal.bisht
 *
 */
public class LongestConsecutiveSequence {
	
	  public int longestConsecutive(int[] nums) {
		  Map<Integer, Integer> counts = new HashMap<>();
	      for (int i = 0; i < nums.length; i++) {
	    	int num= nums[i];
			counts.put(num, 1);
	      }
	      int maxCount=0;
		  for(int i=0;i<nums.length && !counts.isEmpty();i++) {
			  int num= nums[i];
			  if(counts.containsKey(num)) {
				  int count =counts.get(num);
			  	  while(counts.containsKey(--num)) {
			  		count+=counts.get(num);
			  		counts.remove(num);
			  		}
			  		maxCount=maxCount>count?maxCount:count;
			  		counts.put(nums[i], count);
			  }
		  }
		  return maxCount;
	  }
	  
	  public static void main(String[] args) {
		  LongestConsecutiveSequence consecutiveSequence = new LongestConsecutiveSequence();
		System.out.println(consecutiveSequence.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
	}
	
	

}
