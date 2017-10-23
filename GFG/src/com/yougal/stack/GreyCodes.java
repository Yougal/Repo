package com.yougal.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreyCodes {

	public static void main(String[] args) {
		
		int n=4;
		List<String> arrayGroup1 = new ArrayList<>();
		arrayGroup1.add("0");
		arrayGroup1.add("1");
		for(int i=2;i<=n;i++){
			List<String> arrayGroup2 = new ArrayList<>(arrayGroup1);
			Collections.reverse(arrayGroup2);
			
			for (int j = 0; j < arrayGroup1.size(); j++) {
				arrayGroup1.set(j, "0"+arrayGroup1.get(j));
			}
			
			for (int j = 0; j < arrayGroup2.size(); j++) {
				arrayGroup2.set(j, "1"+arrayGroup2.get(j));
			}
			
			arrayGroup1.addAll(arrayGroup2);
		}
		
		System.out.println(arrayGroup1);
		
	}
	
	
}
