package com.yougal;

import java.util.Map;

import com.yougal.utils.Node;

/**
 * 
 * Print first and last node of all the levels of a tree. 
		Ex if tree is - 
		
		root->data = 1 
		root->left->data = 2 
		root->right->data = 3 
		root->left->right->data = 4 
		root->right->right->data = 6 
		root->right->left->data = 5 
		root->right->left->left->data = 7 
		root->right->left->left->right->data = 8 
		
		Output - 1 2 3 4 6 7 8
 * 
 * @author yougal.bisht
 *
 */



public class NodeDisplay {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public <T> void setFirstAndLastNodeOfLevel(Node<T> root,int level, int direction,
			Map<Integer,LevelNodeWrapper<T>> resultMap){
		if(root==null){
			return;
		}
		if(root!=null){
			if(!resultMap.containsKey(level)){
				LevelNodeWrapper<T> levelNodeWrapper = new LevelNodeWrapper<T>(level);
				resultMap.put(level, levelNodeWrapper);
			}
			setLevelNodes(resultMap.get(level),root, direction);
		}
		
		if(root.left!=null && root.right!=null){
			setFirstAndLastNodeOfLevel(root.left,level+1, -1,resultMap);
			setFirstAndLastNodeOfLevel(root.left,level+1, 1,resultMap);
		}
		
		if(root.right!=null && root.left==null){
			setFirstAndLastNodeOfLevel(root.left,level+1, -1,resultMap);
		}
		
	}
	public <T> void setLevelNodes(LevelNodeWrapper<T> levelNode,Node<T> node, int direction){
		switch(direction){
			case 0 : 
					levelNode.leftNode = node;
					levelNode.rightNode = node;
					break;
			case -1 : 
					levelNode.leftNode = node;
					break;
			
			case 1 : 
					levelNode.rightNode = node;
					break;
		}
	}
	
	
	static class LevelNodeWrapper<T>{
		public LevelNodeWrapper(int level) {
			this.level= level;
		}
		Node<T> leftNode;
		Node<T> rightNode;
		int level;
	}
	
}
