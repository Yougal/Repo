package com.yougal.random;
/**
 * 
 * http://www.geeksforgeeks.org/count-numbers-first-last-digits/
 * 
 * @author yougal.bisht
 *
 */
public class CountNumber {

	public static void main(String[] args) {
		int count2 = countNumberWithSameFirstAndLastDigit(8978);
		System.out.println(count2);
		
		System.out.println(getCountWithSameStartAndEndFrom1(8978));
	}

	private static int countNumberWithSameFirstAndLastDigit(int number) {
		int div=10;
		int result = 0;
		do{
			if(div==10){
				result=result+9;
			}else{
				result+= ((div-(div/10))/10);
			}
			div=div*10;
		}while(div<=number);
		
		if(number>(div/10)){
			if(number%(div/10)>number%10){
				result+= ((number-(div/10))/10);
			}else{
				result+= ((number-(div/10))/10)+1;
			}
		}
		
		return result;
	}
	
	
	static int getCountWithSameStartAndEndFrom1(int x)
	{
	    if (x < 10)
	        return x;
	 
	    // get ten-spans from 1 to x
	    int tens = x / 10;
	 
	    // add 9 to consider all 1 digit numbers
	    int res = tens + 9;
	 
	    // Find first and last digits
	    int firstDigit = getFirstDigit(x);
	    int lastDigit = x % 10;
	 
	    // If last digit is greater than first digit
	    // then decrease count by 1
	    if (lastDigit < firstDigit)
	        res--;
	 
	    return res;
	}
	
	static int getFirstDigit(int x)
	{
	    while (x >= 10)
	        x /= 10;
	    return x;
	}
	
}
