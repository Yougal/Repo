package com.yougal.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	public TrieNode() {
		this.trieNode = new HashMap<>();
		this.isEnd = false;
	}

	Map<Character,TrieNode> trieNode;
	
	boolean isEnd;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{" + trieNode + ", " + isEnd + "}";
	}
	
}
