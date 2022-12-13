package com.rubix.hrm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity
	@Table(name="employee1")
	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="emp_Id")
		private Long empId;
		
		@Column(name="name")
		private String name;
		
		@Column(name="designation")
		private String designation;
		
		@Column(name="mail")
		private String mail;
		
		@Column(name="address")
		private String address;
		
		@Column(name="mobile")
		private String mobile;
		
		@Column(name="bloodGroup")
		private String bloodGroup;
		
		@Column(name="emergncyContactNo")
		private String emergncyContactNo; 
}
