package com.yougal.binaryTree;

import java.util.HashMap;

/**
 * 
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 * 
 * @author yougal.bisht
 *
 */
public class CreateBinaryTreeParentArray {

	public static void main(String[] args) {
		 int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
		 HashMap<Integer, Node<Integer>> nodeMap= new HashMap<>(); 
		 for (int i = 0; i < parent.length; i++) {
			 nodeMap.put(i, new Node<Integer>(i));
		 }
		 Node<Integer> root=null;
		 for (int i = 0; i < parent.length; i++) {
			 if(parent[i]==-1){
				 root = nodeMap.get(i);
			 }else{
				 if(nodeMap.get(parent[i]).left==null){
					 nodeMap.get(parent[i]).left= nodeMap.get(i);
				 }else{
					 nodeMap.get(parent[i]).right= nodeMap.get(i);
				 }
			 }
		 }
		 if(root!=null){
			 inorder(root);
		 }else{
			 System.out.println("No root found...");
		 }
	}

	private static void inorder(Node<Integer> root) {
		if(root!=null){
			inorder(root.left);
			System.out.printf("%d , ",root.value);
			inorder(root.right);
		}
		
	}

}
