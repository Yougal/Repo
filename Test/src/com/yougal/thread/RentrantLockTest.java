package com.yougal.thread;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockTest {
	
	int count =0;
	
	Lock lock = new ReentrantLock();
	
	Condition condition = lock.newCondition();
	
	public void firstThread () throws Exception{
		lock.lock();
		System.out.println("Thread - 1 Waiting...." );
		condition.await();
		System.out.println("Thread - 1 Work Up....." );
		try{
			increment();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void secondThread () throws Exception{
		lock.lock();
		System.out.println("Press Enter Key....");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		System.out.println("Got Enter Key....");
		condition.signal();
		try{
			increment();
		}finally{
			lock.unlock();
			scanner.close();
		}
	}
	
	public void increment(){
		for(int i=0;i<10000;i++){
			count++;
		}
	}
	
	public void display() {
		System.out.println("Count is: " +count);
		
	}
	
	public static void main(String[] args) {
		RentrantLockTest rlt=  new RentrantLockTest();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					rlt.firstThread();
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					rlt.secondThread();
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		
		t1.start();
		t2.start();
		
		rlt.display();
		
	}

}
