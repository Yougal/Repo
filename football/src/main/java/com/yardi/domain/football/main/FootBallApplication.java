package com.yardi.domain.football.main;

import java.util.Scanner;

import com.yardi.domain.Coach;
import com.yardi.domain.ConsoleDisplayStrategy;
import com.yardi.domain.Game;
import com.yardi.domain.Player;
import com.yardi.domain.Team;
import com.yardi.domain.Tournament;
import com.yardi.domain.TournamentDisplayStatus;
import com.yardi.domain.football.FootballGame;
import com.yardi.domain.football.FootballGenericTournament;
import com.yardi.domain.football.FootballTeam;

public class FootBallApplication {
	
	public static String roles[] = {
			"Goalkeeper",
			"Defender (Centre-back)",
			"Defender (Sweeper)", 
			"Defender (Full-back)",
			"Defender ( Wing-back)",
			"Midfielder (Centre midfield)",
			"Midfielder (Defensive midfield)", 
			"Midfielder (Attacking midfield)",
			"Midfielder (Wide midfield)",
			"Forward (Centre forward)",
			"Forward (Second striker)"
			};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("FootBall Tournament Started");
		Tournament tournament = new FootballGenericTournament();
		System.out.println("Enter number of teams in Tournament: ");
		int numberOfTeams = Integer.valueOf(sc.nextLine());
		int numberOfPlayersInTeam = 3;
		
		for(int i=0;i<numberOfTeams;i++) {
			System.out.println("Enter Team Name: ");
			String teamName = sc.nextLine();
			Team team = new FootballTeam(teamName, numberOfPlayersInTeam);
			
			System.out.println("Enter Coach Name: ");
			String coachName = sc.nextLine();
			Coach coach = new Coach(coachName,null);
			team.addCoach(coach);
			
			for(int j = 0;j<numberOfPlayersInTeam;j++) {
				Player player = new Player(String.valueOf(((char)(65+j))), roles[j]);
				team.addPlayer(player);
			}
			tournament.addTeam(team);
		}
		
		System.out.println("Enter Game Results....");
		String choice = "Y";
		do {
			System.out.println("Enter Team 1 Name: ");
			String team1Name = sc.nextLine();
			System.out.println("Enter Team 2 Name: ");
			String team2Name = sc.nextLine();
			System.out.println("Enter Team 1 Score: ");
			Integer team1Score = Integer.valueOf(sc.nextLine());
			
			System.out.println("Enter Team 2 Score: ");
			Integer team2Score = Integer.valueOf(sc.nextLine());
			
			Game g = new FootballGame(team1Name, team2Name, team1Score, team2Score);
			tournament.addGame(g);
			System.out.println("Do You Add more Games(Y/N)?: ");
			choice = sc.nextLine();
			
		}while(choice.equals("Y"));
		
		TournamentDisplayStatus displayStatus = new ConsoleDisplayStrategy();
		displayStatus.displayTournamentStatus(tournament);
		sc.close();
	}

}
