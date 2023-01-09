package com.rubix.timesheet.Domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
@Table(name = "official", schema = "public")
public class Official {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long officialId;
	@Temporal(TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy", shape = Shape.STRING)
	private Date DOJ;
	@JsonFormat(shape = Shape.STRING)
	private double salary;
	private String Designation;
	@JsonIgnore
	@OneToOne(optional = false)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	private Employee employee;
}
