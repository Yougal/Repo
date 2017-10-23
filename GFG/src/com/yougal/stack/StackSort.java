package com.yougal.stack;
/**
 * 
 * Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed. 
 * We can only use the following ADT functions on Stack S:
 * 
 * is_empty(S)  : Tests whether stack is empty or not.
 * push(S)	     : Adds new element to the stack.
 * pop(S)	     : Removes top element from the stack.
 * top(S)	     : Returns value of the top element. Note that this function does not 
 * 					remove element from the stack.
 * Example:
 * 		Input:  -3  <--- Top
 * 				14 
 * 				18 
 * 				-5 
 * 				30 
 * 		Output: 30  <--- Top
 * 				18 
 * 				14 
 * 				-3 
 * 				-5 
 * 
 * @author yougal.bisht
 *
 */
public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> stk = Stack.createStack(new Integer[]{30,-5,18,14,-3});
		sortStack(stk);
		System.out.println(stk);
	}

	private static void sortStack(Stack<Integer> stk) {
		if(!stk.isEmpty()){
			int element = stk.pop();
			int min = findMinAndRemove(stk,element);
			sortStack(stk);
			stk.push(min);
		}
	}

	private static int findMinAndRemove(Stack<Integer> stk, int min) {
		if(stk.isEmpty()){
			return min;
		}else{
			int element = stk.pop();
			if(element<min){
				int value = findMinAndRemove(stk,element);
				stk.push(min);
				return value;
			}else{
				min =  findMinAndRemove(stk,min);
				stk.push(element);
				return min;
			}
		}
	}

	
	
}
