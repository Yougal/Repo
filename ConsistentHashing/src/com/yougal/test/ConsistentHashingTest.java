package com.yougal.test;

import java.util.Arrays;

import com.yougal.ConsistentHashingMap;

public class ConsistentHashingTest {

	public static void main(String[] args) {
		System.out.println(-1825818701l & Integer.MAX_VALUE);
		ConsistentHashingMap<String, Integer, String> chm = new ConsistentHashingMap<>(f->f.hashCode(),Arrays.asList("Server-1","Server-2","Server-3"),3 );
		chm.put("Yougal", 2000);
		chm.put("Aarti", 3000);
		chm.put("Sameer", 4000);
		System.out.println(chm);
		System.out.println("----------------------------------------------------------------------------");
		chm.deleteNode("Server-1", 1);
		System.out.println(chm);
		
	}
	
}
