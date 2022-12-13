package com.rubix.react.audit.entities;
/*
 * *@author Muruganandham
 *
 * @version 1.0
 *
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_Id")
	private Long clientId;

	private String clientName;

	private String clientGestNo;

	private String clientMail;

	private String clientAddress;

	private String clientRegion;


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List <Invoice> Invoice;


}
