package AirlineManagmentSystem;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Main {





	public static void main(String[] args) throws SQLException{


		PassengersDatabase database = new PassengersDatabase();
		Scanner s = new Scanner(System.in);
		
		
		int i = 0;
		
		
		
		do {
			System.out.println("Welcome to Airline Managment System");
			System.out.println("1. Add new passenger");
			System.out.println("2. Get passenger id by name");
			System.out.println("3. Print all passengers");
			System.out.println("4. Edit passenger");
			System.out.println("5. Delete passenger");
			System.out.println("20. Quit");
			
			i = s.nextInt();
			
			switch (i) {
			case 1:
				PassengersController.AddNewPassenger(database, s);
				break;
			case 2:
				PassengersController.findPassengerByName(database, s);
				break;
			case 3:
				PassengersController.printAllPassengers(database);
				break;
			case 4:
				PassengersController.EditPassenger(database, s);
				break;
			case 5:
				PassengersController.DeletePassenger(database, s);
				break;
			
			}
		} while (i!=20);


		


	}
	


}
