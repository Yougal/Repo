package com.yougal.stack;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
	
	public static void main(String[] args) {
		findNextGreaterNumber(new Integer[]{13, 7, 6, 12});
	}

	private static void findNextGreaterNumber(Integer[] integers) {
		Map<Integer, Integer> result= new HashMap<Integer, Integer>(integers.length);
		Stack<Integer> st  = new Stack<Integer>(integers.length);
		for (Integer element : integers) {
			while(st.isEmpty() || st.peek()>element ){
				st.push(element);
			}
			boolean x = false;
			while(!st.isEmpty() && st.peek()<element){
				x=true;
				result.put(st.pop(), element);
			}
			if(x){
				st.push(element);
			}
		}
		while(!st.isEmpty()){
			result.put(st.pop(), -1);
		}
		
		System.out.println(result);
		
	}

}
