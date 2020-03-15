package com.yougal.array;

public class FindElementInRowColSortedMatrix {

	public static void main(String[] args) {
		int mat[][] = { 	
						{10, 20, 30, 40},
		                {15, 25, 35, 45},
		                {27, 29, 37, 48},
		                {32, 33, 39, 50}
		              };
		searchMat(mat,20);
		
		
	}

	private static void searchMat(int[][] mat, int element) {
		int rows = mat.length;
		int i = 0 , j= mat[rows-1].length-1;
		while(j>=0 && i<rows){
			
			if(mat[i][j]== element){
				System.out.println(element + " found at " + i + "," + j);
				return;
			}
			
			if(mat[i][j]< element){
				i++;
			}else{
				j--;
			}
			
		}
		System.out.println("Not Found");
	}
	
}
