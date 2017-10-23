package com.yougal.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternMatching {

	public static void main(String[] args) {
		  String str = "baaabab";
		  List<String> patterns = new ArrayList<>();
		  patterns.add("*****ba*****ab");
		  patterns.add("ba*****ab");
		  patterns.add("ba*ab");
		  patterns.add("a*ab");
		  patterns.add("a*****ab");
		  patterns.add("*a*****ab");
		  patterns.add("ba*ab****");
		  patterns.add("****");
		  patterns.add("*");
		  patterns.add("aa?ab");
		  patterns.add("b*b");
		  patterns.add("a*a");
		  patterns.add("baaabab");
		  patterns.add("?baaabab");
		  patterns.add("*baaaba*");
	 
		  for (String pattern : patterns) {
			
			  if (stringMatch(str, pattern))
				  System.out.println("Yes");
			  else
				  System.out.println("No");
			  
		}
	}

	private static boolean stringMatch(String str, String pattern) {
		boolean t[][]=new boolean[str.length()+1][pattern.length()+1];
		t[0][0] = true;
		for (int j = 1; j <= pattern.length(); j++){
	        if (pattern.charAt(j - 1) == '*'){
	            t[0][j] = t[0][j - 1];
	        }
		}
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {
				
				if(str.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
					t[i][j]=t[i-1][j-1];
				}else if(pattern.charAt(j-1)=='*'){
					t[i][j]=t[i][j-1] || t[i-1][j];
				}else{
					t[i][j]=false;
				}
				
			}
		}
		
		
		return t[str.length()][pattern.length()];
	}
	
}
