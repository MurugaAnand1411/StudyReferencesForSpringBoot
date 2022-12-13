package com.rubix.react.audit.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * *@author Muruganandham
 *
 * @version 1.0
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoice_Id")
	private Long invoiceId;

	private Long invoiceNo;

	private Date invoiceDate;

	private Long amount;

	private String tax;

	private String paymentTerm;

	private Date dueDate;

	private String paymentType;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fclient_id", referencedColumnName = "client_Id")
	private Client client;

}
