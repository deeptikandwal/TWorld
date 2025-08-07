package com.travel.world.Tworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.world.Tworld.dto.BookingDto;
import com.travel.world.Tworld.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class BookingController {

	private BookingService bookingService;
	public BookingController(@Autowired BookingService bookingService) {
		this.bookingService=bookingService;
	}
	

	@PostMapping("/create/booking")
	public ResponseEntity<BookingDto> saveInTheDatabase(@Valid @RequestBody BookingDto bookingDto) {
		bookingService.saveInTheDb(bookingDto);
		return ResponseEntity.ok(bookingDto);
	}


}
