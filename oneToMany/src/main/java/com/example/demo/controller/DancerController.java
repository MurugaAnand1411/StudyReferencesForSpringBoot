package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Dancer;
import com.example.demo.service.DancerService;


@RestController
@RequestMapping("/oneToMany/dancer/")

public class DancerController {

		@Autowired
		private  DancerService dancerService;
		

		@PostMapping
		public String saveShoes(@RequestBody  Dancer dancer) {
			Optional<Dancer> danDb = dancerService.createsDancer(dancer);
			if (danDb.isPresent()) {
				return "The comopany data has been saved successfully!";
			} else {
				return "comopany data already exist in records";
			}
		}

		@GetMapping("/{id}")
		public ResponseEntity<Dancer> getDancerById(@PathVariable("id") Long id) {
			Optional<Dancer> com = dancerService.getOneDancer(id);
			if (com.isPresent()) {
				return new ResponseEntity<>(com.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		@GetMapping
		public List<Dancer> getAllDdeails() {
			return dancerService.getAllDancer();
		}

		@PutMapping
		public String updateDancer(@RequestBody Dancer dan) {
			Optional<Dancer> comobj = dancerService.updateDancerDetails(dan);
			if (comobj.isEmpty()) {
				return "The company data does not exist in records!";
			} else {
				return "The company data has been updated successfully!";
			}
		}

		@DeleteMapping("/{id}")
		public String deleteCompanyById(@PathVariable("id")Long id) {
			return dancerService.delete(id);
		}
		
		
	}


