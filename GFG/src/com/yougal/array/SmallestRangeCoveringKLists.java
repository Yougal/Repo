package com.yougal.array;

import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 
 * 
 * http://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
 *  Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. 
 *  If more than one smallest ranges are found, print any one of them.

	Example :
	
	Input:
	K = 3
	arr1[] : [4, 7, 9, 12, 15]
	arr2[] : [0, 8, 10, 14, 20]
	arr3[] : [6, 12, 16, 30, 50]
	Output:
	The smallest range is [6 8] 
	Explanation: Smallest range is formed by 
	number 7 from first list, 8 from second
	list and 6 from third list.
	
	
	Input: 
	k = 3
	arr1[] : [4, 7]
	arr2[] : [1, 2]
	arr3[] : [20, 40]
	
	The smallest range is [2 20]  
 * 
 * @author yougal.bisht
 *
 */
public class SmallestRangeCoveringKLists {

	public static void main(String[] args) {
		int arr[][] = {
		                {4, 7, 9, 12, 15},
		                {0, 8, 10, 14, 20},
		                {6, 12, 16, 30, 50}
					  };
		
		int k = arr.length;
		SmallestRangeCoveringKLists srcl = new SmallestRangeCoveringKLists();
		srcl.findSmallestRange(arr,k);
	}

	private void findSmallestRange(int[][] arr, int k) {
		int index[] = new int [k];
		PriorityQueue<Entry<Integer,Integer>> heapMin = new PriorityQueue<Entry<Integer,Integer>>(k,(c1,c2)->{
				return c1.getValue()-c2.getValue();
		});
		int max = Integer.MIN_VALUE;
		for(int i =0;i<k;i++){
			heapMin.add(new AbstractMap.SimpleEntry<Integer,Integer>(i, arr[i][0]));
			index[i]=0;
			max = Math.max(max, arr[i][0]);
		}
		int minArray = -1;
		Range minRange =null;
		do{
			Entry<Integer,Integer> ele = heapMin.remove();
			minArray = ele.getKey();
			int minElement = ele.getValue();
			Range range = new Range(minElement, max);
			if(minRange==null){
				minRange= range;
			}
			if(range.compareTo(minRange)<0){
				minRange=range;
			}
			index[minArray]=index[minArray]+1;
			if(index[minArray]<arr[minArray].length){
				heapMin.add(new AbstractMap.SimpleEntry<Integer,Integer>(minArray, arr[minArray][index[minArray]]));
				max = Math.max(max, arr[minArray][index[minArray]]);
				
			}else{
				break;
			}
			
		}while(true);
		System.out.println("Range: " + minRange);
	}
	
	private static class Range implements Comparable<Range> {

		int min;

		int max;
		
		public Range(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		
		@Override
		public int compareTo(Range o) {
			return (this.max-this.min) - (o.max-o.min);
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Range [min=" + min + ", max=" + max + "]";
		}
		
	}
	
}
