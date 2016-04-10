package com.yougal.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

	private static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) {
			copyOnWriteArrayList.add("A");
			copyOnWriteArrayList.add("B");
			copyOnWriteArrayList.add("C");
			copyOnWriteArrayList.add("D");
	}
	
	
	static class ListTest implements Runnable{

		private CopyOnWriteArrayList<String> copyOnWriteArrayList;
		
		ListTest( CopyOnWriteArrayList<String> copyOnWriteArrayList){
			this.copyOnWriteArrayList=copyOnWriteArrayList;
		}
		
		@Override
		public void run() {
			Iterator<String> itr = copyOnWriteArrayList.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
			
		}
		
	}
	
	
	
}
