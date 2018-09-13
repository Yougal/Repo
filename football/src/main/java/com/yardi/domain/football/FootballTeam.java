package com.yardi.domain.football;

import java.util.ArrayList;
import java.util.List;

import com.yardi.domain.Coach;
import com.yardi.domain.Player;
import com.yardi.domain.Team;

public class FootballTeam implements Team {

	private String teamName;
	private final int teamSize;
	private Coach coach;

	private List<Player> players = new ArrayList<>();

	@Override
	public String getName() {
		return teamName;
	}

	public FootballTeam(String teamName,int teamSize) {
		super();
		this.teamName = teamName;
		this.teamSize=teamSize;
	}

	@Override
	public void addCoach(Coach coach) {

		this.coach = coach;

	}

	@Override
	public void addPlayer(Player player) {

		if (players.size() > teamSize) {
			throw new FootballException(" Can not add more Team Players");
		} else {
			players.add(player);
		}

	}
	public int getCurrentTeamSize() {
		return players.size();
	}
	
	public Coach getCoach() {
		return coach;
	}

}
