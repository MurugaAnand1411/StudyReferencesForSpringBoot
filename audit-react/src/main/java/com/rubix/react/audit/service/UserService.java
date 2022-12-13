package com.rubix.react.audit.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rubix.react.audit.dto.LoginDto;
import com.rubix.react.audit.dto.UserRegistrationDto;
import com.rubix.react.audit.entities.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	Boolean signIn(LoginDto user) ;
	

	//User findByEmail(String email);
}