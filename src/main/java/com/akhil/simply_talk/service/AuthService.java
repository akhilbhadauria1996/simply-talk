package com.akhil.simply_talk.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akhil.simply_talk.dto.LoginRequest;
import com.akhil.simply_talk.dto.LoginResponse;
import com.akhil.simply_talk.entity.User;
import com.akhil.simply_talk.repo.UserRepo;
import com.akhil.simply_talk.security.JwtService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
	
	private final UserRepo repo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	public LoginResponse login(LoginRequest request) {

	    User user = repo.findByUserName(request.getUsername())
	            .orElseThrow(() -> new RuntimeException("Invalid credentials"));

	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	        throw new RuntimeException("Invalid credentials");
	    }

	    String token = jwtService.generateToken(user.getId().toString());

	    return new LoginResponse(token);
	}

}
