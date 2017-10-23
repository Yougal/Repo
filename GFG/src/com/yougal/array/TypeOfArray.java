package com.yougal.array;
/**
 *
 * http://www.geeksforgeeks.org/type-array-maximum-element/
 * 
 * @author yougal.bisht
 *
 */
public class TypeOfArray {

	public static void main(String[] args) {
		int arr1[] = { 4, 5, 6, 1, 2, 3}; // Ascending rotated
	    findType(arr1);
	 
	    int arr2[] = { 2, 1, 7, 5, 4, 3}; // Descending rotated
	    findType(arr2);
	 
	    int arr3[] = { 1, 2, 3, 4, 5, 8}; // Ascending
	    findType(arr3);
	 
	    int arr4[] = { 9, 5, 4, 3, 2, 1}; // Descending
	    findType(arr4);
	 
	}

	private static void findType(int[] arr) {
		
		int i = 0;
		int n = arr.length; 
	    // Check if the array is in ascending order
	    while (i < n-1 && arr[i] <= arr[i+1])
	        i++;
	    
	    if(i==n-1){
	    	System.out.println("Ascending with maximum element: " + arr[n-1]);
	    	return;
	    }else{
	    	int j=i+1;
	    	int countElementTraversed=0;
	    	do{
	    		int p = (j+1)%n;
	    		if(arr[j] <= arr[p]){
	    			j=p;
	    			countElementTraversed++;
	    			continue;
	    		}else{
	    			break;
	    		}
	    	}while(j!=i);
	    	
	    	if(j==i && countElementTraversed==n-1){
	    		System.out.println("Ascending Rotated with maximum element: " + arr[i]);
	    		return;
	    	}
	    }
	    
	    while (i < n-1 && arr[i] >= arr[i+1])
	        i++;
	    
	    if(i==n-1){
	    	System.out.println("Descending with maximum element: " + arr[0]);
	    	return;
	    }else{
	    	int j=i+1;
	    	int countElementTraversed=0;
	    	do{
	    		int p = (j+1)%n;
	    		if(arr[j] >= arr[p]){
	    			j=p;
	    			countElementTraversed++;
	    			continue;
	    		}else{
	    			break;
	    		}
	    	}while(j!=i);
	    	
	    	if(j==i && countElementTraversed==n-1){
	    		System.out.println("Descending Rotated with maximum element: " + arr[i+1]);
	    		return;
	    	}
	    
	    	
	    }
	    
	    
	    
	    
	    
	}
	
}
