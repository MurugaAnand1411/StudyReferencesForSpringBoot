package com.rubix.hrm.repository;

import org.springframework.data.repository.CrudRepository;

import com.rubix.hrm.models.Payroll;

public interface PayrollRepository extends CrudRepository<Payroll, Long> {
	Payroll findById(long payrollId);
}
