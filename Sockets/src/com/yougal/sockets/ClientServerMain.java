package com.yougal.sockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientServerMain {

	
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		Server s = new Server();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		CompletableFuture.supplyAsync(() -> {
			try {
				return s.start();
			} catch (IOException e) {
				return -1;
			}
		});
		Client c1 = new Client();
		List<CompletableFuture<Void>> threads = new ArrayList<>();
		for(int i=0;i<10;i++) {
			CompletableFuture<Void> clientThread1 = CompletableFuture.runAsync(c1,newFixedThreadPool);
			threads .add(clientThread1);
		}
		for (CompletableFuture<Void> completableFuture : threads) {
			completableFuture.join();
		}
	}
	
	
}
