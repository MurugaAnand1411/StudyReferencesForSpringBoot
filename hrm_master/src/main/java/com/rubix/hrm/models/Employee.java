package com.rubix.hrm.models;

import java.sql.Date;
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
/* *@author  Muruganandham
* @version 1.0
*
*/

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_Id")

	private Long employeeId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "mail")
	private String mail;

	@Column(name = "address")
	private String address;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "bloodGroup")
	private String bloodGroup;

	@Column(name = "emergncyContactNo")
	private String emergncyContactNo;
}
