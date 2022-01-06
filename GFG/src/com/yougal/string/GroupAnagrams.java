package com.yougal.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
 * 
 * 
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2:
 * 
 * Input: strs = [""] Output: [[""]] Example 3:
 * 
 * Input: strs = ["a"] Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lowercase English letters.
 * 
 * @author yougal.bisht
 *
 */
public class GroupAnagrams {
	int NO_OF_CHARS = 26;

	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			int[] count = new int[NO_OF_CHARS];
			for (int j = 0; j < strs[i].length(); j++) {
				count[strs[i].charAt(j) - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < NO_OF_CHARS; k++) {
				if (count[k] != 0) {
					sb.append('a' + k);
					sb.append(count[k]);
				}
			}
			String key = sb.toString();
			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(strs[i]);
			map.put(key, list);
		}

		return new ArrayList<List<String>>(map.values());

	}
}
