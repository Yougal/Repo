package com.yougal;

public class AddAllGreaterValue {

	public static void main(String[] args) {
		AddAllGreaterValue addAllGreaterValue = new AddAllGreaterValue();
		
		BinaryTree bTree = addAllGreaterValue.initialize();
		bTree.inOrderTraverseTree(bTree.root);
		System.out.println("----Result----");
		addAllGreaterValue.modifyTree(bTree.root,0);
		bTree.inOrderTraverseTree(bTree.root);
	}
	
	private int modifyTree(Node root, int value) {
		if(root==null){
			return 0;
		}
		int rightSubTreeSum  = modifyTree(root.rightChild, value);
		int leftSubTreeSum = modifyTree(root.leftChild, rightSubTreeSum + root.value+value);
		int returnValue = leftSubTreeSum + root.value + rightSubTreeSum;
		root.value= root.value+value+ rightSubTreeSum;
		return returnValue;
	}

	public BinaryTree initialize(){
		BinaryTree theTree = new BinaryTree();
		
		Node root = new Node(50);
		theTree.root=root;
	    root.leftChild = new Node(30);
	    root.leftChild.leftChild = new Node(20);
	    root.leftChild.rightChild = new Node(40);
	    
	    root.rightChild = new Node(70);
	    root.rightChild.leftChild = new Node(60);
	    root.rightChild.leftChild.rightChild = new Node(65);
	    root.rightChild.rightChild = new Node(80);
		return theTree;
	}
	
}
