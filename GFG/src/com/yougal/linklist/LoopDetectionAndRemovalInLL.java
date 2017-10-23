package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and 
 * if loop is present then removes the loop and returns true. 
 * And if the list doesn’t contain loop then returns false. 
 * 
 * Convert the linked list 1->2->3->4->5->2 with a loop, using detectAndRemoveLoop() 
 * must change the below list to 1->2->3->4->5->NULL. <br/> 
 * 
 * <img src="http://www.geeksforgeeks.org/wp-content/uploads/2009/04/Linked-List-Loop.gif"/>
 * 
 * @author yougal.bisht
 *
 */
public class LoopDetectionAndRemovalInLL {

	public static void main(String[] args) {
		Node headNode = createList(new int[]{1,2,3,4,5,2});
		boolean isLoopPresent = detectAndRemoveLoop(headNode);
		if(isLoopPresent){
			System.out.println(headNode);
		}else{
			System.out.println("No Loop");
		}
	}
	
	private static Boolean detectAndRemoveLoop(Node headNode) {
		return detectLoop(headNode);
	}

	private static Boolean detectLoop(Node headNode) {
		Node pointer = headNode;
		Node fasterPointer = headNode;
		while(pointer!=null && fasterPointer!=null && fasterPointer.next!=null){
			pointer = pointer.next;
			fasterPointer=fasterPointer.next.next;
			if(fasterPointer==pointer){
				removeLoop(headNode,pointer);
				return true;
			}
		};
		
		return false;
	}
	
	

	private static void removeLoop(Node headNode, Node pointer) {
		int k=0;
		Node temp = pointer.next;
		while(temp!=pointer){
			k++;
			temp=temp.next;
		}
		
		temp= headNode;
		while(k>0){
			temp=temp.next;
			k--;
		}
		
		while(headNode!=temp.next){
			headNode = headNode.next;
			temp=temp.next;
		}
	    temp.next=null;
	}

	public static Node createList(int...items){
		 Node head=null;
		 Node prev= null;
		 for (int item : items) {
			Node node = new Node(item);
			Node linkNode = findItem(node,head); 
			if(prev==null){
				head =  node;
				prev = head;
			}else{
				if(linkNode==null){
					prev.next= node;
					prev = prev.next;
				}else{
					prev.next=linkNode;
					break;
				}
			}
		}
		 return head;
	 }

	private static Node findItem(Node item, Node head) {
		while(head!=null){
			if(item.equals(head)){
				return head;
			}
			head = head.next;
		}
		return null;
	}
	
}
