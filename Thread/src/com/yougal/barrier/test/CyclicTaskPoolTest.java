package com.yougal.barrier.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.yougal.barrier.CyclicTaskPool;
import com.yougal.barrier.Task;

public class CyclicTaskPoolTest {
	
	 private final static String[] cyclicInputStrings[] = { 
		        {"xreo1", "xfao1", "xmiomio1", "xlao1", "xtiotio1", "xsoosoo1", "xdoo1", "xdoodoo1"},
		        {"xreo2", "xfao2", "xmiomio2", "xlao2", "xtiotio2", "xsoosoo2", "xdoo2", "xdoodoo2"},
		        {"xreo3", "xfao3", "xmiomio3", "xlao3", "xtiotio3", "xsoosoo3", "xdoo3", "xdoodoo3"},
		        {"xre04", "xfao4", "xmiomio4", "xlao4", "xtiotio4", "xsoosoo4", "xdoo4", "xdoodoo4"},
		    };

	
	public static void main(String[] args) {
		CyclicTaskPool pool;
		ArrayList<List<Task>> inputs = new ArrayList<>();
		for (String input[] : cyclicInputStrings) {
			inputs.add(Arrays.asList(input).stream().map(f->new TaskImpl(f)).collect(Collectors.toList()));
		}
		pool = new CyclicTaskPool(inputs,inputs.get(0).size());
		pool.run();
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
