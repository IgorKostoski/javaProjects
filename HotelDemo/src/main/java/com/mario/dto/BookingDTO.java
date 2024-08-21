package com.mario.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mario.entity.Room;
import com.mario.entity.User;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)




public class BookingDTO {
	
	
private Long id;
	
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	
	private int numOfAdults;
	
	private int numOfChildren;
	
	
	private int totalNumOfGuests;
	
	
	private String bookingConfirmationCode;
	
	
	private User user;
	
	
	

	private Room room;

}
