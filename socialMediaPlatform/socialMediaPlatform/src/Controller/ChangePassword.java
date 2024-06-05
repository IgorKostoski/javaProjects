package Controller;

import Model.Database;

public class ChangePassword {
	
	private String password;
	private int ID;
	private Database database;
	
	public ChangePassword(String password, String newP, int ID, Database database) {
		this.ID = ID;
		this.password = password;
		this.database = database;
		
	}
	
	
	public boolean change() {
		
		boolean matches = false ;
		String select = "";
		
	}

}
