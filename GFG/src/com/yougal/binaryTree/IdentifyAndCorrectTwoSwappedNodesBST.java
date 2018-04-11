package com.yougal.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 
 * 
 * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 * 
 * @author yougal.bisht
 *
 */
public class IdentifyAndCorrectTwoSwappedNodesBST {

	/* Driver program to test above functions*/
	public static void main(String[] args) {
	    /*   3
	        /  \
	       2    10
	      / \   / \
	     1   6 7  12
	     10 and 2 are swapped
	    */
	 
	    Node<Integer> root = new Node<Integer>(3);
	    root.left        = new Node<Integer>(2);
	    root.right       = new Node<Integer>(10);
	    root.left.left  = new Node<Integer>(1);
	    root.left.right = new Node<Integer>(6);
	    root.right.right = new Node<Integer>(12);
	    root.right.left = new Node<Integer>(7);
	 
	    System.out.println("Inorder Traversal of the original tree");
	    printInorder(root);
	    System.out.println();
	    root = correctBST(root);
	 
	    System.out.println("Inorder Traversal of the fixed tree");
	    printInorder(root);
	    
	}
	
	private static Node<Integer> correctBST(Node<Integer> root) {
		List<Node<Integer>> swappedNodes = identifyWappedNodes(root);
		if(swappedNodes.size()>0){
			System.out.println(swappedNodes.get(0).value +" , "+ swappedNodes.get(1).value);
		}
		return replaceSwappedNode(root, swappedNodes);
	}

	private static Node<Integer> replaceSwappedNode(Node<Integer> root, List<Node<Integer>> swappedNodes) {
		for (int i=0;i<swappedNodes.size();i=i+2) {
			Node<Integer> node1 = swappedNodes.get(i);
			Node<Integer> parent1 = findParent(root,node1,null);
			Node<Integer> node2 = swappedNodes.get(i+1);
			Node<Integer> parent2 = findParent(root,node2,null);

			Node<Integer> node1Left = node1.left;
			Node<Integer> node1Right = node1.right;
			
			Node<Integer> node2Left = node2.left;
			Node<Integer> node2Right = node2.right;

			swap(node1,node2Left,node2Right);
			swap(node2,node1Left,node1Right);
			
			if(node1==root){
				root=node2;
				if(parent2.left==node2){
					parent2.left=node1;
				}else{
					parent2.right=node1;
				}
			}else if(node2==root){
				root=node1;
				if(parent1.left==node1){
					parent1.left=node2;
				}else{
					parent1.right=node2;
				}
			}else{
				swapParent(node1,parent1, node2,parent2);
			}
		}
		return root;
	}

	private static void swapParent(Node<Integer> node1, Node<Integer> parent1, Node<Integer> node2,Node<Integer> parent2) {
		if(parent1.left == node1 && parent2.left==node2){
			parent2.left = node1;
			parent1.left= node2;
		}else if(parent1.left == node1 && parent2.right==node2){
			parent1.left = node2;
			parent2.right= node1;
		}else if(parent1.right == node1 && parent2.left==node2){
			parent1.right = node2;
			parent2.left= node1;
		}else{
			parent1.right = node2;
			parent2.right= node1;
		}
	}

	private static void swap(Node<Integer> node, Node<Integer> nodeLeft, Node<Integer> nodeRight) {
		node.left =nodeLeft;
		node.right =nodeRight;
	}

	private static Node<Integer> findParent(Node<Integer> root, Node<Integer> node,Node<Integer> parent) {
		if(root==null){
			return null;
		}
		if(node.value==root.value){
			return parent;
		}else{
			Node<Integer> leftParent = findParent(root.left,node,root);
			if(leftParent==null){
				return findParent(root.right,node,root);
			}else{
				return leftParent;
			}
		}
		
	}

	private static List<Node<Integer>> identifyWappedNodes(Node<Integer> root) {
		List<Node<Integer>> swappedNodes = new ArrayList<>();
		Node<Integer> lastNode = null;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> nextNode = null;
		if(root!=null){
			do{
				while(root!=null){
					stack.push(root);
					root=root.left;
				}
				root=stack.pop();
				if(lastNode==null){
					lastNode = root;
				}else{
					if(swappedNodes.size()<1){
						if(lastNode.value>root.value){
							swappedNodes.add(lastNode);
							nextNode=root;
						}
					}else{
						if(lastNode.value>root.value){
							swappedNodes.add(root);
						}
					}
					lastNode = root;
				}
				if(root.right!=null){
					root = root.right;
				}else{
					root=null;
				}
			}while(!stack.isEmpty() || root!=null);
		}
		if(swappedNodes.size()==1){
			swappedNodes.add(nextNode);
		}
		return swappedNodes;
	}

	private static void printInorder(Node<Integer> root) {
		if(root==null){
			return;
		}else{
			printInorder(root.left);
			System.out.printf("%d, ",root.value);
			printInorder(root.right);
		}
	}
}
