package com.yougal.binaryTree;
/**
 * 
 * http://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 * 
 * @author yougal.bisht
 *
 */
public class CloneBinaryTreeWithRandomPointer {
	
	public static void main(String args[])
	{
	/*  //Test No 1
	    RandomNode<Integer> root = new RandomNode<>(1);
	    root.left = new RandomNode<>(2);
	    root.right = new RandomNode<>(3);
	    root.left.left = new RandomNode<>(4);
	    root.left.right = new RandomNode<>(5);
	    root.random = root.left.right;
	    root.left.left.random = root;
	    root.left.right.random = root.right;
	 
	//  Test No 2
	//  RandomNode<Integer> root = NULL;
	/*
	//  Test No 3
	    RandomNode<Integer> root = new RandomNode<>(1);
	 
	//  Test No 4
	    RandomNode<Integer> root = new RandomNode<>(1);
	    root.left = new RandomNode<>(2);
	    root.right = new RandomNode<>(3);
	    root.random = root.right;
	    root.left.random = root;
	 
	  Test No 5
	    RandomNode<Integer> root = new RandomNode<>(1);
	    root.left = new RandomNode<>(2);
	    root.right = new RandomNode<>(3);
	    root.left.left = new RandomNode<>(4);
	    root.left.right = new RandomNode<>(5);
	    root.right.left = new RandomNode<>(6);
	    root.right.right = new RandomNode<>(7);
	    root.random = root.left;
	*/
	//  Test No 6
	    RandomNode<Integer> root = new RandomNode<>(10);
	    RandomNode<Integer> n2 = new RandomNode<>(6);
	    RandomNode<Integer> n3 = new RandomNode<>(12);
	    RandomNode<Integer> n4 = new RandomNode<>(5);
	    RandomNode<Integer> n5 = new RandomNode<>(8);
	    RandomNode<Integer> n6 = new RandomNode<>(11);
	    RandomNode<Integer> n7 = new RandomNode<>(13);
	    RandomNode<Integer> n8 = new RandomNode<>(7);
	    RandomNode<Integer> n9 = new RandomNode<>(9);
	    root.left = n2;
	    root.right = n3;
	    root.random = n2;
	    n2.left = n4;
	    n2.right = n5;
	    n2.random = n8;
	    n3.left = n6;
	    n3.right = n7;
	    n3.random = n5;
	    n4.random = n9;
	    n5.left = n8;
	    n5.right = n9;
	    n5.random = root;
	    n6.random = n9;
	    n9.random = n8;
	 
	/*  Test No 7
	    RandomNode<Integer> root = new RandomNode<>(1);
	    root.left = new RandomNode<>(2);
	    root.right = new RandomNode<>(3);
	    root.left.random = root;
	    root.right.random = root.left;
	*/
	    System.out.println("Inorder traversal of original binary tree is:");
	    printInorder(root);
	 
	    RandomNode<Integer> clonedRoot = cloneTree(root);
	 
	    System.out.println("\nInorder traversal of cloned binary tree is:");;
	    printInorder(clonedRoot);
	 
	}
	

	public static RandomNode<Integer> cloneTree(RandomNode<Integer> root) {
		_cloneLeftTree(root);
		_adjustRandomPointer(root);
		RandomNode<Integer> clonedRoot = root.left;
		_removeClonedElementFromTree(root);
		return clonedRoot;
	}


	private static void _removeClonedElementFromTree(RandomNode<Integer> root) {
		if(root==null){
			return;
		}else{
			if(root.left!=null){
				RandomNode<Integer> originalElement = root;
				RandomNode<Integer> clonedElement = root.left;
				if(clonedElement.left!=null){
					originalElement.left=clonedElement.left;
					clonedElement.left=clonedElement.left.left;
				}else{
					originalElement.left=null;
					clonedElement.left=null;
				}
				_removeClonedElementFromTree(root.left);
			}
			_removeClonedElementFromTree(root.right);
		}
	}


	private static void _adjustRandomPointer(RandomNode<Integer> root) {
		if(root==null){
			return;
		}else{
			if(root.random!=null){
				root.left.random=root.random.left;
			}
			_adjustRandomPointer(root.left.left);
			_adjustRandomPointer(root.right);
		}
	}


	private static void _cloneLeftTree(RandomNode<Integer> originalRoot) {
		
		if(originalRoot==null){
			return;
		}else{
			RandomNode<Integer> clonedElement = new RandomNode<Integer>(originalRoot.value,true);
			RandomNode<Integer> pointerToLeft = originalRoot.left;
			originalRoot.left=clonedElement;
			clonedElement.left=pointerToLeft;
			_cloneRightTree(originalRoot.right,clonedElement);
			_cloneLeftTree(clonedElement.left);
		}
		
	}



	private static void _cloneRightTree(RandomNode<Integer> rightRoot, RandomNode<Integer> clonedRoot) {
		if(rightRoot==null){
			return;
		}else{
			RandomNode<Integer> clonedElement = new RandomNode<Integer>(rightRoot.value,true);
			clonedRoot.right=clonedElement;
			
			RandomNode<Integer> pointerToLeft = rightRoot.left;
			rightRoot.left=clonedElement;
			clonedElement.left=pointerToLeft;
			_cloneLeftTree(clonedElement.left);
			_cloneRightTree(rightRoot.right,clonedElement);
		}
	}


	private static void printInorder(RandomNode<Integer> root) {
		    if (root == null)
		        return;
		 
		    /* First recur on left sutree */
		    printInorder(root.left);
		 
		    /* then print data of Node and its random */
		  System.out.printf("[" + root.value + " ");
		    if (root.random == null)
		    	 System.out.printf("NULL], ");
		    else
		    	 System.out.printf(root.random.value + "], ");
		    /* now recur on right subtree */
		    printInorder(root.right);
	}







	static class RandomNode <T>{
		
		public T value;
		
		public RandomNode<T> left;
		
		public RandomNode<T> right;

		public RandomNode<T> random;
		
		public boolean isCloned;
		
		public RandomNode(T value,boolean isCloned) {
			this.value=value;
			this.isCloned=isCloned;
		}
		
		public RandomNode(T value) {
			this.value=value;
		}
		
	}
	
}
