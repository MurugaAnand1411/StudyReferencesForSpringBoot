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
@Table(name="company1")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	private long companyId;
	
	@Column(name="com_name")
	private String comName;
	
	@Column(name="gstno")
	private String gestNo;
	
	@Column(name="com_mail")
	private String comMail;
	
	@Column(name="com_address")
	private String comaAddress;
	
	@Column(name="com_barach")
	private String comabrach;
	
	@Column(name="com_region")
	private String comaRegion;




}
