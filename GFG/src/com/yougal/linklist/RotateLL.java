package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. 
 * Where k is a given positive integer. For example, if the given linked list is 
 * 10->20->30->40->50->60 and k is 4, the list should be modified to 
 * 50->60->10->20->30->40. 
 * 
 * Assume that k is smaller than the count of nodes in linked list.
 * 
 * @author yougal.bisht
 *
 */
public class RotateLL {

	public static void main(String[] args) {
		Node headNode = LinkListUtils.createList(new int[]{10,20,30,40,50,60});
		int k=2;
		System.out.println(headNode);
		Node newHead = rotate(headNode,k);
		System.out.println(newHead);
	}

	private static Node rotate(Node headNode, int k) {
		Node newHeadNode = headNode;
		while(k>1){
			k--;
			headNode = headNode.next;
		}
		Node kthNode = headNode;
		while(headNode.next!=null){
			headNode=headNode.next;
		}
		headNode.next=newHeadNode;
		newHeadNode=kthNode.next;
		kthNode.next=null;
		return newHeadNode;
	}
	
}
