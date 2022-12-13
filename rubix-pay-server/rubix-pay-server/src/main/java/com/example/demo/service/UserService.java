package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<UserEntity> getAllEmployee()
	{
		List<UserEntity> books = new ArrayList<>(); 
		userRepository.findAll().forEach(books1 -> books.add(books1));  
		return books; 
	}
	
	public UserEntity save(UserEntity employee)
	{
		return userRepository.save(employee);
	}
	
	public Optional<UserEntity> findById(long id)
	{
		return userRepository.findById(id);
	}
	public void deleteById(UserEntity user)
	{
		userRepository.delete(user);
	}
	
	public UserEntity getElement(long id)
	{
		Optional<UserEntity> userEntity=userRepository.findById(id);
		UserEntity userEntitys=null;
		if(userEntity.isPresent())
		{
			userEntitys=userEntity.get();
		}
		return userRepository.save(userEntitys);
	}
	
}
