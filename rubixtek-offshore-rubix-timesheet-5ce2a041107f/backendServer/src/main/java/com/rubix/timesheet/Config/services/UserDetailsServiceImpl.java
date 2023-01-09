package com.rubix.timesheet.Config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubix.timesheet.Repository.EmployeeRepository;
import com.rubix.timesheet.Domain.Employee;
import com.rubix.timesheet.Exception.*;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	EmployeeRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException{
		Employee user = userRepository.findByEmailId(emailId);
		if(user==null) {
			throw new UsernameNotFoundException("Employee not found with this emailId ");
		}
		return UserDetailsImpl.build(user);
	}

}
