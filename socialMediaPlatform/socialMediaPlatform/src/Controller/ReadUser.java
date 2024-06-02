package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.User;
import View.Alert;

public class ReadUser {
	
	private boolean loggedIn = false; 
	private User user;
	
	public ReadUser(String email,String password, Database database) {
		String select = "SELECT * FROM `Users` WHERE `Email` = '"+email+"' "
				+ "AND `Password` = '"+password+"';";
		
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			loggedIn = rs.next();
			if(loggedIn) {
				user = new User();
				user.setID(rs.getInt("ID"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("Lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("Password"));
				
			}
			
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			
		}
		
	}
	
	public boolean loggedIn() {
		return loggedIn;
		
	}
	
	public User getUser() {
		return user;
		
	}

}
