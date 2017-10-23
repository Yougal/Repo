package com.yougal.binaryTree;
/**
 * 
 * http://www.geeksforgeeks.org/print-Nodes-dont-sibling-binary-tree/
 * 
 * @author yougal.bisht
 *
 */
public class NodesWithoutSiblings {
	public static void main(String[] args) {
		 // Let us create binary tree given in the above example
	    Node<Integer>root = new Node<>(1);
	    root.left = new Node<>(2);
	    root.right = new Node<>(3);
	    root.left.right = new Node<>(4);
	    root.right.left = new Node<>(5);
	    root.right.left.left = new Node<>(6);
	    printSingles(root);
	}

	private static void printSingles(Node<Integer> root) {
		if(root==null){
			return;
		}else if(root.left!=null && root.right!=null){
			printSingles(root.left);
			printSingles(root.right);
		}else if(root.left!=null){
			System.out.println(root.left.value);
			printSingles(root.left);
		}else if(root.right!=null){
			System.out.println(root.right.value);
			printSingles(root.right);
		}
	}
}
