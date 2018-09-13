package com.yardi.domain.football;

import java.util.Random;

import com.yardi.domain.GameStrategy;

public class RandomGameStrategy implements GameStrategy {

	private Random random=new Random(System.currentTimeMillis());
	
	@Override
	public int execute() {

		
		return Math.abs(random.nextInt())%10;
	}

}
