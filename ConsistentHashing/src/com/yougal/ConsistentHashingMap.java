package com.yougal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsistentHashingMap<K, V, N> implements ConsistentMap<K, V>, MembershipChangeable<N>{

	private TreeMap<Integer, Node<N,K,V>> circle = new TreeMap<>();
	
	private Function<Object,Integer> hashFunction;
	
	int replicationFactor;
	
	public ConsistentHashingMap(Function<Object,Integer> hashingFunction, Collection<N> serverNodes, int replicationFactor){
		this.hashFunction = hashingFunction;
		this.hashFunction = this.hashFunction.andThen((o)->Integer.MAX_VALUE & ( o^ (o >>> 16)));
		this.replicationFactor=replicationFactor;
		for (N node : serverNodes) {
			for (int i = 0; i < replicationFactor; i++) {
				Node<N,K,V> value = new Node<>(node,i,hashFunction);
				circle.put(value.hashCode(),value);
			}
		}
	}
	
	@Override
	public V getValue(K key) {
		int hashValue = hashFunction.apply(key);
		SortedMap<Integer, Node<N,K,V>> tailMap = circle.tailMap(hashValue);
		if(!tailMap.isEmpty()){
			Node<N,K,V> node = tailMap.get(tailMap.firstKey());
			if(node.containsKey(hashValue)){
				return node.getValue(hashValue).getValue();
			}
		}
		return null;
	}

	@Override
	public void put(K key, V value) {
		int hashValue = hashFunction.apply(key);
		List<Entry<Integer, Node<N,K,V>>> entrySet = findAffectedNodeByKeyClockWise(hashValue,replicationFactor);
		if(!entrySet.isEmpty()){
			for (Entry<Integer, Node<N,K,V>> entry : entrySet) {
				Node<N,K,V> node = entry.getValue();
				node.putValue(hashValue, new AbstractMap.SimpleEntry<K, V>(key,value));
			}
		}else{
			throw new IllegalStateException("No Nodes Present In System");
		}
	}

	private List<Entry<Integer, Node<N,K,V>>> findAffectedNodeByKeyClockWise(int hashValue,int remainElements) {
		if(circle.size()<remainElements){
			remainElements = circle.size();
		}
		SortedMap<Integer, Node<N,K, V>> tailMap = circle.tailMap(hashValue,false);
		List<Entry<Integer, Node<N,K, V>>> entrySet = tailMap.entrySet().stream().limit(remainElements).collect(Collectors.toList());
		if(entrySet.size()<remainElements){
			remainElements = remainElements - tailMap.size();
			TreeMap<Integer, Node<N,K,V>> treeMap = new TreeMap<Integer, Node<N,K,V>>(Collections.reverseOrder());
			treeMap.putAll(circle.tailMap(circle.firstKey(),true));
			entrySet.addAll(treeMap.entrySet().stream().limit(remainElements).collect(Collectors.toList()));
		}
		return entrySet;
	}
	
	private List<Entry<Integer, Node<N,K, V>>> findAffectedNodeByKeyAntiClockWise(int hashValue) {
		int remainElements = replicationFactor;
		if(circle.size()<remainElements){
			remainElements = circle.size();
		}
		SortedMap<Integer, Node<N,K, V>> headMap = circle.headMap(hashValue,false);
		List<Entry<Integer, Node<N,K, V>>> entrySet = headMap.entrySet().stream().limit(remainElements).collect(Collectors.toList());
		if(entrySet.size()<remainElements){
			remainElements = remainElements - headMap.size();
			TreeMap<Integer, Node<N,K,V>> treeMap = new TreeMap<Integer, Node<N,K,V>>(Collections.reverseOrder());
			treeMap.putAll(circle.headMap(circle.lastKey(),true));
			entrySet.addAll(treeMap.entrySet().stream().limit(remainElements).collect(Collectors.toList()));
		}
		return entrySet;
	}


	@Override
	public boolean deleteNode(N nodeToDelete, int replicaId) {
		Node<N,K, V> nodeDeleted = new Node<>(nodeToDelete,replicaId,hashFunction);
		if(circle.size()>replicationFactor+1 && circle.containsKey(nodeDeleted.hashCode())){
			nodeDeleted = circle.remove(nodeDeleted.hashCode());
			_shuffleNodeDelete(circle, nodeDeleted);
			return true;
		}
		return false;
	}
	
	private void _shuffleNodeDelete(TreeMap<Integer, Node<N,K,V>> circle, Node<N,K,V> nodeDeleted) {
		List<Entry<Integer, Node<N,K,V>>> entrySet = findAffectedNodeByKeyAntiClockWise(nodeDeleted.hashCode());
		for (int i=entrySet.size()-1;i>0;i--) {
			Entry<Integer, Node<N,K,V>> entry = entrySet.get(i);
			List<Entry<Integer, Node<N,K,V>>> forwardSet = findAffectedNodeByKeyClockWise(entry.getKey(),replicationFactor-1);
			Entry<Integer, Node<N,K,V>> affectedNode = forwardSet.get(forwardSet.size()-1);
			if(!entrySet.get(i-1).getValue().map.isEmpty()){
				affectedNode.getValue().putAll(entrySet.get(i-1).getValue().map.headMap(entry.getKey()).tailMap(entrySet.get(i-1).getKey()));
			}
		}
		List<Entry<Integer, Node<N,K,V>>> forwardSet = findAffectedNodeByKeyClockWise(entrySet.get(0).hashCode(),replicationFactor);
		Entry<Integer, Node<N,K,V>> affectedNode = forwardSet.get(forwardSet.size()-1);
		
		affectedNode.getValue().putAll(entrySet.get(0).getValue().map.headMap(entrySet.get(0).getKey()).tailMap(nodeDeleted.hashCode()));
	}


	@Override
	public void addNode(N node) {
		Node<N,K,V> nodeCreated = checkAndCreateNode(node);
		_shuffleNodeAdd(circle,nodeCreated);
		circle.put(nodeCreated.hashCode(), nodeCreated);
	}
	
	private void _shuffleNodeAdd(TreeMap<Integer, Node<N,K,V>> circle, Node<N,K,V> nodeCreated) {
		Entry<Integer, Node<N,K,V>> forwardNode = circle.ceilingEntry(nodeCreated.hashCode());
		
		if(forwardNode==null){
			forwardNode = circle.firstEntry();
		}
		nodeCreated.putAll(forwardNode.getValue().map);
		nodeCreated.remove(nodeCreated.hashCode(), forwardNode.getKey());
		
		List<Entry<Integer, Node<N,K,V>>> entrySet = findAffectedNodeByKeyAntiClockWise(nodeCreated.hashCode());
		Node<N,K,V> nodeTo = nodeCreated;
		for (Entry<Integer, Node<N,K,V>> entry : entrySet) {
			List<Entry<Integer, Node<N,K,V>>> forwardSet = findAffectedNodeByKeyClockWise(entry.getKey(),replicationFactor);
			Entry<Integer, Node<N,K,V>> affectedNode = forwardSet.get(forwardSet.size()-1);
			affectedNode.getValue().remove(entry.getKey(), nodeTo.hashCode());
			nodeTo= affectedNode.getValue();
		}
	}

	private Node<N,K,V> checkAndCreateNode(N node) {
		for (int i = 0; i < replicationFactor; i++) {
			Node<N,K,V> nodeValue = new Node<>(node,i,hashFunction);
			if(!circle.containsKey(nodeValue.hashCode())){
				return nodeValue;
			}
		}
		throw new IllegalStateException("Trying to add Same Node Again...");
	}

	private static class Node<N,K,V>{
		
		private N node;
		
		private int replicaId;
		
		private TreeMap<Integer,Entry<K,V>> map = new TreeMap<>();
		
		private Function<Object,Integer> hashFunction;
		
		public Node(N node, int replicaId, Function<Object,Integer> hashFunction) {
			super();
			this.node = node;
			this.replicaId = replicaId;
			this.hashFunction=hashFunction;
		}

		
		public boolean containsKey(Integer key){
			return map.containsKey(key);
		}
		
		
		public Entry<K,V> getValue(Integer key){
			return map.get(key);
		}
		
		public void putValue(Integer key, Entry<K,V> value){
			map.put(key,value);
		}
		
		public void putAll(SortedMap<Integer, Entry<K,V>> entries){
			map.putAll(entries);
		}
		
		public void remove(Integer LowerBound, Integer upperBound){
			map.tailMap(LowerBound).headMap(upperBound).clear();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(node);
			sb.append(", Replica-Id: " + replicaId);
			sb.append(System.lineSeparator());
			sb.append("[Key,Value]: " + map);
			sb.append(System.lineSeparator());
			sb.append(System.lineSeparator());
			return sb.toString();
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((node == null) ? 0 : node.hashCode());
			result = prime * result + replicaId;
			return hashFunction.apply(result);
		}


		@Override
		@SuppressWarnings("rawtypes")
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (node == null) {
				if (other.node != null)
					return false;
			} else if (!node.equals(other.node))
				return false;
			if (replicaId != other.replicaId)
				return false;
			return true;
		}

		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Circle: ");
		sb.append(System.lineSeparator());
		Set<Entry<Integer, Node<N,K,V>>> entrySet = circle.entrySet();
		for (Entry<Integer, Node<N,K,V>> element : entrySet) {
			sb.append("Hash: " + element.getKey());
			sb.append(", Server Name: " + element.getValue());
			sb.append(System.lineSeparator());
		}
		
		return sb.toString();
	}
	

}
