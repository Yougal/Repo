package com.yougal.binaryTree;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class LeastCommonAncestor {

	/* Driver program to test above functions */
    public static void main(String args[])
    {
    	Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
 
        Node<Integer> lca = findLCA(root, 4, 7);
        if (lca != null)
            System.out.println("LCA(4, 7) = " + lca.value);
        else
            System.out.println("Keys are not present");
 
        lca = findLCA(root,4, 5);
        if (lca != null)
            System.out.println("LCA(2, 4) = " + lca.value);
        else
            System.out.println("Keys are not present");
    }
	
    
	private static Node<Integer> findLCA(Node<Integer> root, int i, int j) {
		Entry<Node<Integer>,Integer> result=  findLCAUtils(root, i, j,null);
		return result.getValue()==2?result.getKey():null;
	}

	private static Entry<Node<Integer>,Integer> findLCAUtils(Node<Integer> root , int i, int j, Node<Integer> parent) {
		if(root==null){
			return null;
		}else{
				if(root.value==i || root.value==j){
					return new SimpleEntry<Node<Integer>,Integer>(parent,1);
				}
				Entry<Node<Integer>,Integer> leftRoot= findLCAUtils(root.left, i, j,root);
				Entry<Node<Integer>,Integer> rightRoot= findLCAUtils(root.right, i, j,root);
				if(leftRoot!=null && rightRoot!=null){
					if(leftRoot.getKey()== rightRoot.getKey()){
						return new SimpleEntry<Node<Integer>,Integer>(leftRoot.getKey(),2);
					}else{
						return new SimpleEntry<Node<Integer>,Integer>(root,2);
					}
				}
				if(leftRoot!=null){
					return leftRoot;
				}
				if(rightRoot!=null){
					return rightRoot;
				}else{
					return null;
				}
			}
		}
	
}
