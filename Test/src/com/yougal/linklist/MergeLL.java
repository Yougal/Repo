package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * Merge sorted LL
 * @author yougal.bisht
 *
 */
public class MergeLL {

	public static void main(String[] args) {
		Node headNode1 = LinkListUtils.createList(new int[]{5,10,15});
		Node headNode2 = LinkListUtils.createList(new int[]{2,3,20});
		System.out.println(headNode1);
		System.out.println(headNode2);
		MergeLL ll = new MergeLL();
		Node mergeListHead = ll.merge(headNode1,headNode2);
		System.out.println(mergeListHead);
	}

	public Node merge(Node headNode1, Node headNode2) {
		Node mergedHead= null;
		Node result = null;
		while(headNode1!=null && headNode2!=null){
			Node temp = null;
			if(headNode1.compareTo(headNode2)>0){
				temp=headNode2;
				headNode2=headNode2.next;
			}else{
				temp=headNode1;
				headNode1=headNode1.next;
			}
			temp.next=null;
			if(result==null){
				result=temp;
				mergedHead=temp;
			}else{
				result.next=temp;
				result=temp;
			}
		}
		while(headNode1!=null){
			Node temp =headNode1;
			headNode1=headNode1.next;
			temp.next=null;
			if(result==null){
				result=temp;
				mergedHead=temp;
			}else{
				result.next=temp;
				result=temp;
			}
		}
		while(headNode2!=null){
			Node temp =headNode2;
			headNode2=headNode2.next;
			temp.next=null;
			if(result==null){
				result=temp;
				mergedHead=temp;
			}else{
				result.next=temp;
				result=temp;
			}
		}
		return mergedHead;
	}
	
}
