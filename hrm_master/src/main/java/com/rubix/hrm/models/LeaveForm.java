package com.rubix.hrm.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "leave_app")
public class LeaveForm {

	@Id
	@Column(name = "empid")
	private int empid;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

	@Column(name = "leave_type")
	private String leaveType;

	@Column(name = "reason")
	private String reason;

	@Column(name = "working_days")
	private String workingDays;

	@Column(name = "approved_by")
	private String approvedBy;

}
