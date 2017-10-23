package com.yougal.string;

public class PhoneNumberUtils {

	static String [] phoneKey= {"","","abc","def","ghi","jkl" ,"mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {
		int number[] = {2, 3, 4};
		wordPrintUtils(number, 0, "");
	}
	
	static void wordPrintUtils(int number[],int i, String output){
		if(i<number.length){
			String buttonString = phoneKey[number[i]];
			for(int j=0;j<buttonString.length();j++){
				wordPrintUtils(number, i+1,output+buttonString.charAt(j));
			}
		}else{
			System.out.println(output);
		}
		
	}
	
}
