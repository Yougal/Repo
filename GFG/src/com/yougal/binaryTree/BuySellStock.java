package com.yougal.binaryTree;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class BuySellStock {

	 public static void main(String args[]) 
	    {
		 BuySellStock stock = new BuySellStock();
	         
	        // stock prices on consecutive days
	        int price[] = {100, 180, 260, 310, 40, 535, 695};
	        int n = price.length;
	 
	        // function call
	        stock.stockBuySell(price, n);
	    }

	private void stockBuySell(int[] price, int n) {
		List<Entry<Integer,Integer>> result =  new ArrayList<Entry<Integer,Integer>>();
		for(int i=0;i<n;i++){
			while(i<n-1 && price[i]>=price[i+1]){
				i++;
			}
			if(i==n-1){
				return;
			}
			int minIndex = i;
			
			 while ((i < n) && (price[i] >= price[i - 1])){
	                i++;
			 }
			 int maxIndex = i-1;
			 result.add(new SimpleEntry<Integer,Integer>(minIndex,maxIndex));
			
		}
		
	}
	
	
	
}
