package AirlineManagmentSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengersController {
	
	public static void AddNewPassenger(Database database, Scanner s) throws SQLException {
		
		
		System.out.println("Enter first name: ");
		String firstName = s.next();
		System.out.println("Enter last name: ");
		String lastName = s.next();
		System.out.println("Enter phone: ");
		String Phone = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setPhone(Phone);
		passenger.setEmail(email);
		ArrayList<Passenger> passengers = database.getAllPassengers();
		
		passenger.setId(passengers.get(passengers.size()-1).getId()+1);
		
		
	}
	

	
	

}
