package com.rubix.react.audit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.react.audit.dto.LoginDto;
import com.rubix.react.audit.dto.UserRegistrationDto;
import com.rubix.react.audit.entities.User;
import com.rubix.react.audit.service.UserService;

/* *@author  Muruganandham
* @version 1.0
*
*/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/signUp")
	public User signUpUser(@RequestBody UserRegistrationDto registrationDto) {
		return userService.save(registrationDto);

	}

	@PostMapping("/emailCheck")
	public UserDetails emailCheck(@RequestBody String email) {
		return userService.loadUserByUsername(email);
	}

	@GetMapping("/signIn")
	public Boolean signInUser(@RequestBody LoginDto registrationDto) {
		return userService.signIn(registrationDto);

	}

}
