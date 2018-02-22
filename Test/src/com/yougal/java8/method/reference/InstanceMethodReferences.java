package com.yougal.java8.method.reference;

import java.util.function.BiFunction;

public class InstanceMethodReferences {

	public static void main(String[] args) {
		BiFunction<String, Integer, String> c =(s, i )->s.substring(i);
		c =String::substring;
	}
	
	
	
}
