package com.yougal.java8;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
		
		hashMap.put("A", "A");
		hashMap.put("B", "B");
		hashMap.put("A", "Z");
		hashMap.put("C", "C");
		
		System.out.println("hashmap: " +hashMap);
		System.out.println(hashMap.get("A"));
		
		
	}
}
