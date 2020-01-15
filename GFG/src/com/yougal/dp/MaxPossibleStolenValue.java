package com.yougal.dp;
/**
 * 
 * 
 * 
 * https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
 * 
 * Find maximum possible stolen value from houses
	There are n houses build in a line, each of which contains some value in it. 
	A thief is going to steal the maximal value of these houses, 
	but he can’t steal in two adjacent houses because owner of the stolen houses will tell his two 
	neighbor left and right side. What is the maximum stolen value.
	Examples:
	
	Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
	Output : 19
	Thief will steal 6, 1, 8 and 4 from house.
	
	Input  : hval[] = {5, 3, 4, 11, 2}
	Output : 16
	Thief will steal 5 and 11

 * @author yougalbisht
 *
 */
public class MaxPossibleStolenValue {

	public static void main(String[] args) {
		int hval[] = {6, 7, 1, 3, 8, 2, 4};
		int maxValue=getMaxValueTheifCanStole(hval);
		System.out.println(maxValue);
		hval = new int[]{5, 3, 4, 11, 2};
		maxValue=getMaxValueTheifCanStole(hval);
		System.out.println(maxValue);
	}

	private static int getMaxValueTheifCanStole(int[] a) {
		int dp[] = new int[a.length];
		if(a.length==0) {
			return 0;
		}else if(a.length>=3) {
			if(a.length>=1) {
				dp[0]=a[0];
			}
			if(a.length>=2) {
				dp[1]=Math.max(a[0], a[1]);
			}
			if(a.length>=3) {
				dp[2]=Math.max(a[0]+a[2], a[1]);
			}
		}
		for(int i= 3;i<a.length;i++) {
			int val = Math.max(dp[i-3]+a[i], dp[i-2]+a[i]);
			dp[i] = Math.max(dp[i-1],val);
		}
		
		return dp[a.length-1];
	}
	
}
