package com.yougal;

import java.util.Scanner;

public class Solution3 {
    
    public static void main(String[] args) {
        
          Scanner in = new Scanner(System.in);
          String a = in.next();
          String b = in.next();
          System.out.println(anagram(a,b));
          in.close();
    }
    
    static int anagram(String a, String b ) {
       int arr[] = new int[26];
       int len =a.length()>b.length()?a.length():b.length();
       for(int i=0;i<len;i++){
    	   if(i<a.length()){
    		   arr[a.charAt(i)-97]=arr[a.charAt(i)-97]+1;
    	   }
    	   if(i<b.length()){
    		   arr[b.charAt(i)-97]=arr[b.charAt(i)-97]-1;
    	   }
       }
       int count=0;
       for(int i=0;i<26;i++){
    	   if(arr[i]!=0){
    		  count++;
    	   }
       }
       return count;

    }

	
}