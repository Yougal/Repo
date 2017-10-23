package com.yougal.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

	
	 public static void main(String[] args) {
		    Node<Integer> root 	= new Node<>(1);
		    root.left        	= new Node<>(2);
		    root.right      	= new Node<>(3);
		    root.left.left  	= new Node<>(4);
		    root.left.right  	= new Node<>(5);
		    root.right.left  	= new Node<>(6);
		    root.right.right 	= new Node<>(7);
		    
		    printReverseLevelOrder(root);
	}

	private static void printReverseLevelOrder(Node<Integer> root) {
		Queue<Node<Integer>> queue = new LinkedList<>();
		Stack<Node<Integer>> stack = new Stack<>();
		if(root==null){
			return;
		}else{
			queue.add(root);
			while(!queue.isEmpty()){
				Node<Integer> node =queue.poll();
				stack.push(node);
				if(node.right!=null){
					queue.add(node.right);
				}
				if(node.left!=null){
					queue.add(node.left);
				}
			}
		}
		
		while(!stack.isEmpty()){
			Node<Integer> node = stack.pop();
			System.out.print(node.value+", ");
		}
	}
}
