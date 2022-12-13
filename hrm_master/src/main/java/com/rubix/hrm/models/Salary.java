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
@Table(name = "salary")

public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salaryId;
	private long jobId;
	private double amount;
	private double annual;
	private double bonus;
}
