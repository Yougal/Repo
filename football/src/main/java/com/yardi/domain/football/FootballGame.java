package com.yardi.domain.football;

import com.yardi.domain.Game;
import com.yardi.domain.GameStrategy;
import com.yardi.domain.Report;
import com.yardi.domain.Team;

public class FootballGame implements Game {

	private String team1Name;
	private String team2Name;
	
	private int team1Score;
	private int team2Score;
	
	public FootballGame() {
		super();
	}


	public FootballGame(String team1Name, String team2Name) {
		super();
		this.team1Name = team1Name;
		this.team2Name = team2Name;
	}


	public FootballGame(String team1Name, String team2Name, int team1Score, int team2Score) {
		super();
		this.team1Name = team1Name;
		this.team2Name = team2Name;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}


	@Override
	public Report play(Team t1, Team t2) {
		FootballTeam ft1=(FootballTeam)t1;
		FootballTeam ft2=(FootballTeam)t2;
		GameStrategy game1Strategy = ft1.getCoach().performRole();
		GameStrategy game2Strategy = ft2.getCoach().performRole();
		int score1 = game1Strategy.execute();
		int score2 = game2Strategy.execute();
		Report rep =new Report(ft1, ft2, score1,score2);
		return rep;
	}
	

	public String getTeam1Name() {
		return team1Name;
	}


	public String getTeam2Name() {
		return team2Name;
	}


	public int getTeam1Score() {
		return team1Score;
	}


	public int getTeam2Score() {
		return team2Score;
	}


}
