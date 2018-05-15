package com.yougal.component.impl;

import com.yougal.component.Proposer;

public class BasicPaxosProposalImpl implements Proposer<Integer>{

	static int maxValue=1;
	
	int serverId;
	
	public BasicPaxosProposalImpl(int serverId) {
		super();
		this.serverId = serverId;
	}

	@Override
	public int generateProposalNumber() {
		return maxValue++;
	}


	@Override
	public int getServerId() {
		return serverId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Proposer[serverId=" + serverId + "]";
	}

	
}
