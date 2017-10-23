package com.yougal.binaryTree;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Map.Entry;

public class ConnectElementAtSameLevel {

	
	// Java program to connect nodes at same level using extended
	// pre-order traversal
	  
	// A binary tree node
	static class Node 
	{
	    int data;
	    Node left, right, nextRight;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right = nextRight = null;
	    }
	}
	
	public static void main(String[] args) {
			Node root = new Node(10);
	        root.left = new Node(8);
	        root.right = new Node(2);
	        root.left.left = new Node(3);
	        LinkedList<Entry<Node,Integer>> queue = new LinkedList<>();
	        queue.add(new SimpleEntry<Node,Integer>(root,0));
	        connectNode(queue);
	}
	
	public static void connectNode(LinkedList<Entry<Node,Integer>> queue){
		if(queue.isEmpty()){
			return;
		}
		Entry<Node,Integer> nodeEntry = queue.removeFirst();
		if(!queue.isEmpty() && queue.peek().getValue().equals(nodeEntry.getValue())){
			nodeEntry.getKey().nextRight=queue.peek().getKey();
		}
		if(nodeEntry.getKey().left!=null){
			queue.add(new SimpleEntry<Node,Integer>(nodeEntry.getKey().left,nodeEntry.getValue()+1));
		}
		if(nodeEntry.getKey().right!=null){
			queue.add(new SimpleEntry<Node,Integer>(nodeEntry.getKey().right,nodeEntry.getValue()+1));
		}
		connectNode(queue);
	}
	
}
