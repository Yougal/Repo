package com.yougal.heap;

import java.util.Arrays;

public class HeapTest {

	public static void main(String[] args) {
		MinHeap mh = new MinHeap(10);
		int arr[] =  {1,4,2,16,14,10,9,3,7,8};
		for (int i = 0; i < arr.length; i++) {
			mh.addItem(arr[i]);
			
		}
		System.out.println(Arrays.toString(mh.arr));
		
		while(!mh.isEmpty()){
			System.out.println(mh.removeItem());
		}
	}
	
}
