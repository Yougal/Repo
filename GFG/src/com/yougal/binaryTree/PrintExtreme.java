package com.yougal.binaryTree;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * 
 * http://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/
 * 
 * @author yougal.bisht
 *
 */
public class PrintExtreme {

	public static void main(String[] args) {
		 // Binary Tree of Height 4
	    Node<Integer> root = new Node<>(1);
	 
	    root.left = new Node<>(2);
	    root.right = new Node<>(3);
	 
	    root.left.left  = new Node<>(4);
	    root.left.right = new Node<>(5);
	    root.right.right = new Node<>(7);
	 
	    root.left.left.left  = new Node<>(8);
	    root.left.left.right  = new Node<>(9);
	    root.left.right.left  = new Node<>(10);
	    root.left.right.right  = new Node<>(11);
	    root.right.right.left  = new Node<>(14);
	    root.right.right.right  = new Node<>(15);
	 
	    root.left.left.left.left  = new Node<>(16);
	    root.left.left.left.right  = new Node<>(17);
	    root.right.right.right.right  = new Node<>(31);
	    
	    printExtremeNodes(root);
	 
	}

	private static void printExtremeNodes(Node<Integer> root) {
		List<Entry<Node<Integer>,Integer>> queue = new LinkedList<>();
		if(root==null){
			return;
		}
		queue.add(new AbstractMap.SimpleEntry<Node<Integer>,Integer>(root, 0));
		int level = 0;
		while(!queue.isEmpty()){
			Node<Integer> firstNode=null;
			Node<Integer> lastNode=null;
			while(!queue.isEmpty()){
				Entry<Node<Integer>, Integer> item = queue.remove(0);
				Node<Integer> node = item.getKey();
				Integer nodeLevel = item.getValue();
				if(level==nodeLevel){
					if(node.left!=null){
						queue.add(new AbstractMap.SimpleEntry<Node<Integer>,Integer>(node.left, nodeLevel+1));
					}
					if(node.right!=null){
						queue.add(new AbstractMap.SimpleEntry<Node<Integer>,Integer>(node.right, nodeLevel+1));
					}
					if(firstNode==null){
						firstNode=node;
					}else{
						lastNode=node;
					}
				}else{
					queue.add(0,item);
					break;
				}
			}
			printNode(firstNode,lastNode,level);
			level++;
		}
		
	}

	private static void printNode(Node<Integer> firstNode, Node<Integer> lastNode, int level) {
		if(level%2==0){
			if(firstNode!=null){
				System.out.printf("%2d ",firstNode.value);
			}
		}else{
			if(lastNode!=null){
				System.out.printf("%2d ",lastNode.value);
			}
		}
		
	}
	
}
