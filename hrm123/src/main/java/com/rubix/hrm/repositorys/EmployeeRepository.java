package com.rubix.hrm.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.hrm.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
