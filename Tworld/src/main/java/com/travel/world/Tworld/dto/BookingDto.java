package com.travel.world.Tworld.dto;

import java.time.LocalDate;
import com.travel.world.Tworld.entity.Passengers;
import lombok.Data;

@Data
public class BookingDto {

	private String ticketNumber;

    private LocalDate bookingDate;
    
    private Passengers passenger;
	

}
