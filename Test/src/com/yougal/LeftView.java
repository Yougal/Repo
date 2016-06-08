package com.yougal;

public class LeftView {
	
	int expectedLevel =0;
	public static void main(String[] args) {
		LeftView leftView = new LeftView();
		BinaryTree bTree = leftView.initialize();
		leftView.printView(bTree.root, 0);
		
	}
	
	public BinaryTree initialize(){
		BinaryTree theTree = new BinaryTree();
		
		Node root = new Node(12);
		theTree.root=root;
	    root.leftChild = new Node(10);

	    root.rightChild = new Node(30);
	    root.rightChild.leftChild = new Node(25);
	    root.rightChild.rightChild = new Node(40);
		return theTree;
	}
	
	public void printView(Node root,int level){
		if(root==null){
			return;
		}
		if(level==expectedLevel){
			System.out.println(root);
			expectedLevel=expectedLevel+1;
		}
		
		printView(root.leftChild, level+1);
		printView(root.rightChild, level+1);
	}

}
