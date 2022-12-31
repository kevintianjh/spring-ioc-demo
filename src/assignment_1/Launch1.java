package assignment_1;

import java.sql.Connection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launch1 {
	public static void main(String[] args) {
		// Demonstrated using annotation, go to Launch2 for XML 
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		 
		/* Bean definition using @Component
		 * Defined as Singleton
		 */
		Connection connection = ac.getBean(Connection.class);
		Connection connection2 = ac.getBean(Connection.class);
		System.out.println(connection == connection2); //Prints true
		System.out.println(connection2);
		
		System.out.println();
		
		/* Bean definition inside Config.java 
		 * Created as Singleton
		 * */
		StudentDB studentDB = ac.getBean(StudentDB.class);
		StudentDB studentDB2 = ac.getBean(StudentDB.class); 
		System.out.println(studentDB);
		System.out.println(studentDB == studentDB2); // Prints true
		
		System.out.println();
		
		//Bean definition using @Component annotation
		CarDB carDB = ac.getBean(CarDB.class); 
		System.out.println(carDB);
		
		System.out.println();
		
		/* Prototype Student bean, with Address and List<Hobby> objects injected using
		 * @Autowired. Address bean is defined using @Component and List<Hobby> bean 
		 * is defined inside Config.java. 
		 */ 
		Student student1 = ac.getBean(Student.class);
		Student student2 = ac.getBean(Student.class);  
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student1==student2); //Prints false 
	}
}
