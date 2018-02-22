package com.yougal.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson01 {
	public static void main(String[] args) {
		List<String> namesList = new ArrayList<String>();
		namesList.add("Yougal");
		namesList.add("Aarti");
		namesList.add("Ruchi");
		StringBuilder sb = new StringBuilder();
		//namesList.forEach(s->sb.append(s.charAt(0)));
		System.out.println(sb.toString());
		
		Map<String,String> namesMap = new HashMap<String,String>();
		namesMap.put("Yougal","Bisht");
		namesMap.put("Aarti","Dewan");
		namesMap.put("Ruchi","Bisht");
		sb = new StringBuilder();
		//namesMap.(s->sb.append(s.charAt(0)));
		System.out.println(sb.toString());
	}
}
