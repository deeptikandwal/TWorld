package com.travel.world.Tworld.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.travel.world.Tworld.entity.User;

@Repository
public interface UserRespository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);

	
}
