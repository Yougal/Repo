package com.yougal;

public class ThreadTest {

	
	public static void main(String[] args) {
		MyThread myThread1 = new MyThread();
		Thread t1 = new Thread(myThread1);
		Thread t2 = new Thread(myThread1);
		final Thread mainThread = Thread.currentThread();
		Thread.UncaughtExceptionHandler h  = new Thread.UncaughtExceptionHandler() {
		    public void uncaughtException(Thread th, Throwable ex) {
		    	mainThread.interrupt();
		    }
		};
		try{
		Object lock = new Object();
		t1.start();
		t2.start();
		t1.setUncaughtExceptionHandler(h);
		t2.setUncaughtExceptionHandler(h);
		while(t1.isAlive() || t2.isAlive()){
			synchronized (lock) {
				lock.wait(10000);
			}
		}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	static class MyThread implements Runnable{

		@Override
		public void run() {
			try{
			
			Thread.sleep(10000);
			throw new InterruptedException("Manual Exception");
			}catch(InterruptedException e){
				throw new RuntimeException(e);
			}
		}
		
	}
	
}
