package com.mario.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mario.entity.Booking;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserDTO {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String name;
	private String phoneNumber;
	private String role;
	private List<BookingDTO> bookings = new ArrayList<>();
	
	

}
