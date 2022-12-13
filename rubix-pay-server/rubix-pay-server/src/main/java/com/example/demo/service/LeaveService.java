package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LeaveEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	LeaveRepository leaveRepository;
	
	@Autowired
	UserService userService;
	
	public List<LeaveEntity> getAllLeaves()
	{
		List<LeaveEntity> books = new ArrayList<>(); 
		leaveRepository.findAll().forEach(books1 -> books.add(books1));  
		return books; 
	}
	
	public LeaveEntity save(LeaveEntity employee)
	{
		return leaveRepository.save(employee);
	}
	
	public UserEntity getElementById(long id)
	{
		return userService.getElement(id);
	}
	
	
	public Optional<LeaveEntity> findById(long id)
	{
		return leaveRepository.findById(id);
	}
	public LeaveEntity getElement1(long id)
	{
		Optional<LeaveEntity> userEntity=leaveRepository.findById(id);
		LeaveEntity userEntitys=null;
		if(userEntity.isPresent())
		{
			userEntitys=userEntity.get();
		}
		return leaveRepository.save(userEntitys);
		
	}
	
	public void delete(LeaveEntity userEntity)
	{
		leaveRepository.delete(userEntity);
	}
	public void delete1(UserEntity userEntity)
	{
		userService.deleteById(userEntity);
	}
}
