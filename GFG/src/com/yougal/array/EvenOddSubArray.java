package com.yougal.array;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 
 * 
 * https://www.geeksforgeeks.org/count-subarrays-with-same-even-and-odd-elements/
 * 
 * 
 * @author yougal.bisht
 *
 */
public class EvenOddSubArray {

	public static void main(String[] args) {
		int arr[] = {3, 4, 6, 8, 1, 10, 5, 7};
		int count = countEvenOddSubArrays(arr);
		System.out.println(count);
	}

	private static int countEvenOddSubArrays(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		map.put(0, -1);
		Map<Integer, Integer> result = new LinkedHashMap<>();
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				count--;
			}else {
				count++;
			}
			if(map.containsKey(count)) {
				int temp = result.getOrDefault(count, 1);
				result.put(count, temp+1);
			}
			map.put(count, i);
		}
		
		int finalResult=0;
		for (Integer value : result.values()) {
			finalResult = finalResult+ combination(value, 2);
		}
 		
		return finalResult;
	}
	
	static int combination(int n, int r){
        return getFact(n)/(getFact(n-r)*getFact(r));
    
    }

    public static int getFact(int n)
    {
        int f=1;

        for(int i=n;i>=1;i--)
        {
        f*=i;
        }
        return f;
	}
}
