package com.mario.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Response {
	
	private int statusCode;
	
	
	private String message;
	
	private String token;
	
	
	private String role;
	
	private String bookingConfirmationCode;
	

	private UserDTO user;
	
	
	

	private RoomDTO room;
	
	private String expirationTime;
	

	
	
	
	
	
	
	
	

}
