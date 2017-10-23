package com.yougal.binaryTree;

public class LeftViewBinaryTree {

	public static void main(String[] args) {
		 	Node<Integer> root = new Node<>(12);
		    root.left = new Node<>(10);
		    root.right = new Node<>(30);
		    root.right.left = new Node<>(25);
		    root.right.right = new Node<>(40);
		    leftView(root);
	}

	private static void leftView(Node<Integer> root) {
		_leftView(root, 1, 0);
	}

	private static int _leftView(Node<Integer> root, int currentLevel, int maxLevel) {
		if(root==null){
			return maxLevel;
		}else{
			if(maxLevel<currentLevel){
				System.out.println(root.value);
				maxLevel=currentLevel;
			}
			maxLevel = _leftView(root.left, currentLevel+1, maxLevel);
			maxLevel = _leftView(root.right, currentLevel+1, maxLevel);
			return maxLevel;
		}
	}
	
	
}
