package com.yardi.domain.football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yardi.domain.Game;
import com.yardi.domain.Report;
import com.yardi.domain.Team;
import com.yardi.domain.Tournament;

public class FootballKnockoutTournament implements Tournament {

	private Map<String, Team> teams = new HashMap<>();
	private List<Report> result = new ArrayList<>();

	@Override
	public void addTeam(Team team) {
		teams.put(team.getName(),team);
	}

	public int getCurrentTournamentTeamSize() {
		return teams.size();
	}
	
	@Override
	public List<Report> tournamentStandings() {
		return result;
	}

	public void startTournament() {
		List<Team> teamInTournamemt = new ArrayList<>(teams.values());
		List<Team> winners = new ArrayList<>();
		while (teamInTournamemt.size() > 1) {
			for (int i = 0; i < teamInTournamemt.size(); i = i + 2){
				if (i + 1 >= teamInTournamemt.size()) {
					winners.add(teamInTournamemt.get(i));
				} else {
					Team team1 = teamInTournamemt.get(i);
					Team team2 = teamInTournamemt.get(i + 1);
					Game g = new FootballGame(team1.getName(),team2.getName());
					addGame(g);
				}
			}
			teamInTournamemt = new ArrayList<>(winners);
			winners.clear();
		}
	}

	@Override
	public void addGame(Game g) {
		Report gameResult = g.play(teams.get(g.getTeam1Name()), teams.get(g.getTeam2Name()));
		result.add(gameResult);
	}

}
