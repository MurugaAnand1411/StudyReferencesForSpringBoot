package com.rubix.timesheet.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workingexperience", schema = "public")
public class WorkingExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(shape = Shape.STRING)
	private long experienceId;
	private String role;
	private String comapnyName;
	private String workingDuration;
	private String companyAddress;
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	private Employee employee;
}
