package com.yougal.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class KMostFrequentElement {

	public static void main(String[] args) {
		KMostFrequentElement kMostFrequentElement = new KMostFrequentElement();
		List<Integer> topKFrequent = kMostFrequentElement.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
		System.out.println(topKFrequent);
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.compareTo(o2)==0) {
					return 0;
				}
				return map.get(o1)-map.get(o2);
			}
		});
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        for (Entry<Integer,Integer> entry : map.entrySet()) {
			if(minHeap.size()<k) {
				minHeap.offer(entry.getKey());
			}else {
				if(map.get(minHeap.peek())<map.get(entry.getKey())) {
					minHeap.poll();
					minHeap.offer(entry.getKey());
				}
			}
		}
        
        return minHeap.stream().collect(Collectors.toList());
    }
	
}
