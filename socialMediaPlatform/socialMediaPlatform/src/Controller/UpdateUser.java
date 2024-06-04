package Controller;

import Model.Database;
import Model.User;

public class UpdateUser {
	
	private Database database;
	
	public UpdateUser(User user, Database databae) {
		this.database = database;
		
		
	}
	
	
	public boolean isEmailUsed(String email) {
		User u = new User();
		u.setEmail(email);
		return new CreateUser(u, database).isEmailUsed();
	}

}
