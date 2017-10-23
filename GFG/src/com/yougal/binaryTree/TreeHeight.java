package com.yougal.binaryTree;

public class TreeHeight {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
	    root.left = new Node<>(2);
	    root.right = new Node<>(3);
	    root.left.left = new Node<>(4);
	    root.left.right = new Node<>(5);

	    Height height = new Height();
	    height(root,height);
		System.out.println("The Height of given binary tree is : " + height.h );
	}
	
	private static void height(Node<Integer> root, Height height) {
		if(root!=null){
			Height leftHeight = new Height(height.h);
			Height rightHeight = new Height(height.h);
			height(root.left, leftHeight);
			height(root.right, rightHeight);
			height.h = Math.max(leftHeight.h+1, rightHeight.h+1);
		}
	}

	static class Height{
		int h=0;
		public Height(){
			
		}
		
		public Height(int h){
			this.h=h;
		}
	}
	
}
