package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		int m=2;
		int n=2;
		Node headNode = LinkListUtils.createList(new int[]{1,2,3,4,5,6,7,8});
		DeleteNNodesAfterMNodes oper = new DeleteNNodesAfterMNodes();
		headNode = oper.performDelete(headNode,m,n);
		System.out.println(headNode);
		
	}

	private Node performDelete(Node headNode, int startLoc, int numberOfNodeToBeDeleted) {
		Node temp = headNode;
		while(temp!=null){
			Node start=temp;
			for (int i = 0; i < startLoc; i++) {
				if(temp==null){
					System.out.println("Impossible to navigate to Locate start Position.");
					return headNode;
				}
				start=temp;
				temp= temp.next;
			}
			for(int i=0;i<numberOfNodeToBeDeleted;i++){
				if(temp==null){
					return headNode;
				}
				temp= temp.next;
			}
				start.next=temp;
		}
		return headNode;
	}
}
