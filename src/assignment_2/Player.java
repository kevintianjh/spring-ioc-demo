package assignment_2;

import java.util.Scanner; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;  

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
public class Player { 
	private static int playerCount = 1; 
	 
	@Autowired private Scanner scanner; 
	private int playerNo; 
	private int guess;
	
	public Player() { 
		this.playerNo = Player.playerCount++;
	}
	 
	public int getPlayerNo() {
		return playerNo; 
	}
  
	public int getGuess() {
		return guess;
	}
  
	public void askInput() { 
		while(true) {
			try { 
				System.out.print("Player " + playerNo + ", guess a number between 1-10: ");
				String strInput = this.scanner.nextLine();
				int input = Integer.parseInt(strInput);
				
				if(input < 1 || input > 10) {
					System.out.println("Please enter a valid input");
					continue;
				} 

				this.guess = input;
				
				break; 
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter a valid input"); 
			}
		} 
	}
}