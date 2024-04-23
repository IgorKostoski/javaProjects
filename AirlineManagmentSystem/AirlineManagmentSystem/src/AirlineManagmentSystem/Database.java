package AirlineManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	
	private  String url = "jdbc:mysql://localhost:3306/Airline Management System";
	
	private  String user = "igor";
	private  String pass = "";
	
	private  Statement statement;
	
	
	public Database() throws SQLException {
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
		

		
	}
	
}
	
	
	