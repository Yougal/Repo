package com.yougal.stack;
/**
 * 
 * https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
 * 
 * Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. Find minimum number of bracket reversals to make the expression balanced.

	Examples:
	
	Input:  exp = "}{"
	Output: 2
	We need to change '}' to '{' and '{' to
	'}' so that the expression becomes balanced, 
	the balanced expression is '{}'
	
	Input:  exp = "{{{"
	Output: Can't be made balanced using reversals
	
	Input:  exp = "{{{{"
	Output: 2 
	
	Input:  exp = "{{{{}}"
	Output: 1 
	
	Input:  exp = "}{{}}{{{"
	Output: 3
 * 
 * @author yougalbisht
 *
 */
public class BalanceParanthesis {
	
	public static void main(String[] args) {
		String input="}{";
		int count = findCountReversals(input);
		if(count==-1) {
			System.out.println("Can't be made balanced using reversals");
		}else {
			System.out.println("Reversal Count: " +count);
		}
		
		input="{{{";
		count = findCountReversals(input);
		if(count==-1) {
			System.out.println("Can't be made balanced using reversals");
		}else {
			System.out.println("Reversal Count: " +count);
		}
		
		input="{{{{";
		count = findCountReversals(input);
		if(count==-1) {
			System.out.println("Can't be made balanced using reversals");
		}else {
			System.out.println("Reversal Count: " +count);
		}
		
		input="{{{{}}";
		count = findCountReversals(input);
		if(count==-1) {
			System.out.println("Can't be made balanced using reversals");
		}else {
			System.out.println("Reversal Count: " +count);
		}
		
		input="}{{}}{{{";
		count = findCountReversals(input);
		if(count==-1) {
			System.out.println("Can't be made balanced using reversals");
		}else {
			System.out.println("Reversal Count: " +count);
		}
		
	}

	private static int findCountReversals(String input) {
		int count=0;
		int openCount=0;
		int closeCount=0;
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if(c=='{') {
				openCount++;
			}else {
				if(openCount>0) {
					openCount--;
				}else {
					closeCount++;
				}
			}
		}
		
		if(openCount==closeCount) {
			count=openCount+closeCount;
		}else if((openCount+closeCount)%2==0) {
			if(openCount==0) {
				count =closeCount/2;
			}else if(closeCount==0) {
				count= openCount/2;
			}else {
				count = openCount>closeCount?2*closeCount:2*openCount;
				count+= ((Math.abs(openCount-closeCount))/2);
			}
		}else {
			count=-1;
		}
		return count;
	}

}
