package com.yougal.random;

public class LookAndSaySequence {

	public static void main(String[] args) {
		int n = 7;
		int number = 1;
		int lastNumber=1;
		while(n>=1){
			number=0;
			int numberOfDigits = findDigitCounts(lastNumber);
			do{
				int frequency=0;
				int digit=-1;
				while(numberOfDigits>0){
					int lastDigit=digit;
					int d = Double.valueOf(Math.pow(10, numberOfDigits-1)).intValue();
					digit = lastNumber/d;
					
					if(lastDigit==digit || lastDigit==-1){
						frequency++;
						numberOfDigits--;
						lastNumber=lastNumber%d;
					}else{
						digit=lastDigit;
						break;
					}
					
				
				}
				number=number*100+(frequency*10+digit);
			}while(numberOfDigits>0);
			lastNumber=number;
			n--;
		}
		System.out.println(number);
	}

	private static int findDigitCounts(int n) {
		int count =0;
		while(n>0){
			n=n/10;
			count++;
		}
			
		return count;
	}
	
}
