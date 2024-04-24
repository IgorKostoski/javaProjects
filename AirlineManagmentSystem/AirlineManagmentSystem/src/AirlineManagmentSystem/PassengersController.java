package AirlineManagmentSystem;

import java.util.Scanner;

import java.sql.Connection;


	
	public  class  PassengersController {
		
		
		public static void AddNewPassenger(Database database, Scanner s) {
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
		
			
			
			
		}
		
		
		
	}
