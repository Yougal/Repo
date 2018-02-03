package com.yougal.lock;

import java.util.concurrent.Semaphore;

public class ThreadNumber {

	static int counter = 1;
	
	public static void main(String[] args) {
		int numberOfThreads = 3;
		Thread targets[] = new Thread[numberOfThreads];
		
		Semaphore s[] = new Semaphore[numberOfThreads];
		init(targets,s,numberOfThreads);
		for (Thread thread : targets) {
			thread.start();
		}
	}

	private static void init(Thread[] targets, Semaphore[] s, int numberOfThreads) {
		for (int i = 0; i < numberOfThreads; i++) {
			s[i]= new Semaphore(i==0?1:0);
		}
		for (int i = 0; i < numberOfThreads; i++) {
			int index = i;
			targets[i] = new Thread(()->{
				while(counter<10) {
					try {
						s[index].acquire();
						System.out.println(Thread.currentThread().getName() +" "+counter++);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						s[(index+1)%numberOfThreads].release();
					}
				}
			});
			targets[i].setName("Thread- " +(i+1));
		}
	}
	
	
}
