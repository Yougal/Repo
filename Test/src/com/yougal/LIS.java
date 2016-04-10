package com.yougal;

import java.util.ArrayList;


/**
 * 
 * 
 * 
 *  Given a sequence, find the length of the longest subsequence of a given sequence .
 *  The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest
 *  to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 *  For example:
 *  length of LIS for 
 *  { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * 
 * 
 * @author yougal.bisht
 *
 */
public class LIS {

	public static void main(String[] args) {
		int arr1[] = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int arr2[] = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	
		System.out.println(LIS.bruteForce(arr1));
		System.out.println(LIS.bruteForce(arr2));
		optimizedSolution(arr1);
	}
	
	private static int bruteForce(int[] arr) {
		int maxSize =0;
		for(int i=0;i<arr.length;i++){
			int _maxSize = _bruteForce(arr, i+1,arr[i]);
			if(maxSize<_maxSize+1){
				maxSize = _maxSize+1;
			}
		}
		return maxSize;
	}

	static int  _bruteForce(int arr[], int j, int element){
		if (j<arr.length){
			int sizeWith =0;
			if(element<arr[j] ){
				sizeWith = 1 + _bruteForce(arr, j+1, arr[j]);
			}
			int sizeWithout = _bruteForce(arr, j+1,element);
			if(sizeWith<sizeWithout){
				return sizeWithout;
			}
			else{
				return sizeWith;
			}
		
		}else{
			return 0;
		}
	}
	
	public static void optimizedSolution(int arr[]){
		/**
		 * stores the sequence elements in increasing order. Cannot be final sequence
		 */
		ArrayList<Integer> sequence=new ArrayList<Integer>();
		/**
		 * 
		 * stores the parent of each element ie one code runs fine, you will traverse this array from the last element in above array
		 * 
		 */
		int parent[]= new int [arr.length];
		int lastElementIndex =-1;
		for (int i=0;i<arr.length;i++) {
			Integer element = arr[i];
			int loc = findLocationToPut(element , sequence);
			if(loc==sequence.size()){
				lastElementIndex=i;
			}
			sequence.add(loc,element);
			parent[i]=loc-1;
		}
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		while (lastElementIndex!=-1) {
			resultArrayList.add(sequence.get(lastElementIndex));
			lastElementIndex = parent[lastElementIndex];
		}
		for (int j=resultArrayList.size()-1;j>=0;j--) {
			System.out.print(resultArrayList.get(j) + ", ");
		}
		
		
	}

	private static int findLocationToPut(int element, ArrayList<Integer> sequence) {
		int mid =0;
		int low = -1;
		int high = sequence.size()-1;
		if(sequence.size()==0){
			return mid;	
		}else{
			if(sequence.get(high)<element){
				return sequence.size();
			}
			while(high-low>1){
				mid=(low+high)/2;
				if(sequence.get(mid)<element){
					low=mid;
				}else{
					high=mid;
				}
			}
		}
		return high;
	}
	
	
	
	
	
}
