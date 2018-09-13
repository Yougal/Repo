package com.yardi.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleDisplayStrategy implements TournamentDisplayStatus{

	
	 public void displayTournamentStatus(Tournament tournament) {
		 	List<Report> gameResults = tournament.tournamentStandings();
	    	Map<String, Long> winners = gameResults.stream().collect(Collectors.groupingBy(f->f.getWinner().getName(),Collectors.counting()));
	    	Map<String, Long> losers = gameResults.stream().collect(Collectors.groupingBy(f->f.getLoser().getName(),Collectors.counting()));
	    	
	    	HashSet<String> teams  = new HashSet<>(winners.keySet());
	    	teams.addAll(losers.keySet());
	    	
	    	System.out.println("Team" +" Win "+" Loss " );
	    	teams.forEach(team ->
	    			System.out.println(team + winners.getOrDefault(team, 0l) + losers.getOrDefault(team, 0l))
	    	);
	    	
	    }
	
}
