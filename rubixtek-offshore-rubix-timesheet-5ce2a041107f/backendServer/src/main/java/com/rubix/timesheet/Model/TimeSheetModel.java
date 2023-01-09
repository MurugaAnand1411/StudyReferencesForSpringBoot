package com.rubix.timesheet.Model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.rubix.timesheet.Domain.Status;

public interface TimeSheetModel {

	public String getTimesheetId();

	public String getTeamname();

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	public Date getStartDate();

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	public Date getEndDate();

	public String getTimesheetApprover();
	
	public String getProjectName();

	public String getTimesheetDetailId();

	public Status getStatus();
	
	public String getEmployeeId();
	
	public String getEmployeeName();
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	public Date getSubmittedDate();
	
	public long getBillableHours();
}
