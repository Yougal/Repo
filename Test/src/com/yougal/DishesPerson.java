package com.yougal;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * There are n persons and k different type of dishes. 
 * Each person has some preference for each dish. 
 * Either he likes it or not. We need to feed all people. 
 * Every person should get atleast one dish of his chioce. 
 * What is the minimum number of different type of dishes we can order? 
 * Input is n x k matrix boolean matrix.
 * For each person a row represent his likes or not likes each row. 
 * 
 * 
 * @author yougal.bisht
 *
 */
public class DishesPerson {
	
	public static int arr[][] = new int[][]{ 
							{1,0,0,0,1,0,0},
							{1,0,0,0,0,1,0},
							{1,0,0,0,0,0,1},
							{0,1,0,0,1,0,0},
							{0,0,1,0,0,1,0},
							{0,0,0,1,0,0,1}
							};
	static int dishesToOrder =9999;
	public static void main(String[] args) {
		int n = arr.length;
		findMinimumNumberOfDishesToOrder(arr,n,0,0,0);
		System.out.println(dishesToOrder);
	}

	private static void findMinimumNumberOfDishesToOrder(int[][] arr2, int n,int iPerson, int dishNumber,int dishCount) {
		if(iPerson>=n){
			return ;
		}else if(iPerson==n && Double.compare(dishNumber,(Math.pow(2,arr[arr.length-1].length))-1)==0){
			dishesToOrder = Math.min(dishesToOrder, dishCount);
		}else{
			int count = 0;
			for(int dish: arr[iPerson]){
				if(dish==1){
					count++;
				}
			}
			for(int i=1;i<=count;i++){
				List<Integer> dishCountToDishNumberMap= getNumberForDishes(arr[iPerson],i);
				for (Integer likedDish : dishCountToDishNumberMap) {
					findMinimumNumberOfDishesToOrder(arr2,n,iPerson+1,(dishNumber|likedDish),dishCount+i);
				}
			}
		}
	}

	private static List<Integer> getNumberForDishes(int[] dishLikes,int count) {
		
		
		return null;
	}

}
