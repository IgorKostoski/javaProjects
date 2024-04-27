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
		System.out.println("Enter salary (double):  ");
		double salary = s.nextDouble();
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setPhone(Phone);
		employee.setSalary(salary);
		
		ArrayList<Employee> employees = getAllEmployees(database);	
		
		int id;
		
		
		if(employees.size()!=0) {
			id = employees.get(employees.size()-1).getId()+1;
		} else {
			id = 0;
		}
		employee.setId(id);
		
		
		String insert = "INSERT INTO `employees`(`id`, `firstName`, `lastName`,"
				+ " `Phone`, `email`,`salary`)"
				+ " VALUES "
				+ "('"+employee.getId()+"','"+employee.getFirstName()+"',"
						+ "'"+employee.getLastName()+"',"
								+ "'"+employee.getPhone()+"','"+employee.getEmail()+"','"+employee.getSalary()+"');";
		
		database.getStatement().execute(insert);
		
		
		
		System.out.println("Employee added successfully!");
	}
	
	private static ArrayList<Employee> getAllEmployees(Database database) throws SQLException{
		
		String get = "SELECT * FROM `employees`;";
		ResultSet rs = database.getStatement().executeQuery(get);
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		while(rs.next()) {
			Employee p = new Employee();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setPhone(rs.getString("Phone"));
			p.setEmail(rs.getString("email"));
			p.setSalary(Double.parseDouble(rs.getString("salary")));
			
			employees.add(p);
			
			
		}
		
		return employees;
		
	}

}
