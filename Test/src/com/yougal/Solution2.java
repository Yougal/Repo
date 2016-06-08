package com.yougal;

import java.util.Scanner;

public class Solution2 {
    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine());
        
        res = getIntegerComplement(_n);
        System.out.println(res);
        
    }
/*
 * Complete the function below.
 */

    static int getIntegerComplement(int n) {
       int p =n;
       int count=0;
       int num=0;
       while(p!=0){
    	   int x=p%2;
    	   if(x==1){
    		   x=0;
    	   }else{
    		   x=1;
    	   }
    	   num=num+((int)Math.pow(2, count))*x;
    	   count++;
    	   p=p/2;
       }
       return num;

    }


	
}