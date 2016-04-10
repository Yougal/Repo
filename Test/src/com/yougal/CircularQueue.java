package com.yougal;

import java.util.Arrays;
import java.util.Scanner;

public class CircularQueue {
	Object arr[];
	int maxSize = 0;
	int front = 0;
	int rear =-1;
	public CircularQueue(int maxSize){
		this.maxSize = maxSize;
		this.arr = new Object[maxSize];
	}
	
	public boolean isFull(){
		return false;
	}
	public boolean isEmpty(){
		return false;
	}
	
	public boolean offer(Object obj){
		if(front==0 && rear==maxSize ||
				((rear+1)%maxSize == front && rear!=-1)
				){
			return false;
		}
		rear=(rear+1)%maxSize;
		arr[rear] = obj;
		return true;
	}
	
	public Object take(){
		if(rear==-1 && front==0){
			return null;
		}
		if(front==rear){
			Object obj = arr[front];
			rear=-1;
			front=0;
			arr[front] = null;
			return obj;
		}else{
			Object obj = arr[front];
			arr[front] = null;
			front=(front+1)%maxSize;
			return obj;
		}
		
	}
	
	public void display() {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
	    int ch;
	    System.out.println("Circular Queue operations");
	    System.out.println("1.insert\n2.delete\n3.display\n4.exit\n");
	    Scanner scanner = new Scanner(System.in);
	    CircularQueue circularQueue = new CircularQueue(5);
	    int i=0;
	    while(true)
	    {
	        System.out.print("Enter your choice: ");
	      
	        ch= scanner.nextInt();
	        switch(ch)
	        {
	        case 1: circularQueue.offer(i++);
	        		break;
	        case 2: circularQueue.take();
	            	break;
	        case 3: circularQueue.display();
	            	break;
	        case 4: scanner.close();
	        		System.exit(0);
	        default: System.out.println("Invalid option");
	        }
	    }
	}

}
