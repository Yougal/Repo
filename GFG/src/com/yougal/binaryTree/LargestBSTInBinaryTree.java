package com.yougal.binaryTree;

public class LargestBSTInBinaryTree {

	
	  public static void main(String[] args) {
	        /* Let us construct the following Tree
	                50
	             /      \
	            10        60
	           /  \       /  \
	          5   20    55    70
	         /     /  \
	        45   65    80
	         */
	 
	        Node<Integer> root = new Node<>(5);
	        root.left = new Node<>(10);
	        root.right = new Node<>(60);
	        root.left.left = new Node<>(5);
	        root.left.right = new Node<>(20);
	        root.right.left = new Node<>(55);
	        root.right.right = new Node<>(70);
	        //root.right.left.left = new Node<>(45);
	        //root.right.right.left = new Node<>(65);
	        //root.right.right.right = new Node<>(80);
	        root.left.left.left = new Node<>(45);
	        root.left.right.left = new Node<>(19);
	        root.left.right.right = new Node<>(80);
	 
	        /* The complete tree is not BST as 45 is in right subtree of 50.
	         The following subtree is the largest BST
	             60
	            /  \
	          55    70
	          /     /  \
	        45     65   80
	        */
	        largestBST(root);
	        System.out.println("Size of largest BST is " + maxSize);
	    }

	private static int maxSize=1; 
	
	private static int largestBST(Node<Integer> root) {
		if(root==null){
			return 0;
		}else{
			int size;
			if((root.left!=null && root.left.value<root.value 
					&& 
				root.right!=null && root.right.value>root.value
				) ||
				(
						root.left==null && 
						root.right!=null && root.right.value>root.value
				)
				||
				(
						root.right==null && 
						root.left!=null && root.left.value<root.value
				)	
				||
				(
						root.right==null && root.left==null
				)
			   ){
				size=1+largestBST(root.left) + largestBST(root.right);
				maxSize = Math.max(maxSize, size);
				return size;
			}else{
				size= Math.max(largestBST(root.left), largestBST(root.right));
				return 1;
			}
			
			
			
			
		}
		
	}	
}
