package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportsController {
	
	public static void AddNewAirport(Database database, Scanner s) throws SQLException {
		
		System.out.println("Enter city: ");
		String city = s.next();
		
		ArrayList<Airport> airports = getAllAirports(database);
		int id = airports.get(airports.size()-1).getID()+1;
		
		
		Airport airport = new Airport();
		airport.setID(id);
		airport.setCity(city);
		
		
		String insert = "INSERT INTO `airports`(`id`, `city`) "
				+ "VALUES ('"+airport.getID()+"','"+airport.getCity()+"');";
		
	}
	
	public static ArrayList<Airport> getAllAirports(Database database) throws SQLException{
		ArrayList<Airport> airports = new ArrayList<>();
		
		
		String select = "SELECT * FROM `airports` ;";
		ResultSet rs = database.getStatement().executeQuery(select);
		while(rs.next()) {
			Airport a = new Airport();
			a.setID(rs.getInt("id"));
			a.setCity(rs.getString("city"));
			airports.add(a);
		}
		return airports;
		
	}

}
