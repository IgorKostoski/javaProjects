package AirlineManagmentSystem;


import java.sql.*;

public class Main {
	
	private String url = "jdbc:mysql://localhost/Airline Management System";
	
	private String user = "user";
	private String pass = "123456";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	private Connection connection() throws SQLException  {
		return DriverManager.getConnection(url, user, pass);
	}

}
