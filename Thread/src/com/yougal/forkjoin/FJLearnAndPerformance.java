package com.yougal.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class FJLearnAndPerformance {

	
	public static void main(String[] args) {
		int arr1[] = IntStream.range(1, 90000000).toArray();
		RegulaMergeSort rs = new RegulaMergeSort(arr1);
		long startTime1 = System.currentTimeMillis();
		rs.sort();
		long stopTime1 = System.currentTimeMillis();
		System.out.println("Time take for normal Merger Sort: " + (stopTime1-startTime1)/1000.0 +" secs" );
		int arr2[] = IntStream.range(1, 90000000).toArray();
		FJMergeSort fjrs = new FJMergeSort(arr2);
		long startTime2 = System.currentTimeMillis();
		fjrs.sort();
		long stopTime2 = System.currentTimeMillis();
		System.out.println("Time take for FJ Merger Sort: " + (stopTime2-startTime2)/1000.0 +" secs" );
		
	}
	
	
	
	
	public static class FJMergeSort extends RecursiveTask<int []>{
		
		private static final long serialVersionUID = 1L;

		int arr[];
		
		private static final int THRESHHOLD = 99;
		
		FJMergeSort(int arr[]){
			this.arr=arr;
		}
		
		public void sort(){
			//System.out.println("Thread: " + Thread.currentThread().getName());
			_mergeSort(0,arr.length-1);
		}

		private void _mergeSort(int low, int high) {
			if((high-low)<=THRESHHOLD) {
				int arrA[] = Arrays.copyOfRange(arr, low, high+1);
				RegulaMergeSort regulaMergeSort = new RegulaMergeSort(arrA);
				regulaMergeSort.sort();
				System.arraycopy(arrA, 0, arr,low,high-low);
			}else {
				if(low<high) {
					int mid = (low+high)/2;
					int arrA[] = Arrays.copyOfRange(arr, low, mid);
					int arrB[] = Arrays.copyOfRange(arr, mid+1, high+1);
					FJMergeSort fjMergeSortA = new FJMergeSort(arrA);
					FJMergeSort fjMergeSortB = new FJMergeSort(arrB);
					fjMergeSortA.fork();
					fjMergeSortB.fork();
					int[] resultA = fjMergeSortA.join();
					int[] resultB = fjMergeSortB.join();
					System.arraycopy(resultA,0, arr,low,resultA.length);
					System.arraycopy(resultB,0, arr,mid+1,resultB.length);
				}
			}
		}

		@Override
		protected int[] compute() {
			sort();
			return arr;
		}
		
	}
	
	
	public static class RegulaMergeSort{
		
		int arr[];
		
		RegulaMergeSort(int arr[]){
			this.arr=arr;
		}
		
		public void sort(){
			_mergeSort(0, arr.length-1);
		}

		private void _mergeSort(int low, int high) {
			if(low<high) {
				int mid = (low+high)/2;
				_mergeSort(low, mid);
				_mergeSort(mid+1, high);
				merge(arr, low,mid,mid+1,high);
			}
			
		}
		
		public void merge(int arr[], int st1, int end1, int st2,int end2) {
			int arrA[] = Arrays.copyOfRange(arr, st1, end1+1);
			int arrB[] = Arrays.copyOfRange(arr, st2, end2+1);
			int index = st1<st2?st1:st2;
			int i =0 ,j =0;
			while(i<arrA.length && j<arrB.length) {
				if(arrA[i]>arrB[j]) {
					arr[index++] = arrA[i++];
				}else {
					arr[index++] = arrB[j++];
				}
			}
			while(i<arrA.length) {
					arr[index++] = arrA[i++];
			}
			while(j<arrB.length) {
				arr[index++] = arrB[j++];
		}
			
		}
		
	}
	
}
