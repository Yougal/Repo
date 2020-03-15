package com.yougal.string;

import java.util.LinkedList;

/**
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/alien-dictionary/1
 * @author yougal.bisht
 *
 */
public class AlienDictionary {
	
	String printOrder(String dict[], int N, int k) {
		LinkedList<Character> listChars = new LinkedList<Character>();
		for(int i=0;i<N-1;i++) {
			String s1 = dict[i];
			String s2 = dict[i+1];
			int index = firstDiffCharacterIndex(s1,s2);
			if(listChars.isEmpty()) {
				listChars.add(s1.charAt(index));
				listChars.add(s2.charAt(index));
			}else {
				int indexOfChar1 = listChars.indexOf(s1.charAt(index));
				int indexOfChar2 = listChars.indexOf(s2.charAt(index));
				if(indexOfChar1==-1 || indexOfChar2==-1) {
					if(indexOfChar1==-1) {
						int indexOfChar = listChars.indexOf(s2.charAt(index));
						listChars.add(indexOfChar, s1.charAt(index));
					}
					if(indexOfChar2==-1) {
						int indexOfChar = listChars.indexOf(s1.charAt(index));
						listChars.add(indexOfChar, s2.charAt(index));
					}
				}
			}
			
		}
		
		return listChars.toString();
		
	}

	private int firstDiffCharacterIndex(String s1, String s2) {
		int i=0,j=0;
		while(i<s1.length() && j< s2.length() && s1.charAt(i)==s2.charAt(j)) {
			i++;
			j++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		AlienDictionary alienDictionary = new AlienDictionary();
		
		System.out.println(alienDictionary.printOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"}, 5, 4));
	}
}
