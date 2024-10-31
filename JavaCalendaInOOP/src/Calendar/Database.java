package Calendar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
	
	
	public ArrayList<Event> getEvents(String date){
		
		ArrayList<Event> events = new ArrayList<>();
		String select = "SELECT * FROM `Calendar` WHERE `Date` =  '';";
		
		try {
			ResultSet rs = statement.executeQuery(select);
			while (rs.next()) {
				Event e = new Event();
				e.setID(rs.getInt("ID"));
				e.setDescription(rs.getString("Title"));
				e.setDescription(rs.getString("Description"));
				e.setDateTImeFromString(rs.getString("Date")+ " |  " +rs.getString("Time"));
				events.add(e);
				
				
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return events;
	}
	
	
	public boolean hasEvent(String date) {
		boolean hasEvent = false;
		String select = "SELECT * FROM `Calendar` WHERE `Date` =  '';";
		
		try {
			ResultSet rs = statement.executeQuery(select);
			hasEvent = rs.next();
		
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		
		
		return hasEvent;
	}
	
	
	public void createEvent(Event e) {
	    String insert = "INSERT INTO `Calendar`( `Title`, `Description`, `Date`, `Time`)"
	            + " VALUES ('" + e.getTItle() + "','" + e.getDescription() + "','" + e.getDateToString() + "','" + e.getTimeToString()+ "');";
	    try {
	        statement.execute(insert);
	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    }
	}
	
	public void updateEvent(Event e) {
		String update = "UPDATE `Calendar` SET `Title`='"+e.getTItle()+"',`Description`='"+e.getDescription()+"',"
				+ "`Date`='"+e.getDateToString()+"',`Time`='"+e.getTimeToString()+"' WHERE `ID` = "+e.getID()+" ;";
		
		try {
	        statement.execute(update);
	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    }
	}
	
	public void deleteEvent(int ID) {
		String delete = "DELETE FROM `Calendar` WHERE `ID` = "+ID+" ;";
		
		try {
	        statement.execute(delete);
	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    }
	}
	

}
