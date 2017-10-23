package com.yougal.heap;

public abstract class Heap {

	Integer arr[];
	
	int sizeOfHeap;
	
	/**
	 * show value +1 
	 */
	protected int elementCountInHeap=-1;
	
	public Heap(int sizeOfHeap){
		this.sizeOfHeap = sizeOfHeap;
		this.arr = new Integer[sizeOfHeap];
	}
	
	public void addItem(int element){
		if(elementCountInHeap+1>sizeOfHeap){
			return;
		}else{
			elementCountInHeap++;
			arr[elementCountInHeap] = element;
			reHeapify(elementCountInHeap);
		}
	}
	
	public int removeItem(){
		if(isEmpty()){
			return -1;
		}else{
			int element = arr[0];
			int lastElementIndex = elementCountInHeap;
			elementCountInHeap--;
			if(elementCountInHeap>=0){
				arr[0]=arr[lastElementIndex];
				reHeapifyAfterDelete(0);
				arr[lastElementIndex] = null;
			}
			return element;
		}
	}

	protected abstract void reHeapify(int index);
	
	protected abstract void reHeapifyAfterDelete(int index);
	
	
	public boolean isEmpty(){
		return elementCountInHeap<0;
	}
}
