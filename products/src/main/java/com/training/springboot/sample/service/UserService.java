package com.training.springboot.sample.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.training.springboot.sample.entities.User;
import com.training.springboot.sample.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    

    User save(UserRegistrationDto registration);
}

