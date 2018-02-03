package com.yougal.binaryTree;

import java.util.Arrays;

public class SegmentTree {

	int tree[];
	
	int orginalArray[] ;
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree  st = new SegmentTree(arr, n);
        System.out.println(Arrays.toString(st.tree));
        
        System.out.println("Sum of values in given range = " + st.getSum(1, 3));
        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
        st.updateValue(1, 10);
 
        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +  st.getSum(1, 3));
	}
	
	private int getSum(int i, int j) {
		return _calculateSum(i,j,0,orginalArray.length-1,0);
	}

	private int _calculateSum(int i, int j, int low, int high,int sti) {
		//outside range
		if(j<low || i>high) {
			return 0;
		}
		//if queried range is between low and high we need that sum
		if(i<=low && j>=high) {
			return tree[sti];
		}else {
			int mid = (low+high)/2;
			return _calculateSum(i,j,low,mid,(2*sti)+1) + _calculateSum(i,j,mid+1,high,(2*sti)+2);
		}
		
	}

	public SegmentTree(int arr[], int n){
		int heighOfTree = (int)Math.ceil(Math.log10(n)/Math.log10(2));
		int totalElementInST=2*(int)Math.pow(2, heighOfTree)-1;
		tree=new int[totalElementInST];
		orginalArray= arr;
		constructST(0, n - 1, 0);
	}

	private void constructST(int low, int high, int index) {
		
		if(low==high) {
			tree[index] = orginalArray[low];
			return;
		}
		int mid = (high+low)/2;
		constructST( low, 	  mid,   (2*index)+1); 
		constructST(mid+1,  high,  (2*index)+2); 
		tree[index] = tree[(2*index)+1]+tree[(2*index)+2];
	}
	
	private void updateValue(int i, int value) {
		if(i>=0 && i<orginalArray.length) {
			int difference = value -orginalArray[i];
			orginalArray[i]=value;
			updateSegmentTree(0,orginalArray.length-1,difference, i,0);
		}
		
	}

	private void updateSegmentTree(int low, int high, int difference, int i, int index) {
		if(i<low || i>high) {
			return;
		}else {
			tree[index]+=difference;
			if(low!=high) {
				int mid = (high+low)/2;
				updateSegmentTree(low, mid, difference, i, (2*index)+1);
				updateSegmentTree(mid+1, high, difference, i, (2*index)+2);
			}
		}
	}
	
}
