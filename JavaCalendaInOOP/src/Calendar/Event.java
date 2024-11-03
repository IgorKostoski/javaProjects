package Calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event {
	
	private int ID;
	private String title;
	private String description;
	private LocalDateTime dateTime;
	
	
	public Event(int ID, String title, String description, LocalDateTime dateTime) {
		
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		
	}
	
	public Event(LocalDate date) {
		dateTime = LocalDateTime.of(date, LocalTime.now());
	}
	
	public Event() {
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public String getDateTimeTostring() {
		return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm"));
	}
	
	public String getDateToString() {
		return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public String getTimeToString() {
		return dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
//	public void setDateTimeFromString(String dateTime) {
//		this.dateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm"));
//	}
	
	
	public void setDateTimeFromString(String dateTime) {
	    try {
	        // Replace multiple spaces with a single space to standardize the input
	        String standardizedDateTimeStr = dateTime.replaceAll("\\s+", " ");
	        
	        // Use a formatter that tolerates one or more spaces after the '|'
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy |[ ]HH:mm");
	        
	        // Parse the standardized date-time string
	        this.dateTime = LocalDateTime.parse(standardizedDateTimeStr, formatter);
	    } catch (DateTimeParseException e) {
	        System.err.println("Error parsing date and time: " + e.getMessage());
	    }
	}

	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public void setTime(String time) {
		this.dateTime = LocalDateTime.of(dateTime.toLocalDate(),
				LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm")));
	}
	
	public LocalDate getDate() {
		return dateTime.toLocalDate();
	}

}
