package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * 
 * Reverse a Linked List in groups of given size
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * Example:
 * 
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
 * Output:  3->2->1->6->5->4->8->7->NULL. 
 * 
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL. 
 * 
 * 
 * @author yougal.bisht
 *
 */
public class ReverseInGroupLL {

	public static void main(String[] args) {
		Node headNode = LinkListUtils.createList(new int[]{1,2,3,4,5,6,7,8});
		System.out.println("Input List:  ");
		System.out.println(headNode);
		int k =8;
		Node newheadNode = reverseInGroup(headNode,k);
		System.out.println("Output List: ");
		System.out.println(newheadNode);
	}
	
	private static Node reverseInGroup(Node headNode, int k){
		Node nextNode = headNode;
		Node newHead = null;
		Node prev = null;
		while(nextNode!=null){
			int count=0;
			Node nodeHead=null;
			Node tempNode = nextNode;
			while(nextNode!=null && count<k){
				Node temp = nextNode.next;
				if(count==0){
					nodeHead = nextNode;
					nextNode.next=null;
				}else{
					nextNode.next=nodeHead;
					nodeHead= nextNode;
				}
				nextNode = temp;
				count++;
			}
			if(newHead==null){
				newHead=nodeHead;
			}else{
				prev.next=nodeHead;
			}
			prev= tempNode;
			
		}
		return newHead;
		
	}
	
}
