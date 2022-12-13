package com.react.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.react.ecommerce.domain.Ecommuser;
import com.react.ecommerce.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<Long> signUpUser(@RequestBody Ecommuser user) {
		return userService.register(user);

	}
	@GetMapping("/{userId}")
	public Optional<Ecommuser> getUserById(@PathVariable(value = "userId", required = true) long userId) {
		return userService.getUserData(userId);

	}
	
	@PostMapping("/emailCheck")
	public ResponseEntity<Boolean> emailCheck(@RequestBody String email) {
		return userService.emailCheck(email);

	}

	@PostMapping("/signIn")
	public ResponseEntity<Long> signInUser(@RequestBody Ecommuser user) {
		return userService.signIn(user);

	}
	@PostMapping("/update")
	public Ecommuser updateUser(@RequestParam(value = "id", required = false)  long id,@RequestBody Ecommuser user) {
		return userService.updateUserData(id,user);

	}

}
