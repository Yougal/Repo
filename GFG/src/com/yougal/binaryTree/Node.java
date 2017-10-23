package com.yougal.binaryTree;

public class Node<T> {

	public T value;
	
	public Node<T> left;
	
	public Node<T> right;

	Node(T value){
		this.value=value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("    ").append(this.value).append("\n").append("  ").append("/").append("   ").append("\\").append("\n").
						append(this.left!=null ? this.left.value:"").append("       ").append(this.right!=null ? this.right.value:"");
		return sb.toString();
	}
	
}
