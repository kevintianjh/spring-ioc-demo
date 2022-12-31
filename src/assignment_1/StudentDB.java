package assignment_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDB { 
	private Connection connection;
	
	public StudentDB() {}
	
	public StudentDB(Connection connection) {
		this.connection = connection;
	} 
	
	public Connection getConnection() {
		return connection;
	} 
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	} 
	
	public List<Student> getList() throws SQLException {
		ArrayList<Student> list = new ArrayList<>();
		 
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		
		while(rs.next()) {
			Student student = new Student(rs.getInt(1), rs.getString(2));
			list.add(student);
		}
		
		return list;
	}

	@Override
	public String toString() {
		return "StudentDB [connection=" + connection + "]";
	}  
}
