package assignment_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch2 {
	
	public static void main(String[] args) {
		//Demonstrated using XML, go to Launch1 for annotation 
		ApplicationContext ac = new ClassPathXmlApplicationContext("assignment_1.xml");
		
		/* Get a Prototype instance of Student, with default 2 hobbies 
		 * already added inside the hobbies list
		 */
		Student student1 = ac.getBean("student", Student.class);
		Student student2 = ac.getBean("student", Student.class);
		System.out.println(student1);
		System.out.println(student2);
		
		System.out.println();
		
		//Get Singleton instance of StudentDB
		StudentDB studentDB = ac.getBean("studentDB", StudentDB.class);
		StudentDB studentDB2 = ac.getBean("studentDB", StudentDB.class); 
		System.out.println(studentDB == studentDB2); // Prints true 
		
		System.out.println();
		
		//Their Connection object is the same
		System.out.println(studentDB.getConnection() == studentDB2.getConnection()); // Prints true
	}
}
