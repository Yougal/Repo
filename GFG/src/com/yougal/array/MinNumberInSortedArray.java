package com.yougal.array;
/**
 * 
 * 
 * 
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
 * 
 * @author yougal.bisht
 *
 */
public class MinNumberInSortedArray {

	
	// Driver Program
    public static void main (String[] args)
    {
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ arr1[findMin(arr1, 0, n1-1)]);
 
        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ arr2[findMin(arr2, 0, n2-1)]);
 
        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ arr3[findMin(arr3, 0, n3-1)]);
 
        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ arr4[findMin(arr4, 0, n4-1)]);
 
        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ arr5[findMin(arr5, 0, n5-1)]);
 
        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ arr6[findMin(arr6, 0, n6-1)]);
 
        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ arr7[findMin(arr7, 0, n7-1)]);
 
        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ arr8[findMin(arr8, 0, n8-1)]);
 
        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ arr9[findMin(arr9, 0, n9-1)]);
    }
    
    static int findMin(int a[], int low, int high){
    	if(high-low+1==1){
    		return low;
    	}
    	if(high>low){
    		int mid = (low+high)/2;
    		int midMinus1 = mid-1<0?a.length-1:mid-1;
    		int midPlus1  = mid+1>a.length-1?0:mid+1;
	    	if(a[mid]<a[midPlus1] &&a[mid]< a[midMinus1]){
	    		return mid;
	    	}else{
	    		if(a[midPlus1]>a[midMinus1]){
	    			return findMin(a, low, midMinus1);
	    		}else{
	    			return findMin(a, midPlus1, high);
	    		}
	    	}
    	}
    	return -1;
    }
    
	
}
