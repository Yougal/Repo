package com.yougal.dp;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {
	
	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    HashMap<Integer, Integer> intResult = new HashMap<Integer, Integer>();
		System.out.println(knapSack(W, wt, val,0 ,intResult));
		System.out.println(intResult.get(W));
	}

	private static int knapSack(int w, int[] wt, int[] val,int i, Map<Integer, Integer> intResult) {
		if(w>0 && i<wt.length && w-wt[i]>=0){
			int withWeight=0;
			if(intResult.containsKey(w-wt[i])){
				withWeight=intResult.get(w-wt[i]);
			}else{
				withWeight= val[i]+ knapSack(w-wt[i], wt, val,i+1,intResult);
			}
			int withoutWeight = 0;
			if(intResult.containsKey(w)){
				withoutWeight=intResult.get(w);
			}else{
				withoutWeight= knapSack(w, wt, val,i+1,intResult);
				
			}
			intResult.put(w,Math.max(withWeight, withoutWeight));
			return Math.max(withWeight, withoutWeight);
		}
		return 0;
	}

}
