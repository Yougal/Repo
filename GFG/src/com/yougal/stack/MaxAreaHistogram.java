package com.yougal.stack;

import java.util.Stack;

/**
 * 
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * @author yougal.bisht
 *
 */
public class MaxAreaHistogram {

	public static void main(String[] args) {
		 int hist[] = {6, 2, 5, 4, 5, 1, 6};
		 System.out.println("Brute Force: " + maxAreaHistogramBF(hist));
		 System.out.println("Efficient: " + maxAreaHistogram(hist));
	}

	private static int maxAreaHistogramBF(int[] hist) {
		int maxArea = -1;
		
		for(int i=0;i<hist.length;i++){
			int multiplier = hist[i];
			for (int j=i+1;j<hist.length;j++) {
				if(hist[j]<multiplier){
					maxArea = Math.max(maxArea, multiplier*(j-i));
					multiplier = hist[j];
				}
			}
			maxArea = Math.max(maxArea, multiplier*(hist.length-i));
		}
		return maxArea;
	}
	
	private static int maxAreaHistogram(int[] hist) {
		int maxArea = -1;
		Stack<Integer> valueHolder = new Stack<>();
		Stack<Integer>  indexHolder= new Stack<>();
		valueHolder.push(hist[0]);
		indexHolder.push(0);
		for(int i=1;i<hist.length;i++){
			int index = i;
			while(!valueHolder.isEmpty() && valueHolder.peek()>hist[i]){
				index = indexHolder.pop();
				int value =  valueHolder.pop();
				maxArea = Math.max(maxArea, value*(i-index));
			}
			valueHolder.push(hist[i]);
			indexHolder.push(index);
		}
		
		while(!valueHolder.isEmpty()){
			int index = indexHolder.pop();
			int value =  valueHolder.pop();
			maxArea = Math.max(maxArea, value*(hist.length-index));
		}
		
		return maxArea;
	}
	
}
