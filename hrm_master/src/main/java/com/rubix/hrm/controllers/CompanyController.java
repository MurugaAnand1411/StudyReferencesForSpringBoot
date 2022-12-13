package com.rubix.hrm.controllers;

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

import com.rubix.hrm.models.Company;
import com.rubix.hrm.services.CompanyService;

/* *@author  Muruganandham
* @version 1.0
*
*/
@RestController
@RequestMapping("/hrm/company")

public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping
	public String savecompany(@RequestBody Company company) {
		Optional<Company> comDb = companyService.create(company);
		if (comDb.isPresent()) {
			return "The comopany data has been saved successfully!";
		} else {
			return "comopany data already exist in records";
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
		Optional<Company> com = companyService.retrieveOne(id);
		if (com.isPresent()) {
			return new ResponseEntity<>(com.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Company> getALLCompany() {
		return companyService.retrieve();
	}

	@PutMapping
	public String updateCompany(@RequestBody Company comapny) {
		Optional<Company> comobj = companyService.update(comapny);
		if (comobj.isEmpty()) {
			return "The company data does not exist in records!";
		} else {
			return "The company data has been updated successfully!";
		}
	}

	@DeleteMapping("/{id}")
	public String deleteCompanyById(@PathVariable("id")Long id) {
		return companyService.delete(id);
	}

}
