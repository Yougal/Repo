package com.yougal.linklist;


public class LinkListUtils {

 static class Node implements Comparable<Node>{
	int value;
	Node next;
	Node (int value){
		this.value=value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value + "->" + next;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value != other.value)
			return false;
		return true;
	}
	@Override
	public int compareTo(Node o) {
		return this.value-o.value;
	}
 }
 
 
 public static Node createList(int...items){
	 Node head=null;
	 Node prev= null;
	 for (int item : items) {
		if(prev==null){
			head =  new Node(item);
			prev = head;
		}else{
			prev.next= new Node(item);
			prev = prev.next;
		}
	}
	 return head;
 }
 
 public static Node reverseListRecursive(Node head){
	if(head==null){
		return null;
	}
	return _reverseListRecursive(head, head.next);
 }
 
 private static Node _reverseListRecursive(Node head, Node next){
	Node temp = head.next;
	if(temp==null){
		return head;
	 }else{
		head.next=null;
		Node temp2 = _reverseListRecursive(next,next.next);
		next.next=head;
		return temp2;
	}
 }
 
 /**
 
 The logic here is the input head is constant never changes.
 logic is build around that itself.
 
 **/

 public static Node reverseList(Node head){
	 Node newHead = head;
	 if(head!=null){
		 if(head.next!=null){
			 while(head.next!=null){
				 Node temp=head.next;
				 head.next=temp.next;
				 temp.next = newHead;
				 newHead = temp;
			 }
		 }
	 }
	 return newHead;
 }

public static int length(Node headNode) {
	int len =0 ;
	while(headNode!=null){
		len++;
		headNode=headNode.next;
	}
	return len;
}
 
 
}
