package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
	
	
	private int ID;
	private String content;
	private User user;
	private LocalDateTime dateTime;
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	
	
	public Comment() {
		
	}
	
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getContent() {
		return content;
	}
	
	public void getContent(String content) {
		this.content = content;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public LocalDateTime getDateTime() {
		return dateTime;
		
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getDateTimeToString() {
		return dateTimeFormatter.format(dateTime);
	}
	
	public void setDateTimeFromString(String dateTime) {
		this.dateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
	}
	
	
	
	
	
	
	
	

}
