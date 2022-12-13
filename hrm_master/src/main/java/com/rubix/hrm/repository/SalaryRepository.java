package com.rubix.hrm.repository;

import org.springframework.data.repository.CrudRepository;

import com.rubix.hrm.models.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Long> {
	Salary findById(long salaryId);
}
