package com.rubix.hrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Employee;
import com.rubix.hrm.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Optional<Employee> create(Employee employee) {
		return Optional.of(employeeRepository.save(employee));
	}

	public List<Employee> retrieve() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> retrieveOne(Long empid) {
		return employeeRepository.findById(empid);
	}

	public Optional<Employee> update(Employee employee) {
		if (employeeRepository.existsById((employee.getEmployeeId()))) {
			return Optional.of(employeeRepository.save(employee));
		} else {
			return Optional.empty();
		}
	}

	public String delete(Long empid) {
		if (employeeRepository.existsById(empid)) {
			employeeRepository.deleteById(empid);
			return empid + " deleted successfully!";
		} else {
			return "The employee data does not exist in records!";
		}

	}

}
