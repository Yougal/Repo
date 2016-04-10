package com.yougal;

import java.util.Arrays;

public class QuickSort {
	
	
	public static void main(String[] args) {
		int a[] = new int[]{3,1,4,1,5,9,2,6,5,3};
		int low = 0;
		int high= a.length-1;
		
		
		_quickSort(a,low, high);
		
		System.out.println(Arrays.toString(a));
		
	}

	private static void _quickSort(int[] a, int low, int high) {
		int i=low,j=high-1;
		if(i<high){
			int pivotLoc = i;
			int pivotEle = a[high];
			while(i<=j){
				while(a[i]<=pivotEle && i<=j){
					pivotLoc++;
					i++;
				}
				while(a[i]>pivotEle && i<=j){
					i++;
				}
				if(i<=j){
					swap(a,i,pivotLoc);
					pivotLoc++;
				}
			}
			swap(a,high,pivotLoc);
			_quickSort(a, low, pivotLoc-1);
			_quickSort(a, pivotLoc+1, high);
		}
		
	}

	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
