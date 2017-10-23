package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

/**
 * 
 * Given two polynomials represented by two linkedlists that contains the coefficients of poynomials. 
 * Your task is to complete the method proOfPolynomials which takes four arguments:  
 * the address of the head of the linked list1, the address of the head of the linked list2, 
 * size of linked list1 and size of linked list2. 
 * The function returns the head of a linked list formed after multiplication of given polynomials.
 * Input:
 * The first line contains an integer T, depicting total number of test cases. 
 * First line of each test case contains two integers M and N,highest degree of the polynomial 
 * linked list1 and linked list2.Next two line contains M and N integers , 
 * decribes the coefficients of polynomials.
 * 
 * Output:
 * 		Print the coefficients of resultant poynomial.
 * Constraints:
 * 		1<=T<=100
 * 		1<=M,N<=100
 * 		1<=size of list1 & list2<=100
 * Example:
 * Input:
 * 		2
 * 		4 3
 * 		1 0 3 2
 * 		2 0 4
 * 		5 4
 * 		1 9 3 4 7
 * 		4 0 2 5
 * Output:
 * 		2 0 10 4 12 8
 * 		4 36 14 39 79 23 34 35
 * Explanation:
 * 		First case:
 * 			First polynomial: 
 * 					1 + 0x^1 + 3x^2 + 2x^3
 * 			Second polynomial: 
 * 					2 + 0x^1 + 4x^2
 * 			Product polynomial:
 * 					2 + 0x^1 + 10x^2 + 4x^3 + 12x^4 + 8x^5
 * 		Second case:
 * 			First polynomial:
 * 					1 + 9x^1 + 3x^2 + 4x^3 + 7x^4
 * 			Second polynomial: 
 * 					4 + 0x^1 + 2x^2 + 5x^3
 * 		Product polynomial: 
 * 					4 + 36x^1 + 14x^2 + 39x^3 + 79x^4 + 23x^5 + 34x^6 + 35x^7
 * 
 * <br/>
 * <a href="http://www.practice.geeksforgeeks.org/problem-page.php?pid=700439">Problem Link</a>
 * 
 * @author yougal.bisht
 *
 */
public class MultiplyPolynomialLL extends NumberLL {

	
	public static void main(String[] args) {
		MultiplyPolynomialLL pro = new MultiplyPolynomialLL();
		Node firstNumber = LinkListUtils.createList(new int[]{1,0,3,2});
		Node secNumber = LinkListUtils.createList(new int[]{2,0,4});
		System.out.println("List: [ " + firstNumber +" ] - Number: [ "+ convertListToNumber(firstNumber) +" ]");
		System.out.println("List: [ " + secNumber +" ] - Number: [ "+ convertListToNumber(secNumber) +" ]");
		Node profin = pro.proOfPolynomials(firstNumber,secNumber,0,0);
		System.out.println("Product: ");
		System.out.println("List: [ " + profin +" ] - Number: [ "+ convertListToNumber(profin) +" ]");
		System.out.println();
		firstNumber = LinkListUtils.createList(new int[]{1,9,3,4,7});
		secNumber = LinkListUtils.createList(new int[]{4,0,2,5});
		System.out.println("List: [ " + firstNumber +" ] - Number: [ "+ convertListToNumber(firstNumber) +" ]");
		System.out.println("List: [ " + secNumber +" ] - Number: [ "+ convertListToNumber(secNumber) +" ]");
		profin = pro.proOfPolynomials(firstNumber,secNumber,0,0);
		System.out.println("Product: ");
		System.out.println("List: [ " + profin +" ] - Number: [ "+ convertListToNumber(profin) +" ]");
	}
	
	
	Node proOfPolynomials(Node head1, Node head2, int n1, int n2)
    {
		Node resultHead = null;
		Node prev = null;
		int i=1;
		for(Node ptr1= head1;ptr1!=null;ptr1=ptr1.next,i++){
			int j= i;
			for (Node ptr2= head2;ptr2!=null;ptr2=ptr2.next,j++) {
				Node findNode = findNode(resultHead,j);
				if(findNode!=null){
					int sum = ptr1.value*ptr2.value+findNode.value;
					findNode.value=sum;
				}else{
					Node digit = new Node(ptr1.value*ptr2.value);
					if(resultHead==null){
						resultHead = digit;
						prev=digit;
					}else{
						prev.next=digit;
						prev = digit;
					}
				}
			}
		}
		return resultHead;
    }


	private Node findNode(Node resultHead, int j) {
		while(resultHead!=null&& j>1){
			resultHead=resultHead.next;
					j--;
		}
		if(resultHead==null){
			return null;
		}
		return resultHead;
	}
	
	
	
}
