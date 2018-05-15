package com.yougal.component;

import com.yougal.common.ApplicationDTO;

public interface Acceptor<T> {

	ApplicationDTO<T> prepare(int proposalNumber);
	
	ApplicationDTO<T> accept(int proposalNumber, T valueToAccept);
	
	int getServerId();
	
}
