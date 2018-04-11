package com.yougal.binaryTree;

import java.util.ArrayList;

/**
 * 
 * https://www.geeksforgeeks.org/reverse-tree-path/  
 * 
 * @author yougal.bisht
 *
 */
public class ReversePath {

	
	public static void main(String[] args) {
		// Let us create binary tree shown in above diagram
	    Node<Integer> root = new Node<>(7);
	    root.left = new Node<>(6);
	    root.right = new Node<>(5);
	    root.left.left = new Node<>(4);
	    root.left.right = new Node<>(3);
	    root.right.left = new Node<>(2);
	    root.right.right = new Node<>(1);
	 
	    /*     7
	         /    \
	        6       5
	       / \     / \
	      4  3     2  1          */
	 
	    int data = 2;
	 
	    // Reverse Tree Path
	    reverseTreePath(root, data,new ArrayList<Node<Integer>>());
	 
	    // Traverse inorder
	    inorder(root);
	}

	private static boolean reverseTreePath(Node<Integer> root, int data, ArrayList<Node<Integer>> nodes) {
		if(root==null) {
			return false;
		}else {
			nodes.add(root);
			if(root.value==data) {
				reverseListValues(nodes);
				nodes.clear();
				return true;
			}else {
				boolean result = reverseTreePath(root.left, data, nodes);
				if(!result) {
					result = reverseTreePath(root.right, data, nodes);
				}
				if(!result) {
					nodes.remove(root);
				}
				return result;
			}
		}
	}

	private static void reverseListValues(ArrayList<Node<Integer>> nodes) {
		int low = 0,high=nodes.size()-1;
		while(low<high) {
			Node<Integer> n1 = nodes.get(low);
			Node<Integer> n2 = nodes.get(high);
			int temp = n1.value;
			n1.value=n2.value;
			n2.value=temp;
			low++;
			high--;
		}
	}

	private static void inorder(Node<Integer> root) {
		if(root==null) {
			return;
		}else {
			inorder(root.left);
			System.out.print(root.value + ", ");
			inorder(root.right);
		}
	}
}
