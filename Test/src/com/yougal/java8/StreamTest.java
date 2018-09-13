package com.yougal.java8;

import java.util.ArrayList;

public class StreamTest {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i=0;i<10;i++) {
			arrayList.add(i);
		}
		arrayList.stream().reduce(0, Integer::sum);
		String a;
		a=null;
		System.out.println(a);
	}
	
}
