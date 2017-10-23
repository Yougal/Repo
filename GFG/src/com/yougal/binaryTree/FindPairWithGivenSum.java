package com.yougal.binaryTree;

import java.util.Stack;

public class FindPairWithGivenSum {

	public static void main(String[] args) {
		/*
			        15
			     /     \
			   10      20
			  / \     /  \
			 8  12   16  25    
		*/
		Node<Integer> root =  new Node<>(15);
		root.left = new Node<>(10);
		root.right = new Node<>(20);
		root.left.left = new Node<>(8);
		root.left.right = new Node<>(12);
		root.right.left = new Node<>(16);
		root.right.right = new Node<>(25);
		
		int target = 17;
		if (isPairPresent(root, target)){
			System.out.println("\n No such values are found\n");
		}

	}

	private static boolean isPairPresent(Node<Integer> root, int target) {
		Stack<Node<Integer>> inorderStack = new Stack<>();
		Node<Integer> inorder = root;
		Node<Integer> revInorder = root;
		Stack<Node<Integer>> revInorderStack = new Stack<>();
		boolean goLeft = true;
		boolean goRight = true;
		Node<Integer> val2= null;
		Node<Integer> val1= null;
		while(true){
			
			while(goLeft){
				if(inorder!=null){
					inorderStack.push(inorder);
					inorder= inorder.left;
				}else{
					if(!inorderStack.isEmpty()){
						 val1 = inorderStack.pop();
						 inorder=val1.right;
					}
					goLeft=false;
				}
			}
			
			
			while(goRight){
				if(revInorder!=null){
					revInorderStack.push(revInorder);
					revInorder= revInorder.right;
				}else{
					if(!revInorderStack.isEmpty()){
					 val2 = revInorderStack.pop();
					 revInorder=val2.left;
					}
					goRight=false;
				}
			}
			
			if(val1==val2){
				return true;
			}else if(val1.value+val2.value==target){
				System.out.println(val1.value + " , "+ val2.value);
				return false;
			}else if(val1.value+val2.value>target){
				goRight=true;
			}else{
				goLeft=true;
			}
		
		}
	}

}
