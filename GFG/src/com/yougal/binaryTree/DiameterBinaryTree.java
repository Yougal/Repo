package com.yougal.binaryTree;
/**
 * 
 * 
 * 
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * @author yougal.bisht
 *
 */
public class DiameterBinaryTree {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
 
        System.out.println("The diameter of given binary tree is : " + diameter(root,new Height()));
	 
	}
	
	static class Height{
		int h=0;
		public Height(){
			
		}
		
		public Height(Height h){
			this.h=h.h;
		}
	}

	private static int diameter(Node<Integer> root, Height height) {
		if(root!=null){
			
			Height lh = new Height(height);
			Height rh = new Height(height);
			int ld= diameter(root.left,lh);
			int rd = diameter(root.right,rh);
			height.h = Math.max(lh.h+1, rh.h+1);
			return Math.max(Math.max(ld,rd), lh.h+rh.h+1);
		}
		return 0;
	}

}
