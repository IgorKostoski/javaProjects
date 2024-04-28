package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportsController {
	
	public static void AddNewAirport(Database database, Scanner s) throws SQLException {
		
		System.out.println("Enter city: ");
		String city = s.next();
		
		int id;
		ArrayList<Airport> airports = getAllAirports(database);
		
		
		if(airports.size()!=0) {
			id = airports.get(airports.size()-1).getID()+1;
			
		} else {
			id = 0;
		}
		
		
		
		Airport airport = new Airport();
		airport.setID(id);
		airport.setCity(city);
		
		
		String insert = "INSERT INTO `airports`(`id`, `city`) "
				+ "VALUES ('"+airport.getID()+"','"+airport.getCity()+"');";
		
		database.getStatement().execute(insert);
		System.out.println("AIrport added successfully");
		
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
	public static void PrintAllAirports(Database database) throws SQLException {
		System.out.println("--------------------------------------");
		System.out.println("id\tcity");
		
		for(Airport a: getAllAirports(database)) {
			a.print();
		}
		System.out.println("--------------------------------------");
	}
	

}
