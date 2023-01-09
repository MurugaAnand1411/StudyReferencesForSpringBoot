package com.rubix.timesheet.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.timesheet.Domain.Employee;
import com.rubix.timesheet.Domain.TimesheetDetail;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	Employee findByEmployeeId(Long empId);
	Optional<Employee> findEmployeeByEmailIdAndPassword(String email,String password);
	Optional<Employee> findEmployeeByEmailId(String email);
	Employee findByEmailId(String email);
	@Query(value = "SELECT email_id from employee  WHERE  employee_id=:id", nativeQuery = true)
	String getEmailIdByEmployeeId(@Param("id") long id);
	Employee findByFirstname(String email);
	Long findEmployeeIdByEmailIdAndPassword(String email,String password);
	
	@Query(value = "SELECT employee_id from employee_roles  WHERE  role_id=2", nativeQuery = true)
	long[] getIdByAdmin();
}
