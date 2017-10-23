package com.yougal.binaryTree;

import java.util.Stack;

public class MergeBinaryTree {
	public static void main(String[] args) {
		/* Create following tree as first balanced BST
		        100
		       /  \
		     50    300
		    / \
		   20  70
		 */
		 Node<Integer> root1  = new Node<>(100);
		 root1.left         = new Node<>(50);
		 root1.right        = new Node<>(300);
		 root1.left.left   = new Node<>(20);
		 root1.left.right  = new Node<>(70);
		
		 /* Create following tree as second balanced BST
		         80
		        /  \
		      40   120
		 */
		 Node<Integer> root2  = new Node<>(80);
		 root2.left         = new Node<>(40);
		 root2.right        = new Node<>(120);
		
		 mergeTrees(root1, root2);
		

	}
	
	static void inorder( Node<Integer> root)
	{
	    if (root != null)
	    {
	        inorder(root.left);
	        System.out.printf("%d ", root.value);
	        inorder(root.right);
	    }
	}

	private static void mergeTrees(Node<Integer> root1, Node<Integer> root2) {
		if(root1==null){
			inorder(root2);
		}else if(root2==null){
			inorder(root1);
		}else {
			Stack<Node<Integer>> st1 = new Stack<>();
			Stack<Node<Integer>> st2 = new Stack<>();
			while(root1!=null){
				st1.push(root1);
				root1=root1.left;
			}
			
			while(root2!=null){
				st2.push(root2);
				root2=root2.left;
			}
			
			while(!st1.isEmpty() && !st2.isEmpty()){
				Node<Integer> value1 = st1.peek();
				Node<Integer> value2 = st2.peek();
				if(value1.value<value2.value){
					value1 = st1.pop();
					 System.out.printf("%d ", value1.value);
					if(value1.right!=null){
						st1.push(value1.right);
					}
				}else{
					value2 = st2.pop();
					 System.out.printf("%d ", value2.value);
					if(value2.right!=null){
						st2.push(value2.right);
					}
				}
			}
			while(!st1.isEmpty()){
				Node<Integer> value1 = st1.pop();
				 System.out.printf("%d ", value1.value);
				if(value1.right!=null){
					st1.push(value1.right);
				}
			}
			
			while(!st2.isEmpty()){
				Node<Integer> value2 = st2.pop();
				System.out.printf("%d ", value2.value);
				if(value2.right!=null){
					st2.push(value2.right);
				}
			}
		}
	}

}
