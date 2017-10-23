package com.yougal.binaryTree;

public class AddAllNodesGreaterThanIt {

	public static void main(String[] args) {
		/* Let us create following BST
			        50
			     /     \
			    30      70
			   /  \    /  \
			 20   40  60   80 
		*/
		Node<Integer> root = null;
		root = insert(root, 50);
		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 60);
		insert(root, 80);
		
		modifyBST(root);
		// print inoder tarversal of the modified BST
		inorder(root);

	}
	static int sum =0;
	
	private static void modifyBST(Node<Integer> root) {
		if(root==null){
			return;
		}else{
			modifyBST(root.right);
			sum=sum+root.value;
			root.value=sum;
			modifyBST(root.left);
		}
	}

	/* A utility function to insert a new node with given data in BST */
	static Node<Integer> insert(Node<Integer> node, int data)
	{
	    /* If the tree is empty, return a new node */
	    if (node == null) return new Node<>(data);
	 
	    /* Otherwise, recur down the tree */
	    if (data <= node.value)
	        node.left  = insert(node.left, data);
	    else
	        node.right = insert(node.right, data);
	 
	    /* return the (unchanged) node pointer */
	    return node;
	}
	
	static void inorder(Node<Integer> root)
	{
	    if (root != null)
	    {
	        inorder(root.left);
	        System.out.printf("%d ", root.value);
	        inorder(root.right);
	    }
	}
	
}
