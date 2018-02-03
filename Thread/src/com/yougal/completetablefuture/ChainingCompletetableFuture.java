package com.yougal.completetablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ChainingCompletetableFuture {

	public static void main(String[] args) {
		CompletableFuture<MessageSender> supplyAsync = CompletableFuture.supplyAsync(ChainingCompletetableFuture::findReceiver);
		CompletableFuture<Void> completetableFuture = supplyAsync.
							thenApplyAsync((MessageSender messageSender)->{
								return messageSender.sendMsg();
							}).thenAccept(System.out::println);
		completetableFuture.join();
		
		
		/**
		 * CompletableFuture<CompletionStage<String>> thenApply = CompletableFuture.supplyAsync(ChainingCompletetableFuture::findReceiver).thenApply(f-> f.sendMsgAsync());
		 * 
		 * returns a value then we do blocking calls of get  so instead we do below mentioned call
		 * 
		 */
		
		
		CompletableFuture.supplyAsync(ChainingCompletetableFuture::findReceiver).thenCompose((MessageSender messageSender)->{
								return messageSender.sendMsgAsync();
							});
		
		
	}
	static class MessageSender{
		public String sendMsg(){
			try {
				System.out.println("Thread Name: " + Thread.currentThread().getName());
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return "Message Sent";
		}
		public CompletionStage<String> sendMsgAsync(){
			return CompletableFuture.supplyAsync(this::sendMsg);
		}
	}
	
	static MessageSender findReceiver() {
		try {
			System.out.println("Thread Name: " + Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return new MessageSender();
	}
	
}
