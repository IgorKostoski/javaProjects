package Calendar;

import java.sql.Statement;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {
	
	private String user = "igor"; 
	private  String pass = "";
	
	private Statement statement;
	
	private String url = "jdbc:mysql://localhost/Calendar";
	
	
	public Database () {
		try {
			Connection connection = DriverManager.getConnection(url,user, pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}


