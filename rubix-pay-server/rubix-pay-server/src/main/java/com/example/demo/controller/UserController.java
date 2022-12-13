package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/employees")
	public List<UserEntity> getEmployee()
	{
		List<UserEntity> userEntitys = userService.getAllEmployee(); 
		return userEntitys;
	}
	
	@GetMapping("/employees/{id}")
	public UserEntity getId(@PathVariable Long id){
		
		Optional<UserEntity> ids = userService.findById(id);
		UserEntity empt=null;
		if(ids.isPresent())
		{
			empt=ids.get();
			
		}
		return empt;
	}
	

	@PutMapping("/employees/{id}")
	public UserEntity updateEmployee(@PathVariable long id,@RequestBody UserEntity employeeDetails) 
	{
		Optional<UserEntity> ids = userService.findById(id);
		UserEntity emtable=null;
		if(ids.isPresent())
		{
			emtable = ids.get(); 
			emtable.setFirstName(employeeDetails.getFirstName());
			emtable.setLastName(employeeDetails.getLastName());
			emtable.setDateOfBirth(employeeDetails.getDateOfBirth());
			emtable.setGender(employeeDetails.getGender());
			emtable.setAddress(employeeDetails.getAddress());
			emtable.setPhoneNumber(employeeDetails.getPhoneNumber());
			emtable.setEmailId(employeeDetails.getEmailId());
			emtable.setPositionTitle(employeeDetails.getPositionTitle());
		}
		
        return userService.save(emtable);
	}
	
	@PostMapping("/employees")
	 public UserEntity createEmployee(@RequestBody UserEntity employee) {
       return userService.save(employee);
   }
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id)
	{
		Optional<UserEntity> userEntitys=userService.findById(id);
		UserEntity userEntity=null;
		if(userEntitys.isPresent())
		{
			userEntity=userEntitys.get();
			userService.deleteById(userEntity);
		}
	
	}
	
}
