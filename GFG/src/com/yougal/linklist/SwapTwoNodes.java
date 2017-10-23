package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Swap nodes in a linked list without swapping data
   Given a linked list and two keys in it, swap nodes for two given keys. 
   Nodes should be swapped by changing links. 
   Swapping data of nodes may be expensive in many situations when 
   data contains many fields.
 * 
 * It may be assumed that all keys in linked list are distinct.

	Examples:
	
	Input:  10->15->12->13->20->14,  x = 12, y = 20
	Output: 10->15->20->13->12->14
	
	Input:  10->15->12->13->20->14,  x = 10, y = 20
	Output: 20->15->12->13->10->14
	
	Input:  10->15->12->13->20->14,  x = 12, y = 13
	Output: 10->15->13->12->20->14
 * 
 * 
 * 
 * @author yougal.bisht
 *
 */
public class SwapTwoNodes {
	
	public static void main(String[] args) {
		Node headNode = LinkListUtils.createList(new int[]{10,15,12,13,20,14});
		System.out.println(headNode);
		
		/**
		 * 
		 * Following cases need to be handled over here
		 * if input nodes are A and B
		 * 1. A is head, B any arbitrary Node
		 * 2. A is arbitrary, B is arbitrary
		 * 3. A is end, B is arbitrary
		 * 4. A,B not present in list
		 * 
		 */
		 headNode = swapNodes(new Node(15),new Node(13), headNode);
		 System.out.println(headNode);
	}
	
	public static Node swapNodes(Node a, Node b, Node head){
		Node temp = head;
		Node prevA = null;
		Node prevB = null;
		Node prev = null;
		while(temp!=null){
			if(temp.equals(a)){
				prevA = prev;
			}else if(temp.equals(b)){
				prevB = prev;
			}
			prev =temp;
			temp = temp.next;
		}
		if(prevA==null&& prevB==null){
			System.out.println("Not Found A and B");
		}else{
			if(prevA==null && prevB!=null){
				Node firstElement = head;
				Node secondElement = prevB.next;
				
				Node firstElementNext = firstElement.next;
				Node secondElementNext = secondElement.next;
				
				prevB.next=firstElement;
				firstElement.next=secondElementNext;
				secondElement.next=firstElementNext;
				head= secondElement;
			}else if(prevA!=null && prevB==null){
				Node firstElement = head;
				Node secondElement = prevA.next;
				
				Node firstElementNext = firstElement.next;
				Node secondElementNext = secondElement.next;
				
				prevA.next=firstElement;
				firstElement.next=secondElementNext;
				secondElement.next=firstElementNext;
				head=secondElement;
			}else{
				Node firstElement = prevA.next;
				Node secondElement = prevB.next;
				
				Node firstElementNext = firstElement.next;
				Node secondElementNext = secondElement.next;
				
				prevB.next=firstElement;
				firstElement.next=secondElementNext;
				secondElement.next=firstElementNext;
				prevA.next=secondElement;
				
			}
		}
		return head;
	}
	
}

