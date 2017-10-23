package com.yougal.binaryTree;
/**
 * 
 * http://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
 * 
 * @author yougal.bisht
 *
 */
public class CheckMirrorTree {

	public static void main(String[] args) {
		Node<Integer> a = new Node<>(1);
	    Node<Integer> b = new Node<>(1);
	    a.left = new Node<>(2);
	    a.right = new Node<>(3);
	    a.left.left  = new Node<>(4);
	    a.left.right = new Node<>(5);
	 
	    b.left = new Node<>(3);
	    b.right = new Node<>(2);
	    b.right.left = new Node<>(5);
	    b.right.right = new Node<>(4);
	 
	    System.out.println(isMirror(a,b)?"Tree are mirror":"Tree are not mirror");
	    
	}

	private static boolean isMirror(Node<Integer> a, Node<Integer> b) {
		if(a==null && b==null){
			return true;
		}
		if(a!=null && b!=null){
			if(a.value==b.value){
				return isMirror(a.left,b.right) && isMirror(a.right, b.left);
			}
		}
		
		return false;
	}
	
}
