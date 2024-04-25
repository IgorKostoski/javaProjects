package AirlineManagmentSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	
	
	

	public static void main(String[] args) throws SQLException{
		
		
		Database database = new Database();
		Scanner s = new Scanner(System.in);
		
		
		int i = 0;
		
		do {
			System.out.println("Welcome to Airline Managment System");
			System.out.println("1. Add new passenger");
			System.out.println("2. Get passenger id by name");
			System.out.println("3. Edit passengers");
			System.out.println("4. Quit");
			
			
			i = s.nextInt();
			switch (i) {
			case 1:
				PassengersController.AddNewPassenger(database, s);
				break;
			case 2: 
				PassengersController.findPassengerIdByName(database, s);
				break;
			case 3:
				PassengersController.EditPassenger(database, s);
				break;
			}
		} 
		while( i != 4);
		
		
		
		
	

	}
	
	

}
