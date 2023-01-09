package com.rubix.timesheet.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bankdetails", schema = "public")
public class Bankdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long bankdetailsId;
	private String bankName;
	private String branchName;
	private String adhaarNo;
	@JsonFormat(shape = Shape.STRING)
	private long accountNo;
	private String ifscCode;
	private String pancardNo;
	@JsonIgnore
	@OneToOne(optional = false)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	private Employee employee;
}
