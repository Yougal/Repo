package com.yougal.binaryTree;
/**
 * 
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * 
 * @author yougal.bisht
 *
 */
public class ConvertToSumTree {
	public static void main(String[] args) {
	  Node<Integer> root = new Node<>(10);
	  root.left = new Node<>(-2);
	  root.right = new Node<>(6);
	  root.left.left = new Node<>(8);
	  root.left.right = new Node<>(-4);
	  root.right.left = new Node<>(7);
	  root.right.right = new Node<>(5);
	 
	  toSumTree(root);
	 
	  // Print inorder traversal of the converted tree to test result of toSumTree()
	  System.out.println("Inorder Traversal of the resultant tree is:");
	  printInorder(root);
	}

	private static void printInorder(Node<Integer> root) {
		if(root!=null){
			printInorder(root.left);
			System.out.println(root.value);
			printInorder(root.right);
		}
	}

	private static int toSumTree(Node<Integer> root) {
		if(root!=null){
			if(root.left==null && root.right==null){
				int value= root.value;
				root.value=0;
				return value;
			}else{
				int value=root.value;
				root.value =  toSumTree(root.left) + toSumTree(root.right);
				return value+ root.value;
			}
		}
		return 0;
	}
}
