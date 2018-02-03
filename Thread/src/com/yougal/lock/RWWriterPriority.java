package com.yougal.lock;

import java.util.concurrent.Semaphore;

public class RWWriterPriority {

	private static Semaphore writerCountSemaphore = new Semaphore(1);
	private static int writerCount =0;
	
	private static Semaphore readerCountSemaphore = new Semaphore(1);
	private static int readerCount =0;
	
	private static Semaphore readSemaphore = new Semaphore(1);
	
	
	private static Semaphore resourceLock = new  Semaphore(1);
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			Reader reader = new Reader();
			Thread t = new Thread(reader,"Reader - " +(i+1));
			t.join();
			t.start();
		}
		for (int i = 0; i < 2; i++) {
			Writer writer = new Writer();
			Thread t = new Thread(writer,"Writer - " +(i+1));
			t.join();
			t.start();
		}
	}
	
	
	private static class Reader implements Runnable{

		@Override
		public void run() {
			try {
				readSemaphore.acquire();
					readerCountSemaphore.acquire();
						readerCount++;
						if(readerCount==1) {
							resourceLock.acquire();
						}
					readerCountSemaphore.release();
				readSemaphore.release();
				
				readData();
				
				readerCountSemaphore.acquire();
					readerCount--;
					if(readerCount==0) {
						resourceLock.release();
					}
				readerCountSemaphore.release();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public void readData() {
			System.out.println(Thread.currentThread().getName() + " Reading Data.... ");
		}
		
	}
	
	private static class Writer implements Runnable{
		@Override
		public void run() {
			try {
				writerCountSemaphore.acquire();
				writerCount++;
				if(writerCount==1) {
					readSemaphore.acquire();
				}
				writerCountSemaphore.release();
				resourceLock.acquire();
					writeData();
				resourceLock.release();
				writerCountSemaphore.acquire();
				writerCount--;
				if(writerCount==0) {
					readSemaphore.release();
				}
				writerCountSemaphore.release();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public void writeData() {
			System.out.println(Thread.currentThread().getName() + " Writing Data.... ");
		}
		
	}
	
	
	
}
