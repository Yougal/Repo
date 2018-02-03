package com.yougal.completetablefuture;

import java.util.concurrent.CompletableFuture;

public class NonBlockingCompletetableFuture {

	public static void main(String[] args) {
		MessageSender messageSender = new MessageSender();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(messageSender::sendMsg);  
		completableFuture.whenComplete((String result, Throwable throwable) ->{
			if(throwable != null) {
		           System.out.println(throwable.getMessage());
		        } else {
		            String threadName = Thread.currentThread().getName();
		            System.out.println(threadName);
		       }
		});
		completableFuture.join();
	}
	static class MessageSender{
		public String sendMsg(){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return "Message Sent";
		}
	}
	
}
