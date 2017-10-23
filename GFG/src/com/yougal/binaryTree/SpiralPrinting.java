package com.yougal.binaryTree;

import java.util.Stack;

public class SpiralPrinting {

	
	 public static void main(String[] args) 
	    {
	        Node<Integer> root = new Node<>(1);
	        root.left = new Node<>(2);
	        root.right = new Node<>(3);
	        root.left.left = new Node<>(7);
	        root.left.right = new Node<>(6);
	        root.right.left = new Node<>(5);
	        root.right.right = new Node<>(4);
	        System.out.println("Spiral Order traversal of Binary Tree is ");
	        printSpiral(root);
	    }

	private static void printSpiral(Node<Integer> root) {
		if(root==null){
			return;
		}else{
			
			Stack<Node<Integer>> evenNodes = new Stack<Node<Integer>>();
			
			Stack<Node<Integer>> oddNodes = new Stack<Node<Integer>>();
			
			oddNodes.push(root);
			
			while(!evenNodes.isEmpty() || !oddNodes.isEmpty()){
				
				while(!oddNodes.isEmpty()){
					Node<Integer> element= oddNodes.pop();
					System.out.printf(element.value+ ", ");
					if(element.right!=null){
						evenNodes.push(element.right);
					}
					if(element.left!=null){
						evenNodes.push(element.left);
					}
				}
				
				while(!evenNodes.isEmpty()){
					Node<Integer> element= evenNodes.pop();
					System.out.printf(element.value+ ", ");
					if(element.left!=null){
						oddNodes.push(element.left);
					}
					if(element.right!=null){
						oddNodes.push(element.right);
					}
					
				}
			}
			
			
		}
		
	}
}
