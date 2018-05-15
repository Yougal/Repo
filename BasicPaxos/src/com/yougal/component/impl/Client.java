package com.yougal.component.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import com.yougal.component.Acceptor;
import com.yougal.component.Proposer;
import com.yougal.component.impl.PaxosManager.Entry;

public class Client<T>{
	
	List<Acceptor<T>> acceptors;
	List<Proposer<T>> proposers;
	
	Random rand = new Random();
	
	PaxosManager<T> paxosManager = new PaxosManager<>();

	public Client(List<Acceptor<T>> acceptors, List<Proposer<T>> proposers) {
		super();
		this.acceptors = acceptors;
		this.proposers = proposers;
	}

	
	
	public Runnable runConsesus(int serverId, Supplier<T> nextValueFunction){
		T valueToAccept = nextValueFunction.get();
		Proposer<T> proposer = proposers.get(serverId);
		return new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inital value choosen by "+proposer + " is " +valueToAccept);
				List<Acceptor<T>> choosenAcceptors = chooseAcceptors();
				boolean valueChoosen = false;
				do{
					try{
						Entry<T> result = paxosManager.runPhaseI(proposer, choosenAcceptors, valueToAccept);
						T valueAccepted = paxosManager.runPhaseII(result);
						valueChoosen=true;
						System.out.println(proposer+ " Acceptors: { "+ choosenAcceptors + " } Agreeed to: " + valueAccepted);
					}catch(IllegalStateException e ){
						System.err.println(e.getMessage());
						
					}
				}while(!valueChoosen);
			}
		};
	}
	
	private List<Acceptor<T>> chooseAcceptors() {
		Map<Integer,Acceptor<T>> choosenAcceptors = new HashMap<>();
		for (int i = 0; i <acceptors.size()/2 + 1; i++) {
			int nextInt = -1;
			do{
				nextInt = rand.nextInt(acceptors.size());
			}while(choosenAcceptors.containsKey(nextInt));
			int randomIndex = nextInt;
	        choosenAcceptors.put(randomIndex,acceptors.get(randomIndex));
	    }
		return new ArrayList<>(choosenAcceptors.values());
	}

	

}
