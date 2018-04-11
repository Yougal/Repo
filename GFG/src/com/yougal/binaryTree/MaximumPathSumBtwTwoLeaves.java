package com.yougal.binaryTree;

public class MaximumPathSumBtwTwoLeaves {
	
	
	static int maximumSum=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		Node<Integer> root = new Node<>(-15);
        root.left = new Node<>(5);
        root.right = new Node<>(6);
        root.left.left = new Node<>(-8);
        root.left.right = new Node<>(1);
        root.left.left.left = new Node<>(2);
        root.left.left.right = new Node<>(6);
        root.right.left = new Node<>(3);
        root.right.right = new Node<>(9);
        root.right.right.right = new Node<>(0);
        root.right.right.right.left = new Node<>(4);
        root.right.right.right.right = new Node<>(-1);
        root.right.right.right.right.left = new Node<>(10);
        maxPathSum(root);
        System.out.println("Max pathSum of the given binary tree is " + maximumSum);
		
	}

	private static int maxPathSum(Node<Integer> root) {
		if(root==null) {
			return 0;
		}else {
			if(root.left==null && root.right==null) {
				return root.value;
			}else {
				int ls = maxPathSum(root.left);
				int rs = maxPathSum(root.right);
				if(ls+rs+root.value>maximumSum) {
					maximumSum=ls+ rs+ root.value;
				}
				return Math.max(ls+root.value,rs+root.value);
			}
		}
	}

}
