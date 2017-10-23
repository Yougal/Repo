package com.yougal.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * http://www.geeksforgeeks.org/boggle-set-2-using-trie/
 * 
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where 
 * every cell has one character. Find all possible words that can be formed by a sequence 
 * of adjacent characters. Note that we can move to any of 8 adjacent characters, 
 * but a word should not have multiple instances of same cell.
 * @author yougal.bisht
 *
 */
public class BoggleWord {

	public static void main(String[] args) {
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		char boggle[][]   = {
								{'G','I','Z'},
				                {'U','E','K'},
				                {'Q','S','E'}
                			};
		BoggleWord bw = new BoggleWord();
		BoggleTrie bt= bw.createBoggleTrie(dictionary);
		System.out.println(bt.getAllWords());
		System.out.println(bt.findWord(boggle));
	}
	

	public BoggleTrie createBoggleTrie(String dictionary[]){
		BoggleTrie bt = new BoggleTrie();
		bt.create(dictionary);
		return bt;
	}
	
	static class BoggleTrie {
		
		TrieNode root; 
		
		public Set<String> findWord(char[][] boggle) {
			Set<String> result = new HashSet<>();
			for(int i =0;i<boggle.length;i++){
				for(int j=0;j<boggle[i].length;j++){
					_findWord( boggle,  i,j ,root,"",result);
				}
			}
			
			return result;
		}
		
		public void _findWord(char[][] boggle, int i, int j ,TrieNode root,String element,Set<String> result) {
			if(root==null){
				return;
			}
			if(root.isEnd){
				result.add(element);
			}else{
				if(isSafe(boggle,i,j,root)){
					char ele = boggle[i][j];
					boggle[i][j]=Character.MAX_VALUE;
					TrieNode nextNode = root.trieNode.get(ele);
					String elementSoFar = element+ele;
					_findWord(boggle,i,j+1,nextNode,elementSoFar,result);
					_findWord(boggle,i+1,j,nextNode,elementSoFar,result);
					_findWord(boggle,i+1,j+1,nextNode,elementSoFar,result);
					_findWord(boggle,i+1,j-1,nextNode,elementSoFar,result);
					
					_findWord(boggle,i,j-1,nextNode,elementSoFar,result);
					_findWord(boggle,i-1,j,nextNode,elementSoFar,result);
					_findWord(boggle,i-1,j-1,nextNode,elementSoFar,result);
					_findWord(boggle,i-1,j+1,nextNode,elementSoFar,result);
					boggle[i][j]=ele;
				}
			}
			
		}

		private boolean isSafe(char[][] boggle, int i, int j, TrieNode root) {
			if(i<0 || j<0 || i>=boggle.length || j>=boggle[0].length ||boggle[i][j]==Character.MAX_VALUE || !root.trieNode.containsKey(boggle[i][j]) ){
				return false;
			}
			return true;
		}

		public void create(String []dictionary) {
			if(root==null){
				TrieNode node = new TrieNode();
				root=node;
			}
			for (String word : dictionary) {
				_create(word,0,root);
			}
			
			
		}

		private void _create(String word,int index, TrieNode root) {
			if(index>=word.length()){
				root.isEnd=true;
				return ;
			}else{
				if(!root.trieNode.containsKey(word.charAt(index))){
					root.trieNode.put(word.charAt(index), new TrieNode());
				}
				_create(word,index+1,root.trieNode.get(word.charAt(index)));
			}
		}
		
		public List<String> getAllWords() {
			List<String> result = new ArrayList<>();
			_getAllWords(root,"",result);
			return result;
		}
		
		public void _getAllWords(TrieNode root, String element,List<String> result) {
			 
			 if(root==null){
				 return;
			 }else{
				 if(root.isEnd){
					 result.add(element);
				 }
				 for (Entry<Character,TrieNode> entry: root.trieNode.entrySet()) {
					 _getAllWords(entry.getValue(),element+entry.getKey(),result);
				}
			 }
		}

	}
	
}
