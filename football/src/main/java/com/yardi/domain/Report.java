package com.yardi.domain;

public class Report {
	
	
	private Team winner;
	private Team loser;
	private int winnerScore;
	private int loserScore;
	public Report(Team team1, Team team2, int team1Score, int team2Score) {
		super();
		
		if(team1Score > team2Score)
		{
			this.winner = team1;
			this.loser = team2;
			this.winnerScore = team1Score;
			this.loserScore = team2Score;
		}
		else {
				this.winner = team2;
				this.loser = team1;
				this.winnerScore = team2Score;
				this.loserScore = team1Score;
		}	
	}
	public Team getWinner() {
		return winner;
	}
	public Team getLoser() {
		return loser;
	}
	public int getWinnerScore() {
		return winnerScore;
	}
	public int getLoserScore() {
		return loserScore;
	}
	@Override
	public String toString() {
		return winner.getName() + " won the match against " + loser.getName() + " Final Score is " + winnerScore + "-" + loserScore + System.lineSeparator();
	}
	
	

}