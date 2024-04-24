package AirlineManagmentSystem;

import java.util.ArrayList;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.SQLException;


	
	public  class  PassengersController {
		
		
		public static void AddNewPassenger(Database database, Scanner s) throws SQLException {
			System.out.println("Enter first name :");
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
			
			int id;
			
			
			if(passengers.size()!=0) {
				id = passengers.get(passengers.size()-1).getId()+1;
			} else {
				id = 0;
			}
			passenger.setId(id);
			database.AddPassenger(passenger);
			System.out.println("Passenger added successfully!");
		
			
			
			
		}
		
		
		
	}
