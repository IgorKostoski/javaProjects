package AirlineManagmentSystem;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightController {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd::HH:mm:ss");
	
	public static void AddNewFlight(Database database, Scanner s) throws SQLException {
		
		System.out.println("Enter plane id(int): \n(-1 to show all planes)");
		int planeID = s.nextInt();
		if (planeID == -1) {
			AirplanesController.PrintAllPlanes(database);
			System.out.println("Enter plane id (int): ");
			
			planeID = s.nextInt();
		}
		
		
		Airplane plane = AirplanesController.getPlaneByID(database, planeID);
		
		System.out.println("Enter origin airport id(int): \n(-1 to show all airports)");
		int originID = s.nextInt();
		if (originID == -1) {
			AirportsController.PrintAllAirports(database);
			System.out.println("Enter origin airport id(int): ");
			originID = s.nextInt();
			
		}
		
		Airport origin = AirportsController.GetAirport(database, originID);
		
		System.out.println("Enter destination airport id (int): \n(-1 to show all airports)");
		int destinationID = s.nextInt();
		
		if (destinationID == -1) {
			AirportsController.PrintAllAirports(database);
			System.out.println("Enter destination airport id(int): ");
			destinationID = s.nextInt();
		}
		
		Airport destination = AirportsController.GetAirport(database, destinationID);
		
		System.out.println("Enter departure time (yyyy-MM-dd::HH:mm:ss): ");
		String dTime = s.next();
		LocalDateTime departureTime = LocalDateTime.parse(dTime, formatter);
		
		System.out.println("Enter arrival time (yyyy-MM-dd::HH:mm:ss): ");
		String aTime = s.next();
		LocalDateTime arrivalTime = LocalDateTime.parse(aTime, formatter);
		
	
		Flight flight = new Flight();
		flight.setAirplane(plane);
		flight.setOriginAirport(origin);
		flight.setDestinationAirport(destination);
		flight.setDepartureTime(departureTime);
		flight.setArrivalTime(arrivalTime);
		
		ArrayList<Flight> flights = getAllFlights(database);
		int id = 0;
		
		if (flights.size()!=0) id = flights.size();
		
		flight.setID(id);
		
		String insert = "INSERT INTO `flights`(`id`, `airplane`, `origin`, `destination`, `departureTime`,"
				+ " `arrivalTime`, `isDelayed`, `bookedEconomy`, `bookedBusiness`, `stuff`, `passengers`)"
				+ " VALUES ('"+flight.getID()+"',"
				+ "'"+planeID+"',"
				+ "'"+originID+"',"
				+ "'"+destinationID+"',"
				+ "'"+dTime+"',"
				+ "'"+aTime+"',"
				+ "'false',"
				+ "'0',"
				+ "'0',"
				+ "'<%%/>',"
				+ "'<%%/>');";
		
		database.getStatement().execute(insert);
		System.out.println("Flight added successfully!");
		
		
		
		
		
		
		
	}
	
	
	public static ArrayList<Flight> getAllFlights(Database database) throws SQLException {
		ArrayList<Flight> flights = new ArrayList<> ();
		
		String select = "SELECT * FROM `flights` ;";
		
		ResultSet rs = database.getStatement().executeQuery(select);
		while (rs.next()) {
			Flight flight = new Flight();
			flight.setID(rs.getInt("id"));
			
			int planeID = rs.getInt("airplane");
			Airplane plane = AirplanesController.getPlaneByID(database, planeID);
			flight.setAirplane(plane);
			
			int originID = rs.getInt("origin");
			flight.setOriginAirport(AirportsController.GetAirport(database, originID));
			
			int destID = rs.getInt("destination");
			flight.setDestinationAirport(AirportsController.GetAirport(database, destID));
			
			String depTime = rs.getString("departure");
			LocalDateTime departure = LocalDateTime.parse(depTime, formatter);
			flight.setDepartureTime(departure);
			
			String arrTime = rs.getString("arrival");
			LocalDateTime arrival = LocalDateTime.parse(arrTime, formatter);
			flight.setArrivalTime(arrival);
			
			boolean delayed = rs.getBoolean("isDelayed");
			if (delayed) flight.delay();
			
			flight.setBookedEconomy(rs.getInt("bookedEconomy"));
			flight.setBookedBusiness(rs.getInt("bookedBusiness"));
			
			String st = rs.getString("stuff");
			String[] stuffID = st.split("<%%/>");
			
			Employee[] stuff = new Employee[10];
			
			for (int i=0; i < stuffID.length; i++ ) {
				int id = Integer.parseInt(stuffID[i]);
				stuff[i] = EmployeesController.getEmployeeByID(database, id);
				
			}
			
			flight.setStuff(stuff);
			
			String pas = rs.getString("passengers");
			String[] passengersID = pas.split("<%%/>");
			
			
			int totalCapacity = plane.getEconomyCapacity()+plane.getBusinessCapacity();
			Passenger[] passengers = new Passenger[totalCapacity];
			
			for (int j = 0; j<passengersID.length; j++) {
				
				int id = Integer.parseInt(passengersID[j]);
				passengers[j] = PassengersController.getPassengerByID(database, id);
				
				
			}
			
			flight.setPassengers(passengers);
			
			flights.add(flight);
			
			
			
		}
		
		
		
		return flights;
		
		
	}

}
