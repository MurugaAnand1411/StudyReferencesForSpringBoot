package com.rubix.react.audit.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "receipt")

public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_Id")

	private Long billId;

	private Date billDate;

	private Long amount;

	private String paidTo;

	private String imageLocation;

	private String status;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_user_id")
//	private User user;
//
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_supplier_id")
//	private Supplier supp;


}
