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
		
		public static void EditPassenger(Database database, Scanner s) {
			System.out.println("Enter passenger id(int): \n(-1 to show all passengers)");
			int id = s.nextInt();
			if (id == -1) {
				printAllPassenger(database);
			}
		}
		
		public static void printAllPassengers(Database database) throws SQLException {
			ArrayList<Passenger> passengers = database.getAllPassengers();
			
			for  (Passenger p : passengers) {
				System.out.println("id: " + p.getId());
				System.out.println("Name :" + p.getFirstName()+" " +p.getLastName());
			}
		}
		
		
		
	}
