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
			System.out.println("01. Add new passenger");
			System.out.println("02. Get passenger  by name");
			System.out.println("03. Print all passengers");
			System.out.println("04. Edit passengers");
			System.out.println("05. Delete passenger");
			System.out.println("06. Add new employee");
			System.out.println("07. Get employee by name");
			System.out.println("08. Print all employees");
			System.out.println("09. Edit employee");
			System.out.println("10. Fire employee ");
			System.out.println("11. Add new plane");
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
			case 6:
				EmployeesController.AddNewEmployee(database, s);
				break;
			case 7:
				EmployeesController.findEmployeeByName(database, s);
				break;
			case 8:
				EmployeesController.printAllEmployees(database);
				break;
			case 9:
				EmployeesController.editEmployee(database, s);
				break;
			case 10:
				EmployeesController.deleteEmployee(database, s);
				break;
			case 11:
				AirplanesController.AddNewAirplane(database, s);
		
			}
		} 
		while( i != 20);
		
		
		
		
	

	}
	
	

}
