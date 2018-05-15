package com.yougal.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.yougal.component.Acceptor;
import com.yougal.component.Proposer;
import com.yougal.component.impl.BasicPaxosAcceptorImpl;
import com.yougal.component.impl.BasicPaxosProposalImpl;
import com.yougal.component.impl.Client;

public class ConsesusTest {

	public static void main(String[] args) {
		List<Acceptor<Integer>> acceptors = Arrays.asList(new BasicPaxosAcceptorImpl<>(0),
							new BasicPaxosAcceptorImpl<>(1),
							new BasicPaxosAcceptorImpl<>(2),
							new BasicPaxosAcceptorImpl<>(3),
							new BasicPaxosAcceptorImpl<>(4));
		
		List<Proposer<Integer>> proposers = Arrays.asList(new BasicPaxosProposalImpl(0),new BasicPaxosProposalImpl(3));
		Client<Integer> client1 = new Client<>(acceptors,proposers);
		
		Client<Integer> client2 = new Client<>(acceptors,proposers);
		Random rand = new Random();
		
		Runnable runConsesus1 = client1.runConsesus(0, ()->rand.nextInt());
		Runnable runConsesus2 = client2.runConsesus(1, ()->rand.nextInt());
		Thread clientThread1 = new Thread(runConsesus1);
		Thread clientThread2 = new Thread(runConsesus2);
		clientThread1.start();
		clientThread2.start();
 	}
	
}
