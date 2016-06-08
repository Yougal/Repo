package com.yougal.thread;

public class ThreeThreadCounting {
	
	int i =0;
	
	static int threadCount = 3;
	public Object lock = new Object();

	public int MAX_COUNT =20;
	
	public static void main(String[] args) {
		ThreeThreadCounting threadCounting = new ThreeThreadCounting();
		PrintNumber printNumber =  threadCounting.new PrintNumber();
		for (int i =1;i<=threadCount;i++) {
			Thread t1 = new Thread(printNumber);
			t1.setName(String.valueOf(i));
			t1.start();
		}
	}
	



class PrintNumber implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized (lock) {
				if(i<MAX_COUNT ){
					String threadName =String.valueOf((i%threadCount)+1);
					if(Thread.currentThread().getName().equals(threadName)){
						i++;
						System.out.println("T-" + threadName + " - " +  i);
						lock.notifyAll();
					}else{
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
}
}
