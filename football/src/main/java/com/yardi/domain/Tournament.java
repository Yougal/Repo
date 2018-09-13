package com.yardi.domain;

import java.util.List;

public interface Tournament {
	
	public void addTeam(Team team);
	
	public void addGame(Game game);
	
	public List<Report> tournamentStandings();

}
