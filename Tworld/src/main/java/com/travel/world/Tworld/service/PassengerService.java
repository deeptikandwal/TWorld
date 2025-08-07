package com.travel.world.Tworld.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.world.Tworld.dto.PassengersDto;
import com.travel.world.Tworld.entity.Passengers;
import com.travel.world.Tworld.repository.PassengerRepository;

@Service
public class PassengerService {
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ModelMapper modelMapper;

	public void saveInTheDatabase(PassengersDto passengersDto) {
		passengerRepository.save(convertToEntity(passengersDto));
	}
	
	public Passengers convertToEntity(PassengersDto dto) {
	    Passengers entity = new Passengers();
	    entity.setName(dto.getName());
	    entity.setEmail(dto.getEmail());
	    return entity;
	}
}
