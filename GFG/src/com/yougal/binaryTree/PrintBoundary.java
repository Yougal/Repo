package com.yougal.binaryTree;

/**
 * 
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 
 * @author yougal.bisht
 *
 */
public class PrintBoundary {

	public static void main(String[] args) {
		 // Let us construct the tree given in the above diagram
	    Node<Integer> root         	= new Node<>(20);
	    root.left                	= new Node<>(8);
	    root.left.left         		= new Node<>(4);
	    root.left.right         	= new Node<>(12);
	    root.left.right.left   		= new Node<>(10);
	    root.left.right.right  		= new Node<>(14);
	    root.right               	= new Node<>(22);
	    root.right.right        	= new Node<>(25);
	 
	    printBoundary(root);
	}

	private static void printBoundary(Node<Integer> root) {
		printLeftBoundary(root);
		printLeaves(root);
		printRightBoundary(root.right);
	}

	private static void printLeaves(Node<Integer> root) {
		if(root!=null){
			printLeaves(root.left);
			if(root.left==null && root.right==null){
				System.out.println(root.value);
			}
			printLeaves(root.right);
		}
	}

	private static void printLeftBoundary(Node<Integer> root) {
		if(root!=null){
			if(!(root.left==null && root.right==null)){
				System.out.println(root.value);
			}
			printLeftBoundary(root.left);
		}
	}

	private static void printRightBoundary(Node<Integer> root) {
		if(root!=null){
			printRightBoundary(root.right);
			if(!(root.left==null && root.right==null)){
				System.out.println(root.value);
			}
		}
		
	}
	
}
