package com.mario.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mario.entity.Booking;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RoomDTO {
	
	

	private String roomType;
	private String roomPrice;
	private String roomPhotoUrl;
	private String roomDescription;
	private List<Booking> bookings;

}
