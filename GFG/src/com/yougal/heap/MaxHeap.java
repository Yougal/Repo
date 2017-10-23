package com.yougal.heap;

public class MaxHeap extends Heap {



	public MaxHeap(int sizeOfHeap) {
		super(sizeOfHeap);
	}

	public void reHeapify(int index){
		int parent = index/2;
		if(arr[index] > arr[parent]){
			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
			reHeapify(parent);
		}
	}
		
	@Override
	protected void reHeapifyAfterDelete(int index) {
		int left = (2*index+1);
		int right = (2*index+2);
		int largestIndex = index;
		if(left<=elementCountInHeap && arr[left]>arr[largestIndex]){
			largestIndex = left;
		}
		if(right<=elementCountInHeap && arr[right] > arr[largestIndex]){
			largestIndex = right;
		}
		if(largestIndex!=index){
			int temp = arr[index];
			arr[index] = arr[largestIndex];
			arr[largestIndex] = temp;
			reHeapifyAfterDelete(largestIndex);
		}
		
	}
	
	

}
