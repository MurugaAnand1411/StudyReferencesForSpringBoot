package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RubixDto;
import com.example.demo.models.Rubix;
import com.example.demo.services.RubixService;
@RestController
@RequestMapping("/onetoOne/rubix")
public class RubixController {
	@Autowired
	private  RubixService rubixService;
	
	@PostMapping
	public ResponseEntity<RubixDto> createNew(@RequestBody Rubix rubi) {
		return rubixService.saveData(rubi);
//		 Optional<Rubix> db1= rubixService.saveData(rub);
//		if(db1.isPresent())
//			return "new value added successfully";
//		else 
//			return "value is already there";
	}
	@GetMapping
	public List<Rubix> allData() {
		return rubixService.getAllData();
	
	}
	
	
}
