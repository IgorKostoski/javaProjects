package AirlineManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private  String url = "jdbc:mysql://localhost/Airline Management System";
	
	private  String user = "user";
	private  String pass = "123456";
	
	private  Connection connection;
	
	
	public Database() throws SQLException {
		
		connection = DriverManager.getConnection(url, user, pass);
		

		
	}

}
