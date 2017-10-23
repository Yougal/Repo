package com.yougal.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class NodesAtKDistanceFromANode {

	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(20);
	    root.left = new Node<Integer>(8);
	    root.right = new Node<Integer>(22);
	    root.left.left = new Node<Integer>(4);
	    root.left.right = new Node<Integer>(12);
	    root.left.right.left = new Node<Integer>(10);
	    root.left.right.right = new Node<Integer>(14);
	    Node<Integer> target = new Node<Integer>(8);
	    NodesAtKDistanceFromANode obj = new NodesAtKDistanceFromANode();
	    obj.printKDistanceNode(root, target, 2);
	}

	private void printKDistanceNode(Node<Integer> root, Node<Integer> target, int k) {
		List<Node<Integer>> allParent = new ArrayList<Node<Integer>>();
		findAllParents(root,target,k,allParent);
		Node<Integer> prev  = null;
		for (Node<Integer> node : allParent) {
			if(k==0){
				System.out.print(node.value+", ");
			}else if(prev==null){
				printNodes(node.left,k-1);
				printNodes(node.right,k-1);
			}else if(node.left==prev){
				printNodes(node.right,k-1);
			}else if (node.right==prev){
				printNodes(node.left,k-1);
			}
			prev=node;
			k--;
		}
	}

	private void printNodes(Node<Integer> root, int k) {
		if(root==null || k<0){
			return;
		}
		if(k==0){
			System.out.print(root.value+", ");
		}else{
			printNodes(root.left,k-1);
			printNodes(root.right,k-1);
		}
	}

	private int findAllParents(Node<Integer> root, Node<Integer> target, int k , List<Node<Integer>> allParent) {
		if(root==null){
			return -1;
		}else if(root.value==target.value){
			allParent.add(root);
			return k-1;
		}else{
			int leftIndex= findAllParents(root.left, target,k,allParent);
			int rightIndex= findAllParents(root.right, target,k,allParent);
			if(leftIndex>=0){
				allParent.add(root);
				return leftIndex-1;
			}
			if(rightIndex>=0){
				allParent.add(root);
				return rightIndex-1;
			}
			return -1;
		}
	}
	
	
}
