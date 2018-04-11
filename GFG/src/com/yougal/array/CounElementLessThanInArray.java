package com.yougal.array;

public class CounElementLessThanInArray {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		int count = countSmaller(arr,55);
		System.out.println(count);
	}

	private static int countSmaller(int[] a, int x) {
		int low=0, high=a.length;
		while(low<high) {
			int mid = (low+high)/2;
			if(a[mid]==x) {
				return mid+1;
			}else {
				if(a[mid]<x) {
					if(mid+1<a.length) {
						if(a[mid+1]>x) {
							return mid+1;
						}else {
							low=mid;
						}
					}else {
						return mid+1;
					}
				}else {
					if(mid-1>=0) {
						if(a[mid-1]<x) {
							return mid-1;
						}else {
							high=mid;
						}
					}else {
						return 0;
					}
				}
				
			}
		}
		return 0;
	}
	
}
