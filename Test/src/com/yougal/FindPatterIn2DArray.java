package com.yougal;
/**
 * 
 * Given a 2D array of digits, try to find the occurrence of a given 2D pattern of digits. For example, consider the following 2D matrix: 
 * 7283455864 
 * 6731158619 
 * 8988242643 
 * 3839505324 
 * 9509505813 
 * 3843845384 
 * 6473530293
 * 7053106601
 * 0834282956 
 * 4607924137 
 * 
 * Assume we need to look for the following 2D pattern: 
 * 950 
 * 384 
 * 353
 * 
 * 
 * @author yougal.bisht
 *
 */
public class FindPatterIn2DArray {
	
	public static void main(String[] args) {
		int inputArray[][] =  {
									
									{7,2,8,3,4,5,5,8,6,4},
									{6,7,3,1,1,5,8,6,1,9},
									{8,9,8,8,2,4,2,6,4,3},
									{3,8,3,9,5,0,5,3,2,4},
									{9,5,0,9,5,0,5,8,1,3},
									{3,8,4,3,8,4,5,3,8,4},
									{6,4,7,3,5,3,0,2,9,3},
									{7,0,5,3,1,0,6,6,0,1},
									{0,8,3,4,2,8,2,9,5,6},
									{4,6,0,7,9,2,4,1,3,7}
								
							    };
		
		int patternArray[][] = {
									{9,5,0},
									{3,8,4},
									{3,5,3}
								};
		
		for(int i=0;i<inputArray.length-patternArray.length;i++){
			for(int j=0;j<inputArray[i].length-patternArray[0].length;j++){
				boolean foundPattern = findMatch(patternArray,inputArray, i,j);
				if(foundPattern){
					System.out.println("Pattern Found at: (" + i +", "+j +")");
				}
			}
		}
	}

	private static boolean findMatch(int[][] patternArray, int[][] inputArray,int startRow, int startCol) {
		int maxRows = startRow+patternArray.length;
		for (int i=startRow;i<maxRows && i<inputArray.length; i++) {
			int maxCols = startCol + patternArray[0].length;
			for (int j=startCol;j<maxCols && j<inputArray[j].length;j++){
				if(inputArray[i][j]!=patternArray[i-startRow][j-startCol]){
					return false;
				}
			}
		}
		return true;
	}
	
	

}
