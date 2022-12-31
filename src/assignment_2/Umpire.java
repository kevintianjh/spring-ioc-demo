package assignment_2;

import java.util.ArrayList; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Umpire { 
	@Autowired private Guesser guesser; 
	@Autowired private ArrayList<Player> playerList;
	  
	public void run() { 
		ArrayList<Player> winners = new ArrayList<>();
		int answer = this.guesser.getGuess();  
		this.playerList.forEach((i)-> {
			i.askInput();
			if(i.getGuess() == answer) {
				winners.add(i);
			}
		}); 
		
		System.out.println("Number from guesser: " + answer);  
		
		if(winners.size() == 0) {
			System.out.println("Game lost, try again...");
			return;
		} 
		
		String output = "Player";
		
		for(int i = 0; i < winners.size(); i++) {
			if(i == 0) {
				output += " " + winners.get(i).getPlayerNo();
			}
			else if(i == (winners.size()-1)) {
				output += " and " + winners.get(i).getPlayerNo();
			}
			else {
				output += ", " + winners.get(i).getPlayerNo();
			} 
		}
		
		String lastPart = " has won the game";
		
		if(winners.size() > 1) {
			lastPart = " have won the game";
		}
		
		output += lastPart; 
		System.out.println(output); 
	}  
} 