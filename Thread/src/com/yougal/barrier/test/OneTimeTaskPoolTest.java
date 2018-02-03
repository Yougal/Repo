package com.yougal.barrier.test;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.yougal.barrier.OneTimeTaskPool;
import com.yougal.barrier.Task;

public class OneTimeTaskPoolTest {
	
	 private final static String[] mOneShotInputStrings[] = { 
		        {"xreo", "xfao", "xmiomio", "xlao", "xtiotio", "xsoosoo", "xdoo", "xdoodoo"}
		    };

	
	public static void main(String[] args) {
		OneTimeTaskPool pool;
		for (String input[] : mOneShotInputStrings) {
			pool = new OneTimeTaskPool(Arrays.asList(input).stream().map(f->new TaskImpl(f)).collect(Collectors.toList()));
			pool.run();
		}
	}
	
	public static class TaskImpl implements Task{
		private String s;
		public TaskImpl(String s){
			this.s=s;
		}
		@Override
		public void process() {
			System.out.println("Thred-" +Thread.currentThread().getName() + " processed: " +s);
		}
		
	}
}
