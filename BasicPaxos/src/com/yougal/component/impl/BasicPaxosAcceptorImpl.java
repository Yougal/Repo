package com.yougal.component.impl;

import com.yougal.common.ApplicationDTO;
import com.yougal.component.Acceptor;

public class BasicPaxosAcceptorImpl<T> implements Acceptor<T>{

	int serverId;

	int minPropsalNumber;
	
	T acceptedValue;
	
	int acceptedProposalNumber;
	
	
	public BasicPaxosAcceptorImpl(int serverId) {
		super();
		this.serverId = serverId;
	}

	@Override
	public ApplicationDTO<T> prepare(int proposalNumber) {
		if(proposalNumber>minPropsalNumber){
			minPropsalNumber=proposalNumber;
		}
		return new ApplicationDTO<T>(acceptedProposalNumber, acceptedValue);
	}

	@Override
	public ApplicationDTO<T> accept(int proposalNumber, T valueToAccept) {
		if(proposalNumber>=minPropsalNumber){
			acceptedProposalNumber = proposalNumber;
			acceptedValue = valueToAccept;
		}
		return new ApplicationDTO<T>(acceptedProposalNumber, acceptedValue);
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
		return  String.valueOf(serverId);
	}
	
	

}
