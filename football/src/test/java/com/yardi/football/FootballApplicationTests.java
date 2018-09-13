package com.yardi.football;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.yardi.domain.Coach;
import com.yardi.domain.Game;
import com.yardi.domain.GameStrategy;
import com.yardi.domain.Player;
import com.yardi.domain.Report;
import com.yardi.domain.Team;
import com.yardi.domain.Tournament;
import com.yardi.domain.football.FootballGame;
import com.yardi.domain.football.FootballGenericTournament;
import com.yardi.domain.football.FootballKnockoutTournament;
import com.yardi.domain.football.FootballTeam;

@RunWith(JUnit4.class)

public class FootballApplicationTests {

	@Test
	public void testAbilityToGenerateReport() {
		
		
		
		Tournament t = new FootballGenericTournament();
		Team t1= new FootballTeam("India",4);
		Coach t1Coach=new Coach("Deepak",null);
		t1.addPlayer(new Player("A","Fwd"));
		t1.addPlayer(new Player("B","Fwd"));
		t1.addPlayer(new Player("C","Def"));
		t1.addPlayer(new Player("D","GoalKeeper"));
		t1.addCoach(t1Coach);
		
		Team t2= new FootballTeam("USA",4);
		Coach t2Coach=new Coach("John",null);
		t2.addPlayer(new Player("A","Fwd"));
		t2.addPlayer(new Player("B","Fwd"));
		t2.addPlayer(new Player("C","Def"));
		t2.addPlayer(new Player("D","GoalKeeper"));
		t2.addCoach(t2Coach);
		
		
		
		Team t3= new FootballTeam("Canada",4);
		Coach t3Coach=new Coach("Erin",new GameStrategy() {
			
			@Override
			public int execute() {
				// TODO Auto-generated method stub
				return Integer.MAX_VALUE;
			}
		});
		
		t3.addPlayer(new Player("A","Fwd"));
		t3.addPlayer(new Player("B","Fwd"));
		t3.addPlayer(new Player("C","Def"));
		t3.addPlayer(new Player("D","GoalKeeper"));
		t3.addCoach(t3Coach);
		
		
		t.addTeam(t1);
		t.addTeam(t2);
		t.addTeam(t3);
		
		Game g1 = new FootballGame("India", "USA",3,2);
		Game g2 = new FootballGame("India", "Canada", 4,5);
		t.addGame(g1);
		t.addGame(g2);
		List<Report> report=t.tournamentStandings();
		assertEquals(report.size(), 2);
		
		
		
	}

	@Test
	public void addPlayerTest() {
		
		
		
		
		FootballTeam t1= new FootballTeam("India",4);
		t1.addPlayer(new Player("A","Fwd"));
		t1.addPlayer(new Player("B","Fwd"));
		t1.addPlayer(new Player("C","Def"));
		t1.addPlayer(new Player("D","GoalKeeper"));
	
	
		assertEquals(t1.getCurrentTeamSize(),4);
		
		
	}
	
	@Test
	public void addCoachTest() {
		
		
		
		
		FootballTeam t1= new FootballTeam("India",4);
		Coach t1Coach=new Coach("Deepak",null);
		
		t1.addCoach(t1Coach);
	
		assertEquals(t1.getCoach(),t1Coach);
		
		
	}
	
	@Test
	public void abilityToAddTeam() {
		
		FootballKnockoutTournament t = new FootballKnockoutTournament();
		Team t1= new FootballTeam("India",4);
		Coach t1Coach=new Coach("Deepak",null);
		t1.addPlayer(new Player("A","Fwd"));
		t1.addPlayer(new Player("B","Fwd"));
		t1.addPlayer(new Player("C","Def"));
		t1.addPlayer(new Player("D","GoalKeeper"));
		t1.addCoach(t1Coach);
		t.addTeam(t1);
		assertEquals(t.getCurrentTournamentTeamSize(),1);
		
	}
	
}
