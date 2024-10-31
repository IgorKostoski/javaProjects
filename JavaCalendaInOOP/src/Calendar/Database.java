package Calendar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	
	private String url = "jdbc:mysql://localhost/Calendar";
	private String user = "igor";
	private String pass = "";
	
	
	private Statement statement;
	
	public Database() {
		
		try {
			Connection connection = DriverManager.getConnection(url, user,pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
