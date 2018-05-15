package com.yougal.component.impl;

import java.util.List;

import com.yougal.common.ApplicationDTO;
import com.yougal.component.Acceptor;
import com.yougal.component.Proposer;

public class PaxosManager<T> {
	
	public Entry<T> runPhaseI(Proposer<T> proposer,List<Acceptor<T>> choosenAcceptors, T valueToAccept){
		int proposalNumber = proposer.generateProposalNumber();
		for (Acceptor<T> acceptor : choosenAcceptors) {
			ApplicationDTO<T> applicationDTO = acceptor.prepare(proposalNumber);
			if(applicationDTO.getProposalNumber()>proposalNumber){
				valueToAccept = applicationDTO.getAcceptedValue();
			}
		}
		return new Entry<T>(proposalNumber,proposer.getServerId(),choosenAcceptors,valueToAccept);
	}
	
	public T runPhaseII(Entry<T> entry){
		int proposalNumber = entry.proposalNumber;
		T valueToAccept = entry.valueToAccept;
		List<Acceptor<T>> choosenAcceptors = entry.choosenAcceptors;
		for (Acceptor<T> acceptor : choosenAcceptors) {
			ApplicationDTO<T> applicationDTO = acceptor.accept(proposalNumber,valueToAccept);
			if(applicationDTO.getProposalNumber()>proposalNumber){
				return applicationDTO.getAcceptedValue();
			}else{
				throw new IllegalStateException("New value Accepted by Server: " +entry.serverId);
			}
		}
		return valueToAccept;
	}
	
	public static class Entry<T>{
		int proposalNumber;
		int serverId;
		List<Acceptor<T>> choosenAcceptors;
		T valueToAccept;
		
		public Entry(int proposalNumber, int serverId, List<Acceptor<T>> choosenAcceptors, T valueToAccept) {
			super();
			this.proposalNumber = proposalNumber;
			this.serverId = serverId;
			this.choosenAcceptors = choosenAcceptors;
			this.valueToAccept = valueToAccept;
		}
		
	}
	
}
