package AirlineManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	
	private  String url = "jdbc:mysql://localhost/Airline Management System";
	
	private  String user = "user";
	private  String pass = "123456";
	
	private  Statement statement;
	
	
	public Database() throws SQLException {
		
		Connection connection = DriverManager.getConnection(url, user, pass);
		
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
		

		
	}
	
	public ArrayList<Passenger> getAllPassengers() throws SQLException{
		String get = "SELECT * FROM `Passengers`;";
		ResultSet rs = statement.executeQuery(get);
		
		ArrayList<Passenger> passengers = new ArrayList<>();
		
		while (rs.next()) {
			Passenger p = new Passenger();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setPhone(rs.getString("Phone"));
			p.setEmail(rs.getString("email"));
			
			passengers.add(p);
		}
		
		return passengers;
		
		
		
	}

}
