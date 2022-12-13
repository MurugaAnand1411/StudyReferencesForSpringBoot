package com.rubix.hrm.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reference_id")
	private int ReferenceId;

	@Column(name = "date")
	private Date date;

	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private String year;

	@Column(name = "inTime")
	private Date inTime;

	@Column(name = "outTime")
	private Date outTime;

}
