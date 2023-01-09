package com.rubix.timesheet.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.timesheet.Service.EmailService;
import com.rubix.timesheet.Service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import com.rubix.timesheet.Repository.*;
import com.rubix.timesheet.Config.jwt.*;
import com.rubix.timesheet.Config.services.*;
import com.rubix.timesheet.Domain.ERole;
import com.rubix.timesheet.Domain.Employee;
import com.rubix.timesheet.Domain.Role;
import com.rubix.timesheet.Exception.AlreadyExistsException;
import com.rubix.timesheet.Config.jwt.response.*;
@Slf4j

@CrossOrigin(origins = { "http://localhost:4200", "https://rubix-timesheet-client.herokuapp.com" })
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/timesheet/auth")
public class AuthController {
	@Autowired
	EmployeeService employeeService;

	

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeeRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils
	;
	@Autowired
	private EmailService emailService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody Employee loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmailId(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), 
						//userDetails.getEmail(),
						roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> register(@RequestBody Employee employee) throws Exception {
		Employee supervisor=userRepository.findByEmailId("dinesh@rubixtek.com");
		Employee newEmployee = new Employee();
		String randomCode = RandomString.make(64);
		BeanUtils.copyProperties(employee, newEmployee,"verificationCode","verified","password","roles");
		newEmployee.setPassword(encoder.encode(employee.getPassword()));
		newEmployee.setVerificationCode(randomCode);
		newEmployee.setVerified(false);
		newEmployee.setSupervisor(supervisor);
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE);
		roles.add(userRole);
		newEmployee.setRoles(roles);
		if (userRepository.findEmployeeByEmailId(newEmployee.getEmailId()).isPresent())
			throw new AlreadyExistsException("emailId already Exists");
		else {
			newEmployee = userRepository.save(newEmployee);
			emailService.sendVerificationEmail(newEmployee,"https://rubix-timesheet-server.herokuapp.com//timesheet/auth");
			
		}
		return new ResponseEntity<String>("Employee Registered", HttpStatus.OK);
	}
	@GetMapping("/verify")
	public String verifyEmployeeById(@RequestParam String code,@RequestParam long id) {
		Employee employee=userRepository.findByEmployeeId(id);
		employee.setVerified(true);
		employee=userRepository.save(employee);
		return "Employee Verified Successfully";
	}


}
