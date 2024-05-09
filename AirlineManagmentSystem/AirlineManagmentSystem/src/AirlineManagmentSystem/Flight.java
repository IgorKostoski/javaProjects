package AirlineManagmentSystem;

import java.time.LocalDateTime;

public class Flight {
	
	private Airplane airplane;
	
	private Airport origin;
	
	private Airport destination;
	
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;
	
	private boolean delayed;
	
	private int bookedEconomy;
	private int bookedBusiness;
	
	private Employee[] stuff;
	private Passenger[] passengers;
	
	
	public Flight() {
		
	}
	
	public Airplane getAirplane() {
		return airplane;
	}
	
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
		
	}
	
	public Airport getOriginAirport() {
		return origin;
	}
	
	public void setOriginAirport(Airport origin) {
		this.origin = origin;
	}
	
	
	public Airport getDestinationAirport() {
		return destination;
	}
	
	public void setDestinationAirport(Airport destination) {
		this.destination = destination;
	}
	
	public LocalDateTime getDepartureTime () {
		return departureTime;
	}
	
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
	

}
