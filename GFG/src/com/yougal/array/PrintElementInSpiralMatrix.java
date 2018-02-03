package com.yougal.array;
/**
 * 
 * 
 * http://www.geeksforgeeks.org/print-kth-element-spiral-form-matrix/
 * 
 * @author yougal.bisht
 *
 */
public class PrintElementInSpiralMatrix {
	
	public static void main(String[] args) {
		int a[][] = {	{1,		2,		3,		4},
				        {12,	13,		14,		5},
				        {11, 	16, 	15, 	6},
				       // {10,	9,		8,		7}
				    };
		
		printSpiral(a,a.length, a[0].length);
	}

	private static void printSpiral(int[][] a, int rows, int cols) {
		int rowCount = rows,colCount=cols;
		for(int index=0;index<=rowCount&& index<=colCount;index++,rowCount/=2,colCount/=2){
			for(int p=index;p<cols-index;p++){
				System.out.println(a[index][p]);
			}
			for(int q=index+1;q<rows-index;q++){
				System.out.println(a[q][cols-index-1]);
			}
			for(int r=cols-index-2;r>=index&& rows-index-1!=index;r--){
				System.out.println(a[rows-index-1][r]);
			}
			for(int s=rows-index-2;s>index && cols-index-1!=index;s--){
				System.out.println(a[s][index]);
			}
		}
	}
	
}
