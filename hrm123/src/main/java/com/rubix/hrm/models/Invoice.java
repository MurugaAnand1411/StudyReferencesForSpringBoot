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


@Entity
@Table(name="invoice1")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="invoice_id")
	private long invoiceId;
	
	@Column (name="billing_start_date")
	private Date billingStartDate;
	
	@Column (name="billing_end_date")
	private Date billingEndDate;
	
	@Column (name="invoice_date")
	private Date invoiceDate;
	
	@Column (name="due_date")
	private Date dueDate;
	
	@Column (name="Pt")
	private PaymentTerms Pt;
	
	@Column (name="description")
	private Date description;
	
	@Column (name="billing_address")
	//company Adress,bank,Pan come from company modelclass
	private String billingAddress;
	
	@Column (name="amount")
	private long amount;
	

}
