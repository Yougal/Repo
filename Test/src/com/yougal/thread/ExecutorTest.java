package com.yougal.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String[] threadNames = new String[]{"1","2","3","4"};
		 ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		 List<Future<String>> futures = new ArrayList<Future<String>>();
		 for (String threadName : threadNames) {
			 Future<String> future = newFixedThreadPool.submit(new Callable<String>() {

					@Override
					public String call() throws Exception {
						System.out.print(threadName);
						return threadName;
					}
					
				});
			 futures.add(future);
		}
		 
		 for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		 
	}

}
