package com.yougal;

public interface MembershipChangeable<N> {

	public void addNode(N node);
	
	public boolean deleteNode(N node, int replicaId);
	
}
