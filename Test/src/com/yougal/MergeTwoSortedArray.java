package com.yougal;

import java.util.Arrays;

public class MergeTwoSortedArray {
	
	
	public static void main(String[] args) {
		int arrA[]= new int[] {2,4,8,13,17, -1,-1,-1,-1,-1};
		
		int arrB[]= new int[] {1,3,5,12,19};
		
		mergeArray(arrA, 5, arrB, 5);
		System.out.println(Arrays.toString(arrA));
		
	}

	private static void mergeArray(int[] arrA, int m, int[] arrB, int n) {
		int j=0;
		int startLoc=m+1;
		int size=0;
		for(int i=0;i<n;){
			while(arrA[j]<arrB[i]){
				j++;
			}
			if(size>0){
				if(arrA[startLoc]<arrB[j]){
					int temp=arrA[j];
					arrA[j]=arrB[i];
					size++;
					arrB[startLoc]=-1;
					arrB[startLoc+size]=temp;
				}else{
					int temp= arrA[j];
					arrA[j]=arrB[i];
					j++;
					size++;
					arrB[startLoc+size]=temp;
				}
			}else{
				arrA[startLoc+size]=arrA[j];
				arrA[j]=arrB[i];
				size++;
				j++;
				i++;
			}
		}
	}

}
