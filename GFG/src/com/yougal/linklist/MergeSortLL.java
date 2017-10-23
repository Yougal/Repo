package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Merge Sort for Linked Lists
 * Merge sort is often preferred for sorting a linked list. The slow random-access performance of a 
 * linked list makes some other algorithms (such as quicksort) perform poorly, 
 * and others (such as heapsort) completely impossible.
 * Let head be the first node of the linked list to be sorted and headRef be the pointer to head. 
 * Note that we need a reference to head in MergeSort() as the below implementation changes next 
 * links to sort the linked lists (not data at the nodes), so head node has to be changed if the data 
 * at original head is not the smallest value in linked list.
 * 
 * @author yougal.bisht
 *
 */
public class MergeSortLL {

	
	public static void main(String[] args) {
		Node headNode = LinkListUtils.createList(new int[]{10,15,12,13,20,14});
		System.out.println("Input List:  ");
		System.out.println(headNode);
		Node sortedHead = mergeSort(headNode);
		System.out.println("Sorted List: ");
		System.out.println(sortedHead);
		
	}

	private static Node mergeSort(Node headNode) {
		int length = LinkListUtils.length(headNode);
		return _mergeSort(headNode,length);
	}

	private static Node _mergeSort(Node headNode, int length) {
		if(length==0 || length==1){
			return headNode;
		}else if(length==2){
			Node node1 = headNode;
			Node node2 = headNode.next;
			if(node1.compareTo(node2)>=0){
				node2.next=node1;
				node1.next=null;
				return node2;
			}else{
				node1.next=node2;
				node2.next=null;
				return node1;
			}
		}else{
			int mid = length/2;
			Node temp = findMid(headNode,mid-1);
			Node midNode = temp.next;
			temp.next=null;
			Node head1 = _mergeSort(headNode, mid);
			Node head2 = _mergeSort(midNode, length-mid);
			return merge(head1,head2);
		}
	}
	
	private static Node findMid(Node headNode, int mid) {
		while(mid>=1){
			headNode =headNode.next;
			mid--;
		}
		return headNode;
	}

	private static Node merge(Node head1, Node head2){
		MergeLL ll = new MergeLL();
		return ll.merge(head1, head2);
	}
}
