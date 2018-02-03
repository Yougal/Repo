package com.yougal.barrier.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.yougal.barrier.Task;
import com.yougal.barrier.VariableTaskPool;

public class VariableTaskPoolTest {
	
	 /*private final static String[] cyclicInputStrings[] = { 
		        {"xreo1", "xfao1", "xmiomio1", "xlao1", "xtiotio1"},
		        {"xreo2", "xfao2", "xmiomio2", "xlao2", "xtiotio2", "xsoosoo2"},
		        {"xreo3", "xfao3", "xmiomio3"},
		        {"xre04", "xfao4", "xmiomio4", "xlao4", "xtiotio4"},
		    };
	 */
	 private final static String[] cyclicInputStrings[] = { 
		        {"xreo1", "xfao1"},
		        {"xreo2"},
		        {"xreo3", "xfao3"},
		        {"xre04"},
		    };
	
	public static void main(String[] args) {
		VariableTaskPool pool;
		ArrayList<List<Task>> inputs = new ArrayList<>();
		for (String input[] : cyclicInputStrings) {
			inputs.add(Arrays.asList(input).stream().map(f->new TaskImpl(f)).collect(Collectors.toList()));
		}
		pool = new VariableTaskPool(inputs,inputs.size());
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
