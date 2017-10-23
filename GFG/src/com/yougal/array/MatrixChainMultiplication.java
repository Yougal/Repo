package com.yougal.array;

/**
 * 
 * http://www.geeksforgeeks.org/?p=15553
 * 
 * @author yougal.bisht
 *
 */
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4,5};
        System.out.println("Minimum number of multiplications is "+
                           matrixChainOrder(arr));
	}

	private static int matrixChainOrder(int[] p) {
		int n = p.length;
		int m[][] = new int[n][n];
		
		for(int i=1;i<n;i++){
			m[i][i]=0;
		}
		
		
		for(int L =2;L<=n;L++){
				for(int i=1;i<n-L+1;i++){
					StringBuilder sb = new StringBuilder();
					int j = i+L;
					for(int k=i;k<j;k++){
						
						m[i][k]= p[k-1];
						
					}
					System.out.println(sb.toString());
					sb.setLength(0);
				}
			}
	return n;
	}
	
}
