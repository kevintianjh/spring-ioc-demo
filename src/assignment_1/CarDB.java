package assignment_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarDB {
	 
	@Autowired private Connection connection;
	
	public CarDB(Connection connection) {
		this.connection = connection;
	}
	 
	public List<Car> getList() throws SQLException {
		ArrayList<Car> list = new ArrayList<>();
		 
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM car");
		
		while(rs.next()) {
			Car student = new Car(rs.getInt(1), rs.getString(2));
			list.add(student);
		}
		
		return list;
	}

	@Override
	public String toString() {
		return "CarDB [connection=" + connection + "]";
	} 
}
