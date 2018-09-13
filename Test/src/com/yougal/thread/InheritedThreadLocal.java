package com.yougal.thread;

import java.util.TreeMap;

public class InheritedThreadLocal {
	
	private static final ThreadLocal<TreeMap<String,Integer>> contextLog = new InheritableThreadLocal<>();

	static int k=0; 
	
	public static void main(String[] args) throws InterruptedException {
		contextLog.set(new TreeMap<>());
		Thread t1 = new Thread(new ThreadTest());
		Thread t2 = new Thread(new ThreadTest());
		Thread t3 = new Thread(new ThreadTest());
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println(contextLog.get());
	}
	
	private static class ThreadTest implements Runnable{

		@Override
		public void run() {
			int j = k+1;
			k++;
			contextLog.get().put("A", j);
		}
		
	}
	
}
