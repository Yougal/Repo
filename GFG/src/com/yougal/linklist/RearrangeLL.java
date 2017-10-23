package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Given a linked list,performs the following task
 * Remove alternative nodes from second node
 * Reverse the removed list. 
 * Append the removed list at the end.
 * Input : 
 * 			You have to complete the method which takes one argument: the head of the linked list. 
 * 			You should not read any input from stdin/console. 
 * 			The struct Node has a data part which stores the data and a next pointer which points to the 
 * 			next element of the linked list. There are multiple test cases. For each test case, 
 * 			this method will be called individually.
 * Output:
 * 			You should not print any output to stdin/console.
 * Example:
 * 			Input List: 1->2->3->4->5->6
 * 			After step 1 Linked list are 1>3->5 and 2->4->6
 * 			After step 2 Linked list are 1->3->5 abd 6->4->2
 * 			After step 3 Linked List is 1->3->5->6->4->2
 * 			Output List: 1->3->5->6->4->2<br/>
 * 
 * 
 * <a href="http://www.practice.geeksforgeeks.org/problem-page.php?pid=700006">Problem Link</a>
 * @author yougal.bisht
 *
 */
public class RearrangeLL {

	public static void main(String[] args) {
		Node headNode = LinkListUtils.createList(new int[]{1,2,3,4,5,6,7});
		RearrangeLL rArr = new RearrangeLL();
		Node result = rArr.rearrange(headNode);
		System.out.println(result);
		System.out.println(headNode);
	}
	
	 Node rearrange(Node odd){
		 return _rearrange(odd, null);
	 }
	
	 Node _rearrange(Node odd, Node ptr)
	  {
		if(odd==null){
			return ptr;
		}else if(odd.next==null){
			odd.next=ptr;
			return ptr;
		}else{
			Node temp = odd.next;
			if(temp.next==null){
				odd.next=temp;
				temp.next=ptr;
				return temp;
			}else{
				odd.next=temp.next;
				temp.next=ptr;
				return _rearrange(odd.next,temp);
			}
		}
		
	  }
	
}
