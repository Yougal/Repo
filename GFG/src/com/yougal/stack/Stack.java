package com.yougal.stack;

import java.util.Arrays;

public class Stack<T> {

	Object arr[] = null;
	int top=-1;
	int size;
	public Stack(int size){
		arr = new Object[size];
		this.size=size;
	}
	
	public void push(T element){
		if(!isFull()){
			top++;
			arr[top] =element;
		}
	}
	
	public boolean isFull() {
		return top==size-1;
	}
	
	
	public boolean isEmpty() {
		return top==-1;
	}

	@SuppressWarnings("unchecked")
	public T pop(){
		if(!isEmpty()){
			T element = (T)arr[top];
			arr[top]=null;
			top--;
			return element;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		if(!isEmpty()){
			return (T)arr[top];
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stack [arr=" + Arrays.toString(arr) + ", top=" + top + ", size=" + size + "]";
	}
	
	public static <T> Stack<T> createStack(T [] a){
		Stack<T> stack = new Stack<T>(a.length);
		for (T t : a) {
			stack.push(t);
		}
		return stack;
	}
	
	public void clear(){
		arr = new Object[size];
		top=-1;
	}
	
}
