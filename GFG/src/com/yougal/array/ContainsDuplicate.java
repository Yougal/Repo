package com.yougal.array;

import java.util.TreeSet;

public class ContainsDuplicate {

	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<nums.length;i++) {
        	if(i>k) {
        		treeSet.remove(nums[i-k-1]);
        	}
        	
        	if(!treeSet.add(nums[i])) {
        		return true;
        	}
        	
        	 Integer left = treeSet.lower(nums[i]);
             if(left != null && Math.abs((long) left - nums[i]) <= t){
                 return true;
             }
             Integer right = treeSet.higher(nums[i]);
             if(right != null && Math.abs((long) right - nums[i]) <= t){
                 return true;
             }
        }
        return false;
    }
	
}
