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
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "name")
	private String companyName;

	@Column(name = "gstno")
	private String gestNo;

	@Column(name = " company_mail")
	private String companyMail;

	@Column(name = "com_address")
	private String companyAddress;

	@Column(name = "com_barach")
	private String companyBrach;

	@Column(name = "com_region")
	private String companyRegion;

}
