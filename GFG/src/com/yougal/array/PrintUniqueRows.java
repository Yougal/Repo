package com.yougal.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * http://www.geeksforgeeks.org/print-unique-rows/
 * 
 * @author yougal.bisht
 *
 */
public class PrintUniqueRows {

	
	public static void main(String[] args) {
		 int m[][] = {
				 
					 	{0, 1, 0, 0, 1},
				        {1, 0, 1, 1, 0},
				        {0, 1, 0, 0, 1},
				        {1, 0, 1, 0, 0}
				        
		 			 };
		findUniqueRows(m);
	}

	private static void findUniqueRows(int[][] m) {
		Set<Integer>	map = new HashSet<Integer>();
		for(int i=0;i<m.length;i++) {

			int sum=0;
			int p=0;
			for(int j=m[i].length-1;j>0;j--) {
				sum+=Math.pow(2, p++)*m[i][j];
			}
			if(!map.contains(sum)) {
				map.add(sum);
				System.out.println(Arrays.toString(m[i]));
			}
		
		}
	}
	
}
