package com.rubix.timesheet.Controller;

import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.timesheet.Domain.Employee;
import com.rubix.timesheet.Domain.Timesheet;
import com.rubix.timesheet.Domain.TimesheetDetail;
import com.rubix.timesheet.Model.TimeSheetModel;
import com.rubix.timesheet.Service.TeamLeadService;
@CrossOrigin(origins = { "http://localhost:4200", "https://rubix-timesheet-client.herokuapp.com" })
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/timesheet/rubix/admin")
@RolesAllowed({"TL","ADMIN"})
public class TeamLeadController {
	@Autowired
	TeamLeadService teamleadService;

	@RolesAllowed({"TA","TL","ADMIN"})
	@GetMapping("/getPendingTimesheet")
	public List<TimeSheetModel> getTimesheetwithEmployeeName() {
		return teamleadService.getPendingTimesheet();
	}

	@RolesAllowed({"TA","TL","ADMIN"})
	@GetMapping("/geApprovedAndRejectedTimesheet/{start_date}/{end_date}")
	public List<TimeSheetModel> getAllApprovedAndRejectedTimesheet(@PathVariable(value = "start_date")@DateTimeFormat(iso = ISO.DATE)Date start_date, 
    		@PathVariable(value = "end_date")@DateTimeFormat(iso = ISO.DATE) Date end_date) {
		return teamleadService.getAllApprovedAndRejectedTimesheet(start_date, end_date);
	}
	@RolesAllowed({"TA","TL","ADMIN"})
	@GetMapping("/getTimesheetwithEmpId/{timesheetId}")
	public TimeSheetModel getTimesheetwithEmp(@PathVariable long timesheetId) {
		return teamleadService.getTimesheetWithEmp(timesheetId);
	}
	@RolesAllowed({"TA","TL","ADMIN"})
	@GetMapping("/approveTimesheet/{timesheetId}")
	public ResponseEntity<String> approveTimesheet(@PathVariable long timesheetId) {
		
		return teamleadService.approveTimesheetById(timesheetId);
	}
	@RolesAllowed({"TA","TL","ADMIN"})
	@GetMapping("/rejectTimesheet/{timesheetId}")
	public ResponseEntity<String> rejectTimesheet(@PathVariable long timesheetId) {
		return teamleadService.rejectTimesheetById(timesheetId);
	}
	@RolesAllowed({"TA","TL","ADMIN"})
	@GetMapping("/getAllPendingCounts")
	public long  getPendingTimesheetCount() {
		return teamleadService.getPendingTimesheetCounts();
	}
	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployeesList() {
		return teamleadService.getEmployeeDetails();
	}
	@GetMapping("/getAllAdmin")
	public List<Employee> getAdmin() {
		return teamleadService.getAdmin();
	}
	@PostMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable long employeeId,@RequestBody Employee employee) {
		return teamleadService.updateEmployee(employeeId, employee);
	}
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long employeeId){
		return teamleadService.deleteEmployee(employeeId);
	}
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee,@RequestParam String role)throws Exception {
		return teamleadService.addEmployee(employee,role);
	}
	@PostMapping("/updateSupervisor/{employeeId}/{supervisorId}")
	public ResponseEntity<String> updateSupervisor(@PathVariable long employeeId,@PathVariable long supervisorId) {
		return teamleadService.setSupervisor(employeeId, supervisorId);
	}
	@PostMapping("/updateRoles/{employeeId}")
	public ResponseEntity<String> updateRoles(@PathVariable long employeeId,@RequestParam String rolesName) {
		return teamleadService.setRoles(employeeId, rolesName);
	}
}
