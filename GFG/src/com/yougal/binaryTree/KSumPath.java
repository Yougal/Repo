package com.yougal.binaryTree;

import java.util.Stack;


public class KSumPath {

	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
	    root.left = new Node<Integer>(3);
	    root.left.left = new Node<Integer>(2);
	    root.left.right = new Node<Integer>(1);
	    root.left.right.left = new Node<Integer>(1);
	    root.right = new Node<Integer>(-1);
	    root.right.left = new Node<Integer>(4);
	    root.right.left.left = new Node<Integer>(1);
	    root.right.left.right = new Node<Integer>(2);
	    root.right.right = new Node<Integer>(5);
	    root.right.right.right = new Node<Integer>(2);
	    int k=5;
	    printAllPathWithKSum(root, k);
	    
	}

	private static void printAllPathWithKSum(Node<Integer> root, int k) {
		if(root==null){
			return;
		}else{
			//taking this node as root identify the paths possible to sum k
			Stack<Integer> stack = new Stack<Integer>();
			identifyPaths(root, k, stack);
			printAllPathWithKSum(root.left,k);
			printAllPathWithKSum(root.right, k);
		}
	}

	private static void identifyPaths(Node<Integer> root, int k, Stack<Integer> result) {
		if(root==null || k<0){
			return;
		}else{
			result.push(root.value);
			k = k-root.value;
			if(k==0){
				 System.out.println(result);
			}else{
				identifyPaths(root.left, k,result);
				identifyPaths(root.right, k,result);
			}
			result.pop();
			
		}
	}
}
