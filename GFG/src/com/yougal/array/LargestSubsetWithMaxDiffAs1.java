package com.yougal.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://www.geeksforgeeks.org/largest-subset-maximum-difference-1/
 * 
 * @author yougal.bisht
 *
 */
public class LargestSubsetWithMaxDiffAs1 {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 1, 2 };
		int size = sizeOfMaxArray(arr);
		System.out.println(size);
	}

	private static int sizeOfMaxArray(int[] arr) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}
		int max = 0;
		for (int i : map.keySet()) {
			int count = map.get(i);
			int countiM1 = map.getOrDefault(i-1, 0);
			int countiP1 = map.getOrDefault(i+1,0);
			max = Math.max(max, Math.max(countiM1, countiP1) + count);
		}
		return max;
	}
	
}
