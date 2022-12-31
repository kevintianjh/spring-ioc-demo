package assignment_2;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class Launch {
	public static void main(String[] args) { 
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		Umpire umpire = ac.getBean(Umpire.class);
		umpire.run();   
	}
}
