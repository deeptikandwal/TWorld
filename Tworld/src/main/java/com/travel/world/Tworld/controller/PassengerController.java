package com.travel.world.Tworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.world.Tworld.dto.PassengersDto;
import com.travel.world.Tworld.service.PassengerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PassengerController {
	
	@Autowired
	PassengerService passengerService;
	

	@PostMapping("/create")
	public ResponseEntity<PassengersDto> saveInTheDatabase(@Valid @RequestBody PassengersDto passengersDto) {
		passengerService.saveInTheDatabase(passengersDto);
		return ResponseEntity.ok(passengersDto);
	}

}
