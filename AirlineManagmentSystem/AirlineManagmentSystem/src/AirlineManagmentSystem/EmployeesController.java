package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {
	
	public static void AddNewEmployee(Database database, Scanner s) throws SQLException {
		
		System.out.println("Enter first name: ");
		String firstName = s.next();
		System.out.println("Enter last name: ");
		String lastName = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		System.out.println("Enter Phone: ");
		String Phone = s.next();
		System.out.println("Enter salary (double): ");
		Double salary = s.nextDouble();
		System.out.println("Enter position:");
		String position = s.next();
		
		
		
		
		Employee employee = new Employee();
		
		
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setPhone(Phone);
		employee.setSalary(salary);
		employee.setPosition(position);
		
		
		ArrayList<Employee> employees = getAllEmployees(database);
		
		
		int id;
		
		if (employees.size()!=0) {
			id = employees.get(employees.size()-1).getId()+1;
		} else {
			id = 0;
		}
		
		
		employee.setId(id);
		
		String insert = "INSERT INTO `employees`(`id`, `firstName`, `lastName`, `Phone`, `email`, `salary`,`position`) "
				+ "VALUES ('"+employee.getId()+"','"+employee.getFirstName()+"',"
						+ "'"+employee.getLastName()+"','"+employee.getPhone()+"',"
								+ "'"+employee.getEmail()+"','"+employee.getSalary()+"','"+employee.getPosition()+"')";
		
		database.getStatement().execute(insert);
		
		System.out.println("Employee added successfully! ");
			
		
	}
	
	private static ArrayList<Employee> getAllEmployees(Database database) throws SQLException {
		
		String get = "SELECT * FROM `employees`;";
		ResultSet rs = database.getStatement().executeQuery(get);
		
		ArrayList<Employee > employees = new ArrayList<>();
		
		
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(Integer.parseInt(rs.getString("id")));
			e.setFirstName(rs.getString("firstName"));
			e.setLastName(rs.getString("lastName"));
			e.setPhone(rs.getString("Phone"));
			e.setEmail(rs.getString("email"));
			e.setSalary(rs.getDouble("salary"));
			e.setPosition("position");
			employees.add(e);
		}
		return employees;
	}
}	
	
	
