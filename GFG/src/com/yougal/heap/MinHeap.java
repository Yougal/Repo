package com.yougal.heap;

public class MinHeap extends Heap{
	
	public MinHeap(int sizeOfHeap) {
		super(sizeOfHeap);
	}

	public void reHeapify(int index){
		int parent = index/2;
		if(arr[index] < arr[parent]){
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
		int smallIndex = index;
		if(left<=elementCountInHeap && arr[left]<arr[smallIndex]){
			smallIndex = left;
		}
		if(right<=elementCountInHeap && arr[right] < arr[smallIndex]){
			smallIndex = right;
		}
		if(smallIndex!=index){
			int temp = arr[index];
			arr[index] = arr[smallIndex];
			arr[smallIndex] = temp;
			reHeapifyAfterDelete(smallIndex);
		}
		
	
		
	}
	
	
}
