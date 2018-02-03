package com.yougal.binaryTree;

import java.util.Stack;

/**
 * 
 * http://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
 * 
 * @author yougal.bisht
 *
 */
public class BinaryTreeFromStringWithParenthesis {
	
	private int i;
	
	public static void main(String[] args) {
		BinaryTreeFromStringWithParenthesis bs = new BinaryTreeFromStringWithParenthesis();
		String s = "4(2(3)(1))(6(5))";
		Node<Character> root = bs.constructTree(s,null);
		printPreorder(root);
		root = bs.constructTreeIterative(s);
		System.out.println("-----------------");
		printPreorder(root);
	}

	private Node<Character> constructTree(String s, Node<Character> parent) {
		if(i<s.length()){
			char c = s.charAt(i);
			i++;
			if(c=='('){
				if(parent.left==null){
					parent.left=constructTree(s, parent);
				}else{
					parent.right=constructTree(s, parent);
				}
			}else if(c==')'){
				return null;
			}else{
				Node<Character> t = new Node<>(c);
				constructTree(s, t);
				return t;
			}
			constructTree(s, parent);
		}
		return null;
	}
	
	private Node<Character> constructTreeIterative(String s) {
		Stack<Node<Character>> st = new Stack<>();
		Boolean side = null;
		for(int i=0;i<s.length();i++){
			char x = s.charAt(i);
			if(st.isEmpty()){
				st.push(new Node<>(x));
			}else{
				if(x=='('){
					Node<Character> top = st.peek();
					if(top.left==null){
						side = true;
					}else{
						side = false;
					}
				}else if(x==')'){
					st.pop();
				}else{
					char y = s.charAt(i);
					Node<Character> top = st.peek();
					Node<Character> newNode = new Node<>(y);
					if(side){
						top.left=newNode;
					}else{
						top.right=newNode;
					}
					side=null;
					st.push(newNode);
				}
			}
		}
		return st.pop();
	}
	
	private static void printPreorder(Node<Character> root) {
		if(root!=null){
			System.out.println(root.value);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	
}
