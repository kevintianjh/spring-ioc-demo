package assignment_2;

import java.util.ArrayList;
import java.util.Scanner;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration; 

@Configuration
@ComponentScan("assignment_2")
public class Config {
	
	@Bean
	public Scanner scannerBean() {
		return new Scanner(System.in);
	}
	 
	@Bean
	public ArrayList<Player> playerListBean(Player p1, Player p2, Player p3) {
		ArrayList<Player> playerList = new ArrayList<>();
		playerList.add(p1);
		playerList.add(p2);
		playerList.add(p3);
		return playerList;
	} 
}