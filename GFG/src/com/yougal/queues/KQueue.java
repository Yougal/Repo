package com.yougal.queues;

public class KQueue<T> {

	int nQueue;
	Object arr[];
	
	int front[];
	int rear[];
	
	int next[];
	
	int nextAvaibleSlot;
	
	
	public KQueue(int nQueue, int totalSize){
		this.nQueue=nQueue;
		this.arr = new Object[totalSize];
		this.front= new int[nQueue];
		this.rear= new int[nQueue];
		this.next= new int[totalSize];
		for(int i=0;i<totalSize;i++){
			this.next[i] =i+1;
		}
		for (int i=0;i<nQueue;i++) {
			this.front[i] =-1;
		}
		for (int i=0;i<nQueue;i++) {
			this.rear[i] =0;
		}
		this.next[totalSize-1]=-1;
		nextAvaibleSlot=0;
	}
	
	public void enqueue(T value,int queueId ){
		if(isFull()){
			System.out.println("Stack Overflow");
			return;
		}
		int index = nextAvaibleSlot;
		if(front[queueId]==-1){
			front[queueId] = index;
		}
		nextAvaibleSlot =  next[nextAvaibleSlot];
		next[index] = rear[queueId];
		rear[queueId] = index;
		arr[index] = value;
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue(int queueId){
		if(!isEmpty(queueId)){
			int index  = front[queueId];
			front[queueId] = next[index];
			next[index] = nextAvaibleSlot;
			nextAvaibleSlot=index;
			T value = (T)arr[index];
			arr[index] =null;
			return value;
		}else{
			System.out.println("queue Empty");
			return null;
		}
	}
	
	public boolean isFull(){
		return nextAvaibleSlot==-1;
	}
	
	public boolean isEmpty(int queueId ){
		return front[queueId]==-1;
	}
	
		public static void main(String args[]){
			int k = 3, n = 10;
			KQueue<Integer> ks  =  new KQueue<Integer>(k, n);
		 
		    // Let us put some items in queue number 2
		    ks.enqueue(15, 2);
		    ks.enqueue(45, 2);
		 
		    // Let us put some items in queue number 1
		    ks.enqueue(17, 1);
		    ks.enqueue(49, 1);
		    ks.enqueue(39, 1);
		 
		    // Let us put some items in queue number 0
		    ks.enqueue(11, 0);
		    ks.enqueue(9, 0);
		    ks.enqueue(7, 0);
		 
		    System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
		    System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
		    System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0));
		}
	
}
