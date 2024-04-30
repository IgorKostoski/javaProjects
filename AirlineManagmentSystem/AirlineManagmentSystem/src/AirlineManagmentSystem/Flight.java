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
		delayed = false;
		stuff = new Employee[10];
		int totalCapacity = airplane.getBusinessCapacity()+airplane.getEconomyCapacity();
		passengers = new Passenger[totalCapacity];
		
	}
	
	public Airplane getAirplane() {
		return airplane;
		
	}
	
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
		
	}
	
	public Airport getOriginaAirport() {
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
	
	
	public LocalDateTime getDepartureTime() {
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
	
	public boolean isDelayed() {
		return delayed;
	}
	
	public void delay() {
		delayed = true;
	}
	
	public int getBookedEconomy() {
		return bookedEconomy;
	}
	
	public void setBookedEconomy(int bookedEconomy) {
		this.bookedEconomy = bookedEconomy;
	}
	
	public int getBookedBusiness() {
		return bookedBusiness;
	}
	
	public void  setBookedBusiness(int bookedBusiness) {
		this.bookedBusiness = bookedBusiness;
	}
	
	public Employee[] getStuff() {
		return stuff;
	}
	
	public void setStuff(Employee[] stuff) {
		this.stuff = stuff;
	}
	
	public Passenger [] getPassengers() {
		return passengers;
	}
	
	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}
	

}
