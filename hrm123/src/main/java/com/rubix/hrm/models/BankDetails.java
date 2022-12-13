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
@Table(name="bank_details1")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bank_id")
	private long bankId;
	
	@Column(name="account_no")
	private long accountNo;

	@Column(name="ifsc_code")
	private String ifscCode;

	@Column(name="account_holder_name")
	private String accountHolderName;

	@Column(name="bank_name")
	private String bankName;
}
