package com.travel.world.Tworld.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.world.Tworld.dto.BookingDto;
import com.travel.world.Tworld.entity.Bookings;
import com.travel.world.Tworld.entity.Passengers;
import com.travel.world.Tworld.repository.BookingRepository;
import com.travel.world.Tworld.repository.PassengerRepository;

@Service
public class BookingService {

	private BookingRepository bookingRepository;
	private PassengerRepository passengerRepository;

	private ModelMapper modelMapper;

	public BookingService(@Autowired BookingRepository bookingRepository,
			@Autowired PassengerRepository passengerRepository,
			@Autowired ModelMapper modelMapper) {
		this.bookingRepository = bookingRepository;
		this.passengerRepository=passengerRepository;
		this.modelMapper = modelMapper;
	}

	public Bookings saveInTheDb(BookingDto bookingDto) {
		
		 Passengers passenger = bookingDto.getPassenger();

		    // Example: check by email (or ID if you have it)
		 Passengers savedOrExisting = passengerRepository
				    .findByEmail(passenger.getEmail())
				    .orElseGet(() -> passengerRepository.save(passenger));
		 
		 bookingDto.setPassenger(savedOrExisting);

		return bookingRepository.save(modelMapper.map(bookingDto, Bookings.class));
	}
}
