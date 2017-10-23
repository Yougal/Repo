package com.yougal.binaryTree;

import com.yougal.linklist.LinkListUtils;
import com.yougal.linklist.LinkListUtils.Node;

public class LLToBinaryTree {

	public static void main(String[] args) {
		Node head = LinkListUtils.createList(10,12,15,25,30,36);
		com.yougal.binaryTree.Node<Integer> root = convertToBinaryTree(head);
		printInorder(root);
	}

	private static void printInorder(com.yougal.binaryTree.Node<Integer> root) {
		 if (root != null){
		 	printInorder(root.left);
            System.out.print(root.value + " ");
            printInorder(root.right);
	     }
	}

	private static com.yougal.binaryTree.Node<Integer> convertToBinaryTree(Node head) {
		return _convertToBinaryTree(head,0);
	}

	private static com.yougal.binaryTree.Node<Integer> _convertToBinaryTree(Node head,int i) {
		if(head!=null){
			com.yougal.binaryTree.Node<Integer> root =new com.yougal.binaryTree.Node<Integer>(head.value);
			Node leftNode = getLeft(head,i);
			if(leftNode!=null){
				root.left = _convertToBinaryTree(leftNode,2*i+1);
				if(leftNode.next!=null){
					root.right = _convertToBinaryTree(leftNode.next,2*i+2);
				}
			}
			return root;
		}else{
			return null;
		}
	}

	private static Node getLeft(Node head, int i) {
		int index = 2*i+1 - i;
		while(index>0 && head!=null){
			head = head.next;
			index--;
		}
		return head;
	}
	
}
