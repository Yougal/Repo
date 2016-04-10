package com.yougal.thread;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {
	
	LinkedList<Integer>  queue = new LinkedList<Integer>();
	
	public static final int MAX_LIMIT=10;
	
	private Object lock = new Object();
	
	public void produce() throws InterruptedException{
		Random random = new Random();
		int value=0;
		while(true){
			synchronized (lock) {
				if(queue.size() == MAX_LIMIT){
					lock.wait();
				}else{
					queue.add(value++);
					lock.notify();
				}
			}
			Thread.sleep(random.nextInt(1000));
		}
	}
	
	public void consume() throws InterruptedException{
		Random random = new Random();
		while(true){
			synchronized (lock) {
				if(queue.size() == 0){
					lock.wait();
				}else{
					System.out.println("Size of Queue: " + queue.size());
					int value = queue.removeFirst();
					System.out.println("value Consumed: " + value);
					lock.notify();
				}
			}
			Thread.sleep(random.nextInt(1000));
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer pc=  new ProducerConsumer();
		
		Thread pThread = new Thread(new Runnable() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		});
		
		Thread cThread = new Thread(new Runnable() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		});
		
		pThread.start();
		cThread.start();
		
	}
	
	

}
