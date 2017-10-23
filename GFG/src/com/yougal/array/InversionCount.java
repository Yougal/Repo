package com.yougal.array;
/**
 * 
 * http://www.geeksforgeeks.org/counting-inversions/
 * 
 * @author yougal.bisht
 *
 */
public class InversionCount {

	static int arr[] = new int[]{7, 4, 1, 3, 5};
    
    static int getInvCount(int arr[], int n)
    {
    	return mergeSort(arr,new int[arr.length],0,n);
    }
    
    
    
    
  
    private static int mergeSort(int[] arr, int temp[], int left, int right) {
    	int invCount = 0;
    	if(left<right){
    		int mid = (left+right)/2;
    		invCount=mergeSort(arr,temp ,left, mid);
    		invCount+=mergeSort(arr,temp , mid+1, right);
    		invCount+=merge(arr, temp ,left,mid+1,right);
    	}
		return invCount;
	}


    private static int merge(int[] arr,int temp[], int left, int mid, int right) {
    	int invCount=0;
    	int i=left;
    	int j=mid;
    	int k=left;
    	 while ((i<=mid-1) && (j<=right)){
    	    if (arr[i] <= arr[j]){
    	      temp[k++] = arr[i++];
    	    }else{
    	      temp[k++] = arr[j++];
    	      invCount+=(mid - i);
    	    }
    	  }
    	  /* Copy the remaining elements of left subarray
    	   (if there are any) to temp*/
    	  while (i <= mid - 1)
    	    temp[k++] = arr[i++];
    	  /* Copy the remaining elements of right subarray
    	   (if there are any) to temp*/
    	  while (j <= right)
    	    temp[k++] = arr[j++];
    	  /*Copy back the merged elements to original array*/
    	  for (i=left; i <= right; i++)
    	    arr[i] = temp[i];
		return invCount;
	}


	// Driver method to test the above function
    public static void main(String[] args) 
    {
        System.out.println("Number of inversions are " + getInvCount(arr,arr.length));
     
    }
	
}
