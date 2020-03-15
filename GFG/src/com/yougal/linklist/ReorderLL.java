package com.yougal.linklist;

import java.util.Stack;

public class ReorderLL {
	
	public ListNode reorderList(ListNode A) {
        
        Stack<ListNode> stk = new Stack<>();
        ListNode temp=A;
        int count =0;
        while(temp!=null){
            stk.push(temp);
            temp=temp.next;
            count++;
        }
        int i=0;
        temp=A;
        ListNode prevNode = null;
        while(i<=count/2){
            ListNode next = temp.next;
            ListNode lastNode = stk.pop();
            temp.next=lastNode;
            if(prevNode!=null){
                prevNode.next=temp;
            }
            lastNode.next=null;
            prevNode=lastNode;
            temp=next;
            i++;
        }
        return A;
        
    }
	
	public static void main(String[] args) {
		String input ="90 -> 94 -> 25 -> 51 -> 45 -> 29 -> 55 -> 63 -> 48 -> 27 -> 72 -> 10 -> 36 -> 68 -> 16 -> 20 -> 31 -> 7 -> 95 -> 70 -> 89 -> 23 -> 22 -> 9 -> 74 -> 71 -> 35 -> 5 -> 80 -> 11 -> 49 -> 92 -> 69 -> 6 -> 37 -> 84 -> 78 -> 28 -> 43 -> 64 -> 96 -> 57 -> 83 -> 13 -> 73 -> 97 -> 75 -> 59 -> 53 -> 52 -> 19 -> 18 -> 98 -> 12 -> 81 -> 24 -> 15 -> 60 -> 79 -> 34 -> 1 -> 54 -> 93 -> 65 -> 44 -> 4 -> 87 -> 14 -> 67 -> 26 -> 30 -> 77 -> 58 -> 85 -> 33 -> 21 -> 46 -> 82 -> 76 -> 88 -> 66 -> 101 -> 61 -> 47 -> 8";
		ListNode head= convertToLL(input);
		ListNode reorderList = new ReorderLL().reorderList(head);
		System.out.println(reorderList);
		
	}
	
	private static ListNode convertToLL(String input) {
		String arr[] = input.split(" -> ");
		ListNode head = null;
		ListNode lastNode = null;
		for (String number : arr) {
			ListNode node = new ListNode(Integer.parseInt(number));
			if(lastNode==null) {
				head=node;
			}else {
				lastNode.next=node;
			}
			lastNode= node;
		}
		return head;
	}

	static class ListNode {
		     public int val;
		     public ListNode next;
		     ListNode(int x) { val = x; next = null; }
		     
		    @Override
		 	public String toString() {
		 		return val + " -> " + next;
		 	}
	 }

}
