package com.yougal.java8.method.reference;

import java.util.Arrays;

public class InstanceMethodReferences {

	public static void main(String[] args) {
		 String[] strNames = new String[]{"Ram", "shyam", "Ramesh", "John", "brad", 
         "Suresh"};
		 SortedNamesClass sortedNamesClass = new SortedNamesClass();
		String names[] =stringMeth(sortedNamesClass::sortNames, strNames);
		System.out.println(Arrays.toString(names));
	}
	
	
	//First param is a functional interface. Thus, it can be passed a method  reference.
    //  which becomes an instance of functional interface 
    static String[] stringMeth(IMyStringFunc sf, String[] names) {
        return sf.stringFunc(names);
    }

	static class SortedNamesClass{
		String[] sortNames( String[] names){
			Arrays.sort(names, String::compareTo);
			return names;
		 }
	}
	
}
