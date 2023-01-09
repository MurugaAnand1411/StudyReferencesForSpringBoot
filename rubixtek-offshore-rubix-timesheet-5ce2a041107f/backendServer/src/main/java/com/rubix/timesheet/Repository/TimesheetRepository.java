package com.rubix.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

import com.rubix.timesheet.Domain.Timesheet;
import com.rubix.timesheet.Model.TimeSheetModel;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
	List<Date> findDateRangeByTimesheetId(long id);

	Timesheet findByTimesheetId(long id);

	@Query(value = "SELECT * from timesheet  WHERE  employee_id=:id", nativeQuery = true)
	List<Timesheet> getByEmployeeId(@Param("id") Long id);
	
	@Query(value = "SELECT employee_id from timesheet  WHERE  timesheet_id=:id", nativeQuery = true)
	Long getEmployeeIdByTimesheetId(@Param("id") Long id);

	@Query(value = "SELECT t.timesheet_id as timesheetId,t.teamname as teamname,t.billable_hours as billableHours,t.start_date as startDate,t.end_date as endDate,"
			+ "t.timesheet_approver as timesheetApprover,t.status as status,d.timesheet_detail_id as timesheetDetailId "
			+ "from timesheet t,timesheetdetail d where t.timesheet_id=d.timesheet_id and  t.employee_id=:id", nativeQuery = true)
	public List<TimeSheetModel> getAlltimesheetDetailByEmployeeId(@Param("id") Long id);


	@Query(value = "SELECT t.timesheet_id as timesheetId,t.billable_hours as billableHours,t.teamname as teamname,t.start_date as startDate,t.submitted_date as submittedDate, t.end_date as endDate,"
			+ "t.timesheet_approver as timesheetApprover,t.status as status,d.projectname as projectName,d.timesheet_detail_id as timesheetDetailId,e.firstname as EmployeeName  "
			+ "from timesheet t,timesheetdetail d,employee e where t.timesheet_id=d.timesheet_id and t.employee_id=e.employee_id and t.status='PENDING'", nativeQuery = true)
	List<TimeSheetModel> getByPendingTimesheet();
	@Query(value = "SELECT t.timesheet_id as timesheetId,t.billable_hours as billableHours,t.teamname as teamname,t.start_date as startDate,t.submitted_date as submittedDate, t.end_date as endDate,"
			+ "t.timesheet_approver as timesheetApprover,t.status as status,d.projectname as projectName,d.timesheet_detail_id as timesheetDetailId,e.firstname as EmployeeName  "
			+ "from timesheet t,timesheetdetail d,employee e where t.timesheet_id=d.timesheet_id and t.employee_id=e.employee_id and t.status='APPROVED' or  t.status='REJECTED' and  t.submitted_date between :x and :y  ", nativeQuery = true)
	List<TimeSheetModel> getByApprovedAndRejectedTimesheet(@Param("x") Date start_date, @Param("y") Date end_date);
	@Query(value = "SELECT Count(timesheet_id) from timesheet where status='PENDING'", nativeQuery = true)
	Long getAllPendingTimesheetCount();
	@Query(value = "SELECT t.timesheet_id as timesheetId,t.billable_hours as billableHours,t.teamname as teamname,t.start_date as startDate,t.end_date as endDate,"
			+ "t.timesheet_approver as timesheetApprover,t.status as status,d.timesheet_detail_id as timesheetDetailId ,t.employee_id as employeeId, e.firstname as employeeName "
			+ "from timesheet t,timesheetdetail d,employee e where t.timesheet_id=d.timesheet_id and e.employee_id=t.employee_id and t.timesheet_id=:id", nativeQuery = true)
	TimeSheetModel getTimesheetwithEmployee(@Param("id") Long id);
}
