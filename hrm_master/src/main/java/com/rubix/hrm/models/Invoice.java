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
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoice_id")
	private Long invoiceId;

	@Column(name = "billing_start_date")
	private Date billingStartDate;

	@Column(name = "billing_end_date")
	private Date billingEndDate;

	@Column(name = "invoice_date")

	private Date invoiceDate;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "paymentTerms")
	private PaymentTerms paymentTerms;

	@Column(name = "description")
	private String description;

	@Column(name = "billing_address")
	private String billingAddress;

	@Column(name = "amount")
	private long amount;

}
