package com.rubix.timesheet.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rubix.timesheet.Domain.Address;
import com.rubix.timesheet.Domain.Bankdetails;
import com.rubix.timesheet.Domain.ERole;
import com.rubix.timesheet.Domain.EmailTemplate;
import com.rubix.timesheet.Domain.Employee;
import com.rubix.timesheet.Domain.Official;
import com.rubix.timesheet.Domain.Role;
import com.rubix.timesheet.Domain.Status;
import com.rubix.timesheet.Domain.Timesheet;
import com.rubix.timesheet.Exception.AlreadyExistsException;
import com.rubix.timesheet.Model.TimeSheetModel;
import com.rubix.timesheet.Repository.AddressRepository;
import com.rubix.timesheet.Repository.BankDetailsRepository;
import com.rubix.timesheet.Repository.DateRangeRepository;
import com.rubix.timesheet.Repository.EmployeeRepository;
import com.rubix.timesheet.Repository.OfficialRepository;
import com.rubix.timesheet.Repository.RoleRepository;
import com.rubix.timesheet.Repository.TimesheetDetailRepository;
import com.rubix.timesheet.Repository.TimesheetRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class TeamLeadService {

	@Autowired
	private TimesheetRepository timesheetRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private OfficialRepository officialRepository;
	@Autowired
	private BankDetailsRepository bankRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private TimesheetDetailRepository timesheetDetailRepository;
	
	@Autowired
	private DateRangeRepository dateRangeRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	PasswordEncoder encoder;
	
	public List<TimeSheetModel> getPendingTimesheet() {
		List<TimeSheetModel> timesheet=timesheetRepository.getByPendingTimesheet();
		return timesheet;
	}
	public List<TimeSheetModel> getAllApprovedAndRejectedTimesheet(Date start_date,Date end_date) {
		List<TimeSheetModel> timesheet=timesheetRepository.getByApprovedAndRejectedTimesheet(start_date,end_date);
		return timesheet;
	}
	public long getPendingTimesheetCounts() {
		long count=timesheetRepository.getAllPendingTimesheetCount();
		return count;
	}
	public TimeSheetModel getTimesheetWithEmp(long timesheetId) {
		TimeSheetModel timesheet=timesheetRepository.getTimesheetwithEmployee( timesheetId);
		return timesheet;
	}
	public ResponseEntity<String> approveTimesheetById(long timesheetId) {
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		Employee emp=employeeRepository.findByEmployeeId(timesheetRepository.getEmployeeIdByTimesheetId(timesheetId));
		String emailId=employeeRepository.getEmailIdByEmployeeId(emp.getEmployeeId());
		timesheet.setIsApproved(true);
		timesheet.setStatus(Status.APPROVED);
		timesheetRepository.save(timesheet);
		EmailTemplate email=new EmailTemplate(emailId,"Timesheet Approval","Your TimesheetID :"+timesheetId+" has been Approved");
		emailService.sendTextEmail(email);
		return new ResponseEntity<String>("Timesheet Approved", HttpStatus.OK);
		
	}
	public ResponseEntity<String> rejectTimesheetById(long timesheetId) {
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		Employee emp=employeeRepository.findByEmployeeId(timesheetRepository.getEmployeeIdByTimesheetId(timesheetId));
		String emailId=employeeRepository.getEmailIdByEmployeeId(emp.getEmployeeId());
		timesheet.setIsRejected(true);
		timesheet.setStatus(Status.REJECTED);
		timesheetRepository.save(timesheet);
		EmailTemplate email=new EmailTemplate(emailId,"Timesheet Approval","Your TimesheetID :"+timesheetId+" has been Rejected");
		emailService.sendTextEmail(email);
		return new ResponseEntity<String>("Timesheet Rejected", HttpStatus.OK);
		
	}
	public List<Employee> getEmployeeDetails() {
		log.info("Into Employee List");
		List<Employee> employees=employeeRepository.findAll();
		for(Employee employee:employees) {
			employee.setPassword(null);
		}
		return employees;
	}
	public List<Employee> getAdmin() {
		List<Employee> employees=new ArrayList<>();
		long[] empId=employeeRepository.getIdByAdmin();
		for(long id:empId) {
			Employee emp=employeeRepository.findByEmployeeId(id);
			Employee newemp=new Employee();
			newemp.setFirstname(emp.getFirstname());
			newemp.setEmployeeId(emp.getEmployeeId());
			newemp.setEmailId(emp.getEmailId());
			employees.add(newemp);
		}
		return employees;
	}
	public ResponseEntity<String> setSupervisor(long employeeId,long supervisorId) {
		Employee updateEmp=employeeRepository.findByEmployeeId(employeeId);
		Employee supervisor=employeeRepository.findByEmployeeId(supervisorId);
		updateEmp.setSupervisor(supervisor);
		employeeRepository.save(updateEmp);
		return new ResponseEntity<String>("Supervisor Updated", HttpStatus.OK);
	}
	public ResponseEntity<String> setRoles(long employeeId,String rolesName) {
		Employee updateEmp=employeeRepository.findByEmployeeId(employeeId);
		Set<Role> roles = new HashSet<>();
		switch (rolesName) {
		case "Admin":
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
			roles.add(adminRole);

			break;
		case "TL":
			Role modRole = roleRepository.findByName(ERole.ROLE_TL);
			roles.add(modRole);
			break;
		case "TimesheetApprover":
			Role taRole = roleRepository.findByName(ERole.ROLE_TA);
			roles.add(taRole);
			break;
		default:
			Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE);
			roles.add(userRole);
		}
		updateEmp.setRoles(roles);
		employeeRepository.save(updateEmp);
		return new ResponseEntity<String>("Roles Updated", HttpStatus.OK);
	}
	public ResponseEntity<String> addEmployee(Employee employee,String rolename) throws Exception{
		Employee supervisor=employeeRepository.findByEmailId("dinesh@rubixtek.com");
		Employee newEmployee = new Employee();
		String randomCode = RandomString.make(64);
		BeanUtils.copyProperties(employee, newEmployee,"verificationCode","verified","password","roles");
		newEmployee.setPassword(encoder.encode(employee.getPassword()));
		newEmployee.setVerificationCode(randomCode);
		newEmployee.setVerified(false);
		newEmployee.setSupervisor(supervisor);
		Set<Role> roles = new HashSet<>();
		switch (rolename) {
		case "ROLE_ADMIN":
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
			roles.add(adminRole);

			break;
		case "ROLE_TL":
			Role modRole = roleRepository.findByName(ERole.ROLE_TL);
			roles.add(modRole);
			break;
		case "ROLE_TA":
			Role taRole = roleRepository.findByName(ERole.ROLE_TA);
			roles.add(taRole);
			break;
		default:
			Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE);
			roles.add(userRole);
		}
		newEmployee.setRoles(roles);
		if (employeeRepository.findEmployeeByEmailId(newEmployee.getEmailId()).isPresent())
			throw new AlreadyExistsException("emailId already Exists");
		else {
			newEmployee = employeeRepository.save(newEmployee);
			emailService.sendVerificationEmail(newEmployee,"https://rubix-timesheet-server.herokuapp.com//timesheet/auth");
			
		}
		return new ResponseEntity<String>("Employee Registered", HttpStatus.OK);
	}
	
	public ResponseEntity<String> updateEmployee(long employeeId,Employee employee) {
		Employee updateEmp=employeeRepository.findByEmployeeId(employeeId);
		BeanUtils.copyProperties(employee, updateEmp,"roles","password","address","official","bank","qualification","supervisor","timesheet","experience","salary");
		updateEmp.setEmployeeId(employeeId);
		employeeRepository.save(updateEmp);
		List<Address> address=employee.getAddress();
		for(Address updatedAddress:address) {
			updatedAddress.setAddressId(updatedAddress.getAddressId());
			updatedAddress.setEmployee(updateEmp);
			addressRepository.save(updatedAddress);
		}
		Bankdetails bank=employee.getBank();
		bank.setBankdetailsId(bank.getBankdetailsId());
		bank.setEmployee(updateEmp);
		bankRepository.save(bank);
		Official official=employee.getOfficial();
		official.setOfficialId(official.getOfficialId());
		official.setEmployee(updateEmp);
		officialRepository.save(official);
		return new ResponseEntity<String>("Employee Updated", HttpStatus.OK);
	}
	public ResponseEntity<String> deleteEmployee(long employeeId) {
		Employee employee=employeeRepository.findByEmployeeId(employeeId);
		employeeRepository.delete(employee);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}
}
