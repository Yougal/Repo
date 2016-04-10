package com.yougal;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 
 * In a binary tree, find and print the path with smallest weight.
 * Criteria: the tree contains integer values in the nodes. 
 * It may not be balanced tree. 
 * Weight is calculated by sum of values in the nodes in that path. 
 * Write code that returns the path as well as the minimum weight.
 * 
 * 
 * @author yougal.bisht
 *
 */
public class PrintPathWithSmallestWeight {

	public void findPathWithSmallestWeight(BinaryTree theTree){
		System.out.println(_findPathWithSmallestWeight(theTree.root));
	}
	
	private ResultWrapper _findPathWithSmallestWeight(Node root){
		
		if(root==null){
			return new ResultWrapper(0);
		}
		ResultWrapper sumLeft =new ResultWrapper(root.value);
		sumLeft.resultList.add(root);
		ResultWrapper sumRight =new ResultWrapper(root.value);
		sumRight.resultList.add(root);
		if(root.leftChild!=null){
			ResultWrapper leftResult = _findPathWithSmallestWeight(root.leftChild);
			sumLeft.value=sumLeft.value+ leftResult.value;
			sumLeft.resultList.addAll(leftResult.resultList);
		}
		if(root.rightChild!=null){
			ResultWrapper righResult = _findPathWithSmallestWeight(root.rightChild);
			sumRight.value=sumRight.value+ righResult.value;
			sumRight.resultList.addAll(righResult.resultList);
		}
		if(root.leftChild!=null && root.rightChild!=null){
			if(sumLeft.value<sumRight.value){
				return sumLeft;
			}else{
				return sumRight;
			}
		}else if(root.leftChild!=null){
			return sumLeft;
		}else if(root.rightChild!=null){
			return sumRight;
		}else{
			ResultWrapper resultWrapper = new ResultWrapper(root.value);
			resultWrapper.resultList.add(root);
			return resultWrapper;
		}
		
		
	}
	
	public static void main(String[] args) {
		PrintPathWithSmallestWeight pathWithSmallestWeight = new PrintPathWithSmallestWeight();
		BinaryTree theTree = pathWithSmallestWeight.initialize();
		
		pathWithSmallestWeight.findPathWithSmallestWeight(theTree);
	}
	
	
	public BinaryTree initialize(){
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNode(50);
		theTree.addNode(25);
		theTree.addNode(15);
		theTree.addNode(30);
		theTree.addNode(75);
		theTree.addNode(85);
		theTree.addNode(14);
		theTree.addNode(13);
		theTree.addNode(12);
		theTree.addNode(29);
		theTree.addNode(74);
		theTree.addNode(73);
		return theTree;
	}
	
	class ResultWrapper{
		int value;
		List<Node> resultList = new LinkedList<Node>();
		public ResultWrapper(int value) {
			this.value= value;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ResultWrapper [SmallestWeight=" + value + ", Path="
					+ resultList + "]";
		}
	}
	
	
	
	
}

