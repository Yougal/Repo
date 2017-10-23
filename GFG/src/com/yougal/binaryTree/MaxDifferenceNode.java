package com.yougal.binaryTree;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
 * 
 * @author yougal.bisht
 *
 */
public class MaxDifferenceNode {

	public static void main(String[] args) {

	    // Making above given diagram's binary tree
	    Node<Integer> root = new Node<>(8);
	    root.left = new Node<>(3);
	 
	    root.left.left = new Node<>(1);
	    root.left.right = new Node<>(6);
	    root.left.right.left = new Node<>(4);
	    root.left.right.right = new Node<>(7);
	 
	    root.right = new Node<>(10);
	    root.right.right = new Node<>(14);
	    root.right.right.left = new Node<>(13);
	    
	    MaxDifferenceNode mdn = new MaxDifferenceNode();
	    mdn.computeResult(root);
	    System.out.println("Result: " + mdn.res);
	}

	int res;
	
	private Node<Integer> computeResult(Node<Integer> root) {
		if(root==null){
			return null;
		}else{
			Node<Integer> left = computeResult(root.left);
			Node<Integer> right = computeResult(root.right);
			Node<Integer> min = findMin(left,right);
			if(min!=null){
				res = Math.max(res,root.value-min.value);
			}
			min = findMin(min,root);
			return min;
		}
	}

	private Node<Integer> findMin(Node<Integer> left, Node<Integer> right) {
		if(left==null){
			return right;
		}else if(right==null || left.value<right.value){
			return left;
		}else{
			return right;
		}
	}
	
}
