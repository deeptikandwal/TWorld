package com.travel.world.Tworld.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travel.world.Tworld.documents.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);

	

}
