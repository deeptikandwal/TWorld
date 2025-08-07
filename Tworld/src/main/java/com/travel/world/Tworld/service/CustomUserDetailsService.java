package com.travel.world.Tworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.travel.world.Tworld.entity.User;
import com.travel.world.Tworld.repository.UserRespository;

@Service
//UserDetailService is part of spring security
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRespository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().replace("ROLE_", "")) // e.g., "USER"
                .build();
    }
}
