package com.rubix.timesheet.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rubix.timesheet.Service.*;
import com.rubix.timesheet.Domain.*;
import com.rubix.timesheet.Model.TimeSheetModel;

import java.util.List;
@CrossOrigin(origins = { "http://localhost:4200", "https://rubix-timesheet-client.herokuapp.com" })
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/timesheet/rubix/employee")
@RolesAllowed({"EMPLOYEE","TL","ADMIN","TA"})
public class EmployeeController {
	@Autowired
	TeamLeadService teamleadService; 
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/details/{employeeId}")	
	public Employee getEmployeeDetails(@PathVariable long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	//	@RolesAllowed({"EMPLOYEE","TL"})
	//@PreAuthorize("hasRole('EMPLOYEE') or hasRole('HR') or hasRole('ADMIN')")
	@GetMapping("/getTimesheetByEmployeeId/{employeeId}")
	public List<TimeSheetModel> getTimesheetByEmployeeId(@PathVariable long employeeId) {
		return employeeService.getTimesheetByEmployeeId(employeeId);
	}
	@GetMapping("/getTimesheetById/{timesheetId}")
	public Timesheet getTimesheetById(@PathVariable long timesheetId) {
		return employeeService.getTimesheetById(timesheetId);
	}
	@GetMapping("/getTaskDetailById/{timesheetdetailId}")
	public TimesheetDetail getTasktDetailById(@PathVariable long timesheetdetailId) {
		return employeeService.getTaskDetailById(timesheetdetailId);
	}
	@GetMapping("/getTaskDetailByTimesheetId/{timesheetId}")
	public List<TimesheetDetail> getTasktDetailByTimesheetId(@PathVariable long timesheetId) {
		return employeeService.getTaskDetailByTimesheetId(timesheetId);
	}
	@PostMapping("/addTimesheet")
	public long addTimesheet(@RequestParam(value = "employeeId", required = true) long employeeId,@RequestBody Timesheet timesheet)throws Exception{
		return employeeService.addtimesheet(employeeId,timesheet);
	}
	@PutMapping("/updateTimesheet")
	public ResponseEntity<String> updateTimesheet(@RequestParam(value = "employeeId", required = true) long employeeId,@RequestParam(value = "timesheetId", required = true) long timesheetId,@RequestBody Timesheet timesheet)throws Exception{
		return employeeService.updatetimesheet(employeeId,timesheetId,timesheet);
	}
	
	@PostMapping("/addTaskDetail")
	public long addTaskDetail(@RequestParam(value = "timesheetId", required = true) long timesheetId,@RequestBody TimesheetDetail timesheetDetail)throws Exception{
		return employeeService.addTaskDetail(timesheetId,timesheetDetail);
	}
	@PutMapping("/updateTaskDetail")
	public ResponseEntity<String> updateTaskDetail(@RequestParam(value = "timesheetId", required = true) long timesheetId,@RequestParam(value = "timesheetDetailId", required = true) long timesheetDetailId,@RequestBody TimesheetDetail timesheetDetail)throws Exception{
		return employeeService.updateTaskDetail(timesheetId, timesheetDetailId, timesheetDetail);
	}
	@GetMapping("/submitForApproval")
	public ResponseEntity<String> submitForApproval(@RequestParam(value = "timesheetId", required = true) long timesheetId,@RequestParam(value = "timesheetDetailId", required = true) long timesheetDetailId,@RequestParam(value = "billableHours", required = true) long billableHours)throws Exception{
		return employeeService.submitForApprovalRequest(timesheetId,timesheetDetailId,billableHours);
	}
	@DeleteMapping("/deleteTaskDetail/{timesheetDetailId}")
	public ResponseEntity<String> removeTasktDetail(@PathVariable long timesheetDetailId) {
		return employeeService.deleteTaskDetailById(timesheetDetailId);
	}
	@DeleteMapping("/deleteTimesheet/{timesheetId}")
	public ResponseEntity<?> removeTimesheet(@PathVariable long timesheetId) {
		return employeeService.deleteTimesheetById(timesheetId);
	}
	@GetMapping("/getAllAdmin")
	public List<Employee> getAdmin() {
		return teamleadService.getAdmin();
	}
}