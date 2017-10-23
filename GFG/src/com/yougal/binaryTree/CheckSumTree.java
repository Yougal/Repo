package com.yougal.binaryTree;
/**
 * 
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * 
 * @author yougal.bisht
 *
 */
public class CheckSumTree {

	public static void main(String[] args) {
		Node<Integer> root  = new Node<>(26);
	    root.left         = new Node<>(10);
	    root.right        = new Node<>(3);
	    root.left.left   = new Node<>(4);
	    root.left.right  = new Node<>(6);
	    root.right.right = new Node<>(3);
	    if(isSumTree(root)){
	    	System.out.println("The given tree is a SumTree ");
	    }else{
	    	System.out.println("The given tree is not a SumTree ");
	    }
	}

	private static boolean isSumTree(Node<Integer> root) {
		int ls=0,rs=0;
		if(root!=null && !isLeaf(root)){
			if(root.left!=null){
				if(isLeaf(root.left)){
					ls = root.left.value;
				}else{
					ls = 2*root.left.value;
				}
			}
			if(root.right!=null){
				if(isLeaf(root.right)){
					rs = root.right.value;
				}else{
					rs = 2*root.right.value;
				}
			}
			if(ls+rs==root.value){
				return isSumTree(root.left) && isSumTree(root.right);
			}else{
				return false;
			}
			
		}
		return true;
	}

	private static boolean isLeaf(Node<Integer> node) {
		if(node!=null){
			return node.left==null && node.right==null;
		}else{
			return false;
		}
		
	}
	
}
