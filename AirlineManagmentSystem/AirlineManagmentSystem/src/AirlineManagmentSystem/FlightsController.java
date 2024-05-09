package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightsController {
	
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void AddNewFlight(Database database, Scanner s) throws SQLException {
		
		System.out.println("Enter plane id (int): \n(-1 to show all planes)");
		int planeID = s.nextInt();
		if (planeID==-1) {
			AirplanesController.PrintAllPlanes(database);
			System.out.println("Enter plane id (int): ");
			planeID = s.nextInt();
		}
		
		Airplane plane = AirplanesController.getPlaneByID(database, planeID);
		
		
		System.out.println("Enter origin airport id (int): \n(-1 to show all airports)");
		int originID = s.nextInt();
		if (originID==-1) {
			AirportsController.PrintAllAirports(database);
			System.out.println("Enter origin airport id (int): ");
			originID = s.nextInt();
		}
		
		Airport origin = AirportsController.GetAllAirport(database, originID);
		
		System.out.println("Enter destination airport id (int): \n(-1 to show all airports)");
		int destinationID = s.nextInt();
		if (destinationID==-1) {
			AirportsController.PrintAllAirports(database);
			System.out.println("Enter destination airport id (int): ");
			destinationID = s.nextInt();
		}
		
		Airport destination = AirportsController.GetAllAirport(database, destinationID);
		
		System.out.println("Enter departure time(yyyy-MM-dd HH:mm:ss): ");
		String dTime = s.next();
		LocalDateTime departureTime = LocalDateTime.parse(dTime, formatter);
		
		System.out.println("Enter departure time(yyyy-MM-dd HH:mm:ss): ");
		String aTime = s.next();
		LocalDateTime arrivalTime = LocalDateTime.parse(aTime, formatter);
		
		
		
		Flight flight = new Flight();
		flight.setAirplane(plane);
		flight.setOriginAirport(origin);
		flight.setDestinationAirport(destination);
		flight.setArrivalTime(arrivalTime);
		flight.setDepartureTime(departureTime);
		
		
	}
	
	public static ArrayList<Flight> getAllFlights(Database database) throws SQLException {
		ArrayList<Flight> flights = new ArrayList<>();
		String select = "SELECT * FROM `flights`;";
		
		ResultSet rs = database.getStatement().executeQuery(select);
		
		while (rs.next()) {
			Flight flight = new Flight();
			flight.setID(rs.getInt("id"));
			
			
			int planeID =  rs.getInt("airplane");
			flight.setAirplane(AirplanesController.getPlaneByID(database, planeID));
			
			
			int originID = rs.getInt("origin");
			flight.setOriginAirport(AirportsController.GetAllAirport(database, originID));
			
			
			int destID = rs.getInt("destination");
			flight.setDestinationAirport(AirportsController.GetAllAirport(database, destID));
			
			String depTime = rs.getString("departure");
			LocalDateTime departure = LocalDateTime.parse(depTime, formatter);
			flight.setDepartureTime(departure);
			
			String arrTime = rs.getString("arrival");
			LocalDateTime arrival = LocalDateTime.parse(arrTime, formatter);
			flight.setArrivalTime(arrival);
		}
				
				
		return flights;
		
	}

}
