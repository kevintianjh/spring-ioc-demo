package assignment_2;

import java.util.Random; 
import org.springframework.stereotype.Component;

@Component
public class Guesser {
	private Random random = new Random();
	
	public int getGuess() {
		int guess = random.nextInt(10);
		guess++;
		return guess;
	}
}