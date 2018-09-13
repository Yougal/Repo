package com.yardi.domain.football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yardi.domain.Game;
import com.yardi.domain.Report;
import com.yardi.domain.Team;
import com.yardi.domain.Tournament;

public class FootballGenericTournament implements Tournament {

	private Map<String,Team> teams = new HashMap<>();
	private List<Report> gameResults = new ArrayList<>();

	@Override
	public void addTeam(Team team) {	
		teams.put(team.getName(), team);
	}

	public int getCurrentTournamentTeamSize() {
		return teams.size();
	}
	
    public void addGame(Game g) {
    	Report report = new Report(teams.get(g.getTeam1Name()), teams.get(g.getTeam2Name()),g.getTeam1Score(),g.getTeam2Score());
    	gameResults.add(report);
	}
    
	@Override
	public List<Report> tournamentStandings() {
		return gameResults;
	}

}
