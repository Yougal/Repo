package com.yougal;

public class LCA {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.leftChild = new Node(6);
        tree.root.rightChild.rightChild = new Node(7);	
        LCA lca = new  LCA();
        lca.findLeastCommonAncestor(tree.root, 4, 5);
        lca.findLeastCommonAncestor(tree.root,4, 10);
	}	
	public int findLeastCommonAncestor(Node root, int n1, int n2){
		if(root==null){
			return 0;
		}
		if(root.value==n1 || root.value==n2){
			return 1 + _findLeastCommonAncestor(root, n1, n2);
		}
		return _findLeastCommonAncestor(root, n1, n2);
	}
	
	
	public int _findLeastCommonAncestor(Node root, int n1, int n2){
		if(root==null){
			return 0;
		}
		int value = findLeastCommonAncestor(root.leftChild, n1, n2) + findLeastCommonAncestor(root.rightChild, n1, n2);
		
		if(value==2){
			System.out.println("LCA("+n1+","+ n2+") = " + root.value);
			return 0;
		}else{
			return value;
		}
		
	}
	
	
	
}
