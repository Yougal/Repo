package com.yougal.array;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * 
 * @author yougal.bisht
 *
 */
public class LargestSubarrayOf01 {

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		LargestSubarrayOf01 sub = new LargestSubarrayOf01();
		int arr[] = { 1,0, 1, 1, 1, 0,0};
		int size = arr.length;

		sub.findSubArray(arr, size);
	}

	private void findSubArray(int[] a, int size) {
		int sumLeft[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if(a[i]==0){
				a[i]=-1;
			}
			if(i>0){
				sumLeft[i]=sumLeft[i-1]+a[i];
			}else{
				sumLeft[i]=a[i];
			}
		}
		
		
		Result maxValue =  new Result(-1, -1);
		for (int i = 0; i < sumLeft.length; i++) {
			if(sumLeft[i]==0){
				if(i>maxValue.endLoc){
					maxValue.maxSize=i-1;
					maxValue.endLoc=i;
				}
			}
		}
		Map<Integer,Result> map = new HashMap<>();
		for (int i = 0; i < sumLeft.length; i++) {
			int j = sumLeft[i];
			Result rs; 
			if(map.containsKey(j)){
				rs  = map.get(j);
				if(rs.maxSize < i-rs.endLoc){
					rs.maxSize=i-rs.endLoc;
					rs.endLoc=i;
				}
			}else{
				rs = new Result(1, i);
				map.put(j, rs);
			}
			if(rs.compareTo(maxValue)>0){
				maxValue=rs;
			}
		}
		if(maxValue.endLoc- maxValue.maxSize-1>=0){
			System.out.printf("startLoc: %d endLoc: %d",  maxValue.endLoc- maxValue.maxSize-1,maxValue.endLoc);
		}else{
			System.out.printf("No such subarray");
		}
		
		
	}
	
	static class Result implements Comparable<Result>{
		int maxSize = -1;
		int endLoc = -1;
		
		public Result(int maxSize, int endLoc) {
			super();
			this.maxSize = maxSize;
			this.endLoc = endLoc;
		}

		@Override
		public int compareTo(Result o) {
			if(o==null){
				return Integer.MAX_VALUE;
			}
			return this.maxSize - o.maxSize;
		}
	}

}
