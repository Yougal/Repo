package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * 
 * Reverse a Linked List in groups of given size Given a linked list, write a
 * function to reverse every k nodes (where k is an input to the function).
 * Example:
 * 
 * Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3 Output:
 * 3->2->1->6->5->4->8->7->NULL.
 * 
 * Inputs: 1->2->3->4->5->6->7->8->NULL and k = 5 Output:
 * 5->4->3->2->1->8->7->6->NULL.
 * 
 * 
 * @author yougal.bisht
 *
 */
public class ReverseInGroupLL {

	public static void main(String[] args) {
		Node headNode = LinkListUtils.createList(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("Input List:  ");
		System.out.println(headNode);
		int k = 3;
		Node newheadNode = reverseKGroup(headNode, k);
		System.out.println("Output List: ");
		System.out.println(newheadNode);
	}

	public static Node reverseKGroup(Node head, int k) {

		Node newHead = head;

		Node prevNode = null;

		while (head != null) {
			Node startNode = head;
			Node endNode = head;
			int i = 0;
			for (; i <k && head != null; i++) {
				endNode=head;
				head = head.next;
			}
			if (i == k) {
				head = endNode.next;
				Node reverseHead = reverse(startNode, endNode);
				if (prevNode == null) {
					newHead = reverseHead;
				} else {
					prevNode.next = reverseHead;
				}
				prevNode = startNode;
				startNode.next = head;
			}
		}
		return newHead;
	}

	public static Node reverse(Node startNode, Node endNode) {

		Node head = null;
		while (startNode != endNode) {
			Node temp = startNode.next;
			if (head == null) {
				head = startNode;
				head.next = null;
			} else {
				startNode.next = head;
				head = startNode;
			}
			startNode = temp;
		}
		startNode.next = head;
		head = startNode;
		return head;
	}

}
