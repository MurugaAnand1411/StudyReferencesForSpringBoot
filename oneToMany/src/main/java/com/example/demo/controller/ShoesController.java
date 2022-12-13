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

import com.example.demo.models.Shoes;
import com.example.demo.service.ShoesService;

@RestController
@RequestMapping("/maytomany/shoes/")
public class ShoesController {

	
	@Autowired
	private ShoesService shoesSerive;
	
	@PostMapping
	public String saveShoes(@RequestBody  Shoes shoes) {
		Optional<Shoes> shDb = shoesSerive.createsSho(shoes);
		if (shDb.isPresent()) {
			return "The comopany data has been saved successfully!";
		} else {
			return "comopany data already exist in records";
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Shoes> getShoesById(@PathVariable("id") Long id) {
		Optional<Shoes> com = shoesSerive.getOneShoe(id);
		if (com.isPresent()) {
			return new ResponseEntity<>(com.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Shoes> getAllshoess() {
		return shoesSerive.getAllshoes();
	}

	@PutMapping
	public String updateCompany(@RequestBody Shoes shoes) {
		Optional<Shoes> comobj = shoesSerive.updateShoes(shoes);
		if (comobj.isEmpty()) {
			return "The company data does not exist in records!";
		} else {
			return "The company data has been updated successfully!";
		}
	}

	@DeleteMapping("/{id}")
	public String deleteCompanyById(@PathVariable("id")Long id) {
		return shoesSerive.delete(id);
	}
}
