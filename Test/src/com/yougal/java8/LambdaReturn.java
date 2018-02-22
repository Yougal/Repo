package com.yougal.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaReturn {

	public static void main(String[] args) {
		List<String> list =  Arrays.asList("One","Two","Three","Four");
		list.forEach(f->{
			if(f.equals("Two")){
				return;
			}
			System.out.println(f);
		});
	}
	
}
