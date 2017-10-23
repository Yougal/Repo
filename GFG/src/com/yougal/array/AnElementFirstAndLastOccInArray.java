package com.yougal.array;

public class AnElementFirstAndLastOccInArray {

	public static void main(String[] args) {
		int arr[] = {2, 2, 2, 2, 2, 3, 4, 7, 8, 8};
		
		int element = 8;
		
		System.out.println("First Occurrence = " + first(arr,element));
	    System.out.println("Last Occurrence = " + last(arr,element));
		
	}

	private static int last(int[] arr, int element) {

		int low=0;
		int high=arr.length;
		
		while(low<=high){
			int mid =  (low+high)/2;
			if(arr[mid]==element && (mid==arr.length-1 || arr[mid+1] > element)){
				return mid;
			}if(arr[mid]>element){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return -1;
	}

	private static int first(int[] arr, int element) {
		int low=0;
		int high=arr.length;
		
		while(low<=high){
			int mid =  (low+high)/2;
			if(arr[mid]==element && (mid==0 || arr[mid-1] < element)){
				return mid;
			}if(arr[mid]>=element){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return -1;
	}
	
}
