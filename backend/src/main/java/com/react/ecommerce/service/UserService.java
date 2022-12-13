package com.react.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.react.ecommerce.domain.Ecommuser;
import com.react.ecommerce.repository.EcommuserRepository;

@Service
public class UserService {
	@Autowired
	EcommuserRepository userRepository;

	public ResponseEntity<Long> register(Ecommuser user) {
		Ecommuser newuser = new Ecommuser();
		if (userRepository.findByEmailId(user.getEmailId()).isPresent()) {
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		} else {
			BeanUtils.copyProperties(user, newuser,"address", "roles", "isVerified");
			newuser.setUserId(newuser.getUserId());
			newuser.setAddress("");
			newuser.setRoles("customer");
			newuser.setIsVerified(true);

			Ecommuser savedUser = userRepository.save(newuser);
			if (userRepository.findById(savedUser.getUserId()).isPresent())
				return new ResponseEntity<Long>(savedUser.getUserId(), HttpStatus.OK);
			else
				return new ResponseEntity<Long>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public ResponseEntity<Boolean> emailCheck(String email) {
		boolean emailExist = false;
		if (userRepository.findByEmailId(email).isPresent()) {
			emailExist = true;
			return new ResponseEntity<Boolean>(emailExist, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(emailExist, HttpStatus.OK);
		}
	}

	public ResponseEntity<Long> signIn(Ecommuser user) {
		String email = user.getEmailId();
		String pass = user.getPassword();
		Ecommuser userExist = userRepository.findByEmailIdAndPassword(email, pass);

		if (userExist != null) {
			return new ResponseEntity<Long>(userExist.getUserId(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
		}
	}

	public Optional<Ecommuser> getUserData(long userId) {
		Optional<Ecommuser> user = userRepository.findById(userId);
		return user;
	}

	public Ecommuser updateUserData(long id, Ecommuser user) {
		Ecommuser olduser = userRepository.findByUserId(id);
		BeanUtils.copyProperties(user, olduser);
		olduser=userRepository.save(olduser);
		return olduser;
	}

}
