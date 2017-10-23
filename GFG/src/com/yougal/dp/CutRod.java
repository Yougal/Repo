package com.yougal.dp;
/**
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * @author yougal.bisht
 *
 */
public class CutRod {
	
	public static void main(String[] args) {
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
	    System.out.printf("BF Maximum Obtainable Value is %d n", cutRodBF(price, 8));
	    System.out.println();
	    System.out.printf("DP Maximum Obtainable Value is %d n", cutRodDP(price, 8));
	}
	
	private static int cutRodBF(int[] price, int lengthOfRod) {
		if(lengthOfRod<=0){
			return 0;
		}else{
			int max=Integer.MIN_VALUE;
			for(int i=lengthOfRod;i>0;i--){
				max = Math.max(cutRodBF(price,lengthOfRod-i) + price[i-1], max);
			}
			
			return max;
		}
	}
	
	private static int cutRodDP(int[] price, int lengthOfRod) {
		int result[]= new int[price.length+1];
			for(int i=1;i<=lengthOfRod;i++){
				int max = Integer.MIN_VALUE;
				for(int j=0;j<i;j++){
					max = Math.max(max, price[j]+ result[i-j-1]);
				}
				result[i]=max;
			}
			return result[lengthOfRod];
		}
}
