package AirlineManagmentSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class FlightsController {
	
	public static void AddNewFlight(Database database, Scanner s) throws SQLException {
		
		System.out.println("Enter plane id (int): \n(-1 to show all planes)");
		int planeID = s.nextInt();
		if (planeID==-1) {
			AirplanesController.PrintAllPlanes(database);
			System.out.println("Enter plane id (int): ");
			planeID = s.nextInt();
		}
		
		
		System.out.println("Enter origin airport id (int): \n(-1 to show all airports)");
		int originID = s.nextInt();
		if (originID==-1) {
			AirportsController.PrintAllAirports(database);
			System.out.println("Enter origin airport id (int): ");
			originID = s.nextInt();
		}
		
		System.out.println("Enter destination airport id (int): \n(-1 to show all airports)");
		int destinationID = s.nextInt();
		if (destinationID==-1) {
			AirportsController.PrintAllAirports(database);
			System.out.println("Enter destination airport id (int): ");
			destinationID = s.nextInt();
		}
		
	}

}
