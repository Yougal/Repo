package com.yougal.random;

import java.util.HashMap;

public class LRUCache<K,V> {
	
	Entry<K,V> headNode;
	Entry<K,V> tailNode;
	
	HashMap<K, Entry<K,V>> map;
	
	int count;
	
	public LRUCache(int sizeOfCache) {
		super();
		this.sizeOfCache = sizeOfCache;
		this.map=new HashMap<>();
	}

	int sizeOfCache;

	public V put(K key, V value){
		
		if(map.containsKey(key)){
			adjustAccess(key);
			V oldValue = headNode.value;
			headNode.value=value;
			return oldValue;
		}
		checkSize(key);
		return addElement(key,value);
	}
	
	private void checkSize(K key) {
		if(count==sizeOfCache){
			removeFirst();
			count--;
		}
	}
	
	public void removeFirst(){
		remove(headNode.key);
	}
	
	public V remove(K key){
		if(map.containsKey(key)){
			Entry<K, V> entry = map.get(key);
			Entry<K, V> nextEntry = entry.next;
			Entry<K, V> prevEntry = entry.prev;
			if(prevEntry==null){
				nextEntry.prev=null;
				headNode=nextEntry;
			}else{
				nextEntry.prev=prevEntry;
				prevEntry.next=nextEntry;
			}
			count--;
			map.remove(key);
			return entry.value;
		}
		return null;
	}
	
	private V addElement(K key, V value) {
		if(headNode==null){
			Entry<K,V> newNode = new Entry<>(key,value,null);
			headNode=tailNode=newNode;
			map.put(key,newNode);
		}else{
			Entry<K,V> newNode = null;
			if(headNode==tailNode){
				newNode = new Entry<>(key,value,headNode);
				headNode.next=newNode;
			}else{
				newNode = new Entry<>(key,value,tailNode);
				tailNode.next=newNode;
			}
			tailNode=newNode;
			newNode.next=null;
			map.put(key, tailNode);
		}
		count++;
		return value;
	}

	public V get(K key){
		if(map.containsKey(key)){
			adjustAccess(key);
			return headNode.value;
		}else{
			return null;
		}
	}
	
	
	private void adjustAccess(K key) {
		Entry<K, V> entry = map.get(key);
		if(entry!=tailNode){
			
			Entry<K, V> nextEntry = entry.next;
			Entry<K, V> prevEntry = entry.prev;
			if(prevEntry==null){
				nextEntry.prev=null;
				headNode=nextEntry;
			}else{
				nextEntry.prev=prevEntry;
				prevEntry.next=nextEntry;
				headNode=prevEntry;
			}
			
			tailNode.next=entry;
			entry.prev=tailNode;
			entry.next=null;
			tailNode=entry;
		}
	}

	@Override
	public String toString() {
		return map.values().toString();
	}

	private static class Entry<K,V>{
		
		K key;
		V value;
		
		public Entry(K key, V value,Entry<K, V> prev) {
			super();
			this.key = key;
			this.value = value;
			this.prev = prev;
		}
		Entry<K, V> next;
		Entry<K, V> prev;

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "[K=" + key + ", V=" + value + "]";
		}
		
	}
	
	public static void main(String[] args) {
		LRUCache<Integer, Integer> lru = new LRUCache<>(3);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.put(3, 3);
		System.out.println(lru.get(1));
		lru.put(4, 4);
		System.out.println(lru);
	}
	

}
