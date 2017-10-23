package com.yougal.stack;
/**
 * 
 * Count natural numbers whose all permutation are greater than that number
	There are some natural number whose all permutation is greater than or equal to that number eg. 123, whose all the permutation (123, 231, 321) are greater than or equal to 123.
	
	Given a natural number n, the task is to count all such number from 1 to n.
	
	Examples:
	
	Input : n = 15.
	Output : 14
	1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 
	13, 14, 15 are the numbers whose all 
	permutation is greater than the number
	itself. So, output 14.
	
	Input : n = 100.
	Output : 54
 * 
 * 
 * @author yougal.bisht
 *
 */
public class Permutations {
	
	static int findPermututions(int n){
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		int count=0;
		for(int i=1;i<=9;i++){
			stk.push(i);
			count++;
		}
		while(!stk.isEmpty()){
			int top = stk.pop();
			for(int i=top%10;i<=9;i++){
				int number = top*10+i;
				if(number<=n){
					stk.push(number);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(findPermututions(100));
	}

}
