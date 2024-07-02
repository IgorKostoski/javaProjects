package Controller;

import Model.Database;
import Model.User;


public class AddFriend {
	
	private User user, f;
	private Database database;
	
	public AddFriend(User user, Database database, User f) {
		this.user = user;
		this.database = database;
		this.f = f;
		
		
		
	}
	
	public boolean isAdded() {
		boolean added = false;
		String insert = "INSERT INTO `Friends`(`User`, `Friend`) VALUES ('"+user.getID()+"','"+f.getID()+"');";
	}
	
	

}
