package com.rubix.react.audit.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rubix.react.audit.dto.LoginDto;
import com.rubix.react.audit.dto.UserRegistrationDto;
import com.rubix.react.audit.entities.Role;
import com.rubix.react.audit.entities.User;
import com.rubix.react.audit.repository.RoleRepository;
import com.rubix.react.audit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registration) {

		System.out.println("Going to save the user....");
		User user = new User();
		user.setFirstName(registration.getFirstName());
		user.setLastName(registration.getLastName());
		user.setEmail(registration.getEmail());
		user.setMobileNumber(registration.getMobileNumber());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));

		System.out.println("Going to get the roles for the user now.....");

		Role role = roleRepository.findByName("ROLE_USER");
		user.setRoles(Arrays.asList(role));
		return userRepository.save(user);
	}

	// password and username already exisit or not [method one]

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

// pasword and username already exisit or not [method two]

	public Boolean signIn(LoginDto user) {

		String email = user.getEmail();
		String pass = user.getPassword();
		User userExist = userRepository.findByEmailAndPassword(email, pass);
		if (userExist != null) {
			return true;
		} else {
			return false;
		}
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	// forget password without verification
	public User updateUserData(long id, UserRegistrationDto registrationDto) {
		User olduser = userRepository.findByUserId(id);
		BeanUtils.copyProperties(registrationDto, olduser);
		olduser = userRepository.save(olduser);
		return olduser;
	}

}
