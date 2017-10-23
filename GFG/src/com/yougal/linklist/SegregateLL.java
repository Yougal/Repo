package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Given a Linked List of integers, write a function to modify the linked list such that 
 * all even numbers appear before all the odd numbers in the modified linked list. 
 * Also, keep the order of even and odd numbers same.
 * Input:
 * 		The first line of input contains an integer T denoting the number of test cases.
 * 		The first line of each test case is N,N is the number of elements in Linked List.
 * 		The second line of each test case contains N input,elements in Linked List.
 * Output:
 * 		Print the all even numbers then odd numbers in the modified Linked List.
 * Constraints:
 * 		1 ≤ T ≤ 100
 * 		1 ≤ N ≤ 100
 * 		1 ≤ size of elements ≤ 1000
 * Example:
 * Input
 * 		3
 * 		7
 * 		17 15 8 9 2 4 6
 * 		4
 * 		1 3 5 7
 * 		7
 * 		8 12 10 5 4 1 6
 * 	Output
 * 		8 2 4 6 17 15 9
 * 		1 3 5 7
 * 		8 12 10 4 6 5 1
 * 
 * <br/>
 * <a href="http://www.practice.geeksforgeeks.org/problem-page.php?pid=400">Problem Link</a>
 * 
 * @author yougal.bisht
 *
 */
public class SegregateLL {
	
	public static void main(String[] args) {
		Node headNode1 = LinkListUtils.createList(new int[]{17,15,8,9,2,4,6});
		System.out.println(headNode1);
		System.out.println(segregateLL(headNode1));
		
		headNode1 = LinkListUtils.createList(new int[]{1,3,5,7});
		System.out.println(headNode1);
		System.out.println(segregateLL(headNode1));
		
		headNode1 = LinkListUtils.createList(new int[]{8,12,10,4,6,5,1});
		System.out.println(headNode1);
		System.out.println(segregateLL(headNode1));
	}
	
	private static Node segregateLL(Node head){
		Node evenPtr =null;
		Node prevEvenPtr =null;
		Node oddPtr =null;
		Node prevOddPtr=null;
		while(head!=null){
			Node temp = head.next;
			head.next=null;
			if(head.value%2==0){
				if(prevEvenPtr==null){
					evenPtr = head;
					prevEvenPtr=head;
				}else{
					prevEvenPtr.next=head;
					prevEvenPtr=head;
				}
			}else{
				if(prevOddPtr==null){
					oddPtr = head;
					prevOddPtr=head;
				}else{
					prevOddPtr.next=head;
					prevOddPtr=head;
				}
			}
			head=temp;
		}
		if(evenPtr!=null){
			prevEvenPtr.next=oddPtr;
			return evenPtr;
		}else{
			return oddPtr;
		}
	}

}
