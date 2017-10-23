package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

public class PallindromLL {

	
	public static void main(String[] args) {
		Node headNode1 = LinkListUtils.createList(new int[]{2, 3, 1, 4, 1, 2, 3, 5, 2, 3, 3, 1, 5 ,4, 2, 1, 
				2, 3, 2, 2, 4, 3, 5, 3, 1, 3, 4, 3, 1, 5, 3, 3, 4, 5 });
		PallindromLL ll = new PallindromLL();
		System.out.println(ll.isPalindrome(headNode1));
		StringBuilder sb = new StringBuilder("2314123523315421232243531343153345").reverse();
		System.out.println(sb.toString().equals("2314123523315421232243531343153345"));
	}
	
	boolean isPalindrome(Node head) 
    {
		if(head==null){
			return false;
		}else if(head!=null && head.next==null){
			return true;
		}else{
			Node ptr1= head;
			Node ptr2 = head.next;
			while(ptr1!=null && ptr2!=null && ptr2.next!=null){
				ptr1 = ptr1.next;
				ptr2 = ptr2.next.next;
			}
			if(ptr2!=null&& ptr2.next==null){
				Node node = new Node(Integer.MAX_VALUE);
				node.next=ptr1.next;
				ptr1.next=node;
				ptr1 = node;
			}
			//ptr1 is middle element
			if(!new Node(Integer.MAX_VALUE).equals(_checkPallindrome(head,ptr1))){
				return true;
			}else{
				return false;
			}
		}
    }

	private Node _checkPallindrome(Node head, Node ptr1) {
		if(head==ptr1){
			return ptr1.next;
		}else{
			Node temp=head;
			Node value = _checkPallindrome(head.next, ptr1);
			if(temp.value==value.value){
				return value.next;
			}else{
				return new Node(Integer.MAX_VALUE);
			}
		}
	} 
}
