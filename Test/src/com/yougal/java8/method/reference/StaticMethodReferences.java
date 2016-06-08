package com.yougal.java8.method.reference;

import java.util.Arrays;

public class StaticMethodReferences {

	public static void main(String[] args) {
		 String[] strNames = new String[]{"Ram", "shyam", "Ramesh", "John", "brad", 
         "Suresh"};
		String names[] =stringMeth(SortedNamesClass::sortNames, strNames);
		System.out.println(Arrays.toString(names));
	}
	
	
	//First param is a functional interface. Thus, it can be passed a method  reference.
    //  which becomes an instance of functional interface 
    static String[] stringMeth(IMyStringFunc sf, String[] names) {
        return sf.stringFunc(names);
    }

	static class SortedNamesClass{
		 static String[] sortNames( String[] names){
			Arrays.sort(names, String::compareTo);
			return names;
		 }
	}
	
}
