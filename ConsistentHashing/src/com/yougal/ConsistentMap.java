package com.yougal;

public interface ConsistentMap<K,V> {

	public V getValue(K key);
	
	public void put(K key, V value);
	
}
