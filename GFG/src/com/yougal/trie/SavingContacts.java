package com.yougal.trie;

public class SavingContacts {

	public static void main(String[] args) {
		String inputString[] = {"gayle","gary","geera","alex","andy"};
		Trie trie = new Trie();
		for (String name : inputString) {
			trie.addString(name);
		}
	}
	
}
