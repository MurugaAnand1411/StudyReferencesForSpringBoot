package com.rubix.hrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.hrm.models.Salary;
import com.rubix.hrm.services.SalaryService;

@RestController
public class SalaryController {
	@Autowired
	private SalaryService SalarysService;

	@GetMapping("/salary")
	public List<Salary> getAllSalarys() {
		return SalarysService.getallSalarys();
	}

	@GetMapping("/salary/{salaryId}")
	public Salary getSalarys(@PathVariable("salaryId") long salaryId) {
		return SalarysService.getSalarysById(salaryId);
	}

	@DeleteMapping("/salary/{salaryId}")
	public String deleteSalary(@PathVariable("salaryId") long salaryId) {
		return SalarysService.delete(salaryId);
	}

	@PostMapping("/salarys")
	public Salary saveSalary(@RequestBody Salary Salarys) {
		SalarysService.saveOrUpdate(Salarys);
		return Salarys;
	}

	@PutMapping("/salarys")
	public String update(@PathVariable("salaryId") long salaryId, @RequestBody Salary Salarys) {
		return SalarysService.update(salaryId, Salarys);
	}

}
