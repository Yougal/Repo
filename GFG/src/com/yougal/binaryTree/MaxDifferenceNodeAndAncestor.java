package com.yougal.binaryTree;

public class MaxDifferenceNodeAndAncestor {

    public int maxAncestorDiff(Node<Integer> root) {
    	
        Result result= _maxAncestorDiff(root);
        return result.maxDifference;
    }
    
    private static class Result{
        int minNodeValue;
        int maxNodeValue;
        
        int maxDifference;
        
        void updateMinValue(Result r1){
        	if(r1==null) {
        		return;
        	}
        	this.minNodeValue = Math.min(r1.minNodeValue, 
        									Math.min(this.minNodeValue,
        																Math.min(r1.maxNodeValue, this.maxNodeValue)));
        }
        
        void updateMaxValue(Result r1){
        	if(r1==null) {
        		return;
        	}
        	this.maxNodeValue= Math.max(r1.maxNodeValue, 
        									Math.max(this.maxNodeValue,
        																Math.max(r1.minNodeValue, this.minNodeValue)));
        }
        
        void updateMaxDifference(Result r1){
        	if(r1==null) {
        		return;
        	}
        	this.maxDifference= Math.max(r1.maxDifference,this.maxDifference);
        }
        
    }
    
    public Result _maxAncestorDiff(Node<Integer> root) {
        if(root==null){
            return null;
        }else{ 
        	Result result = new Result();
        	result.maxNodeValue=root.value;
        	result.minNodeValue=root.value;
        	Result leftValue = _maxAncestorDiff(root.left);
        	Result rightValue = _maxAncestorDiff(root.right);
        	result.updateMaxValue(leftValue);
        	result.updateMaxValue(rightValue);
        	result.updateMinValue(leftValue);
        	result.updateMinValue(rightValue);
        	result.updateMaxDifference(leftValue);
        	result.updateMaxDifference(rightValue);
        	result.maxDifference=Math.max(result.maxDifference, Math.abs(root.value-result.maxNodeValue));
        	result.maxDifference=Math.max(result.maxDifference, Math.abs(root.value-result.minNodeValue));
        	
        	if(result.minNodeValue>root.value) {
        		result.minNodeValue = root.value;
        	}
        	
        	if(result.maxNodeValue<root.value) {
        		result.maxNodeValue = root.value;
        	}
            return result;
        }
    }
    
    public static void main(String[] args) {
    	Node<Integer> root = new Node<>(2);
        root.right = new Node<>(0);
        root.right.right = new Node<>(4);
        root.right.right.right = new Node<>(3);
        root.right.right.right.right = new Node<>(1);
        
        MaxDifferenceNodeAndAncestor ancestor = new MaxDifferenceNodeAndAncestor();
        int maxAncestorDiff = ancestor.maxAncestorDiff(root);
        System.out.println(maxAncestorDiff);
	}
}
