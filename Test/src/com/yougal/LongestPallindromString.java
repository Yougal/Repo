package com.yougal;

import java.util.Arrays;

public class LongestPallindromString {
	
	public static void main(String[] args) {
		String text="BBABCBCAB";
		
		LongestPallindromString longestPallindromString=  new LongestPallindromString();
		System.out.println(longestPallindromString.find(text));
		
	}

	private String find(String text) {

		 boolean [][] resultArray = new boolean [text.length()][text.length()];

		 int currentMaxLength = 0;
		 int pallindromBeginsAt=0;
		 
		 //one length String is pallindrom
		 for (int i = 0; i < resultArray.length; i++) {
			resultArray[i][i] = true;
		}
		 
		 for(int currentLength=1;currentLength<text.length();currentLength++){
			 
			 for(int i=0;i<text.length()-currentLength;i++){
				 int j = i+currentLength;
				 if(text.charAt(i)==text.charAt(j) && resultArray[i+1][j-1]){
					 resultArray[i][j]=true;
					 currentMaxLength=currentLength;
					 pallindromBeginsAt=i;
				 }
			 }
			 
		 }
		 System.out.println(Arrays.deepToString(resultArray));
		 return text.substring(pallindromBeginsAt,currentMaxLength+pallindromBeginsAt+1);
		 
		
	}

}
