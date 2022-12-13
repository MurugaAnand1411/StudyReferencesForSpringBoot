package com.rubix.hrm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "payroll")
public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long payrollId;
	private long empId;
	private long jobId;
	private long salaryId;
	private long leaveId;
	private String date;
	private String report;
	private double totalAmount;
}