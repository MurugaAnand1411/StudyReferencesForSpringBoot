package com.rubix.hrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Employee;
import com.rubix.hrm.repositorys.EmployeeRepository;



@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

//create new employee
	public Optional<Employee> create(Employee employee) {
		if (employeeRepository.existsById(employee.getEmpId())) {
			return Optional.empty();
		} else {
			return Optional.of(employeeRepository.save(employee));
		}
	}
//get the all employee details from the tables

	public List<Employee> retrieve() {
		return employeeRepository.findAll();
	}


	// get one employee details from the tables
	public Optional<Employee> retrieveOne(int empid) {
		return employeeRepository.findById((long) empid);
	}
	// update existing employee details

	public Optional<Employee> update(Employee employee) {
		if (employeeRepository.existsById((employee.getEmpId()))) {
			return Optional.of(employeeRepository.save(employee));
		} else {
			return Optional.empty();
		}
	}

//Delete by ID
	public String delete(int empid) {
		if (employeeRepository.existsById((long) empid)) {
			employeeRepository.deleteById((long) empid);
			return empid + " deleted successfully!";
		} else {
			return "The employee data does not exist in records!";
		}

	}



}
