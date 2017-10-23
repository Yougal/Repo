package com.yougal.array;
/**
 * 
 * http://www.geeksforgeeks.org/fill-array-1s-minimum-iterations-filling-neighbors/
 * 
 * @author yougal.bisht
 *
 */
public class CountIterationToFillArray {
	public static void main(String[] args) {
		int a[] = {0, 1, 0, 0, 1, 0, 0,
                0, 0, 0, 0, 0, 1, 0};
		int maxZeros = -1;
		for (int i = 0; i < a.length;) {
			
			if(a[i]==1){
				
				while(i<a.length && a[i]==1){
					i++;
				}
				
				int countZero =-1;
				while(i<a.length && a[i]==0){
					countZero++;
					i++;
				}
				if(countZero!=-1){
					countZero=countZero+1;
					if(i==a.length){
						maxZeros = Math.max(maxZeros, countZero);
					}else{
						maxZeros = Math.max(maxZeros, (countZero%2==1)?(countZero+1)/2:countZero/2);
					}
				}
			}else{
				int countZero =-1;
				while(i<a.length && a[i]==0){
					countZero++;
					i++;
				}
				if(countZero!=-1){
					countZero=countZero+1;
					maxZeros = Math.max(maxZeros, countZero);
				}
			}
		}
		
		System.out.println(maxZeros);
		
	}
}
