package com.yougal.binaryTree;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
 * @author yougal.bisht
 *
 */
public class OddEvenLevelNodeDiff {

	public static void main(String[] args) {
		 	Node<Integer> root = new Node<>(5);
	        root.left = new Node<>(2);
	        root.right = new Node<>(6);
	        root.left.left = new Node<>(1);
	        root.left.right = new Node<>(4);
	        root.left.right.left = new Node<>(3);
	        root.right.right = new Node<>(8);
	        root.right.right.right = new Node<>(9);
	        root.right.right.left = new Node<>(7);
	        
	        OddEvenLevelNodeDiff oddEvenLevelNodeDiff = new OddEvenLevelNodeDiff();
	        int result = oddEvenLevelNodeDiff.evaluateDifference(root,1);
	        System.out.println("Result: " + result);
	}

	private int evaluateDifference(Node<Integer> root, int level) {
		if(root!=null){
			int result = evaluateDifference(root.left, level+1)+evaluateDifference(root.right, level+1);
			if(level%2==0){
				return result-root.value ;
			}else{
				return result+root.value ;
			}
		}
		return 0;
	}
	
	
	
}
