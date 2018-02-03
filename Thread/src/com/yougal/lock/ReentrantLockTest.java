package com.yougal.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable{

	private  long counter; 
	
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		ReentrantLockTest lt = new ReentrantLockTest();
		Thread t1 = new Thread(lt,"Thread-1");
		t1.start();
		
		Thread t2 = new Thread(lt,"Thread-2");
		t2.start();
	}
	
	public long incrementCounter(){
		try{
			lock.lock();
			counter++;
			return counter;
		}finally{
			lock.unlock();
		}
		
	}

	@Override
	public void run() {
		try {
			while(true){
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " counter - " + incrementCounter());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
