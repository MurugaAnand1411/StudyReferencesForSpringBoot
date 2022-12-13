package com.example.test.springDataDemo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private Scanner scanner = new Scanner(System.in);

	@Autowired
	private EmployeeRepository repository;

	
	public void queryEntities() {
		
		try {
			// Get a scalar value.
			long empCount = repository.getEmployeeCount();
			System.out.printf("Employee count: %d\n", empCount);
			
			// Get one record.
			long id = promptForId("Enter id of employee to get: ");
			Employee emp = repository.getEmployee(id);
			System.out.printf("Employee %d: %s\n", id, emp);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void modifyEntities() {

		try {
			displayEmployees("Employees in company: ", repository);
			// Insert an employee.
			System.out.println("Going to add new employe........");
			
			Employee newEmp = new Employee(-1, "Ramesh Kumar", 10000, "India");
			repository.insertEmployee(newEmp);
			displayEmployees("All employees after insert new employee: ", repository);

			// Update an employee.
			long id = promptForId("Enter id of employee to update (pay rise of 10000 for this one) : ");
			repository.employeePayRise(id, 10000);
			displayEmployees("All employees after update: ", repository);

			// Delete an employee.
			id = promptForId("(Employee leaving) Enter id of employee to delete: ");
			repository.deleteEmployee(id);
			displayEmployees("All employees after delete: ", repository);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private long promptForId(String message) {
		System.out.printf("\n%s\n", message);
		return scanner.nextLong();
	}

	private static void displayEmployees(String message, EmployeeRepository repository) {
		List<Employee> employees = repository.getEmployees();
		System.out.printf("\n%s\n", message);
		for (Employee emp: employees) {
			System.out.println(emp);
		}
	}
}




