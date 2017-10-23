package com.yougal.stack;

public class KStack<T> {

	int nStacks;
	Object arr[];
	
	int top[];
	
	int next[];
	
	int nextAvaibleSlot;
	
	
	public KStack(int nStacks, int totalSize){
		this.nStacks=nStacks;
		this.arr = new Object[totalSize];
		this.top= new int[nStacks];
		this.next= new int[totalSize];
		for(int i=0;i<totalSize;i++){
			this.next[i] =i+1;
		}
		for (int i=0;i<nStacks;i++) {
			this.top[i] =-1;
		}
		this.next[totalSize-1]=-1;
		nextAvaibleSlot=0;
	}
	
	public void push(int stackId , T value){
		if(isFull()){
			System.out.println("Stack Overflow");
			return;
		}
		int index = nextAvaibleSlot;
		nextAvaibleSlot =  next[nextAvaibleSlot];
		next[index] = top[stackId];
		top[stackId] = index;
		arr[index] = value;
	}
	
	@SuppressWarnings("unchecked")
	public T pop(int stackId){
		if(!isEmpty(stackId)){
			int index  = top[stackId];
			top[stackId] = next[index];
			next[index] = nextAvaibleSlot;
			nextAvaibleSlot=index;
			T value = (T)arr[index];
			arr[index] =null;
			return value;
		}else{
			System.out.println("Stack Empty");
			return null;
		}
	}
	
	public boolean isFull(){
		return nextAvaibleSlot==-1;
	}
	
	public boolean isEmpty(int stackId ){
		return top[stackId]==-1;
	}
	
		public static void main(String args[]){
		    // Let us create 3 stacks in an array of size 10
		    int k = 3, n = 10;
		    KStack<Integer> ks=new KStack<Integer>(k, n);
		 
		    // Let us put some items in stack number 2
		    ks.push(2,15);
		    ks.push(2,45);
		 
		    // Let us put some items in stack number 1
		    ks.push(1,17);
		    ks.push(1,49);
		    ks.push(1,39);
		 
		    // Let us put some items in stack number 0
		    ks.push(0,11);
		    ks.push(0,9);
		    ks.push(0,7);
		 
		    System.out.println("Popped element from stack 2 is "+ks.pop(2));
		    System.out.println("Popped element from stack 1 is "+ks.pop(1));
		    System.out.println("Popped element from stack 0 is "+ks.pop(0));
			}
	
}
