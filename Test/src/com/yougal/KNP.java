package com.yougal;

import java.util.Arrays;

public class KNP {

	public static void main(String[] args) {
		//String pattern = "aabaabaaa";
		//String pattern = "abcdabca";
		String pattern = "abcaby";
		int [] auxArr = analysePattern(pattern);
		System.out.println(Arrays.toString(auxArr));
		String text = "abxabcabcabytts";
		int index = findPatternInText(text,pattern);
		
		System.out.println("Pattern Found at: " + index);
	}

	private static int findPatternInText(String text, String pattern) {
		int [] auxArr = analysePattern(pattern);
		int j=0,i=0;
		for(;j<pattern.length() && i<text.length();){
			if(text.charAt(i)==pattern.charAt(j)){
				j++;
				i++;
			}else{
				if(j-1<0){
					j=0;
					i++;
				}else{
					j=auxArr[j-1];
				}
			}
			
		}
		if(j==pattern.length()){
			return i-pattern.length();
		}
		return -1;
	}

	private static int[] analysePattern(String pattern) {
		int j=0;
		int auxArr[] = new int[pattern.length()];
		auxArr[j]=0;
		for(int i=1;i<pattern.length();){
			if(pattern.charAt(j)==pattern.charAt(i)){
				auxArr[i]=j+1;
				j++;
				i++;
			}else{
				while(j-1>=0 && pattern.charAt(j)!=pattern.charAt(i)){
					j=auxArr[j-1];
				}
				if(pattern.charAt(j)==pattern.charAt(i)){
					auxArr[i]=j+1;
					i++;
				}else{
					auxArr[i]=0;
					i++;
				}
				
			}
		}
		
		return auxArr;
	}
	
	
	
}
