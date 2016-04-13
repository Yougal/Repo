package com.yougal;
/**
 * 
 * Given a binary tree, we need to find maximum value we can get by subtracting value 
 * of node B from value of node A, where A and B are two nodes of the binary tree 
 * and A is an ancestor of B. Expected time complexity is O(n).
 * 
 * @author yougal.bisht
 *
 */
public class MaxDiffBetweenNodeAndAncestor {

	
	public static void main(String[] args) {
		MaxDiffBetweenNodeAndAncestor ancestor= new MaxDiffBetweenNodeAndAncestor();
		BinaryTree bTree = ancestor.initialize();
		Result result = new Result();
		ancestor.maxValueNodeAndAncestor(bTree.root, result);
		System.out.println("Result: " +result.maxValue);
	}
	
	public BinaryTree initialize(){
		BinaryTree theTree = new BinaryTree();
		
		 Node root = new Node(8);
		 theTree.root=root;
	    root.leftChild = new Node(3);
	 
	    root.leftChild.leftChild = new Node(1);
	    root.leftChild.rightChild = new Node(33);
	    root.leftChild.rightChild.leftChild = new Node(4);
	    root.leftChild.rightChild.rightChild = new Node(7);
	 
	    root.rightChild = new Node(10);
	    root.rightChild.rightChild = new Node(74);
	    root.rightChild.rightChild.leftChild = new Node(13);
		return theTree;
	}
	
	public static class Result{
		int maxValue;
	}
	
	public Node maxValueNodeAndAncestor(Node root, Result result){
		if(root==null){
			return root;
		}
		if(root.leftChild !=null && root.rightChild!=null){
			Node leftChild =maxValueNodeAndAncestor(root.leftChild, result);
			Node rightChild =maxValueNodeAndAncestor(root.rightChild, result);
			if(leftChild.value>rightChild.value){
				result.maxValue = Math.max(result.maxValue, root.value - rightChild.value);
				return rightChild;
			}else{
				result.maxValue = Math.max(result.maxValue, root.value - leftChild.value);
				return leftChild;
			}
		}else if(root.leftChild!=null){
			Node leftChild =maxValueNodeAndAncestor(root.leftChild, result);
			result.maxValue = Math.max(result.maxValue, root.value - leftChild.value);
			return leftChild;
		}else if(root.rightChild!=null){
			Node rightChild = maxValueNodeAndAncestor(root.rightChild, result);
			result.maxValue = Math.max(result.maxValue, root.value - rightChild.value);
			return rightChild;
		}else{
			return root;
		}
	}
}
