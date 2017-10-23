package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Given two numbers represented by two lists, write a function that returns sum list. 
 * The sum list is list representation of addition of two input numbers.
 * Example 1
 * 		Input:
 * 			First List: 5->6->3  // represents number 365
 * 			Second List: 8->4->2 //  represents number 248
 * 		Output
 * 			Resultant list: 3->1->6  // represents number 613
 * Example 2
 * 		Input:
 * 			First List: 7->5->9->4->6  // represents number 64957
 * 			Second List: 8->4 //  represents number 48
 * 		Output
 * 			Resultant list: 5->0->0->5->6  // represents number 65005
 * 
 * 
 * @author yougal.bisht
 *
 */
public class AddNumberInLL extends NumberLL{

	public static void main(String[] args) {
		Node firstNumber = LinkListUtils.createList(new int[]{5,6,3});
		Node secNumber = LinkListUtils.createList(new int[]{8,4,2});
		System.out.println("List: [ " + firstNumber +" ] - Number: [ "+ convertListToNumber(firstNumber) +" ]");
		System.out.println("List: [ " + secNumber +" ] - Number: [ "+ convertListToNumber(secNumber) +" ]");
		Node sum = add(firstNumber,secNumber);
		System.out.println("Sum: ");
		System.out.println("List: [ " + sum +" ] - Number: [ "+ convertListToNumber(sum) +" ]");
		System.out.println();
		firstNumber = LinkListUtils.createList(new int[]{7,5,9,4,6});
		secNumber = LinkListUtils.createList(new int[]{8,4});
		System.out.println("List: [ " + firstNumber +" ] - Number: [ "+ convertListToNumber(firstNumber) +" ]");
		System.out.println("List: [ " + secNumber +" ] - Number: [ "+ convertListToNumber(secNumber) +" ]");
		sum = add(firstNumber,secNumber);
		System.out.println("Sum: ");
		System.out.println("List: [ " + sum +" ] - Number: [ "+ convertListToNumber(sum) +" ]");
		
	}
	
	private static Node add(Node firstNumber, Node secNumber) {
		Node resultHead = null;
		Node prev = null;
		int carry = 0;
		while(firstNumber!=null && secNumber!=null ){
			int sum = firstNumber.value+secNumber.value + carry;
			carry = sum/10;
			Node digit = new Node(sum%10);
			if(resultHead==null){
				resultHead = digit;
				prev=digit;
			}else{
				prev.next=digit;
				prev = digit;
			}
			firstNumber=firstNumber.next;
			secNumber=secNumber.next;
		}
		while(firstNumber!=null){
			int sum = firstNumber.value+ carry;
			carry = sum/10;
			Node digit = new Node(sum%10);
			if(resultHead==null){
				resultHead = digit;
				prev=digit;
			}else{
				prev.next=digit;
				prev = digit;
			}
			firstNumber=firstNumber.next;
		}
		
		while(secNumber!=null){
			int sum = secNumber.value+ carry;
			carry = sum/10;
			Node digit = new Node(sum%10);
			if(resultHead==null){
				secNumber = digit;
				prev=digit;
			}else{
				prev.next=digit;
				prev = digit;
			}
			secNumber=secNumber.next;
		}
		if(carry>0){
			prev.next=new Node(carry);
		}
		
		return resultHead;
	}

}
