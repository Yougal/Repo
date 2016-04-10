package com.yougal.thread;

public class ThreadTest implements Runnable{

	private Thread thread2Interrupt;
	
	public ThreadTest(Thread thread2Interrupt){
		this.thread2Interrupt=thread2Interrupt;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		thread2Interrupt.interrupt();
		
	}

}
