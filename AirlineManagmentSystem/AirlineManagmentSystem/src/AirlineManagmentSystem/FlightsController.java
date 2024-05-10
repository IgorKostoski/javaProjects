package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightsController {
	
	
	
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd::HH:mm:ss");
	
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
		
		System.out.println("Enter departure time(yyyy-MM-dd::HH:mm:ss): ");
		String dTime = s.next();
		LocalDateTime departureTime = LocalDateTime.parse(dTime, formatter);
		
		System.out.println("Enter arrival time(yyyy-MM-dd::HH:mm:ss): ");
		String aTime = s.next();
		LocalDateTime arrivalTime = LocalDateTime.parse(aTime, formatter);
		
		
		
		Flight flight = new Flight();
		flight.setAirplane(plane);
		flight.setOriginAirport(origin);
		flight.setDestinationAirport(destination);
		flight.setArrivalTime(arrivalTime);
		flight.setDepartureTime(departureTime);
		
		
		ArrayList<Flight> flights = getAllFlights(database);
		
		int id = 0;
		
		if (flights.size()!=0) id = flights.size();
		
		flight.setID(id);
		
		String insert = "INSERT INTO `flights`(`id`, `airplane`, `origin`, `destination`, `departureTime`, `arrivalTime`, `isDelayed`,"
				+ " `bookedEconomy`, `bookedBusiness`, `stuff`, `passengers`) "
				+ "VALUES ('"+flight.getID()+"','"+planeID+"','"+originID+"',"
						+ "'"+destinationID+"','"+dTime+"',"
				+ "'"+aTime+"','false','0','0','<%%/>','<%%/>');";
		database.getStatement().execute(insert);
		System.out.println("Flight added successfully");
		
		
	}
	
	public static ArrayList<Flight> getAllFlights(Database database) throws SQLException {
		ArrayList<Flight> flights = new ArrayList<>();
		String select = "SELECT * FROM `flights`;";
		
		ResultSet rs = database.getStatement().executeQuery(select);
		
		ArrayList<Integer> IDs = new ArrayList<>();
		ArrayList<Integer> planeIDs = new ArrayList<>();
		ArrayList<Integer> originIDs = new ArrayList<>();
		ArrayList<Integer> destIDs = new ArrayList<>();
		ArrayList<String> depTimes = new ArrayList<>();
		ArrayList<String> arrTimes = new ArrayList<>();
		ArrayList<String> dels = new ArrayList<>();
		ArrayList<Integer> bookedEconomySeats = new ArrayList<>();
		ArrayList<Integer> bookedBusinessSeats = new ArrayList<>();
		ArrayList<String> sts = new ArrayList<>();
		ArrayList<String> pass = new ArrayList<>();
		
		
		while (rs.next()) {
			
			IDs.add(rs.getInt("id"));
			planeIDs.add(rs.getInt("airplane"));
			originIDs.add(rs.getInt("origin"));
			destIDs.add(rs.getInt("destination"));
			depTimes.add(rs.getString("departureTime"));
			arrTimes.add(rs.getString("arrivalTime"));
			dels.add(rs.getString("isDelayed"));
			bookedEconomySeats.add(rs.getInt("bookedEconomy"));
			bookedBusinessSeats.add(rs.getInt("bookedBusiness"));
			sts.add(rs.getString("stuff"));
			pass.add(rs.getString("passengers"));
			
			
			
			
			
			
					
		}
		for (int i=0; i<IDs.size();i++) {
			Flight flight = new Flight();
			flight.setID(IDs.get(i));
			
			
			int planeID = planeIDs.get(i) ;
			int originID = originIDs.get(i);
			int destID = destIDs.get(i);
			String depTime = depTimes.get(i);
			String arrTime = arrTimes.get(i);
			String del = dels.get(i);
			boolean delayed = Boolean.parseBoolean(del);
			flight.setBookedEconomy(bookedEconomySeats.get(i));
			flight.setBookedBusiness(bookedBusinessSeats.get(i));
			String st = sts.get(i);
			String pas = pass.get(i);
			
			
			
			Airplane plane = AirplanesController.getPlaneByID(database, planeID);
			flight.setAirplane(plane);
			
			
			
			flight.setOriginAirport(AirportsController.GetAllAirport(database, originID));
			
			
			
			flight.setDestinationAirport(AirportsController.GetAllAirport(database, destID));
			
		
			LocalDateTime departure = LocalDateTime.parse(depTime, formatter);
			flight.setDepartureTime(departure);
			
			
			LocalDateTime arrival = LocalDateTime.parse(arrTime, formatter);
			flight.setArrivalTime(arrival);
			
			
			if (delayed) flight.delay();
			
			
			
			
			String[] stuffID = st.split("<%%/>");
			Employee[] stuff = new Employee[10];
			
			for (int j=0; j<stuffID.length;j++) {
				int id = Integer.parseInt(stuffID[j]);
				stuff[j] = EmployeesController.getEmployeeByID(database, id);
			}
			flight.setStuff(stuff);
			
			
			
			String[] passengersID = pas.split("<%%/>");
			int totalCapacity = plane.getEconomyCapacity()+plane.getBusinessCapacity();
			Passenger[] passengers = new Passenger[totalCapacity];
			for (int j=0;j<passengersID.length;j++) {
				
				int id = Integer.parseInt(passengersID[j]);
				passengers[j] = PassengersController.getPassengerByID(database, id);
			}
			
			flight.setPassengers(passengers);
			
			
			flights.add(flight);
		}
				
				
		return flights;
		
	}
	
	
	public static void showAllFlights(Database database) throws SQLException {
		ArrayList<Flight> flights = getAllFlights(database);
		System.out.println("id\tAirplane\tOrigin\tDestination\tDeparture Time"
				+ "\t\tArrival Time\t\tstatus\t\tAvailable Economy\tAvailable Business");
		
		for (Flight f : flights) {
			f.print();
			
		}
	}
	
	public static void delayFlight(Database database, Scanner s) throws SQLException {
		System.out.println("Enter flight id(int): \n(-1 to show all flights)");
		int id = s.nextInt();
		
		if (id==-1) {
			showAllFlights(database);
			System.out.println("Enter flight id (int): ");
			id = s.nextInt();
		}
		
		String update = "UPDATE `flights` SET `isDelayed`='true' WHERE `id` = "+id+";";
		database.getStatement().execute(update);
		System.out.println("Flight delayed succefully!");
	}

}
