package assignment_1;

import java.sql.Connection;  
import java.util.ArrayList;
import java.util.List; 
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration; 
import org.springframework.context.annotation.Scope; 

@Configuration
@ComponentScan("assignment_1")
public class Config {
	
	@Bean 
	public StudentDB studentDBBean(Connection connection) {
		return new StudentDB(connection);
	}
	
	@Bean 
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public List<Hobby> hobbiesBean() {
		ArrayList<Hobby> hobbies = new ArrayList<>();
		hobbies.add(new Hobby("Running"));
		hobbies.add(new Hobby("Swimming"));
		return hobbies;
	} 
}
