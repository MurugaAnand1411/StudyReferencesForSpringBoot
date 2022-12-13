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
@Table(name = "bank_details")
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bank_id")
	private Long bankId;

	@Column(name = "account_no")
	private Long accountNo;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "account_holder_name")
	private String accountHolderName;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "aadhar_no")
	private long aadharNo;

	@Column(name = "pan_no")
	private String panNo;
}
