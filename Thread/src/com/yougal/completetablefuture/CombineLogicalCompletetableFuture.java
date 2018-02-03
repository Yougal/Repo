package com.yougal.completetablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CombineLogicalCompletetableFuture {

	public static void main(String[] args) {
		CompletableFuture<String> firstNameAsync = CompletableFuture.supplyAsync(StringProvider::firstName);
		CompletableFuture<String> lastNameAsync = CompletableFuture.supplyAsync(StringProvider::lastName);
		
		CompletableFuture<Void> thenAccept = firstNameAsync.thenCombineAsync(lastNameAsync, (String firstName , String lastName)-> firstName+lastName).thenAccept(System.out::print);
		thenAccept.join();
	}
	static class StringProvider{
		public static String firstName(){
			try {
				System.out.println("Thread Name: " + Thread.currentThread().getName());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return "Yougal";
		}
		public static CompletionStage<String> firstNameAsync(){
			return CompletableFuture.supplyAsync(StringProvider::firstName);
		}
		
		public static String lastName(){
			try {
				System.out.println("Thread Name: " + Thread.currentThread().getName());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return "Bisht";
		}
		public static CompletionStage<String> lastNameAsync(){
			return CompletableFuture.supplyAsync(StringProvider::lastName);
		}
	}
}
