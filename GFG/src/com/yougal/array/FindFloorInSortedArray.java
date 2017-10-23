package com.yougal.array;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/floor-in-a-sorted-array/
 * 
 * @author yougal.bisht
 *
 */
public class FindFloorInSortedArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
	    int n = arr.length;
	    int x = 20;
	    int index = floorSearch(arr, 0, n-1, x);
	    if (index == -1)
	        System.out.printf("Floor of %d doesn't exist in array ", x);
	    else
	    	System.out.printf("Floor of %d is %d ",x, arr[index]);
	}

	private static int floorSearch(int[] a, int low, int high, int x) {
		if(low<=high){
		
			int mid = (low+high)/2;
			if(a[mid]==x){
				return mid;
			}
			if(a[mid]>x){
				if(mid-1>=low){
					if(a[mid-1]>=x){
						return floorSearch(a, low, mid-1, x);
					}else{
						return mid;
					}
				}else{
					return -1;
				}
			}else{
				if(mid+1<=high && a[mid+1]<=x){
					return floorSearch(a, mid+1, high, x);
				}else{
					return mid;
				}
			}
		}else{
			return -1;
		}
	}
	
}
