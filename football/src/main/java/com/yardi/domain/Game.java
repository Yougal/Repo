package com.yardi.domain;

public interface Game {

	public Report play(Team t1,Team t2);
	
	public String getTeam1Name();
	
	public String getTeam2Name();
	
	public int getTeam1Score();
	
	public int getTeam2Score();
	
	
}
