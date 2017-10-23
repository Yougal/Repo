package com.yougal.random;

/**
 * 
 * 
 * Alice is a kindergarten teacher. 
 * She wants to give some candies to the children in her class.  
 * All the children sit in a line (their positions are fixed), 
 * and each  of them has a rating score according to his or her performance in the class.  
 * Alice wants to give at least 1 candy to each child. 
 * If two children sit next to each other, then the one with the higher rating must get more candies. 
 * Alice wants to save money, so she needs to minimize the total number of candies given to the children.
 * 
 * 
 * Input Format
 * 
 * The first line of the input is an integer , the number of children in Alice's class. Each of the following  lines contains an integer that indicates the rating of each child.
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Output a single line containing the minimum number of candies Alice must buy.
 * 
 * @author yougal.bisht
 *
 */
public class Candies {
	
	/**
	 * 
	 * 
2
4
2
6
1
7
8
9
2
1

1,2,1,2,1,2,3,4,2,1
	 * @param n
	 * @param arr
	 * @return
	 */
	 	static int candies(int n, int[] arr) {
	 		int totalCandyCount=1;
	 		int i=1;
	 		int lastNumber =2;
	 		while(i<n){
	 			
	 			while(i<n && arr[i]==arr[i-1]){
	 				totalCandyCount+=lastNumber;
	 				i++;
	 			}
	 			while(i<n && arr[i]>arr[i-1]){
	 				totalCandyCount+=lastNumber;
	 				lastNumber++;
	 				i++;
	 			}
	 			
	 			lastNumber = i>1?1:lastNumber;
	 			while(i<n && arr[i]<arr[i-1]){
	 				totalCandyCount+=lastNumber;
	 				lastNumber++;
	 				i++;
	 			}
	 			
	 		}
	        return totalCandyCount;
	    }

	    public static void main(String[] args) {
	        /**Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int arr_i = 0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }**/
	        int result = candies(3, new int[]{1,2,2});
	        System.out.println(result);
	      //  in.close();
	    }
}
