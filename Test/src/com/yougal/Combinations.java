package com.yougal;

/**
 * Given a number print the number of combinations you can derive from the number. 1=A, 2=B, 26=Z, 0=+. 

	For example: 1123 can be represented by 1,1,2,3 which would stand for AABC. 
	Another representation - 11,23 - KW 
	Another representation - 1,1,23 - AAW 
	Another representation - 11,2,3 - KBC 
	
	For number 1123, there will be 5 combinations.
	
 * @author yougal.bisht
 *
 */
public class Combinations {
	
	public static void main(String[] args) {
		String number = "0123";
		System.out.println("\nNumber: "+findCombinations(number,0,number.length()));
	}

	private static int findCombinations(String number,int index, int maxIndex) {
		int sum =0;
		if(index>=maxIndex){
			System.out.println(number);
			return 1;
		}else{
			if(index+1<=maxIndex){
				String remainingString ="";
				if(index+1<maxIndex){
					remainingString = number.substring(index+1);
				}
				 sum = sum + findCombinations(number.substring(0, index)+convertNumberToString(number.substring(index, index+1)) + remainingString,
										index+1, number.length());
			}
			if(index+2<=maxIndex){
				String remainingString ="";
				if(index+2<maxIndex){
					remainingString = number.substring(index+2);
				}
				 sum =sum +findCombinations(number.substring(0, index)+convertNumberToString(number.substring(index, index+2))+ remainingString, index+1, number.length()-1);
			}
		}
		return sum;
	}

	private static String convertNumberToString(String charAt) {
		int intVal = Integer.valueOf(charAt);
		if(intVal==0){
			return "+";
		}
		char a = (char)(intVal + 64);
		return a+"";
	}

}
