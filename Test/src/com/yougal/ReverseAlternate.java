package com.yougal;

import java.util.Scanner;

/**
 * 
 * 
 * Written test: 
 * Q2) in single linked list reverse alternative k nodes. 
 * 
 * 
 * e.g. k=3 , 1->2->3->4->5->6->7->8->9->10 
 * 
 * 3->2->1->4->5->6->9->8->7->10 
 * void reverseAlternativeKNodes(node *&head, int k);
 * 
 * @author yougal.bisht
 *
 */
public class ReverseAlternate {

	

	
	public static void main(String[] args) {
		int k=2;
		Node head = constructList("1,2,3,4,5,6,7,8,9,10");
		System.out.println(head);
		Node newHead = reverseAlternativeKNodes(head,k);
		System.out.println(newHead);
		
	}
	
	
	
	private static Node reverseAlternativeKNodes(Node head, int k) {
		Node newHead=null;
		Node temp=head;
		Node tail = null;
		while(temp!=null){
			int reverseSize =k;
			Node headReverse = temp; 
			while(reverseSize>0 && temp!=null){
				temp=temp.nextNode;
				reverseSize--;
			}
			
			if(reverseSize<=0){
				Node reverseHead = reverse(headReverse,k);
				if(newHead==null){
					newHead = reverseHead;
				}else{
					tail.nextNode=reverseHead;
				}
				tail = headReverse;
				tail.nextNode=temp;
			}
			
		}
		return newHead;
	}



	private static Node reverse(Node head, int k) {
		Node temp = head;
		Node previousNode = null;
		for(int i=0;i<k;i++){
			Node x = temp.nextNode;
			if(previousNode==null){
				temp.nextNode=null;
			}else{
				temp.nextNode=previousNode;
			}
			previousNode=temp;
			temp=x;
			
		}
		return previousNode;
	}



	private static Node constructList(String input) {
		Scanner s = new Scanner(input);
		s.useDelimiter(",");
		Node head = null;
		Node prev=null;
		try{
			while(s.hasNext()){
				Node temp= new Node();
				Integer value = Integer.valueOf(s.next());
				temp.value=value;
				if(prev!=null){
					prev.nextNode=temp;
				}else{
					head=temp;
				}
				prev=temp;
			}
		}finally{
			s.close();
		}
		return head;
	}



	static class Node{
		int value;
		Node nextNode;
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return  value + "-> "+ nextNode;
		}
		
	}
	
}

 
