package com.yougal.queues;

import java.util.Arrays;

/**
 * 
 * circular implementation of queue using array
 * 
 * @author yougal.bisht
 *
 * @param <T>
 */
public class Queue<T> {
	
	T arr[];
	int capacity;
	int size;
	int front=-1;
	int rear=-1;
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity){
		arr = (T[])new Object[capacity];
		this.capacity = capacity;
	}
	
	public void enqueue(T element ){
		if(isFull()){
			return;
		}else{
			rear=(rear+1)%capacity;
			arr[rear]=element;
			if(front==-1){
				front=0;
			}
			size++;
		}
	}
	
	public T dequeue(){
		if(isEmpty()){
			return null;
		}else{
			T element = arr[front];
			arr[front] = null;
			front=(front+1)%capacity;
			if(front==rear){
				front=-1;
				rear=-1;
			}
			size--;
			return element;
		}
	}
	public T peek(){
		if(!isEmpty()){
			return arr[front];
		}else{
			return null;
		}
	}
	

	public boolean isEmpty() {
		return front==-1 && rear==-1;
	}

	public boolean isFull() {
		return (rear+1)%capacity==front;
	}
	
	@SuppressWarnings("unchecked")
	public void clear(){
		arr = (T[])new Object[capacity];
		front=-1;
		rear=-1;
	}
	
	public int size(){
		return this.size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Queue [arr=" + Arrays.toString(arr) + ", front=" + front + ", rear=" + rear + "]";
	}

}
