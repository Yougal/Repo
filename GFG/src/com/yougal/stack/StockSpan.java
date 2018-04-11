package com.yougal.stack;

import java.util.Arrays;

/**
 * 
 * The Stock Span Problem:
 * The stock span problem is a financial problem where we have a series of n daily price quotes for
 * a stock and we need to calculate span of stock’s price for all n days. 
 * The span Si of the stock’s price on a given day i is defined as the maximum number of
 * consecutive days just before the given day, for which the price of the stock on the current day is 
 * less than or equal to its price on the given day.
 * 
 * 
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * 
 * <a href="http://www.geeksforgeeks.org/the-stock-span-problem">Problem link</a>
 * 
 * @author yougal.bisht
 *
 */
public class StockSpan {

	public static void main(String[] args) {
		int prices[] = new int[] {10, 4, 5, 90, 120, 80};
		int stockSpan[] = calculateStockSpan(prices);
		System.out.println(Arrays.toString(stockSpan));
	}

	private static int[] calculateStockSpan(int[] prices) {
		Stack<Integer> indexStk = new Stack<Integer>(prices.length);
		int stockSpan[] = new int[prices.length];
		stockSpan[0] = 1;
		for(int i=0;i<prices.length;i++){
			if(indexStk.isEmpty()){
				indexStk.push(i);
			}else{
				while(!indexStk.isEmpty() && prices[i]>=prices[indexStk.peek()]){
					indexStk.pop();
				}
				stockSpan[i]=indexStk.isEmpty()?i+1: i-indexStk.peek();
				indexStk.push(i);
			}
		}
		
		return stockSpan;
	}
	
}
