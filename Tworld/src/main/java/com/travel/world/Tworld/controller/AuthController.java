package com.travel.world.Tworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.world.Tworld.dto.AuthRequest;
import com.travel.world.Tworld.dto.AuthResponse;
import com.travel.world.Tworld.entity.User;
import com.travel.world.Tworld.repository.UserRespository;
import com.travel.world.Tworld.service.CustomUserDetailsService;
import com.travel.world.Tworld.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AuthRequest request) {
		if (userRespository.findByUsername(request.getUsername()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
		}

		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		userRespository.save(user);

		return ResponseEntity.ok("User registered successfully");
	}

	@PostMapping("/login")
    public ResponseEntity<AuthResponse> login( @RequestBody AuthRequest request) {
        org.springframework.security.core.Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
