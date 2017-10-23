package com.yougal.stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stk = Stack.createStack(new Integer[]{1,2,3,4,5});
		System.out.println(stk);
		reverseStack(stk);
		System.out.println(stk);
	}

	private static void reverseStack(Stack<Integer> stk) {
		if(!stk.isEmpty()){
			int p  = stk.pop();
			reverseStack(stk);
			_insertAtTheBottom(stk,p);
		}
	}

	private static void _insertAtTheBottom(Stack<Integer> stk, int p) {
		if(stk.isEmpty()){
			stk.push(p);
		}else{
			int x = stk.pop();
			_insertAtTheBottom(stk, p);
			stk.push(x);
		}
	}
}
