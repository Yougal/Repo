package com.yougal.string;
/**
 * 
 * http://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/
 * 
 * @author yougal.bisht
 *
 */
public class ConvertToRoman {

	public static void main(String[] args) {
		int num = 3549;
		System.out.println(convertToRoman(num));
	}

	private static String convertToRoman(int num) {
		// TODO Auto-generated method stubstring m[] = {"", "M", "MM", "MMM"};
		 String output = "";
		 String m[] = {"", "M", "MM", "MMM"};
	     String c[] = {"", "C", "CC", "CCC", "CD", "D", 
                 "DC", "DCC", "DCCC", "CM"};
	     String x[] = {"", "X", "XX", "XXX", "XL", "L", 
                 "LX", "LXX", "LXXX", "XC"};
	     String i[] = {"", "I", "II", "III", "IV", "V", 
                 "VI", "VII", "VIII", "IX"};
		     
	     output=m[num/1000] + c[(num%1000)/100] + x[(num%100)/10] +i[(num%10)];
	     return output;
	}
	
}
