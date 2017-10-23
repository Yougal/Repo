package com.yougal.binaryTree;

public class DistanceBetweenTwoNodes {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
	    root.left = new Node<>(2);
	    root.right = new Node<>(3);
	    root.left.left = new Node<>(4);
	    root.left.right = new Node<>(5);
	    root.right.left = new Node<>(6);
	    root.right.right = new Node<>(7);
	    root.right.left.right = new Node<>(8);
	    System.out.printf( "Dist(4, 5) = " +findDistance(root, 4, 5));
	    System.out.printf( "\nDist(4, 6) = " +findDistance(root, 4, 6));
	    System.out.printf( "\nDist(3, 4) = " +findDistance(root, 3, 4));
	    System.out.printf( "\nDist(2, 4) = " +findDistance(root, 2, 4));
	    System.out.printf( "\nDist(8, 5) = " +findDistance(root, 8, 5));
	}

	private static int findDistance(Node<Integer> root, int ele1, int ele2) {
		int heightEle1=findHeight(root,ele1,0);
		int heightEle2=findHeight(root,ele2,0);
		findLca(root,ele1,ele2);
		int height = findHeight(root,lca.value,0);
		return heightEle1+heightEle2 - 2*height;
	}
	
	private static Node<Integer> lca = null;

	private static int findLca(Node<Integer> root, int ele1, int ele2) {
		if(root==null){
			return 0;
		}else{
			int value = 0;
			if(root.value==ele1 || root.value==ele2){
				value =1 + findLca(root.left, ele1, ele2) + findLca(root.right, ele1, ele2);
			}else{
				value =findLca(root.left, ele1, ele2) + findLca(root.right, ele1, ele2);
			}
			if(value==2){
				lca= root;
				value=0;
			}
			return value;
		}
		
	}

	private static int findHeight(Node<Integer> root, int ele, int level) {
		if(root==null){
			return -1;
		}else if(root.value==ele){
			return level;
		}else{
			
			int leftHeight = findHeight(root.left,ele, level+1);
			if(leftHeight==-1){
				int rightHeight = findHeight(root.right,ele, level+1);
				return rightHeight;
			}else{
				return leftHeight;
			}
		}
	}
	
	
}
