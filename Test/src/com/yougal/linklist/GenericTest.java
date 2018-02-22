package com.yougal.linklist;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		List<Object> myList = new ArrayList<>();
		myList.add(1);
		func(myList);
	}
	
	public static void func(List<? super Number> myList) {
		myList.add(new Integer(5));
		
	}
	
	
	
	
}
