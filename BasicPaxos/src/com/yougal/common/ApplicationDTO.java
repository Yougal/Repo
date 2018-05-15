package com.yougal.common;

public class ApplicationDTO<T> {
	
	private int proposalNumber;
	
	private T acceptedValue;

	public ApplicationDTO(int proposalNumber, T acceptedValue) {
		super();
		this.proposalNumber = proposalNumber;
		this.acceptedValue = acceptedValue;
	}

	/**
	 * @return the proposalNumber
	 */
	public int getProposalNumber() {
		return proposalNumber;
	}

	/**
	 * @return the acceptedValue
	 */
	public T getAcceptedValue() {
		return acceptedValue;
	}

}
