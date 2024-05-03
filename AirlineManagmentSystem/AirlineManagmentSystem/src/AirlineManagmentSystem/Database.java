package AirlineManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {

	private  String url = "jdbc:mysql://localhost:3306/Airline Managment System";

	private  String user = "igor";
	private  String pass = "";

	private Statement statement;


	public Database() throws SQLException {

		Connection connection = DriverManager.getConnection(url, user, pass);

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);



	}


	public Statement getStatement() {
		return statement;
	}
	
	
	public void Addpassenger(Passenger p) throws SQLException  {
		String insert = "INSERT INTO `Passengers`(`id`, `firstName`, `lastName`, `Phone`, `email`) "
				+ "VALUES ('"+p.getId()+"','"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getPhone()+"','"+p.getEmail()+"')";
		
		statement.execute(insert);
		
		
	}
	
	public Passenger getPassenger(int id) throws SQLException {
		
		String get = "SELECT `id`, `firstName`, `lastName`, `Phone`, `email` FROM `Passengers` WHERE  `id` = "+id+";";
		ResultSet rs = statement.executeQuery(get);
		
		Passenger p = new Passenger();
		rs.next();
		p.setId(Integer.parseInt(rs.getString("id")));
		p.setFirstName(rs.getString("firstName"));
		p.setLastName(rs.getString("lastName"));
		p.setPhone(rs.getString("Phone"));
		p.setEmail(rs.getString("email"));
		
		return p;
		
		
		 
	}
	
	public Passenger getPassenger(String firstName, String lastName) throws SQLException {
		
		String get = "SELECT `id`, `firstName`, `lastName`, `Phone`, `email` FROM `Passengers` WHERE  `firstName` = \""+firstName+"\";";
		ResultSet rs = statement.executeQuery(get);
		Passenger passenger = new Passenger();
		while(rs.next()) {
			
			Passenger p = new Passenger();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setPhone(rs.getString("Phone"));
			p.setEmail(rs.getString("email"));
			
			
			if (p.getLastName().equals(lastName))  passenger = p; break;	
		}
		return passenger;
		
}
	
	public  void editPassenger(Passenger p) throws SQLException {
		
		String update = "UPDATE `Passengers` SET `id`='"+p.getId()+"',`firstName`='"+p.getFirstName()+"',`lastName`='"+p.getLastName()+"',"
				+ "`Phone`='"+p.getPhone()+"',`email`='"+p.getEmail()+"' WHERE `id` =  '"+p.getId()+"';";
		
		statement.execute(update);
		
		
	}
	
	public ArrayList<Passenger> getAllPassengers() throws SQLException{
		String get = "SELECT * FROM `Passengers`;";
		ResultSet rs = statement.executeQuery(get);
		
		ArrayList<Passenger > passengers = new ArrayList<>();
		
		
		while (rs.next()) {
			Passenger p = new Passenger();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setPhone(rs.getString("Phone"));
			p.setEmail(rs.getString("email"));
			passengers.add(p);
		}
		return passengers;
	}
}


