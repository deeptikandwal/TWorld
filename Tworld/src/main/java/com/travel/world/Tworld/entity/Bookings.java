package com.travel.world.Tworld.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookingId;
	
	private String ticketNumber;

    private LocalDate bookingDate;
    
    //If you want saving Booking to also save the associated Passenger automatically, you can enable cascading:
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passengers passenger;
}
