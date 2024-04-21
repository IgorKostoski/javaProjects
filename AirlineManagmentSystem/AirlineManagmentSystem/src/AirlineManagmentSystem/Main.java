package AirlineManagmentSystem;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	private static String url = "jdbc:mysql://localhost/Airline Management System";
	
	private static String user = "user";
	private static String pass = "123456";

	public static void main(String[] args) throws SQLException {
		
		
		PassengersController passengersController = new PassengersController(connection());

	}
	
	
	
	private static Connection connection() throws SQLException  {
		return DriverManager.getConnection(url, user, pass);
	}

}
