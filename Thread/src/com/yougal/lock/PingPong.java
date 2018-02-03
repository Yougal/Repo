package com.yougal.lock;

import java.util.concurrent.Semaphore;

public class PingPong {

	public static void main(String[] args) {
		Semaphore pingSemaphore = new Semaphore(1);
		Semaphore pongSemaphore = new Semaphore(0);
		Thread pingThread = new Thread(
				()->{
					while(true) {
						try {
							pingSemaphore.acquire();
							System.out.println("Ping");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}finally {
							pongSemaphore.release();
						}
					}
				}
			);
		Thread pongThread = new Thread(
				()->{
					while(true) {
						try {
							pongSemaphore.acquire();
							System.out.println("Pong");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}finally {
							pingSemaphore.release();
						}
					}
				}
			);
		pingThread.start();
		pongThread.start();
		
	}
	
}
