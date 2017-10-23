package com.yougal.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie{
	
	Node root;
	
	public Trie(){
		root = new Node('*');
	}
	
	private class Node {
		
		private char character;
		
		int count=0;
		
		public Node(char character){
			this.character=character;
		}
		
		Node []children= new Node[27];
		
		public Node addCharacter(char character){
			int index = getIndex(character);
			Node temp = children[index];
			if(temp==null){
				Node newNode = new Node(character);
				children[index] = newNode;
			}
			return  children[index];
		}
		

		private int getIndex(char character) {
			return character-'a';
		}
		
	}
	
	public int addString(String s){
		Node temp = root;
		s =s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			temp = temp.addCharacter(c);
		}
		Node terminalNode = temp.children[26];
		if(terminalNode==null){
			terminalNode = new Node('\n');
		}
		temp.children[26] = terminalNode;
		terminalNode.count++;
		return terminalNode.count;
	}
	
	public void addAll(String... items){
		for (String s : items) {
			s =s.toLowerCase();
			Node temp = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				temp = temp.addCharacter(c);
			}
			Node terminalNode = temp.children[26];
			if(terminalNode==null){
				terminalNode = new Node('\n');
			}
			temp.children[26] = terminalNode;
			terminalNode.count++;
		}
	}
	
	public boolean find(String s){
		return countOf(s)>0;
	}
	
	public int countOf(String s){
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = temp.getIndex(c);
			if(temp.children[index]==null){
				return 0;
			}
			temp= temp.children[index];
		}
		return temp.children[26]!=null && temp.children[26].character=='\n'?temp.children[26].count:0;
	}

	public void displayElements() {
		System.out.println(getAllWords());
	}
	
	public List<String> getAllWords() {
		List<String> result = new ArrayList<>();
		_getAllWords(root,"",result);
		return result;
	}
	
	private void _getAllWords(Node root, String element,List<String> result) {
		 if(root==null){
			 return;
		 }else{
			 if(root.children[26]!=null && root.children[26].character=='\n'){
				 result.add(element);
			 }
			 for (Node entry: root.children) {
				 if(entry!=null){
					 _getAllWords(entry,element+entry.character,result);
				 }
			}
		 }
	}
	
}
