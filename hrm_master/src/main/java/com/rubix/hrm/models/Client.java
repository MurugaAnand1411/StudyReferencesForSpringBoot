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
@Table(name = "client")

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "client_gstno")
	private String clientGestNo;

	@Column(name = "client_mail")
	private String clientMail;

	@Column(name = "client_address")
	private String clientAddress;

	@Column(name = "client_barach")
	private String clientbrach;

	@Column(name = "client_region")
	private String clientRegion;

}
