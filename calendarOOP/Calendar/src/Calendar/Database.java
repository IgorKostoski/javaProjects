package Calendar;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	private String url = "jdbc:mysql://localhost/Calendar";
	private String user = "igor";
	private String pass = "";
	
	private Statement statement;
	
	public Database() {
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Event> getEvents(String date){
		
		ArrayList<Event> events = new ArrayList<>();
		String select = "SELECT * FROM `Calendar` WHERE  `Date` = '"+date+"';";
		
		try {
			ResultSet rs = statement.executeQuery(select);
			while (rs.next()) {
				Event e = new Event();
				e.setID(rs.getInt("ID"));
				e.setTitle(rs.getString("Title"));
				e.setDescription(rs.getString("Description"));
				e.setDateTimeFromString(rs.getString("Date")+" "+rs.getString("Time"));
			}
		}
		return events;
		
	}

}
