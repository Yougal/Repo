package com.yougal.string;

import java.util.Arrays;

public class LongestPallindromicSubsequence {

	public static void main(String[] args) {
		String input = "BBABC";
		int a[][] = new int[input.length()][];
		for (int i = 0; i < a.length; i++) {
			 a[i]= new int[input.length()];
		}
		
		
		int i=0;int j=0;
		int length=1;
		for(length=1;length<=input.length();length++){
			for(i=0;i<input.length();i++){
				j = i+length-1;
				if(j<input.length()){
					if(input.charAt(i)==input.charAt(j)){
						if(length==1 || length==2){
							a[i][j] = length; 
						}else{
							a[i][j] = 2 + a[i+1][j-1];
						}
					}else{
						a[i][j] = Math.max(a[i+1][j], a[i][j-1]);
					}
				}
			}
		}
		
		for (i = 0; i < a.length; i++) {
			 System.out.println(Arrays.toString(a[i]));
		}
		
	}
	
	
}
