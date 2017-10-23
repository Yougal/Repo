package com.yougal.array;

import java.util.Arrays;

/**
 * 
 * 
 * http://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
 * 
 * 
 * @author yougal.bisht
 *
 */
public class FindFourElementSetSumToGivenValue {

	public static void main(String[] args) {
		  int arr[] = {10, 20, 30, 40, 1, 2};
		  int X = 91;
		  findFourElements (arr, X);
	}

	private static void findFourElements(int[] arr, int X) {
		final class Aux implements Comparable<Aux>{
			int value;
			int first;
			int sec;
			public Aux(int value, int first, int sec) {
				super();
				this.value = value;
				this.first = first;
				this.sec = sec;
			}
			@Override
			public int compareTo(Aux o) {
				return this.value-o.value;
			}
		}
		Aux aux[] = new Aux [(arr.length*(arr.length-1))/2];
		int x = 0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				aux[x] = new Aux(arr[i]+arr[j], i, j); 
				x++;
			}
		}
		
		Arrays.sort(aux);
		
		for (int i = 0; i < aux.length; i++) {
			int indexFound = Arrays.binarySearch(aux, new Aux(X-aux[i].value,0,0));
			if(indexFound>=0){
				System.out.println(arr[aux[i].first] + "," + arr[aux[i].sec] + "," 
								 + arr[aux[indexFound].first]  + "," + arr[aux[indexFound].sec]);
			}
		}
		
		
		
		
	}
	
}
