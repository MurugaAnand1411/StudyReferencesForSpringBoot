package com.rubix.timesheet.Domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "emp_seq", initialValue = 5, allocationSize = 5)
@Table(name = "employee", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "emailId" }))
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@JsonFormat(shape = Shape.STRING)
	private long employeeId;
	private String firstname;
	private String lastname;
	@JsonFormat(shape = Shape.NUMBER)
	private String mobileno;
	@Column(name = "emailId")
	private String emailId;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Address> address;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Qualification> qualification;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<WorkingExperience> experience;
	 @Column(length = 100)
	private String password;
	private String bloodgroup;
	@Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private Date dateOfBirth;
	@OneToOne(mappedBy = "employee",cascade =CascadeType.REMOVE)
	private Official official;
	@OneToOne(mappedBy = "employee", cascade =CascadeType.REMOVE)
	private Bankdetails bank;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisor")
	private Employee supervisor;
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Timesheet> timesheet;
	@OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private Salary salary;
	private String verificationCode;
	private Boolean verified;
}
