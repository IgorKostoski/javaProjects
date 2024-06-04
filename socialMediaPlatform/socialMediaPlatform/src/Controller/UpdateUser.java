package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.User;
import View.Alert;

public class UpdateUser {
	
	private Database database;
	private User user;
	
	public UpdateUser(User user, Database databae) {
		this.database = database;
		this.user = user;
		
		
	}
	
	
	public boolean isEmailUsed() {
		return new CreateUser(user, database).isEmailUsed();
	}
	
	
	
	public void update() {
		String update = "UPDATE `Users` SET `FirstName`='"+user.getFirstName()+"',"
				+ "`LastName`='"+user.getLastName()+"',`Email`='"+user.getEmail()+"' WHERE `ID` = "+user.getID()+";";
		
		
		try {
			database.getStatement().execute(update);
		} catch (SQLException e) {
			new Alert(e.getMessage(),null);
		}
	}

}
