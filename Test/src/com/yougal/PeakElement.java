package com.yougal;

//A Java program to find a peak element element using divide and conquer

class PeakElement
{
 static int findPeakUtil(int arr[], int low, int high, int n)
 {
     int mid = low + (high - low)/2;  

     if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
          arr[mid+1] <= arr[mid]))
         return mid;

     // If middle element is not peak and its left neighbor is
     // greater than it,then left half must have a peak element
     else if (mid > 0 && arr[mid-1] > arr[mid])
         return findPeakUtil(arr, low, (mid -1), n);

     // If middle element is not peak and its right neighbor
     // is greater than it, then right half must have a peak
     // element
     else return findPeakUtil(arr, (mid + 1), high, n);
 }

 // A wrapper over recursive function findPeakUtil()
 static int findPeak(int arr[], int n)
 {
     return findPeakUtil(arr, 0, n-1, n);
 }

 // Driver method
 public static void main (String[] args)
 {
     int arr[] = {10, 20, 15, 2, 23, 90, 67};
     int n = arr.length;
     System.out.println("Index of a peak point is " +
                         findPeak(arr, n));
 }
}