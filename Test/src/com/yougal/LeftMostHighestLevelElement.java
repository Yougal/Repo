package com.yougal;

public class LeftMostHighestLevelElement {

	
	public static void main(String[] args) {
		 Node root=new Node(1);
	     root.leftChild=new Node(2);
	     root.rightChild=new Node(3);
	     root.leftChild.leftChild=new Node(4);
	     //root.leftChild.leftChild.leftChild=new Node(9);
	     root.leftChild.rightChild=new Node(5);
	     //root.leftChild.rightChild.leftChild=new Node(12);
	     //root.leftChild.rightChild.leftChild.leftChild=new Node(13);
	     root.rightChild.leftChild=new Node(7);
	     root.rightChild.rightChild=new Node(8);
	     System.out.println(findNode(root));
	}
	 
	 public static Node findNode(Node root){
		 return _findNodeInternal(root,0).item;
	 }
	 
	 
	 

	private static Result _findNodeInternal(Node root,int level) {
		if(root==null){
			return null;
		}
		Result left = _findNodeInternal(root.leftChild,level+1);
		Result right = _findNodeInternal(root.rightChild,level+1);
		
		
		if(left!=null && right!=null){
			if(left.level>right.level){
				return left;
			}else if(left.level<right.level){
				return right;
			}else{
				return left;
			}
		}
		if(left!=null && right==null){
				return left;
		}else if(left==null && right!=null){
			return right;
		}else{
			if(root.leftChild!=null){
				return new Result(level+1, root.leftChild);
			}else{
				return null;
			}
		}
		
	}
	
	static class Result{
	    int level;
		Node item;
		public Result(int level, Node item) {
			super();
			this.level = level;
			this.item = item;
		}
	}
}
