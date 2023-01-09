package com.rubix.timesheet.Service;

import java.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rubix.timesheet.Repository.*;
import com.rubix.timesheet.Domain.*;
import com.rubix.timesheet.Exception.*;
import com.rubix.timesheet.Model.TimeSheetModel;
import com.rubix.timesheet.Util.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private TimesheetRepository timesheetRepository;
	
	@Autowired
	private TimesheetDetailRepository timesheetDetailRepository;
	
	
	@Autowired
	private DateRangeRepository dateRangeRepository;
	
	@Autowired
	private HolidaytimeoffRepository holidaytimeoffRepository;
	
	@Autowired
	private ApplytimeoffRepository applytimeoffRepository;
	
	

//	public ResponseEntity<Long> login(Employee employee) throws Exception {
//		String email = employee.getEmailId();
//		String pass = employee.getPassword();
//		if (employeeRepository.findEmployeeByEmailIdAndPassword(email, pass).isPresent())
//			return new ResponseEntity<Long>(employeeRepository.findEmployeeIdByEmailIdAndPassword(email, pass), HttpStatus.OK);
//		else
//			return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
//
//	}
	
	public List<TimeSheetModel> getTimesheetByEmployeeId(long employeeId) {
		
		List<TimeSheetModel> timesheet=timesheetRepository.getAlltimesheetDetailByEmployeeId(employeeId);
		log.info("GET Timesheet Detail By Employee Id");
		return timesheet;
	}
	public Timesheet getTimesheetById(long timesheetId) {
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		return timesheet;
	}
	public TimesheetDetail getTaskDetailById(long timesheetdetailId) {
		TimesheetDetail detail=timesheetDetailRepository.findByTimesheetDetailId(timesheetdetailId);
		List<DateRange> range=dateRangeRepository.getByTimesheetDetailId(timesheetdetailId);
		detail.setDaterange(range);
		return detail;
	}
	public List<TimesheetDetail> getTaskDetailByTimesheetId(long timesheetId) {
		List<TimesheetDetail> detail=timesheetDetailRepository.getByTimesheetId(timesheetId);
		return detail;
	}

	public long addtimesheet(long employeeId,Timesheet timesheet) throws Exception {
		
		Timesheet newTimesheet=new Timesheet();
		BeanUtils.copyProperties(timesheet, newTimesheet,"employee","dateRange","isApproved");
		List<Date> dateRange=DateUtil.listofDatesBetweenTwoDate(newTimesheet.getStartDate(),newTimesheet.getEndDate());
		newTimesheet.setDateRange(dateRange);
		newTimesheet.setStatus(Status.CREATED);
		newTimesheet.setIsApproved(false);
		newTimesheet.setIsRejected(false);
		newTimesheet.setEmployee(employeeRepository.findByEmployeeId(employeeId));
		Timesheet savedtimesheet=timesheetRepository.save(newTimesheet);
			return savedtimesheet.getTimesheetId(); 
			

	}
	public ResponseEntity<String> submitForApprovalRequest(long timesheetId,long timesheetDetailId,long billableHours){
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		timesheet.setStatus(Status.PENDING);
		timesheet.setSubmittedDate(new Date());
		timesheet.setBillableHours(billableHours);
		timesheet.setIsApproved(false);
		timesheet.setIsRejected(false);
		timesheetRepository.save(timesheet);
		EmailTemplate email=new EmailTemplate(timesheet.getTimesheetApprover(),"Timesheet Approval","Please check out the Approval of the employee"
				+ "\n Click on the below link for access "
				+ "\n https://rubix-timesheet-client.herokuapp.com/admin/timesheet/"+timesheetId+"/"+timesheetDetailId);
		emailService.sendTextEmail(email);
		return new ResponseEntity<String>("Submitted for Approval", HttpStatus.OK);
	}
public ResponseEntity<String> updatetimesheet(long employeeId,long timesheetId,Timesheet timesheet) throws Exception {
		
		Timesheet oldTimesheet=timesheetRepository.findByTimesheetId(timesheetId);
		BeanUtils.copyProperties(timesheet, oldTimesheet,"timesheetId","employee","dateRange");
		List<Date> dateRange=DateUtil.listofDatesBetweenTwoDate(oldTimesheet.getStartDate(),oldTimesheet.getEndDate());
		oldTimesheet.setDateRange(dateRange);
		oldTimesheet.setEmployee(employeeRepository.findByEmployeeId(employeeId));
		timesheetRepository.save(oldTimesheet);
			return new ResponseEntity<String>("Updated Timesheet", HttpStatus.OK);
			

	}

	public long addTaskDetail(long timesheetId,TimesheetDetail details)throws Exception {
		
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		timesheet.setStatus(Status.SAVED);
		timesheetRepository.save(timesheet);		
		TimesheetDetail newDetail=new TimesheetDetail();
		BeanUtils.copyProperties(details, newDetail,"daterange");
		newDetail.setTimesheet(timesheet);
		TimesheetDetail savedDetail=timesheetDetailRepository.save(newDetail);
		List<DateRange> newdateRange=new ArrayList<>();
		List<DateRange> listdaterange=details.getDaterange();
		for(DateRange datee:listdaterange) {
			BeanUtils.copyProperties(listdaterange, datee,"timesheetDetail","dateRangeId");
			datee.setTimesheetDetail(savedDetail);
			newdateRange.add(datee);
		}
		dateRangeRepository.saveAll(newdateRange);
//		List<Holidaytimeoff> listholidayTimeoff=details.getHolidaytimeoff();
//		for(Holidaytimeoff holiday:listholidayTimeoff) {
//			System.out.println("holiday iteration array 1");
//			BeanUtils.copyProperties(listholidayTimeoff, holiday,"timesheetDetail","holidaytimeoffId");
//			holiday.setTimesheetDetail(savedDetail);
//			holidaytimeoffRepository.save(holiday);
//		}
//		List<Applytimeoff> listApplytimeoff=details.getApplytimeoff();
//		for(Applytimeoff timeoff:listApplytimeoff) {
//			BeanUtils.copyProperties(listApplytimeoff, timeoff,"timesheetDetail","applytimeoffId");
//			timeoff.setTimesheetDetail(savedDetail);
//			applytimeoffRepository.save(timeoff);
//		}
		return savedDetail.getTimesheetDetailId();
	}
	public ResponseEntity<String> updateTaskDetail(long timesheetId,long timesheetdetailId,TimesheetDetail detail)throws Exception {
		TimesheetDetail oldDetail=timesheetDetailRepository.findByTimesheetDetailId(timesheetdetailId);
		BeanUtils.copyProperties(detail, oldDetail,"timesheetDetailId","daterange");
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		oldDetail.setTimesheet(timesheet);
		oldDetail.setTimesheetDetailId(timesheetdetailId);
		TimesheetDetail savedDetail=timesheetDetailRepository.save(oldDetail);
		List<DateRange> listdaterange=detail.getDaterange();
		for(DateRange datee:listdaterange) {
		DateRange daterange=new DateRange();
		BeanUtils.copyProperties(datee,daterange,"timesheetDetail");
		daterange.setTimesheetDetail(savedDetail);
		dateRangeRepository.save(daterange); 
		}
//		List<Holidaytimeoff> listHolidaytimeoff=detail.getHolidaytimeoff();
//		for(Holidaytimeoff holiday:listHolidaytimeoff) {
//			Holidaytimeoff holidaytimeoff=new Holidaytimeoff();
//		BeanUtils.copyProperties(holiday,holidaytimeoff,"timesheetDetail");
//		holidaytimeoff.setTimesheetDetail(savedDetail);
//		holidaytimeoffRepository.save(holidaytimeoff); 
//		}
//		List<Applytimeoff> listApplytimeoff=detail.getApplytimeoff();
//		for(Applytimeoff applytime:listApplytimeoff) {
//			Applytimeoff applytimeoff=new Applytimeoff();
//		BeanUtils.copyProperties(applytime,applytimeoff,"timesheetDetail");
//		applytimeoff.setTimesheetDetail(savedDetail);
//		applytimeoffRepository.save(applytimeoff); 
//		}
		return new ResponseEntity<String>("Updated Timesheet Details", HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteTimesheetById(long timesheetId) {
		Timesheet timesheet=timesheetRepository.findByTimesheetId(timesheetId);
		timesheetRepository.delete(timesheet);
		return new ResponseEntity<String>("Deleted Timesheet", HttpStatus.OK);
	}
	public ResponseEntity<String> deleteTaskDetailById(long timesheetdetailId) {
		TimesheetDetail detail=timesheetDetailRepository.findByTimesheetDetailId(timesheetdetailId);
		timesheetDetailRepository.delete(detail);
		return new ResponseEntity<String>("Deleted task Detail", HttpStatus.OK);
	}
	public Employee getEmployeeById(long employeeId) {
		Employee employee=employeeRepository.findByEmployeeId(employeeId);
		log.info("getEmpDetails");
		employee.setPassword(null);
		return employee;
	}
	
	
	
}
