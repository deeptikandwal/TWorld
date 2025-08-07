package com.travel.world.Tworld.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.world.Tworld.entity.Passengers;

@Repository
public interface PassengerRepository extends CrudRepository<Passengers, Integer> {

	public Optional<Passengers> findByEmail(@Param("email") String email);

}
