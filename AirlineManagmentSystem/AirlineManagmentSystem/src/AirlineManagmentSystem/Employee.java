package AirlineManagmentSystem;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String Phone;
	private double salary;
	
	
	public Employee() {
		
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName =lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

}