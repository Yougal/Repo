package com.yougal.binaryTree;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
		root.left = new Node<>(2);
		root.left.left = new Node<>(3);
		root.left.left.right = new Node<>(4);
	    root.right = new Node<>(4);
	    root.right.left = new Node<>(5);
	    root.right.right = new Node<>(6);
	    root.right.right.left = new Node<>(7);
	    System.out.println(findSequence(root));
	    
	}

	private static int findSequence(Node<Integer> root) {
		if(root==null){
			return 0;
		}else{
			int leftValue = 1;
			int rightValue = 1;
			if(root.left!=null){
				if(root.value+1==root.left.value){
					leftValue=  1 + findSequence(root.left);
				}else{
					leftValue = findSequence(root.left);
				}
			}
			if(root.right!=null){
				if(root.value+1==root.right.value){
					rightValue=  1 + findSequence(root.right);
				}else{
					rightValue = findSequence(root.right);
				}
			}
			if(leftValue>rightValue){
				return leftValue;
			}else{
				return rightValue;
			}
		}
		
	}
	
}
