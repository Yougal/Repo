package com.yougal.array;

import java.util.Arrays;
/**
 * 
 * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * 
 * @author yougal.bisht
 *
 */

public class RotateMatrix {

	
	public static void main(String[] args) {
		int size =4;
		int counter=1;
		int m[][] =new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = counter++;
			}
		}
		System.out.println("---------------- Original Matrix ----------------");
		printMatrix(m);
		int last = size-1;
		for(int level = 0 ;level<size/2;level++){
			
			for(int i =level;i<last;i++){
				swap(m,level,i,last-i+level,level);
				swap(m,level,i,last,last-i+level);
				swap(m,level,i+level,i,last-level);
			}
			last--;
		}
		System.out.println("---------------- Rotated Matrix ----------------");
		printMatrix(m);
	}
	

	private static void swap(int[][] m, int fromI, int fromJ, int toI, int toJ) {
		int temp = m[fromI][fromJ];
		m[fromI][fromJ] = m[toI][toJ];
		m[toI][toJ] = temp;
	}


	private static void printMatrix(int[][] m) {
		for (int[] is : m) {
			System.out.println(Arrays.toString(is));
		}
	}
	
}
