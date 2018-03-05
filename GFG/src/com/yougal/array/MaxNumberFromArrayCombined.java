package com.yougal.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * 
 * @author yougal.bisht
 *
 */
public class MaxNumberFromArrayCombined {
	
	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr .add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
        arr.clear();
        
        arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");
        printLargest(arr);
        arr.clear();
        
        arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        printLargest(arr);
        arr.clear();
	}

	private static void printLargest(List<String> arr) {
		Collections.sort(arr, (s2,s1)->{
			String a = s1+s2;
			String b = s2+s1;
			return a.compareTo(b);
		});
		String result="";
		for (String string : arr) {
			result+=string;
		}
		System.out.println(result);
	}

}
