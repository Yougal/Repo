package com.yougal.binaryTree;

public class AllNodesHavingKLeafs {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
	    root.left        = new Node<>(2);
	    root.right       = new Node<>(4);
	    root.left.left  = new Node<>(5);
	    root.left.right = new Node<>(6);
	    root.left.left.left  = new Node<>(9);
	    root.left.left.right  = new Node<>(10);
	    root.right.right = new Node<>(8);
	    root.right.left  = new Node<>(7);
	    root.right.left.left  = new Node<>(11);
	    root.right.left.right  = new Node<>(12);
	    
	    kLeaves(root,2);
	}

	private static int kLeaves(Node<Integer> root, int k) {
		if(root==null){
			return 0 ;
		}else{
			int leavesLeft = kLeaves(root.left, k);
			int leavesRight = kLeaves(root.right, k);
			if(leavesLeft+leavesRight==k){
				System.out.println(root.value);
			}
			return leavesLeft+leavesRight+1;
		}
		
	}
	
}
