package com.yougal.heap;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		int mat[][] = { 
				{10, 20, 30, 40}, 
                {15, 25, 35, 45}, 
                {25, 29, 37, 48}, 
                {32, 33, 39, 50}, 
              }; 
		System.out.println(kthSmallest(mat, 7)); 
	}

	private static int kthSmallest(int[][] mat, int k) {
		PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue<Entry<Integer,Integer>>(new Comparator<Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
				
				return mat[o1.getKey()][o1.getValue()] - mat[o2.getKey()][o2.getValue()];
			}
		});
		for(int i=0;i<mat[0].length;i++) {
			minHeap.offer(new SimpleImmutableEntry<Integer,Integer>(0,i));
		}
		while(k>1) {
			Entry<Integer, Integer> peek = minHeap.poll();
			if(peek.getKey()+1<mat[0].length) {
				minHeap.offer(new SimpleImmutableEntry<Integer,Integer>(peek.getKey()+1,peek.getValue()));
			}
			k--;
		}
		Entry<Integer, Integer> peek = minHeap.peek();
		return mat[peek.getKey()][peek.getValue()];
	}
	
}
